package com.jackson.demo.streaming;

import java.io.File;
import java.io.FileWriter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class JavaBean2JsonByStream {

    public static void main(String[] args) throws Exception {
        JsonFactory factory = new JsonFactory();
        JsonGenerator generator = factory.createGenerator(new FileWriter(new File("country3.json")));

        generator.writeStartObject();
        generator.writeStringField("country_id", "China");
        generator.writeStringField("birthDay", "1949-10-01");
        // nation
        generator.writeFieldName("nation");
        generator.writeStartArray();
        generator.writeString("Han");
        generator.writeString("Meng");
        generator.writeString("Hui");
        generator.writeString("WeiWuEr");
        generator.writeString("Zang");
        generator.writeEndArray();
        // lakes
        generator.writeFieldName("lakes");
        generator.writeStartArray();
        generator.writeString("QingHai Lake");
        generator.writeString("Poyang Lake");
        generator.writeString("DongTing Lake");
        generator.writeString("Taihui Lake");
        generator.writeEndArray();
        // provinces
        generator.writeFieldName("provinces");
        generator.writeStartArray();
        generator.writeStartObject();
        generator.writeStringField("name", "Shanxi");
        generator.writeFieldName("population");
        generator.writeNumber(55080000);
        generator.writeEndObject();
        generator.writeStartObject();
        generator.writeStringField("name", "ZheJiang");
        generator.writeFieldName("population");
        generator.writeNumber(37751200);
        generator.writeEndObject();
        generator.writeEndArray();
        // traffic
        generator.writeFieldName("traffic");
        generator.writeStartObject();
        generator.writeFieldName("HighWay(KM)");
        generator.writeNumber(4240000);
        generator.writeFieldName("Train(KM)");
        generator.writeNumber(112000);
        generator.writeEndObject();

        generator.writeEndObject();

        generator.close();
    }

}
