package com.nagappans.todoapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagappans.todoapp.entity.ToDos;
import com.nagappans.todoapp.repository.ToDosRepository;

@RestController
@RequestMapping(value="/todos")
public class ToDosController {

	@Autowired ToDosRepository todosRepository;
	
	@RequestMapping(method=RequestMethod.POST)
	public boolean saveToDoItem(@Valid @RequestBody ToDos todos) {
		System.out.println("save todos method");
		todosRepository.save(todos);
		return true;
	}
	
	@RequestMapping(value="/filter", method=RequestMethod.GET)
	public List<ToDos> findToDoItems(@RequestParam(value="status") String status,
								@RequestParam(value="todoItem", required=false) String todoItem) {
		System.out.println("find todos method");
		//return todosRepository.findByStatus(ToDos.Status.valueOf(status));
		return todosRepository.findToDos(ToDos.Status.valueOf(status), todoItem);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ToDos> findAllToDoItems() {
		System.out.println("find All todos method");
		return todosRepository.findAll();
	}
}
