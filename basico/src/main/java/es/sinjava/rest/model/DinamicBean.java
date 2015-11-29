package es.sinjava.rest.model;

import java.net.URL;
import java.util.Map;

public class DinamicBean {

	private String name;
	private URL url;
	private Map<String, Category> property;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Category> getProperty() {
		return property;
	}

	public void setProperty(Map<String, Category> property) {
		this.property = property;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}
}
