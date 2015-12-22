package com.fererlab.query.city.service;

import com.fererlab.query.city.model.CityQuery;
import com.fererlab.query.city.serviceengine.CityQueryServiceEngine;
import com.fererlab.query.city.serviceengine.dto.CityDTO;
import com.fererlab.query.city.serviceengine.dto.CityListDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless(name = "CityQueryServiceEngineImpl", mappedName = "CityQueryServiceEngineImpl")
public class CityQueryServiceEngineImpl implements CityQueryServiceEngine {

    @EJB(beanName = "CityQueryServiceImpl")
    private CityQueryService cityQueryService;

    @EJB(beanName = "CityQueryCopyStrategy")
    private CityQueryCopyStrategy cityQueryCopyStrategy;

    @Override
    public CityDTO findById(Integer id) {
        CityDTO cityDTO = new CityDTO();
        CityQuery cityQuery = cityQueryService.findById(id);
        cityQueryCopyStrategy.copy(cityQuery, cityDTO);
        return cityDTO;
    }

    @Override
    public CityListDTO list(Integer index, Integer numberOfRecords) {
        CityListDTO cityListDTO = new CityListDTO();
        List<CityQuery> cityList = cityQueryService.list(index, numberOfRecords);
        cityQueryCopyStrategy.copy(cityList, cityListDTO);
        return cityListDTO;
    }

    @Override
    public Long count() {
        return cityQueryService.count();
    }
}
