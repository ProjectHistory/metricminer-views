package app.infra.metricminer;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class MetricMinerDownloader {

	public String csv(String url) {
		try {
			URL csvUrl = new URL(url);
			InputStream is = csvUrl.openStream();
			
			Scanner sc = new Scanner(is);
			sc.useDelimiter("$$");
			String result = sc.next();
			sc.close();
			
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
