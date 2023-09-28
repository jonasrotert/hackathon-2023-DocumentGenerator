package de.itzbund.stplf.documents.documentmerger.dto;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentDataDTO {

	Map<String, String> placeholder;

}
