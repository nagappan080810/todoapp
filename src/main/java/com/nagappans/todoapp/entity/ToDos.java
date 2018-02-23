package com.nagappans.todoapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="todos")
public class ToDos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String todoItem;
	
	private Status status=Status.NOT_STARTED;
	
	public ToDos() {
		super();
	}
	
	public ToDos(String todoItem, String status) {
		this.todoItem = todoItem;
		this.status = Status.findByValue(status);
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTodoItem() {
		return todoItem;
	}

	public void setTodoItem(String todoItem) {
		this.todoItem = todoItem;
	}
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = Status.findByValue(status);
	}


	public enum Status{
		NOT_STARTED,
		IN_PROGRESS,
		COMPLETED;
		
		static Status findByValue(String value) {
			for (Status status:values()) {
				if (status.name().equals(value)) {
					return status;
				}
			}
			return null;
		}
	}
}
