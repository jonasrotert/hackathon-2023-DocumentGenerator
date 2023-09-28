package de.itzbund.stplf.documents.documentmerger.write;

import de.itzbund.stplf.documents.documentmerger.exception.DocumentMergerException;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;

@Component
@Log4j2
public class WriteDocumentService {

	public void writeDocument(XWPFDocument document, final String path) throws DocumentMergerException {
		log.info("Writing document {} ...", path);
		final var file = new File(path);

		try (final var fileOutputStream = new FileOutputStream(file.getAbsolutePath())) {
			document.write(fileOutputStream);
			document.close();
			log.info("Successful");
		} catch (Exception e) {
			throw new DocumentMergerException("Document cannot be written.");
		}

	}

}
