package com.safri.latihanSpringBoot.Controllers;

import com.safri.latihanSpringBoot.Entity.Todo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class TodoController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("todo-list")
    public String getTodo(){
        String result = restTemplate.getForObject("http://jsonplaceholder.typicode.com/todos", String.class);
        return result;
    }

    @GetMapping("todo/post")
    public String postTodo(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Todo newTodo = new Todo();
        newTodo.setId((long) 1000);
        newTodo.setUserId((long) 88);
        newTodo.setTitle("Preman Pensiun Bro");
        newTodo.setCompleted(false);

        HttpEntity<Todo> entity = new HttpEntity<Todo>(newTodo, headers);

        return restTemplate.exchange("http://jsonplaceholder.typicode.com/todos", HttpMethod.POST,
                entity, String.class).getBody();

    }

    @GetMapping("todo/delete")
    public String deleteTodo(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Todo newTodo = new Todo();
        newTodo.setId((long) 1000);

        HttpEntity<Todo> entity = new HttpEntity<Todo>(newTodo, headers);

        return restTemplate.exchange("http://jsonplaceholder.typicode.com/todos/" + newTodo.getId(),
                HttpMethod.DELETE, entity, String.class).getBody();

    }

    @GetMapping("todo/update/{id}")
    public String updateTodo(@PathVariable("id") String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Todo updateTodo = new Todo();
        updateTodo.setUserId((long) 42342);
        updateTodo.setTitle("SMPN 113");
        updateTodo.setCompleted(true);

        HttpEntity<Todo> entity = new HttpEntity<Todo>(updateTodo, headers);

        return restTemplate.exchange("http://jsonplaceholder.typicode.com/todos/" + id,
                HttpMethod.PUT, entity, String.class).getBody();

    }

}
