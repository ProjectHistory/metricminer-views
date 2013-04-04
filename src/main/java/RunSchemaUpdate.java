import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

import app.infra.config.Config;
import app.infra.config.HardCodedConfig;
import app.infra.hibernate.DatabaseConfigurator;


public class RunSchemaUpdate {

	public static void main(String[] args) {
		Config cfg = new HardCodedConfig();
		Configuration hibernateConfig = new DatabaseConfigurator(cfg).config();
		
		SchemaUpdate se = new SchemaUpdate(hibernateConfig);
		se.execute(true, true);
	}
}
