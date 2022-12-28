package com.tosan.core.operation;

public interface Operation {

    OperationType getOperationType();

    void rollback();
}
