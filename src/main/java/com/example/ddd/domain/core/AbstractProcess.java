package com.example.ddd.domain.core;

public interface AbstractProcess<T extends AbstractProcessInput> {
    Result execute(T abstractProcessInput);
}
