package com.translator.processing;

import com.translator.model.Message;
import com.translator.model.Messages;

import jakarta.xml.bind.JAXBException;
import java.io.File;
import java.util.List;
import java.util.Map;

public class MessageProcessor {

    private final XmlProcessor xmlProcessor;
    private final FieldTranslator fieldTranslator;

    public MessageProcessor() {
        this.xmlProcessor = new XmlProcessor();
        this.fieldTranslator = new FieldTranslator();
    }

    public void process(File xmlFile) throws JAXBException {
        Messages messages = xmlProcessor.parseXml(xmlFile);
        List<Message> messageList = messages.getMessages();

        for (Message message : messageList) {
            Map<String, Object> translatedPayload = fieldTranslator.translateAll(message);

            // Stub: Replace with actual call to your existing message service
            System.out.println("Translated message for objectID: " + translatedPayload.get("objectID"));
            translatedPayload.forEach((key, value) ->
                    System.out.println("  " + key + ": " + value)
            );
        }
    }
}