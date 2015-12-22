package com.fererlab.query.city.dao;

import com.fererlab.query.city.model.CityQuery;
import com.fererlab.query.core.dao.AbstractQueryDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless(name = "CityQueryDAOImpl", mappedName = "CityQueryDAOImpl")
public class CityQueryDAOImpl extends AbstractQueryDAO<CityQuery, Integer> implements CityQueryDAO {

    public List<CityQuery> findByName(String name) {
        // get entity manager from AbstractQueryDAO(EntityManagerAware) which is created from an read-only persistence unit's factory
        // we cannot use persist or delete methods of this entity manager,
        // and also we cannot change properties of entities to be merged/updated since this is only a read-only db connection
        EntityManager entityManager = super.getEntityManager();
        TypedQuery<CityQuery> typedQuery = entityManager.createNamedQuery(CityQuery.NQ_FIND_BY_NAME, CityQuery.class);
        typedQuery.setParameter("name", name);
        return typedQuery.getResultList();
    }

}
