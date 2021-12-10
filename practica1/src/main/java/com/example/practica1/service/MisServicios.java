package com.example.practica1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import com.example.practica1.model.dataApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/rest")
public class MisServicios {
	static String urlApple = "https://itunes.apple.com/search?term=";
	static String urlTV = "https://api.tvmaze.com/search/people?q=";
	static String urlTVPersonalized = "https://api.tvmaze.com/search/shows?q=";
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping(path="/test/{name}")
	public String test(@PathVariable("name") String name) {
		return "Hello " + name + ", Welcome to Practice 1";
	}
	
	@GetMapping(path="/find/{name}")
	public List<dataApi> find(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException {
		List<dataApi> info = new ArrayList<dataApi>();
		
		info = getDataApple(urlApple + name);
		info.addAll(getDataTV(urlTV + name));
		
		return info;
	}
	
	private List<dataApi> getDataApple(String url) throws JsonMappingException, JsonProcessingException {
		List<dataApi> info = new ArrayList<dataApi>();
		dataApi data;
		
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode results = root.path("results");
		JsonNode artistName, trackName, type;
		
		for(JsonNode result :results) {
			data  = new dataApi();
			artistName = result.path("artistName");
			trackName = result.path("trackName");
			type = result.path("wrapperType");
			
			data.setName(artistName.toString().replace("\"", ""));
			data.setTrackName(trackName.toString().replace("\"", ""));
			data.setType(type.toString().replace("\"", ""));
			data.setService("API iTunes");
			data.setUrl(url);
			
			info.add(data);
		}
		
		return info;
	}
	
	private List<dataApi> getDataTV(String url) throws JsonMappingException, JsonProcessingException {
		List<dataApi> info = new ArrayList<dataApi>();
		dataApi data;

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode people, name;
		
		for(JsonNode result :root) {
			data  = new dataApi();
			
			people = result.path("person");
			name = people.path("name");
			
			data.setName(name.toString().replace("\"", ""));
			data.setType("People");
			data.setService("API TVmaze");
			data.setUrl(url);
			
			info.add(data);
		}
		
		return info;
	}
	
	@GetMapping(path="/find/personalized/{name}")
	public List<dataApi> Personalized(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException {
		List<dataApi> info = new ArrayList<dataApi>();
		
		info = getDataApplePersonalized(urlApple + name);
		info.addAll(getDataTVPersonalized(urlTVPersonalized + name));
		
		return info;
	}
	
	private List<dataApi> getDataApplePersonalized(String url) throws JsonMappingException, JsonProcessingException {
		List<dataApi> info = new ArrayList<dataApi>();
		dataApi data;
		
		ResponseEntity<String> response = restTemplate.getForEntity(url + "&entity=musicVideo", String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode results = root.path("results");
		JsonNode artistName, trackName, type;
		
		for(JsonNode result :results) {
			data  = new dataApi();
			artistName = result.path("artistName");
			trackName = result.path("trackName");
			type = result.path("wrapperType");
			
			data.setName(artistName.toString().replace("\"", ""));
			data.setTrackName(trackName.toString().replace("\"", ""));
			data.setType(type.toString().replace("\"", ""));
			data.setService("API iTunes");
			data.setUrl(url + "&entity=musicVideo");
			
			info.add(data);
		}
		
		return info;
	}
	
	private List<dataApi> getDataTVPersonalized(String url) throws JsonMappingException, JsonProcessingException {
		List<dataApi> info = new ArrayList<dataApi>();
		dataApi data;

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode show, name, type;
		
		for(JsonNode result :root) {
			data  = new dataApi();
			
			show = result.path("show");
			name = show.path("name");
			type = show.path("type");
			
			data.setName(name.toString().replace("\"", ""));
			data.setType(type.toString().replace("\"", ""));
			data.setService("API TVmaze");
			data.setUrl(url);
			
			info.add(data);
		}
		
		return info;
	}
}
