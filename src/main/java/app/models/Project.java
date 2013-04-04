package app.models;

import javax.persistence.Entity;

@Entity
public class Project {

	private int id;
	private String name;
	private String ccUrl;
	private String committersUrl;
	
	public String getCcUrl() {
		return ccUrl;
	}

	public String getCommittersUrl() {
		return committersUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCcUrl(String ccUrl) {
		this.ccUrl = ccUrl;
	}

	public void setCommittersUrl(String committersUrl) {
		this.committersUrl = committersUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
