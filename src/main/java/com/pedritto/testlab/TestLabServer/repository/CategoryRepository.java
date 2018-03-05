package com.pedritto.testlab.TestLabServer.repository;

import com.pedritto.testlab.TestLabServer.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
