package com.neurogine.app;

import java.io.IOException;

import com.neurogine.app.service.FlatFileGenerator;
import com.neurogine.app.service.JasperReportGenerator;


public class NeurogineApplication {

	public static void main(String[] args) throws IOException {
		FlatFileGenerator.createFlatFileFromJava();
		JasperReportGenerator.generateJasperReport();
    }

	
}
