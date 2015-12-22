package com.fererlab.command.core.model;

import java.io.Serializable;

public interface CommandModel<T> extends Serializable {

    T getId();

    void setId(T t);

}
