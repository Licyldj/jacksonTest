package com.jackson.demo.treeModel;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDeserializationJavaBean2 {

    public static void main(String[] args) throws JsonProcessingException, IOException {
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File("country2.json"));
      //path方法获取JsonNode时，当对象不存在时，返回MISSING类型的JsonNode 
        JsonNode missingNode = node.path("test");
        if(missingNode.isMissingNode()){
            System.out.println("JsonNodeType : "+missingNode.getNodeType());
        }
        
        System.out.println("country_id : "+node.path("country_id"));
        System.out.println("birthDate : "+node.path("birthDate"));
        System.out.println("nation : "+node.path("nation"));
        System.out.println("lakes : "+node.path("lakes"));
        
        JsonNode provinces = node.path("provinces");
        System.out.println(provinces);
        for (JsonNode jsonNode : provinces) {
            System.out.println(jsonNode);
            Iterator<String> provincesFields = jsonNode.fieldNames();
            while (provincesFields.hasNext()) {
                String fieldName = provincesFields.next();
                String p;
                if("name".equals(fieldName)){
                    p = fieldName + " : "+jsonNode.path(fieldName);
                }else{
                    p = fieldName + " : "+jsonNode.path(fieldName);
                }
                System.out.println(p); 
            }
        }
        
        
    }

}













