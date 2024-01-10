package com.neurogine.app;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

import com.neurogine.app.dto.FlatFile;

public class NeurogineApplication {

	public static void main(String[] args) throws IOException {
        // Create a BeanIO stream factory
        StreamFactory factory = StreamFactory.newInstance();
        ClassLoader classLoader = NeurogineApplication.class.getClassLoader();
        URL resourceUrl = classLoader.getResource("mapping.xml");
        
        if (resourceUrl != null) {
            String resourcePath = resourceUrl.getPath();
            System.out.println("Resource Folder Path (using ClassLoader): " + resourcePath);
            factory.load(resourcePath); // Load the mapping file
        } else {
            System.out.println("Resource Folder not found");
        }
        
        

        // Create a BeanWriter
        

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
    }
}
