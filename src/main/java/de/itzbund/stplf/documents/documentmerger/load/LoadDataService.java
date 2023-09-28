package de.itzbund.stplf.documents.documentmerger.load;

import de.itzbund.stplf.documents.documentmerger.dto.DocumentDataDTO;
import org.springframework.stereotype.Component;

@Component
public class LoadDataService {

	public DocumentDataDTO loadData() {
		return DocumentDataDTO.builder().build();
	}

}
