package app.infra.config;


public interface Config {
	String env();

	String dbConnectionString();
	String dbUser();
	String dbPassword();
	
	boolean isProduction();
}
