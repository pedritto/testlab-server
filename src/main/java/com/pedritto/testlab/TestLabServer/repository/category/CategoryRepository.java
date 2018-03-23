package com.pedritto.testlab.TestLabServer.repository.category;

import com.pedritto.testlab.TestLabServer.data.model.Category;
import com.pedritto.testlab.TestLabServer.repository.CustomRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String> , CustomRepository<Category> {

}
