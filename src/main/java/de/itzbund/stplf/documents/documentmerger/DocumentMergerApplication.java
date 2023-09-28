package de.itzbund.stplf.documents.documentmerger;

import de.itzbund.stplf.documents.documentmerger.exception.DocumentMergerException;
import de.itzbund.stplf.documents.documentmerger.load.LoadDataService;
import de.itzbund.stplf.documents.documentmerger.read.ReadDocumentService;
import de.itzbund.stplf.documents.documentmerger.write.WriteDocumentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class DocumentMergerApplication implements CommandLineRunner {

	@Autowired
	private LoadDataService loadDataService;

	@Autowired
	private ReadDocumentService readDocumentService;

	@Autowired
	private WriteDocumentService writeDocumentService;

	public static void main(String[] args) {
		SpringApplication.run(DocumentMergerApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("Starting DocumentMerger");

		String inputPath = "";
		String outputPath = "";

		for (int i = 0; i < args.length; ++i) {

			if (args[i].equals("-i") && i < args.length - 1) {
				inputPath = args[i + 1];
			}

			if (args[i].equals("-o") && i < args.length - 1) {
				outputPath = args[i + 1];
			}
		}

		if (inputPath.isEmpty()) {
			log.error("Input parameter -i is missing. Please provide an input path.");
			return;
		}


		if (outputPath.isEmpty()) {
			log.error("Output parameter -o is missing. Please provide an output path.");
			return;
		}

		try {
			final var inputDoc = this.readDocumentService.readDocument(inputPath);
			this.writeDocumentService.writeDocument(inputDoc, outputPath);
		} catch (DocumentMergerException e) {
			throw new RuntimeException(e);
		}
	}

}
