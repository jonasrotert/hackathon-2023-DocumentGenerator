package de.itzbund.stplf.documents.documentmerger.load;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Properties;

import org.springframework.stereotype.Component;

import de.itzbund.stplf.documents.documentmerger.dto.DocumentDataDTO;

@Component
public class LoadDataService {
	
	public DocumentDataDTO loadData(String propertiesPath) {
		DocumentDataDTO data =  DocumentDataDTO.builder().build();
		data.setPlaceholder(new HashMap<>());
		
		 Properties properties = new Properties();

	        try (FileInputStream input = new FileInputStream(propertiesPath)) {
	            InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8);

	        	properties.load(reader);
	            
	            for (String key : properties.stringPropertyNames()) {
	                String value = properties.getProperty(key);
	                data.getPlaceholder().put(key, value);
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }	
	        
		return data;
	
	}

}
