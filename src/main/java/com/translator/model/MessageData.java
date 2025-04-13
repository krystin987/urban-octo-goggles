package com.translator.model;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class MessageData {

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Status")
    private String status;

    @XmlElement(name = "Priority")
    private Integer priority;

    @XmlElement(name = "Confidence")
    private Double confidence;

    @XmlElement(name = "Category")
    private String category;

    @XmlElement(name = "Region")
    private String region;

    @XmlElement(name = "RetryCount")
    private Integer retryCount;

    @XmlElement(name = "Score")
    private Double score;

    // Getters and setters

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getPriority() {
        return this.priority;
    }
    public void setPriority(int priority) { this.priority = priority; }

    public Double getConfidence() {
        return this.confidence;
    }
    public void setConfidence(double confidence) { this.confidence = confidence; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public Integer getRetryCount() {
        return this.retryCount;
    }
    public void setRetryCount(int retryCount) { this.retryCount = retryCount; }

    public Double getScore() {
        return this.score;
    }
    public void setScore(double score) { this.score = score; }
}
