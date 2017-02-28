package com.devculture.katas.syntax;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestGsonEnumSerializationExample {

    private Gson gson = new GsonBuilder().serializeNulls().create();

    @Test
    public void testSerialization() {
        GsonEnumSerializationExample.MyObject a = new GsonEnumSerializationExample.MyObject(GsonEnumSerializationExample.MyEnum.A);
        String json = gson.toJson(a);
        assertEquals("{\"myEnum\":\"thisIsA\"}", json);
    }

    @Test
    public void testDeserialization() {
        String json;

        json = "{\"myEnum\":\"thisIsA\"}";
        GsonEnumSerializationExample.MyObject a = gson.fromJson(json, GsonEnumSerializationExample.MyObject.class);
        assertEquals(a.myEnum, GsonEnumSerializationExample.MyEnum.A);

        json = "{\"myEnum\":\"thisIsB\"}";
        GsonEnumSerializationExample.MyObject b = gson.fromJson(json, GsonEnumSerializationExample.MyObject.class);
        assertEquals(b.myEnum, GsonEnumSerializationExample.MyEnum.B);
    }
}
