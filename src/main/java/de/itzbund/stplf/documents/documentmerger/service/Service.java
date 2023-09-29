package de.itzbund.stplf.documents.documentmerger.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.itzbund.stplf.documents.documentmerger.converter.BinaryDataConverter;
import de.itzbund.stplf.documents.documentmerger.dto.DocumentDataDTO;
import de.itzbund.stplf.documents.documentmerger.exception.DocumentMergerException;
import de.itzbund.stplf.documents.documentmerger.merge.MergeService;
import de.itzbund.stplf.documents.documentmerger.openoffice.OpenOfficeClient;
import de.itzbund.stplf.documents.documentmerger.read.ReadDocumentService;
import de.itzbund.stplf.documents.documentmerger.write.WriteDocumentService;

@Component
public class Service {

	@Autowired
	private ReadDocumentService readDocumentService;

	@Autowired
	private WriteDocumentService writeDocumentService;

	@Autowired
	private OpenOfficeClient openOfficeClient;

	public void doSmth(DocumentDataDTO data, String inputPath, String outputPath) {
		try {
			final var inputDoc = readDocumentService.readDocument(inputPath);

			MergeService.merge(inputDoc, data);

			// Upload of OpenOffice
			openOfficeClient.uploadFile(writeDocumentService.getFileName(outputPath),
					BinaryDataConverter.convert(inputDoc));

			writeDocumentService.writeDocument(inputDoc, outputPath);
		} catch (DocumentMergerException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
