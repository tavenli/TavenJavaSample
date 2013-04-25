package com.taven.app.hibernate.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * JPA操作数据库的基类
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-5-16
 *         </p>
 */
public abstract class BaseDaoImpl {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Transactional(readOnly = false)
	public void save(Object vo) {
		entityManager.persist(vo);
	}

	@Transactional(readOnly = false)
	public void delete(Object vo) {
		entityManager.remove(entityManager.merge(vo));
	}

	@Transactional(readOnly = false)
	public Object update(Object vo) {
		return entityManager.merge(vo);
	}

	public Object getById(Class<?> entityClass, Serializable id) {
		return entityManager.find(entityClass, id);
	}

	public Query createQuery(String hql) {
		return entityManager.createQuery(hql);
	}
}
