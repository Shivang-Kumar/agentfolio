package com.github.shivang.agentfolio.config.reader;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.shivang.agentfolio.config.exception.AgentConfigurationException;
import com.github.shivang.agentfolio.config.properties.AgentProperties;


@Component
public class AgentConfigurationReader {
	
	private final ObjectMapper objectMapper;
	
	public AgentConfigurationReader()
	{
		this.objectMapper=new ObjectMapper(new YAMLFactory());;
	}

    public AgentProperties read(Path configFile){
    	
    	try{
        return objectMapper.readValue(configFile.toFile(), AgentProperties.class);        
    	}
    	catch(Exception ex)
    	{
    		System.out.println(ex);
    		throw new AgentConfigurationException("Failed to read configuration file: "+configFile);
    	}
    }

}