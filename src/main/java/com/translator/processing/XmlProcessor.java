package com.translator.processing;

import com.translator.model.Messages;
import com.translator.model.Messages;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

import java.io.File;

public class XmlProcessor {

    public Messages parseXml(File xmlFile) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Messages.class);
        return (Messages) context.createUnmarshaller().unmarshal(xmlFile);
    }
}
