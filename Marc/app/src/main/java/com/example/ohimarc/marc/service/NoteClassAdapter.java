package com.example.ohimarc.marc.service;


import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.example.ohimarc.marc.model.Note;

import java.lang.reflect.Type;

/**
 * Adapter to handle abstract Note class when converting to and from JSON format,
 * This class is heavily inspired from "http://ovaraksin.blogspot.com/2011/05/json-with-gson-and-abstract-classes.html"
 * */
public class NoteClassAdapter implements JsonSerializer<Note>, JsonDeserializer<Note> {
    @Override
    public Note deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");

        try {
            String thepackage = "com.example.ohimarc.marc.model.";
            return context.deserialize(element, Class.forName(thepackage + type));
        } catch (ClassNotFoundException cnfe) {
            throw new JsonParseException("Unknown element type: " + type, cnfe);
        }
    }

    @Override
    public JsonElement serialize(Note src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(src.getClass().getSimpleName()));
        result.add("properties", context.serialize(src, src.getClass()));
        return result;
    }
}
