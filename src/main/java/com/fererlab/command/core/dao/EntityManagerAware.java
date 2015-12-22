package com.fererlab.command.core.dao;

import javax.persistence.EntityManager;

public interface EntityManagerAware {
    EntityManager getEntityManager();
}
