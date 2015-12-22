package com.fererlab.query.core.service;

import com.fererlab.query.core.dao.QueryDAO;
import com.fererlab.query.core.model.QueryModel;

import java.util.List;

public abstract class AbstractQueryService<T extends QueryModel, PK> implements QueryService<T, PK> {

    public abstract QueryDAO<T, PK> getQueryDAO();

    @Override
    public T findById(PK id) {
        return getQueryDAO().findById(id);
    }

    @Override
    public List<T> list() {
        return getQueryDAO().list();
    }

    @Override
    public List<T> list(Integer index, Integer numberOfRecords) {
        return getQueryDAO().list(index, numberOfRecords);
    }

    @Override
    public Long count() {
        return getQueryDAO().count();
    }

}
