package com.pedritto.testlab.TestLabServer.repository;


public interface SequenceRepository  {

    int getNextSequence(String collection);
}
