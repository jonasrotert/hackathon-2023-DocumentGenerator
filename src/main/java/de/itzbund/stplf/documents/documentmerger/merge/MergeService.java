package de.itzbund.stplf.documents.documentmerger.merge;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.util.Strings;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Component;

import de.itzbund.stplf.documents.documentmerger.dto.DocumentDataDTO;

@Component
public class MergeService {

	public static void merge(XWPFDocument document, DocumentDataDTO data) {
		// Platzhalter in Tabellen ersetzen
		for (var table : document.getTables()) {
			for (var row : table.getRows()) {
				for (var cell : row.getTableCells()) {
					mergeDataInParagraphes(data, cell.getParagraphs());
				}
			}
		}

		// Platzhalter im Fließtext ersetzen
		mergeDataInParagraphes(data, document.getParagraphs());

	}

	private static void mergeDataInParagraphes(DocumentDataDTO data, List<XWPFParagraph> paragraphList) {
		Pattern pattern = Pattern.compile("\\{\\S+\\}");

		for (XWPFParagraph paragraph : paragraphList) {
			for (XWPFRun run : paragraph.getRuns()) {
				String text = run.getText(0);
				if (!Strings.isBlank(text)) {
					Matcher matcher = pattern.matcher(text);
					if (matcher.find()) {
						String key = matcher.group();
						run.setText(text.replace(key, data.getPlaceholder().get(key)), 0);
					}
				}
			}
		}
	}
}
