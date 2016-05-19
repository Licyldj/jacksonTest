package com.test;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 *  May 转化 json
 * @author gome_licy
 *
 */
public class MyTest01 {
    /**
     * Map 转化 json
     */
    public static void Test01(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "licy");
        map.put("sex", "man");
        map.put("login", "licy");
        map.put("password", "123456");
        map.put("idcard", "0000000");
        
        ObjectMapper objectMapper = new  ObjectMapper(); 
        try {
            String userMapJson = objectMapper.writeValueAsString(map);
            JsonNode node = objectMapper.readTree(userMapJson);
            
            System.out.println(node);

            System.out.println(node.get("password").asText());
            System.out.println(node.get("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Map 转化 json
     */
    public static void Test02(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "licy");
        map.put("sex", "man");
        map.put("login", "licy");
        map.put("password", "123456");
        map.put("idcard", "0000000");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("data2", "data2");
        map.put("data", map2);
        
        ObjectMapper objectMapper = new  ObjectMapper(); 
        try {
            String userMapJson = objectMapper.writeValueAsString(map);
            JsonNode node = objectMapper.readTree(userMapJson);
            
            System.out.println(node);

            System.out.println(node.get("password").asText());
            System.out.println(node.get("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 解析 json  格式字符串
     */
    public static void Test03(){
        String str="{\"data\":{\"birth_day\":1,\"birth_month\":6},\"errcode\":0,\"msg\":\"ok\",\"ret\":0}";
        System.out.println("json:"+str);
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(str);
            JsonNode data = root.path("data");
            System.out.println("data:"+data.asText());
            
            JsonNode birth_day = data.path("birth_day");
            System.out.println("birth_day:"+birth_day.asInt());
            
            JsonNode birth_month = data.path("birth_month");
            System.out.println("birth_month:"+birth_month.asInt());
            
            JsonNode msg = root.path("msg");
            System.out.println("msg:"+msg.asText());
            System.out.println("msg:"+msg.textValue());
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * json 直接提取值
     */
    public static void Test04(){
        String str= "{\"data\":{\"hasnext\":0,\"info\":[{\"id\":\"288206077664983\",\"timestamp\":1371052476},{\"id\":\"186983078111768\",\"timestamp\":1370944068},{\"id\":\"297031120529307\",\"timestamp\":1370751789},{\"id\":\"273831022294863\",\"timestamp\":1369994812}],\"timestamp\":1374562897,\"totalnum\":422},\"errcode\":0,\"msg\":\"ok\",\"ret\":0,\"seqid\":5903702688915195270}";
        System.out.println("str:"+str);
        
        try {
            ObjectMapper mapper = new ObjectMapper();
            //读取json串
            JsonNode root = mapper.readTree(str);
            JsonNode data = root.path("data");
            JsonNode info = data.path("info");
            System.out.println(info.size());
            
            JsonNode item = info.get(0);
            System.out.println("id:"+item.get("id"));
            System.out.println("timestamp:"+item.get("timestamp"));
            
            item = info.get(1);
            System.out.println("id:"+item.get("id"));
            System.out.println("timestamp:"+item.get("timestamp"));
            
            if(info.isArray()){
                for (JsonNode jsonNode : info) {
                    System.out.println(jsonNode);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * 创建一个json，并向该json添加内容
     */
    public static void Test05(){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        ObjectNode root2 = mapper.createObjectNode();
        root2.put("nodekey1", 1);
        root2.put("nodekey2", 2);
        root.put("child", root2);
        ArrayNode arraynode = mapper.createArrayNode();
        ObjectNode node1 = mapper.createObjectNode();
        node1.put("nodekey11", "11");
        ObjectNode node2 = mapper.createObjectNode();
        node2.put("nodekey22", "22");
        arraynode.add(node1);
        arraynode.add(node2);
        arraynode.add(1);
        arraynode.add("ABC");
        root.put("arraynode", arraynode);
        
        try {
            System.out.println(mapper.writeValueAsString(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     */
    public static void Test06(){
        
    }
    
    public static void main(String[] args) {
//        MyTest01.Test01();
//        MyTest01.Test02();
//        MyTest01.Test03();
//        MyTest01.Test04();
        MyTest01.Test05();

    }
}
