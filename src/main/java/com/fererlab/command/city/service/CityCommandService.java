package com.fererlab.command.city.service;

import com.fererlab.command.city.model.CityCommand;
import com.fererlab.command.core.service.CommandService;

import javax.ejb.Local;

@Local
public interface CityCommandService extends CommandService<CityCommand, Integer> {

}
