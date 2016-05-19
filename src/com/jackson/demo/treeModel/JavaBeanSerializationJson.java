package com.jackson.demo.treeModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JavaBeanSerializationJson {

    public static void main(String[] args) throws Exception {
        //创建一个节点工厂，提供所有节点
        JsonNodeFactory factory = new JsonNodeFactory(false);
        //创建一个 jsonFactory 来写 treeModel为json
        JsonFactory jsonFactory = new JsonFactory();
        //创建一个json生成器
        JsonGenerator generator = jsonFactory.createGenerator(new FileWriter(new File("country2.json")));
        //默认情况下对象映射器不会指定根节点，设根节点为country
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode country = factory.objectNode();
        
        country.put("country_id", "China");
        country.put("birthDate", "1949-10-01");
        
        //在java中，list和array转化为json后对应的格式符号都是“object：[]”
        ArrayNode nation = factory.arrayNode();
        nation.add("Han").add("Meng").add("Hui").add("WeiWuEr").add("Zang");
        country.put("nation", nation);
        
        ArrayNode lakes = factory.arrayNode();
        lakes.add("QingHai Lake").add("Poyang Lake").add("Dongting Lake").add("Taihu Lake");
        country.put("lakes", lakes);
        
        ArrayNode provinces = factory.arrayNode();
        ObjectNode province1 = factory.objectNode();
        province1.put("name", "Shanxi");
        province1.put("population", 37751200);
        ObjectNode province2 = factory.objectNode();
        province2.put("name", "ZheJiang");
        province2.put("population", 55080000);
        provinces.add(province1).add(province2);
        country.put("provinces", provinces);
        
        ObjectNode traffic = factory.objectNode();
        traffic.put("HighWay(KM)", 4240000);
        traffic.put("Train(KM)", 112000);
        country.put("traffic", traffic);
        
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeTree(generator, country);
    }

}






