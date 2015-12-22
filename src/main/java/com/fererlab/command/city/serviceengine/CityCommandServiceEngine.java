package com.fererlab.command.city.serviceengine;


import com.fererlab.command.city.serviceengine.dto.CityCommandDTO;

import javax.ejb.Local;

@Local
public interface CityCommandServiceEngine {

    void create(CityCommandDTO cityCommandDTO);

    void update(CityCommandDTO cityCommandDTO);

    void delete(CityCommandDTO cityCommandDTO);

    void delete(Integer id);

}
