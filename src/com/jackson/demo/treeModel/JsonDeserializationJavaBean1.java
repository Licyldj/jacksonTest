package com.jackson.demo.treeModel;

import java.io.File;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDeserializationJavaBean1 {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File("country2.json"));
        //看看根节点的类型
        System.out.println("node jsonNodeType:"+node.getNodeType());
        //看看是不是一个容器
        System.out.println("node is container Node:"+node.isContainerNode());
        //得到所有node节点的子节点的名称
        System.out.println("--------------------------------------");
        Iterator<String> fieldNames = node.fieldNames();
        while(fieldNames.hasNext()){
            System.out.print(fieldNames.next()+" ");
        }
        System.out.println("\n--------------------------------------");
        //asText()有值则返回，无值则返回空字符串
        JsonNode country_id = node.get("country_id");
        System.out.println("country_id:"+country_id.asText()+" JsonNodeType:"+country_id.getNodeType());
        
        JsonNode birthDate = node.get("birthDate");  
        System.out.println("birthDate:"+birthDate.asText()+" JsonNodeType:"+birthDate.getNodeType());  
          
        JsonNode nation = node.get("nation");  
        System.out.println("nation:"+ nation+ " JsonNodeType:"+nation.getNodeType());  
          
        JsonNode lakes = node.get("lakes");  
        System.out.println("lakes:"+lakes+" JsonNodeType:"+lakes.getNodeType());  
  
        JsonNode provinces = node.get("provinces");  
        System.out.println("provinces JsonNodeType:"+provinces.getNodeType());  
        
//        boolean flag = true;
        for (JsonNode provinceElements : provinces) {
//            if(flag){
//                System.out.println("provinceElements JsonNodeType :"+provinceElements.getNodeType());
//                System.out.println("provinceElements is container node:" +provinceElements.isContainerNode());
//                flag=false;
//            }
            Iterator<String> provinceElementFields = provinceElements.fieldNames();
            while(provinceElementFields.hasNext()){
                String field = provinceElementFields.next();
                String province;
                if("population".equals(field)){
                    province = field + ":" +provinceElements.get(field).asInt();
                }else{
                    province = field + ":" +provinceElements.get(field).asText();
                }
                System.out.println(province);
            }
        }
    }

}








