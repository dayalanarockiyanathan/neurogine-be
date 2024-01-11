package com.neurogine.app.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class JasperReportDto {
	private String date;
	private String referenceNo;
	private BigDecimal amount;
	private String status;
	private String remark;
	private String uuid;

}
