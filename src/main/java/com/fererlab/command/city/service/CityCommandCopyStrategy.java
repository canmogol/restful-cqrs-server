package com.fererlab.command.city.service;

import com.fererlab.command.city.model.CityCommand;
import com.fererlab.command.city.serviceengine.dto.CityCommandDTO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless(name = "CityCommandCopyStrategy", mappedName = "CityCommandCopyStrategy")
public class CityCommandCopyStrategy {

    public void copy(CityCommandDTO from, CityCommand to) {
        to.setId(from.getId());
        to.setName(from.getName());
        to.setHiddenName(from.getHiddenName());
        to.setPopulation(from.getPopulation());
    }

}
