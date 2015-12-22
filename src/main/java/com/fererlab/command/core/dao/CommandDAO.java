package com.fererlab.command.core.dao;


import com.fererlab.command.core.model.CommandModel;

import javax.ejb.Local;


@Local
public interface CommandDAO<T extends CommandModel, PK> {

    void create(T t);

    void update(T t);

    void delete(T t);

    void delete(PK id);

}
