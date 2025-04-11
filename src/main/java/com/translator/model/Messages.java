package com.translator.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Messages")
@XmlAccessorType(XmlAccessType.FIELD)
public class Messages {

    @XmlElement(name = "Message")
    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
