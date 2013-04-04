package app.controllers;


import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

import app.models.Project;

@Resource
public class MetricViewController {

	@Path("/project/{project.name}")
	public void show(Project project) {
		
	}
}
