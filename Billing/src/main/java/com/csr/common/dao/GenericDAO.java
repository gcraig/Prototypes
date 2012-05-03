package com.csr.common.dao;

import org.hibernate.*;
import org.hibernate.criterion.*;
import java.io.*;
import java.util.*;

public class GenericDAO extends DAO
{
	private Class persistentClass;
	private Session session;

	public GenericDAO()
	{
	}

	public GenericDAO(Class persistentClass, Session session)
	{
		this.persistentClass = persistentClass;
		this.session = session;
	}

	protected void setPersistentClass(Class persistentClass, Session session)
	{
		this.persistentClass = persistentClass;
		this.session = session;
	}

	protected Session getSession()
	{
		return this.session;
	}

	public Class getPersistentClass()
	{
        return this.persistentClass.getClass();
    }

	public int countAll() throws Exception
	{
		Query q = getSession().createQuery(
			"select count(*) from " + getPersistentClass().getName());
		Object o = q.uniqueResult();
		Integer i = new Integer(o.toString());
		System.out.println( i );
		return i.intValue();
	}

    public Object makePersistent(Object entity) throws Exception
	{
        getSession().saveOrUpdate(entity);
        return entity;
    }

    public void makeTransient(Object entity)
	{
        getSession().delete(entity);
    }

    public List findAll() throws Exception
	{
		return null;
        // 1.5
        // return findByCriteria();
    }

	public Object findByID(String id)  throws Exception
	{
		Object entity;
		entity = (Object) getSession().load(getPersistentClass(), id);
        return entity;
	}

/*
	1.5

	protected List findByCriteria(Criterion... criterion) throws Exception
	{
		Criteria criteria = getSession().createCriteria( getPersistentClass() );

		for (Criterion c : criterion)
		{
			criteria.add(c);
		}

		try
		{
			return criteria.list();
		}
		catch (HibernateException e)
		{
			throw new Exception(e);
		}
	}
*/

	public List search(String startRecord, int pageSize) throws Exception
	{
		Criteria criteria = getSession().createCriteria( getPersistentClass() );
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(new Integer(startRecord).intValue());

		try
		{
			return criteria.list();
		}
		catch (HibernateException e)
		{
			throw new Exception(e);
		}
	}
}