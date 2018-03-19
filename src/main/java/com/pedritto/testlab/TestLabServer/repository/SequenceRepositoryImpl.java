package com.pedritto.testlab.TestLabServer.repository;

import com.pedritto.testlab.TestLabServer.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.*;

@Component
public class SequenceRepositoryImpl implements SequenceRepository {

    @Autowired
    private MongoOperations mongo;

    public int getNextSequence(String collection) {

        Counter counter = mongo.findAndModify(
                query(where("_id").is(collection)),
                new Update().inc("sequence", 1),
                options().returnNew(true),
                Counter.class);

        return counter.getSequence();
    }

}
