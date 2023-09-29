package de.itzbund.stplf.documents.documentmerger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.itzbund.stplf.documents.documentmerger.load.LoadDataService;
import de.itzbund.stplf.documents.documentmerger.service.Service;
import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class DocumentMergerApplication implements CommandLineRunner {

	@Autowired
	private LoadDataService loadDataService;


	public static void main(String[] args) {
		SpringApplication.run(DocumentMergerApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("Starting DocumentMerger");

		String inputPath = "";
		String outputPath = "";
		String dataPath = "";

		for (int i = 0; i < args.length; ++i) {

			if (args[i].equals("-i") && i < args.length - 1) {
				inputPath = args[i + 1];
			}

			if (args[i].equals("-o") && i < args.length - 1) {
				outputPath = args[i + 1];
			}
			if(args[i].equals("-d") && i<args.length-1) {
				dataPath = args[i+1];
			}
		}

		if (inputPath.isEmpty()) {
			log.error("Input parameter -i is missing. Please provide an input path.");
			
		}

		if (outputPath.isEmpty()) {
			log.error("Output parameter -o is missing. Please provide an output path.");
		}
		
		if (dataPath.isEmpty()) {
			log.error("Data parameter -d is missing. Please provide a data path.");
		}
		
		//Service.doSmth(this.loadDataService.loadData(dataPath), inputPath, outputPath);

		
    }
	
	
	
}
