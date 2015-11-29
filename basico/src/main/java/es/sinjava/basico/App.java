package es.sinjava.basico;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import es.sinjava.rest.model.Alps;
import es.sinjava.rest.model.Category;
import es.sinjava.rest.model.Descriptor;
import es.sinjava.rest.model.DinamicBean;
import es.sinjava.rest.model.HateoasRoot;
import es.sinjava.rest.model.Item;
import es.sinjava.rest.model.ModelHateoas;

public class App {
	public static void main(String... args) throws ClientHandlerException,
			UniformInterfaceException, IOException {

		String destiny = "http://localhost:8888/";
		if (args != null && args.length > 1 && args[0] != null) {
			System.out.println("Capturada la url");
			destiny = args[0];
		}
		Client client = Client.create();
		WebResource webResource = client.resource(destiny);
		ObjectMapper om = new ObjectMapper();

		ClientResponse response2 = webResource.accept("application/json").get(
				ClientResponse.class);
		if (response2.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response2.getStatus());
		}
		HateoasRoot hateoas = om.readValue(response2.getEntity(String.class),
				HateoasRoot.class);
		System.out.println(" Recibidos " + hateoas.get_links().size());
		for (Entry<String, Item> item : hateoas.get_links().entrySet()) {
			System.out.println("-> " + item.getKey() + " - "
					+ item.getValue().getHref());
		}
		// REcuperamos los descriptores del profile:

		URL profileURL = hateoas.get_links().get("profile").getHref();
		WebResource webResource2 = client.resource(profileURL.toString());
		ClientResponse profileResponse = webResource2
				.accept("application/json").get(ClientResponse.class);

		if (profileResponse.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ profileResponse.getStatus());
		}
		HateoasRoot profiles = om.readValue(
				profileResponse.getEntity(String.class), HateoasRoot.class);
		System.out.println(profiles.get_links().size());
		profiles.get_links().remove("self");
		System.out.println(profiles.get_links().size());

		Map<String, Alps> mapaModels = new HashMap<>();

		for (Entry<String, Item> hateoasEntitys : profiles.get_links()
				.entrySet()) {
			webResource2 = client.resource(hateoasEntitys.getValue().getHref()
					.toString());
			profileResponse = webResource2.accept("application/json").get(
					ClientResponse.class);
			if (profileResponse.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ profileResponse.getStatus());
			}
			ModelHateoas model = om
					.readValue(profileResponse.getEntity(String.class),
							ModelHateoas.class);
			mapaModels.put(hateoasEntitys.getKey(), model.getAlps());
		}

		List<DinamicBean> dinamicBeanList = new ArrayList<>();
		for (String fieldSelected : mapaModels.keySet()) {
			for (Descriptor item : mapaModels.get(fieldSelected)
					.getDescriptors()) {
				if (item.getType() == null && item.getDescriptors() != null) {
					System.out.println(item);
					DinamicBean dinamicBean = dinamicBeanForDescriptor(
							fieldSelected, hateoas.get_links(), item);
					dinamicBeanList.add(dinamicBean);
				}
			}
		}
		System.out.println("Sacabao" + dinamicBeanList.size());
	}

	private static DinamicBean dinamicBeanForDescriptor(String fieldSelected,
			Map<String, Item> urls, Descriptor desc) {
		DinamicBean db = new DinamicBean();
		db.setName(fieldSelected);
		db.setUrl(urls.get(fieldSelected).getHref());
		db.setProperty(new HashMap<>());
		for (Descriptor property : desc.getDescriptors()) {
			if (property.getDoc() == null) {
				db.getProperty().put(property.getName(), Category.STRING);
			} else if (property.getDoc() != null) {
				db.getProperty().put(property.getName(), Category.ENUMERATED);
			}
		}
		return db;
	}
}
