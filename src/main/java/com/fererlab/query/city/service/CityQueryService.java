package com.fererlab.query.city.service;

import com.fererlab.query.city.model.CityQuery;
import com.fererlab.query.core.service.QueryService;

import javax.ejb.Local;

@Local
public interface CityQueryService extends QueryService<CityQuery, Integer> {

}
