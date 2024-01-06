package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Todo;

@Controller
public class TodoRestServiceConsumerController {
	
	
	@GetMapping("/todo/{id}")
	public String todo(@PathVariable("id") int id, Model model) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Todo todo = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/"+id, Todo.class);
		
		model.addAttribute("todo", todo);
		
		return "todo-details";		
	}
	

	@GetMapping("/todos")
	public String todos(Model model) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Todo[] todos = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos", Todo[].class);
		
		model.addAttribute("todos", todos);
		
		return "todo-list";		
	}
	

}
