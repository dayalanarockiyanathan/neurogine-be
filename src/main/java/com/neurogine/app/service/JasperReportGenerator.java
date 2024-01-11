package com.neurogine.app.service;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.UUID;

import com.neurogine.app.NeurogineApplication;
import com.neurogine.app.dto.JasperReportDto;

import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Log4j2
public class JasperReportGenerator {
	public static void generateJasperReport() {
		log.info("Jasperreport HTML Generation started");

		try {
			// Load and compile the JasperReport template
			ClassLoader classLoader = NeurogineApplication.class.getClassLoader();
			URL resourceUrl = classLoader.getResource("jasper_report_template.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(resourceUrl.getFile());

			// Create a JRBeanCollectionDataSource with your data
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(getData());

			// Fill the report with data
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

			String reportName = "Japser_generated_report.html";
			JasperExportManager.exportReportToHtmlFile(jasperPrint, reportName);

			log.info("Jasper HTML Report generation completed.");
		} catch (JRException e) {
			e.printStackTrace();
		}

	}

	private static List<JasperReportDto> getData() {
		return List.of(
				new JasperReportDto("2024-01-01", "REF123", new BigDecimal("1000.00"), "Completed",
						"Flat File Generation",getNewUuid()),
				new JasperReportDto("2024-01-02", "REF456", new BigDecimal("1500.50"), "Started",
						"Jasper Report Generation",getNewUuid())
		);
	}

	private static String getNewUuid() {

		return UUID.randomUUID().toString();

	}
}
