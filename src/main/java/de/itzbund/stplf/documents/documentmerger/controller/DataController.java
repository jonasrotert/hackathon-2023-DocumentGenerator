package de.itzbund.stplf.documents.documentmerger.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.itzbund.stplf.documents.documentmerger.dto.DocumentDataDTO;
import de.itzbund.stplf.documents.documentmerger.service.Service;

@RestController
public class DataController {
    Logger logger = LoggerFactory.getLogger(DataController.class);

    @Autowired
    Service service;
    

    @RequestMapping(method = RequestMethod.POST, path = "/ersetzePlatzhalter")
    public void ersetzePlatzhalter(@RequestBody Map<String, String> daten) {
		DocumentDataDTO data =  DocumentDataDTO.builder().build();
		data.setPlaceholder(daten);
    	service.doSmth(data, "src/test/resources/Vorlage.docx","target/output.docx");
    	
    }
    
    
}
