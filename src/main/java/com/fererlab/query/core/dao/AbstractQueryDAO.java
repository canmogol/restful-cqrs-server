package com.fererlab.query.core.dao;

import com.fererlab.query.core.model.QueryModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public abstract class AbstractQueryDAO<T extends QueryModel, PK> implements QueryDAO<T, PK>, EntityManagerAware {

    private Class<T> entityClass;

    @PersistenceUnit(unitName = "QueryPersistenceUnit")
    private EntityManagerFactory entityManagerFactory;

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @SuppressWarnings("unchecked")
    public AbstractQueryDAO() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T findById(PK id) {
        EntityManager entityManager = getEntityManager();
        T t = entityManager.find(entityClass, id);
        return t;
    }

    @Override
    public List<T> list() {
        return list(0, Integer.MAX_VALUE);
    }

    public List<T> list(Integer index, Integer numberOfRecords) {
        EntityManager entityManager = getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        List<T> list = entityManager.createQuery(criteriaQuery)
                .setFirstResult(index).setMaxResults(numberOfRecords).getResultList();
        return list;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Long count() {
        EntityManager entityManager = getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(builder.count(root));
        Long count = entityManager.createQuery(criteriaQuery).getSingleResult();
        return count;
    }

}
