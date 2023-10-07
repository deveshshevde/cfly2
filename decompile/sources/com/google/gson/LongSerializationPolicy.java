package com.google.gson;

public enum LongSerializationPolicy {
    DEFAULT {
        public JsonElement serialize(Long l2) {
            return new JsonPrimitive((Number) l2);
        }
    },
    STRING {
        public JsonElement serialize(Long l2) {
            return new JsonPrimitive(String.valueOf(l2));
        }
    };

    public abstract JsonElement serialize(Long l2);
}
