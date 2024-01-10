package com.neurogine.app.service;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

import com.neurogine.app.NeurogineApplication;
import com.neurogine.app.dto.FlatFile;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FlatFileGenerator {
	public static void createFlatFileFromJava() throws IOException {
		// Create a BeanIO stream factory
        StreamFactory factory = StreamFactory.newInstance();
        ClassLoader classLoader = NeurogineApplication.class.getClassLoader();
        URL resourceUrl = classLoader.getResource("mapping.xml");
        
        if (resourceUrl != null) {
        	log.info("mapping.xml Resource file found");
            String resourcePath = resourceUrl.getPath();
            factory.load(resourcePath); // Load the mapping file
            
            // Create instances for header, body, and tail
            FlatFile header = new FlatFile();
            header.setRecordTypeHeader("H");
            header.setFileTypeHeader("FLAT_FILE");

            FlatFile body1 = new FlatFile();
            body1.setReferenceNumber("6813162459");
            body1.setAmount("RM2.00");

            FlatFile body2 = new FlatFile();
            body2.setReferenceNumber("2039229524");
            body2.setAmount("RM10.00");
            
            FlatFile body3 = new FlatFile();
            body3.setReferenceNumber("2299488320");
            body3.setAmount("RM5.00");
            
            
            FlatFile tail = new FlatFile();
            tail.setRecordTypeTail("T");
            tail.setFileTypeTail("FLAT_FILE");
            
            BeanWriter writer = factory.createWriter("flatFile", new FileWriter("test.txt"));
            // Write records to the flat file
            writer.write("header", header);
            writer.write("body", body1);
            writer.write("body", body2);
            writer.write("tail", tail);

            // Close the writer
            writer.close();
            
            log.info("Flat File Generation completed");
        } else {
        	log.error("mapping.xml file is missing");
        }
        

       
	}
}
