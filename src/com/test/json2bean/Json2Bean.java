package com.test.json2bean;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("unchecked")
public class Json2Bean {
    private JsonGenerator jsonGenerator = null;
    private ObjectMapper objectMapper = null;
    private AccountBean bean = null;
    
    @Before
    public void init(){
        bean = new AccountBean();
        bean.setAddress("Beijing-China");
        bean.setEmail("hoo@126.com");
        bean.setId(1);
        bean.setName("hoojo");
        
        objectMapper = new ObjectMapper();
        try {
            jsonGenerator = objectMapper.getJsonFactory().createGenerator(System.out, JsonEncoding.UTF8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @After
    public void destory(){
        try {
            if(jsonGenerator != null){
                jsonGenerator.flush();
            }
            if(!jsonGenerator.isClosed()){
                jsonGenerator.close();
            }
            jsonGenerator = null;
            objectMapper = null;
            bean = null;
            System.gc();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void java2json(){
        System.out.println("jsonGenerator");
        try {
            jsonGenerator.writeObject(bean);
            System.out.println();
            System.out.println("ObjectMapper");
            objectMapper.writeValue(System.out, bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
