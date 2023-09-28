package de.itzbund.stplf.documents.documentmerger.load;

import org.springframework.stereotype.Component;

import de.itzbund.stplf.documents.documentmerger.dto.DocumentDataDTO;

@Component
public class LoadDataService {


	
	public DocumentDataDTO loadData() {
		 
		return DocumentDataDTO.builder().build();
		
		
	}

}
