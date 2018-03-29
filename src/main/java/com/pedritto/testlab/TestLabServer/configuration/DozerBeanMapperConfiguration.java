package com.pedritto.testlab.TestLabServer.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DozerBeanMapperConfiguration {

    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        List<String> myMappingFiles = new ArrayList<>();
        myMappingFiles.add("model-mapping.xml");
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(myMappingFiles);
        return dozerBeanMapper;
    }
}
