package es.sinjava.rest.model;

import java.net.URL;

public class Item {

	private URL href;
	private boolean templated;

	public URL getHref() {
		return href;
	}

	public void setHref(URL href) {
		this.href = href;
	}

	public boolean isTemplated() {
		return templated;
	}

	public void setTemplated(boolean templated) {
		this.templated = templated;
	}
}
