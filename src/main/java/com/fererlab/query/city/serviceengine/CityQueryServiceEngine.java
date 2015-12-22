package com.fererlab.query.city.serviceengine;


import com.fererlab.query.city.serviceengine.dto.CityDTO;
import com.fererlab.query.city.serviceengine.dto.CityListDTO;

import javax.ejb.Local;

@Local
public interface CityQueryServiceEngine {

    CityDTO findById(Integer id);

    CityListDTO list(Integer index, Integer numberOfRecords);

    Long count();

}
