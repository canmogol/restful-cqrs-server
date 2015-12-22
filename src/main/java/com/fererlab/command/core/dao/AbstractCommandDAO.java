package com.fererlab.command.core.dao;

import com.fererlab.command.core.model.CommandModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.lang.reflect.ParameterizedType;


public abstract class AbstractCommandDAO<T extends CommandModel, PK> implements CommandDAO<T, PK>, EntityManagerAware {

    private Class<T> entityClass;

    @PersistenceUnit(unitName = "CommandPersistenceUnit")
    private EntityManagerFactory entityManagerFactory;

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @SuppressWarnings("unchecked")
    public AbstractCommandDAO() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void create(T t) {
        getEntityManager().persist(t);
    }

    @Override
    public void update(T t) {
        getEntityManager().merge(t);
    }

    @Override
    public void delete(T t) {
        getEntityManager().remove(t);
    }

    @Override
    public void delete(PK id) {
        T t = getEntityManager().getReference(entityClass, id);
        getEntityManager().remove(t);
    }

}
