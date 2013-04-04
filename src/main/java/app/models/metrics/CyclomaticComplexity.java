package app.models.metrics;

import app.csv.Position;

public class CyclomaticComplexity {

	@Position(position=1)
	private String name;
	@Position(position=2)
	private int cc;
	
	public String getName() {
		return name;
	}
	
	public int getCc() {
		return cc;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}
	
}
