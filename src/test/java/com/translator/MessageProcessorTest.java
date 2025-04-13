package com.translator;

import com.translator.model.Messages;
import com.translator.processing.FieldTranslator;
import com.translator.processing.MessageProcessor;
import com.translator.processing.XmlProcessor;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;

import java.io.File;
import java.net.URL;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageProcessorTest {

    @Test
    void testFullProcessingPipeline() throws JAXBException {
        // Arrange
        URL resource = getClass().getClassLoader().getResource("sample.xml");
        assertNotNull(resource, "sample.xml should be available in test resources");
        File xmlFile = new File(resource.getFile());

        XmlProcessor xmlProcessor = new XmlProcessor();
        FieldTranslator translator = new FieldTranslator();

        // Act
        Messages messages = xmlProcessor.parseXml(xmlFile());

        // Assert
        assertEquals(3, messages.getMessages().size());

        Map<String, Object> translated = translator.translateAll(messages.getMessages().get(0));
        assertEquals("Lorem Ipsum", translated.get("full_name"));
        assertEquals("ACTIVE", translated.get("current_status"));
        assertEquals(3, translated.get("urgency_level"));
        assertEquals(0.82, (Double) translated.get("confidence_score"), 0.0001);
    }

    @Test
    void testTranslationHandlesNullAndBlankFields() throws Exception {
        String xml = """
        <Messages>
            <Message>
                <ID>9999</ID>
                <Data>
                    <Name></Name>
                    <Status>FAILED</Status>
                    <Confidence>0.0</Confidence>
                </Data>
            </Message>
        </Messages>
        """;

        // Parse from string instead of file
        JAXBContext context = JAXBContext.newInstance(Messages.class);
        Messages messages = (Messages) context.createUnmarshaller()
                .unmarshal(new StringReader(xml));

        assertEquals(1, messages.getMessages().size());

        FieldTranslator translator = new FieldTranslator();
        Map<String, Object> translated = translator.translateAll(messages.getMessages().get(0));

        // Assertions for existing fields
        assertEquals("FAILED", translated.get("current_status"));
        assertEquals(0.0, translated.get("confidence_score"));

        // Expecting blank name → ""
        assertEquals("", translated.get("full_name"));

        // Expecting missing fields → null
        assertNull(translated.get("urgency_level")); // missing <Priority>
        assertNull(translated.get("dept_category")); // missing <Category>
        assertNull(translated.get("geo_region"));    // missing <Region>
        assertNull(translated.get("retry_attempts")); // missing <RetryCount>
        assertNull(translated.get("performance_score")); // missing <Score>
    }

    private File xmlFile() {
        return new File("src/main/resources/sample.xml");
    }
}