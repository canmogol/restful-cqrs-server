package com.fererlab.query.city.service;

import com.fererlab.query.city.model.CityQuery;
import com.fererlab.query.city.serviceengine.dto.CityDTO;
import com.fererlab.query.city.serviceengine.dto.CityListDTO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@LocalBean
@Stateless(name = "CityQueryCopyStrategy", mappedName = "CityQueryCopyStrategy")
public class CityQueryCopyStrategy {

    public void copy(CityQuery from, CityDTO to) {
        to.setId(from.getId());
        to.setName(from.getName());
    }

    public void copy(List<CityQuery> from, CityListDTO to) {
        for (CityQuery cityQuery : from) {
            CityDTO cityDTO = new CityDTO();
            copy(cityQuery, cityDTO);
            to.getCityList().add(cityDTO);
        }
    }
}
