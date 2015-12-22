package com.fererlab.query.core.service;


import com.fererlab.query.core.model.QueryModel;

import javax.ejb.Local;
import java.util.List;

@Local
public interface QueryService<T extends QueryModel, PK> {

    T findById(PK id);

    List<T> list();

    List<T> list(Integer index, Integer numberOfRecords);

    Long count();

}
