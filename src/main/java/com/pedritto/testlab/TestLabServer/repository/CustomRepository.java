package com.pedritto.testlab.TestLabServer.repository;


public interface CustomRepository<T> {

    T findOne(String id);
}
