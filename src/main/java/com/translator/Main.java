package com.translator;

import com.translator.processing.MessageProcessor;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/sample.xml");
            MessageProcessor processor = new MessageProcessor();
            processor.process(xmlFile);
        } catch (Exception e) {
            System.err.println("Failed to process XML: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
