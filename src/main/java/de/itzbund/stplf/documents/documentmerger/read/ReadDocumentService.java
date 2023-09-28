package de.itzbund.stplf.documents.documentmerger.read;

import de.itzbund.stplf.documents.documentmerger.exception.DocumentMergerException;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;

@Component
@Log4j2
public class ReadDocumentService {

	public XWPFDocument readDocument(final String path) throws DocumentMergerException {
		log.info("Reading document {} ...", path);
		final var file = new File(path);

		try (final var fis = new FileInputStream(file.getAbsolutePath())) {
			final var document = new XWPFDocument(fis);
			log.info("Successful");
			return document;
		} catch (Exception e) {
			throw new DocumentMergerException("Document cannot be read.");
		}

	}

}
