package com.fererlab.query.core.dao;


import com.fererlab.query.core.model.QueryModel;

import javax.ejb.Local;
import java.util.List;


@Local
public interface QueryDAO<T extends QueryModel, PK> {

    T findById(PK id);

    List<T> list();

    List<T> list(Integer index, Integer numberOfRecords);

    Long count();

}
