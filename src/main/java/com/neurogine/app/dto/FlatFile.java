package com.neurogine.app.dto;

import org.beanio.annotation.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class FlatFile {
	// notes are not available in the latest version
	// Start location was 0 as per the given test.txt file
	
	@Field(length = 1, at = 0, name = "Type of the Header") 
	private String recordTypeHeader;

	@Field(length = 15, at = 13, name = "Flat File Type")
	private String fileTypeHeader;

	@Field(length = 14, at = 19, name = "Reference Number")
	private String referenceNumber;

	@Field(length = 16, at = 39, name = "Amount")
	private String amount;

	@Field(length = 1, at = 0, name = "Type of the Trailer")
	private String recordTypeTail;

	@Field(length = 15, at = 13, name = "Flat File Type")
	private String fileTypeTail;


}
