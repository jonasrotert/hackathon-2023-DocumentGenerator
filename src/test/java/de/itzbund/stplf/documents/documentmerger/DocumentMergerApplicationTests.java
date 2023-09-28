package de.itzbund.stplf.documents.documentmerger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.itzbund.stplf.documents.documentmerger.dto.DocumentDataDTO;
import de.itzbund.stplf.documents.documentmerger.exception.DocumentMergerException;
import de.itzbund.stplf.documents.documentmerger.load.LoadDataService;
import de.itzbund.stplf.documents.documentmerger.merge.MergeService;
import de.itzbund.stplf.documents.documentmerger.read.ReadDocumentService;
import de.itzbund.stplf.documents.documentmerger.write.WriteDocumentService;

@SpringBootTest
class DocumentMergerApplicationTests {

	@Autowired
	private LoadDataService loadDataService;
	
	@Autowired
	private ReadDocumentService readDocumentService;

	@Autowired
	private WriteDocumentService writeDocumentService;
	
	@Test
	void contextLoads() {
	}

	@Test
	void test() throws DocumentMergerException {		
		var inputDoc = readDocumentService.readDocument("src\\test\\resources\\Vorlage.docx");
				
		DocumentDataDTO data = loadDataService.loadData("src\\test\\resources\\data.properties");
		
		MergeService.merge(inputDoc, data);
		
		writeDocumentService.writeDocument(inputDoc, "target\\Generiert.docx");
		
	}
}
