package de.itzbund.stplf.documents.documentmerger;

import org.junit.jupiter.api.Test;

import de.itzbund.stplf.documents.documentmerger.load.LoadDataService;

public class LoadDataServiceTest {
	@Test
	void test() {		
		LoadDataService loadDataService = new LoadDataService();
		loadDataService.loadData("src/test/resources/Vorlage.docx", "Generiert.docx");
	}
}
