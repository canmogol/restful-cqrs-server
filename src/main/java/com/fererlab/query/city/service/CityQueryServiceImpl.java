package com.fererlab.query.city.service;

import com.fererlab.query.city.dao.CityQueryDAO;
import com.fererlab.query.city.model.CityQuery;
import com.fererlab.query.core.dao.QueryDAO;
import com.fererlab.query.core.service.AbstractQueryService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "CityQueryServiceImpl", mappedName = "CityQueryServiceImpl")
public class CityQueryServiceImpl extends AbstractQueryService<CityQuery, Integer> implements CityQueryService {

    @EJB(beanName = "CityQueryDAOImpl")
    private CityQueryDAO cityQueryDAO;

    @Override
    public QueryDAO<CityQuery, Integer> getQueryDAO() {
        return cityQueryDAO;
    }

}
