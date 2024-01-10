package com.neurogine.app.dto;

import org.beanio.annotation.Field;

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

	public String getRecordTypeHeader() {
		return recordTypeHeader;
	}

	public void setRecordTypeHeader(String recordTypeHeader) {
		this.recordTypeHeader = recordTypeHeader;
	}

	public String getFileTypeHeader() {
		return fileTypeHeader;
	}

	public void setFileTypeHeader(String fileTypeHeader) {
		this.fileTypeHeader = fileTypeHeader;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRecordTypeTail() {
		return recordTypeTail;
	}

	public void setRecordTypeTail(String recordTypeTail) {
		this.recordTypeTail = recordTypeTail;
	}

	public String getFileTypeTail() {
		return fileTypeTail;
	}

	public void setFileTypeTail(String fileTypeTail) {
		this.fileTypeTail = fileTypeTail;
	}

}
