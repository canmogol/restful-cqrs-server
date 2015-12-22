package com.fererlab.command.core.service;

import com.fererlab.command.core.dao.CommandDAO;
import com.fererlab.command.core.model.CommandModel;

public abstract class AbstractCommandService<T extends CommandModel, PK> implements CommandService<T, PK> {

    public abstract CommandDAO<T, PK> getCommandDAO();

    @Override
    public void create(T t) {
        getCommandDAO().create(t);
    }

    @Override
    public void update(T t) {
        getCommandDAO().update(t);
    }

    @Override
    public void delete(T t) {
        getCommandDAO().delete(t);
    }

    @Override
    public void delete(PK id) {
        getCommandDAO().delete(id);
    }


}
