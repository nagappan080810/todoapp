package com.nagappans.todoapp.repository;

import java.util.List;

import com.nagappans.todoapp.entity.ToDos;

public interface ToDosRepositoryCustomSearch {
	
	List<ToDos> findToDos(ToDos.Status status, String todoItem);

}
