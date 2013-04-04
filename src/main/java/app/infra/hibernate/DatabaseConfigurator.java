package app.infra.hibernate;


import org.hibernate.cfg.Configuration;

import app.infra.config.Config;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

@Component
@ApplicationScoped
public class DatabaseConfigurator {
	
	private Config cfg;

	public DatabaseConfigurator(Config cfg) {
		this.cfg = cfg;
	}
	
	public Configuration config() {
		
			Configuration configuration = new Configuration();

			String dbUrl = cfg.dbConnectionString();
			String username = cfg.dbUser();
			String password = cfg.dbPassword();

			configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
			configuration.setProperty("hibernate.connection.url", dbUrl);
			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			configuration.setProperty("hibernate.connection.username", username);
			configuration.setProperty("hibernate.connection.password", password);
			
			configuration.setProperty("hibernate.show_sql", "false");
			configuration.setProperty("hibernate.format_sql", "false");
			configuration.setProperty("hibernate.jdbc.batch_size", "20");
			
			if(cfg.isProduction()){
				configuration.setProperty("hibernate.connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
				configuration.setProperty("hibernate.c3p0.acquire_increment", "1");
				configuration.setProperty("hibernate.c3p0.idle_test_period", "100");
				configuration.setProperty("hibernate.c3p0.max_size", "30");
				configuration.setProperty("hibernate.c3p0.min_size", "5");
				configuration.setProperty("hibernate.c3p0.timeout", "1800");
			}
			
			configuration.addAnnotatedClass(app.models.Project.class);

			return configuration;
	}

}
