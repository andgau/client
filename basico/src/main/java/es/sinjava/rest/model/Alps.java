package es.sinjava.rest.model;

import java.util.List;

public class Alps {

	private String version;
	private List<Descriptor> descriptors;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Descriptor> getDescriptors() {
		return descriptors;
	}

	public void setDescriptors(List<Descriptor> descriptors) {
		this.descriptors = descriptors;
	}

}
