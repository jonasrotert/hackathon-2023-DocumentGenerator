package de.itzbund.stplf.documents.documentmerger.rest;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

public class RestClient {

    private final WebClient webClient;

    public RestClient(WebClient.Builder webClientBuilder, final String baseUrl) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    public String get(final String path, List<String> pathParams, Map<String, List<String>> queryParams, Map<String, String> headerNameAndValue) {
        final var uri = buildUri(path, pathParams, queryParams);

        final var request = webClient
                .get()
                .uri(uri);

        for (final var entry : headerNameAndValue.entrySet()) {
            request.header(entry.getKey(), entry.getValue());
        }

        return request
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


    public String delete(final String path, List<String> pathParams, Map<String, List<String>> queryParams, Map<String, String> headerNameAndValue) {
        final var uri = buildUri(path, pathParams, queryParams);

        final var request = webClient
                .delete()
                .uri(uri);

        for (final var entry : headerNameAndValue.entrySet()) {
            request.header(entry.getKey(), entry.getValue());
        }

        return request
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


    public String put(final String path, List<String> pathParams, Map<String, List<String>> queryParams, Map<String, String> headerNameAndValue, Object bodyValue) {
        final var uri = buildUri(path, pathParams, queryParams);

        final var request = webClient
                .put()
                .uri(uri)
                .bodyValue(bodyValue);

        for (final var entry : headerNameAndValue.entrySet()) {
            request.header(entry.getKey(), entry.getValue());
        }

        return request
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


    public String post(final String path, List<String> pathParams, Map<String, List<String>> queryParams, Map<String, String> headerNameAndValue, Object bodyValue) {
        final var uri = buildUri(path, pathParams, queryParams);

        final var request = webClient
                .post()
                .uri(uri)
                .bodyValue(bodyValue);

        for (final var entry : headerNameAndValue.entrySet()) {
            request.header(entry.getKey(), entry.getValue());
        }

        return request
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private static String buildUri(String path, List<String> pathParams, Map<String, List<String>> queryParams) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(path);
        for (final String pathParam : pathParams) {
            uriComponentsBuilder.buildAndExpand(pathParam);
        }

        for (final var entry : queryParams.entrySet()) {
            uriComponentsBuilder.queryParam(entry.getKey(), entry.getValue());
        }

        final var url = uriComponentsBuilder.toUriString();
        return url;
    }
}
