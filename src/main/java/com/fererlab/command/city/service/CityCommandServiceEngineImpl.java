package com.fererlab.command.city.service;


import com.fererlab.command.city.model.CityCommand;
import com.fererlab.command.city.serviceengine.CityCommandServiceEngine;
import com.fererlab.command.city.serviceengine.dto.CityCommandDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "CityCommandServiceEngineImpl", mappedName = "CityCommandServiceEngineImpl")
public class CityCommandServiceEngineImpl implements CityCommandServiceEngine {

    @EJB(beanName = "CityCommandServiceImpl")
    private CityCommandService cityCommandService;

    @EJB(beanName = "CityCommandCopyStrategy")
    private CityCommandCopyStrategy cityCommandCopyStrategy;

    @Override
    public void create(CityCommandDTO cityCommandDTO) {
        CityCommand cityCommand = new CityCommand();
        cityCommandCopyStrategy.copy(cityCommandDTO, cityCommand);
        cityCommandService.create(cityCommand);
    }

    @Override
    public void update(CityCommandDTO cityCommandDTO) {
        CityCommand cityCommand = new CityCommand();
        cityCommandCopyStrategy.copy(cityCommandDTO, cityCommand);
        cityCommandService.update(cityCommand);
    }

    @Override
    public void delete(CityCommandDTO cityCommandDTO) {
        CityCommand cityCommand = new CityCommand();
        cityCommandCopyStrategy.copy(cityCommandDTO, cityCommand);
        cityCommandService.delete(cityCommand);
    }

    @Override
    public void delete(Integer id) {
        cityCommandService.delete(id);
    }

}
