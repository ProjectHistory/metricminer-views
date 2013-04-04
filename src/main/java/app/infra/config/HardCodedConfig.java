package app.infra.config;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

@Component
@ApplicationScoped
public class HardCodedConfig implements Config {

	@Override
	public String env() {
		return "production";
	}

	@Override
	public String dbConnectionString() {
		return "jdbc:postgresql://ec2-107-21-99-45.compute-1.amazonaws.com/d17q3o3c84rjpa?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
	}

	@Override
	public String dbUser() {
		return "mjccgbcxgpxoqb";
	}

	@Override
	public String dbPassword() {
		return "1nY9tFV-sOo4blVKDqsv7Rt1oU";
	}

	@Override
	public boolean isProduction() {
		return true;
	}

}
