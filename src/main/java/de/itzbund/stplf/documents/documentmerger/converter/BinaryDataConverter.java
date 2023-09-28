package de.itzbund.stplf.documents.documentmerger.converter;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BinaryDataConverter {

    public static byte[] convert(XWPFDocument document) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        document.write(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
