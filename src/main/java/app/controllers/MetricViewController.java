package app.controllers;

import javax.annotation.Resource;

import br.com.caelum.vraptor.Path;

import app.models.Project;

@Resource
public class MetricViewController {

	@Path("/project/{project.name}")
	public void show(Project project) {
		
	}
}
