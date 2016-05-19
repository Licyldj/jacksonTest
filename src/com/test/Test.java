package com.test;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
           System.out.println("hello word");
           Map<String, String> map = new HashMap<String, String>();
           map.put("service", "mer_cancel");
           map.put("charset", "GBK");
           map.put("mer_id ", "9996");
           map.put("version", "4.0");
           map.put("res_format", "HTML");
           map.put("order_id", "123456789");
           map.put("mer_date", "20110101");
           map.put("amount", "500");
    }   
}
