package de.itzbund.stplf.documents.documentmerger.load;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Component;

import de.itzbund.stplf.documents.documentmerger.dto.DocumentDataDTO;
import de.itzbund.stplf.documents.documentmerger.merge.MergeService;

@Component
public class LoadDataService {


	
	public DocumentDataDTO loadData(String pfadZurVorlage, String pfadOutput) {
		 try {
	            // Laden der Vorlagen-Datei
	            FileInputStream templateInputStream = new FileInputStream(pfadZurVorlage);
	            XWPFDocument document = new XWPFDocument(templateInputStream);
	            
	            // Hier kannst du Platzhalter ersetzen
	            MergeService.merge(document, "{%platzhalter%}", "Ersetzter Text1");
	            MergeService.merge(document, "Platzhalter2", "Ersetzter Text2");
	            
	            // Speichern des neuen Dokuments
	            FileOutputStream outputStream = new FileOutputStream(pfadOutput);
	            document.write(outputStream);
	            outputStream.close();
	            
	            // Schließen des Vorlagen-Dokuments
	            templateInputStream.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 return null;
		//return DocumentDataDTO.builder().build();
		
		
	}

}
