package com.hotel.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> {
	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	protected Criteria createEntityCriteria() {
		return getSession().createCriteria(persistentClass);
	}

	public String generateID(String prefix, String column) {
		String generateId = "";
		Criteria criteria = getSession().createCriteria(persistentClass).setProjection(Projections.max(column));
		String maxId = (String) criteria.uniqueResult();
		int b = 0;
		if (maxId != null) {
			String a = maxId.substring(1);
			b = Integer.parseInt(a);
		}
		if (b <= 8) {
			b += 1;
			generateId += prefix + "000" + b;
			return generateId;
		} else {
			b += 1;
			generateId += prefix + "00" + b;
			return generateId;
		}
	}

}
