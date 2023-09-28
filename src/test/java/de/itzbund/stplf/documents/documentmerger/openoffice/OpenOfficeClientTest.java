package de.itzbund.stplf.documents.documentmerger.openoffice;

import de.itzbund.stplf.documents.documentmerger.config.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
@Import(Configuration.class)
public class OpenOfficeClientTest {

    @Autowired
    private OpenOfficeClient openOfficeClient;

    @Test
    void testUpload() throws IOException {
        final var inputStream = getClass().getResourceAsStream("/openoffice/test.docx");
        openOfficeClient.uploadFile("test.docx", convert(inputStream));
    }

    public static byte[] convert(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024]; // Puffergröße für das Lesen

        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
        }

        return byteArrayOutputStream.toByteArray();
    }
}
