package com.blockchain;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sample {

    private final static Logger logger = LoggerFactory.getLogger(Sample.class);

    public static void main(String[] args) {
        String name = getNameFromJson("{\"name\": \"Tobias\"}");
        System.out.println(name);
    }


    public static String getNameFromJson(String json_string) {
        logger.error("Funktion startet");
        JsonParser parser = new JsonParser();
        final JsonElement element = parser.parse(json_string);
        final JsonObject object = element.getAsJsonObject();
        final String name = object.get("name").getAsString();
        logger.info("Name: {}", name);
        return name;
    }
}
