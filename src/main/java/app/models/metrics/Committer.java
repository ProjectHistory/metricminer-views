package app.models.metrics;

import app.csv.Position;

public class Committer {

	@Position(position=1)
	private String name;
	@Position(position=2)
	private double commits;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCommits() {
		return commits;
	}
	public void setCommits(double commits) {
		this.commits = commits;
	}
		
}
