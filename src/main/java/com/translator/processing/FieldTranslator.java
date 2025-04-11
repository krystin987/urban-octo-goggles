package com.translator.processing;

import com.translator.model.Message;
import com.translator.model.MessageData;

import java.util.HashMap;
import java.util.Map;

public class FieldTranslator {

    private static final Map<String, String> FIELD_NAME_MAPPING = Map.of(
            "ID", "objectID",
            "Name", "full_name",
            "Status", "current_status",
            "Priority", "urgency_level",
            "Confidence", "confidence_score",
            "Category", "dept_category",
            "Region", "geo_region",
            "RetryCount", "retry_attempts",
            "Score", "performance_score"
    );

    public Map<String, Object> translateAll(Message message) {
        Map<String, Object> translated = new HashMap<>();
        MessageData data = message.getData();

        translated.put(FIELD_NAME_MAPPING.get("ID"), message.getId());
        translated.put(FIELD_NAME_MAPPING.get("Name"), data.getName());
        translated.put(FIELD_NAME_MAPPING.get("Status"), data.getStatus());
        translated.put(FIELD_NAME_MAPPING.get("Priority"), data.getPriority());
        translated.put(FIELD_NAME_MAPPING.get("Confidence"), data.getConfidence());
        translated.put(FIELD_NAME_MAPPING.get("Category"), data.getCategory());
        translated.put(FIELD_NAME_MAPPING.get("Region"), data.getRegion());
        translated.put(FIELD_NAME_MAPPING.get("RetryCount"), data.getRetryCount());
        translated.put(FIELD_NAME_MAPPING.get("Score"), data.getScore());

        return translated;
    }
}