package com.blog.FrameBlog.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TodosServiceClient {
	//Classe de consumo de API fake
	public Object[] getAllTodos() {
		RestTemplate restTemplate = new RestTemplate();
		
		String fakeApiUrl = "http://jsonplaceholder.typicode.com/todos";
		return restTemplate.getForObject(fakeApiUrl, Object[].class);
	}
}
