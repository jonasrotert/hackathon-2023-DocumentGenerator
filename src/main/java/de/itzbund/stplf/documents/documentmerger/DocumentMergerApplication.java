package de.itzbund.stplf.documents.documentmerger;

import de.itzbund.stplf.documents.documentmerger.load.LoadDataService;
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

	public static void main(String[] args) {
		SpringApplication.run(DocumentMergerApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("Starting DocumentMerger");

		for (int i = 0; i < args.length; ++i) {
			log.info("args[{}]: {}", i, args[i]);
		}
	}

}
