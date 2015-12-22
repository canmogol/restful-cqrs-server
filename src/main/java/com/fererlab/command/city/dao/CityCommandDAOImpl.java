package com.fererlab.command.city.dao;

import com.fererlab.command.city.model.CityCommand;
import com.fererlab.command.core.dao.AbstractCommandDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless(name = "CityCommandDAOImpl", mappedName = "CityCommandDAOImpl")
public class CityCommandDAOImpl extends AbstractCommandDAO<CityCommand, Integer> implements CityCommandDAO {

    public void deleteByName(String name) {
        // get entity manager from AbstractCommandDAO(EntityManagerAware) which is created from an read-write persistence unit's factory
        // we can use persist or delete methods of this entity manager,
        // and also we can change properties of entities to be merged/updated
        EntityManager entityManager = super.getEntityManager();
        TypedQuery<CityCommand> typedQuery = entityManager.createNamedQuery(CityCommand.NQ_DELETE_BY_NAME, CityCommand.class);
        typedQuery.setParameter("name", name);
        int result = typedQuery.executeUpdate();
    }

}
