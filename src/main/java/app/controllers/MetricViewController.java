package app.controllers;


import app.csv.CSVParser;
import app.infra.metricminer.MetricMinerDownloader;
import app.models.Project;
import app.models.metrics.Committer;
import app.models.metrics.CyclomaticComplexity;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class MetricViewController {

	private final CSVParser parser;
	private final MetricMinerDownloader download;
	private final Result result;

	public MetricViewController(Result result, CSVParser parser, MetricMinerDownloader download) {
		this.result = result;
		this.parser = parser;
		this.download = download;
	}
	
	@Path("/project/{project.name}")
	public void show(Project project) {
		
		result.include("cc", parser.parse(CyclomaticComplexity.class, download.csv(project.getCcUrl())));
		result.include("committers", parser.parse(Committer.class, download.csv(project.getCommittersUrl())));
		
	}
}
