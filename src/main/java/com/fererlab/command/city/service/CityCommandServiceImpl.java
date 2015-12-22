package com.fererlab.command.city.service;


import com.fererlab.command.city.dao.CityCommandDAO;
import com.fererlab.command.city.model.CityCommand;
import com.fererlab.command.core.dao.CommandDAO;
import com.fererlab.command.core.service.AbstractCommandService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "CityCommandServiceImpl", mappedName = "CityCommandServiceImpl")
public class CityCommandServiceImpl extends AbstractCommandService<CityCommand, Integer> implements CityCommandService {

    @EJB(beanName = "CityCommandDAOImpl")
    private CityCommandDAO cityCommandDAO;

    @Override
    public CommandDAO<CityCommand, Integer> getCommandDAO() {
        return cityCommandDAO;
    }

}
