package com.fererlab.command.core.service;

import com.fererlab.command.core.model.CommandModel;

import javax.ejb.Local;

@Local
public interface CommandService<T extends CommandModel, PK> {

    void create(T t);

    void update(T t);

    void delete(T t);

    void delete(PK id);

}
