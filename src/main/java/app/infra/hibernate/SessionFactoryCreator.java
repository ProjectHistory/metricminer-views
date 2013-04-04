package app.infra.hibernate;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class SessionFactoryCreator implements ComponentFactory<SessionFactory> {

	private final DatabaseConfigurator configurator;
	private SessionFactory sf;

	public SessionFactoryCreator(DatabaseConfigurator configurator) {
		this.configurator = configurator;
	}
	
	public SessionFactory getInstance() {
		return sf;
	}
	
	@PostConstruct
	public void createFactory() {
		Configuration configuration = configurator.config();
		this.sf = configuration.buildSessionFactory();
	}
	
	@PreDestroy
	public void close() {
		this.sf.close();
	}

}
