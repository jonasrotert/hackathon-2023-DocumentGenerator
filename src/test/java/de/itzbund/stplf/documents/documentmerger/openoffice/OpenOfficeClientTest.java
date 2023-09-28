package de.itzbund.stplf.documents.documentmerger.openoffice;

import de.itzbund.stplf.documents.documentmerger.config.Configuration;
import de.itzbund.stplf.documents.documentmerger.rest.RestClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.Map;

@SpringBootTest
@Import(Configuration.class)
public class OpenOfficeClientTest {

    @Autowired
    private OpenOfficeClient openOfficeClient;

    @Test
    void testUpload() {
        openOfficeClient.uploadFile("upload_test_0001.xlsx", new byte[10]);
    }
}
