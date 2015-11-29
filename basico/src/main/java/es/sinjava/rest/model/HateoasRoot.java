package es.sinjava.rest.model;

import java.util.Map;

public class HateoasRoot {
	private Map<String, Item> _links;

	public Map<String, Item> get_links() {
		return _links;
	}

	public void set_links(Map<String, Item> _links) {
		this._links = _links;
	}

}
