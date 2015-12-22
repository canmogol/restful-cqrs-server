package com.fererlab.query.core.dao;

import javax.persistence.EntityManager;

public interface EntityManagerAware {
    EntityManager getEntityManager();
}
