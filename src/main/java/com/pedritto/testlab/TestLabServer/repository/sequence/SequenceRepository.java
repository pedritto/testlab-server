package com.pedritto.testlab.TestLabServer.repository.sequence;


public interface SequenceRepository  {

    int getNextSequence(String collection);
}
