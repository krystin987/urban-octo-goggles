package com.translator.model;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Message {

    @XmlElement(name = "ID")
    private int id;

    @XmlElement(name = "Data")
    private MessageData data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MessageData getData() {
        return data;
    }

    public void setData(MessageData data) {
        this.data = data;
    }
}
