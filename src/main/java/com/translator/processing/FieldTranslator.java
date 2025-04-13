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

        // Always present (non-null primitive int)
        translated.put(FIELD_NAME_MAPPING.get("ID"), message.getId());

        // Safely map nullable or optional fields
        putIfNotNull(translated, "Name", data.getName());
        putIfNotNull(translated, "Status", data.getStatus());
        putIfNotNull(translated, "Priority", data.getPriority());
        putIfNotNull(translated, "Confidence", data.getConfidence());
        putIfNotNull(translated, "Category", data.getCategory());
        putIfNotNull(translated, "Region", data.getRegion());
        putIfNotNull(translated, "RetryCount", data.getRetryCount());
        putIfNotNull(translated, "Score", data.getScore());

        return translated;
    }

    private void putIfNotNull(Map<String, Object> map, String fieldKey, Object value) {
        if (value != null && FIELD_NAME_MAPPING.containsKey(fieldKey)) {
            map.put(FIELD_NAME_MAPPING.get(fieldKey), value);
        }
    }

}