package com.nagappans.todoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagappans.todoapp.entity.ToDos;

public interface ToDosRepository extends JpaRepository<ToDos, Long>, ToDosRepositoryCustomSearch {
	List<ToDos> findByStatus(ToDos.Status status);
}
