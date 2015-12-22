package com.fererlab.command.city.dao;


import com.fererlab.command.city.model.CityCommand;
import com.fererlab.command.core.dao.CommandDAO;

import javax.ejb.Local;


@Local
public interface CityCommandDAO extends CommandDAO<CityCommand, Integer> {

    void deleteByName(String name);

}
