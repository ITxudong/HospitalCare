package com.kaishengit.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;

import com.kaishengit.util.Page;
import com.kaishengit.util.PropertyFilter;

@SuppressWarnings("unchecked")
public class BaseDao<T,PK extends Serializable> {

	private Class<?> tClass;
	
	public BaseDao() {
		Class<?> clazz = this.getClass();
		ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
		Type[] types = type.getActualTypeArguments();
		tClass = (Class<?>) types[0];
	}
	
	@Inject
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void save(T t) {
		getSession().saveOrUpdate(t);
	}
	
	public T findById(PK id) {
		return (T) getSession().get(tClass, id);
	}
	
	public List<T> findAll() {
		return createCriteria().list();
	} 
	
	public List<T> findAll(List<PropertyFilter> filterList) {
		Criteria cri = createCriteria();
		buildCondition(cri,filterList);
		cri.addOrder(Order.desc("createtime"));
		return cri.list();
	}
	
	public Page<T> findByPage(List<PropertyFilter> filterList,String pageNo) {
		Criteria cri = createCriteria();
		buildCondition(cri, filterList);
		
		int totalCount = count(cri).intValue();
		
		Page<T> page = new Page<T>(2,totalCount,pageNo);
		cri.setFirstResult(page.getFrom());
		cri.setMaxResults(page.getPageSize());
		List<T> items = cri.list();
		page.setItems(items);
		
		return page;
	}
	
	public Page<T> findByPage(List<PropertyFilter> filterList,String pageNo,String orderByProperty,String orderBytype) {
		Criteria cri = createCriteria();
		buildCondition(cri, filterList);
		
		int totalCount = count(cri).intValue();
		
		Page<T> page = new Page<T>(2,totalCount,pageNo);
		cri.setFirstResult(page.getFrom());
		cri.setMaxResults(page.getPageSize());
		
		if("desc".equalsIgnoreCase(orderBytype)) {
			cri.addOrder(Order.desc(orderByProperty));
		} else if("asc".equalsIgnoreCase(orderBytype)){
			cri.addOrder(Order.asc(orderByProperty));
		}
		
		List<T> items = cri.list();
		page.setItems(items);
		
		return page;
	}
	
	
	private Long count(Criteria cri) {
		@SuppressWarnings("static-access")
		ResultTransformer rtf = cri.ROOT_ENTITY;
		
		cri.setProjection(Projections.rowCount());
		Long result = (Long) cri.uniqueResult();
		
		cri.setProjection(null);
		cri.setResultTransformer(rtf);
		
		return result;
	}

	public void buildCondition(Criteria cri, List<PropertyFilter> filterList) {
		for(PropertyFilter filter : filterList) {
			String  type = filter.getType();
			String propertyName = filter.getPropertyName();
			Object value = filter.getValue();
			System.out.println("propertyname:"+propertyName);
			System.out.println("value:"+value);
			if(propertyName.contains("_OR_")) {
				String[] parNames = propertyName.split("_OR_");
				//Disjunction add进去的语句之间的关系为or
				Disjunction dis = Restrictions.disjunction();
				for(String name : parNames) {
					Criterion cr = builderConditionByProperty(type,name,value);	
					dis.add(cr);
				}
				cri.add(dis);
			} else {
				cri.add(builderConditionByProperty(type,propertyName,value));
			}
		}
		
	}

	public Criterion builderConditionByProperty(String type,String propertyName,Object value) {
		if(type.equalsIgnoreCase("eq")) {
			return Restrictions.eq(propertyName, value);
		} else if(type.equalsIgnoreCase("like")) {
			return Restrictions.like(propertyName, value.toString(), MatchMode.ANYWHERE);
		} else if(type.equalsIgnoreCase("gt")) {
			return Restrictions.gt(propertyName, value);
		} else if(type.equalsIgnoreCase("ge")) {
			return Restrictions.ge(propertyName, value);
		} else if(type.equalsIgnoreCase("lt")) {
			return Restrictions.lt(propertyName, value);
		} else if(type.equalsIgnoreCase("le")) {
			return Restrictions.le(propertyName, value);
		} else if(type.equalsIgnoreCase("bt")) {
			String[] t = value.toString().split(" - ");
			return Restrictions.between(propertyName, t[0].replace("/", "-"), t[1].replace("/", "-"));
		}
		return null;
	}
	
	
	public void del(PK id) {
		getSession().delete(findById(id));
	}
	
	public void del(T t) {
		getSession().delete(t);
	}
	
	public List<T> findListByProperty(String propertyName,String value) {
		Criteria cri = createCriteria();
		cri.add(Restrictions.eq(propertyName, value));
		return cri.list();
	}
	
	public T findEntityByProperty(String propertyName,Object value) {
		Criteria cri = createCriteria();
		cri.add(Restrictions.eq(propertyName, value));
		return (T) cri.uniqueResult();
	}
	
	public Criteria createCriteria() {
		return getSession().createCriteria(tClass);
	}
	
	
	
}
