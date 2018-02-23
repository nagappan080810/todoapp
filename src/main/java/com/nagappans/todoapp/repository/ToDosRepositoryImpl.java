package com.nagappans.todoapp.repository;

import java.util.List;
import java.util.StringJoiner;

import javax.net.ssl.SSLEngineResult.Status;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagappans.todoapp.entity.ToDos;

@Repository
@Transactional(readOnly=true)
public class ToDosRepositoryImpl implements ToDosRepositoryCustomSearch{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<ToDos> findToDos(ToDos.Status status, String todoItem) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ToDos> query = builder.createQuery(ToDos.class);
		
		Root<ToDos> root = query.from(ToDos.class);
		
		Predicate predicate = builder.conjunction();
		predicate = builder.and(predicate, builder.equal(root.get("status"), status));
		if (null!=todoItem) {
			Path<String> path = root.get("todoItem");
			predicate = builder.and(predicate, builder.like(path, todoItem+"%"));
		}
		query = query.where(predicate);
		
		return entityManager.createQuery(query).getResultList();
	}
}