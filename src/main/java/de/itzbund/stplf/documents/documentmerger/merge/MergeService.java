package de.itzbund.stplf.documents.documentmerger.merge;


import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Component;

@Component
public class MergeService {
	
	public static void merge(XWPFDocument document, String placeholder, String replacement) {
		for (XWPFParagraph paragraph : document.getParagraphs()) {
			List<XWPFRun> runs = paragraph.getRuns();
			for (XWPFRun run : runs) {
				String text = run.getText(0);
				if (text != null && text.contains(placeholder)) {
					text = text.replace(placeholder, replacement);
					run.setText(text, 0);
				}
			}
		}
	}
}
