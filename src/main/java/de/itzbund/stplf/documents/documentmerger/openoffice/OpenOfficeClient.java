package de.itzbund.stplf.documents.documentmerger.openoffice;

import de.itzbund.stplf.documents.documentmerger.rest.RestClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.Map;

@Service
public class OpenOfficeClient {

    public final static String X_WOPI_OVERRIDE = "X-WOPI-Override";
    public final static String X_WOPI_SUGGESTED_TARGET = "X-WOPI-SuggestedTarget";
    private final static String BASE_URL = "http://localhost:80/example/wopi/";
    private final RestClient restClient;

    public OpenOfficeClient(WebClient.Builder webClientBuilder) {
        this.restClient = new RestClient(webClientBuilder, BASE_URL);
    }

    public Object uploadFile(final String fileName, final byte[] file) {
        return this.restClient.post("files/newfile", Collections.emptyList(), Collections.emptyMap(), Map.of(X_WOPI_OVERRIDE, "PUT_RELATIVE", X_WOPI_SUGGESTED_TARGET, fileName), file);
    }
}
