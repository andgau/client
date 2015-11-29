package es.sinjava.rest.model;

import java.net.URL;
import java.util.List;
import java.util.Map;

public class Descriptor {

	private String name;
	private String type;
	private String rt;
	private String id;
	private URL href;
	
	private Map<String, String> doc;
	
	private List<Descriptor> descriptors;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	public Map<String, String> getDoc() {
		return doc;
	}

	public void setDoc(Map<String, String> doc) {
		this.doc = doc;
	}

	public List<Descriptor> getDescriptors() {
		return descriptors;
	}

	public void setDescriptors(List<Descriptor> descriptors) {
		this.descriptors = descriptors;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public URL getHref() {
		return href;
	}

	public void setHref(URL href) {
		this.href = href;
	}
	@Override
	public String toString() {
		return "Descriptor [name=" + name + ", type=" + type + ", rt=" + rt
				+ ", id=" + id + ", href=" + href + ", doc=" + doc
				+ ", descriptors=" + descriptors + "]";
	}

}
