package com.fererlab.query.city.dao;


import com.fererlab.query.city.model.CityQuery;
import com.fererlab.query.core.dao.QueryDAO;

import javax.ejb.Local;
import java.util.List;


@Local
public interface CityQueryDAO extends QueryDAO<CityQuery, Integer> {

    List<CityQuery> findByName(String name);

}
