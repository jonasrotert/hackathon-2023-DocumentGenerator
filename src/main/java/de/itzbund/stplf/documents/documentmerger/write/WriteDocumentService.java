package de.itzbund.stplf.documents.documentmerger.write;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Component;

import de.itzbund.stplf.documents.documentmerger.exception.DocumentMergerException;
import lombok.extern.log4j.Log4j2;

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

	public String getFileName(final String filePath) {
		return Paths.get(filePath).getFileName().toString();
	}

}
