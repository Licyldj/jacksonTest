package com.jackson.demo.dataBinding;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jackson.demo.bean.Country;
import com.jackson.demo.bean.Province;

public class JavaBean2Json {

    public static void convert() throws Exception {
        // 使用ObjectMapper 来转化对象为 json
        ObjectMapper mapper = new ObjectMapper();
        // 添加功能，让时间格式更具有可读性
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(dateFormat);

        Country country = new Country("China");
        country.setBirthDate(dateFormat.parse("1949-10-01"));
        country.setLakes(new String[] { "Qinghai Lake", "Poyang Lake", "Dongting Lake", "taihu Lake" });

        List<String> nation = new ArrayList<String>();
        nation.add("Han");
        nation.add("Meng");
        nation.add("Hui");
        nation.add("WeiWuEr");
        nation.add("Zang");

        country.setNation(nation);

        Province province = new Province();
        province.setName("Shanxi");
        province.setPopulation(37751200);
        Province province2 = new Province();
        province2.setName("ZheJiang");
        province2.setPopulation(55080000);
        List<Province> provinces = new ArrayList<Province>();
        provinces.add(province);
        provinces.add(province2);

        country.setProvinces(provinces);

        Map<String, Integer> m = new HashMap<String, Integer>();
        m.put("Train(KM)", 112000);
        m.put("HighWay(KM)", 4240000);
        country.setTraffic(m);

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);// 配置mapper忽略空属性
        mapper.setSerializationInclusion(Include.NON_EMPTY);// 默认情况下，jackson使用java属性字段名作为
        // Json的属性名称，因为这样会增大json的内容
        mapper.writeValue(new File("country.json"), country);

    }

    public static void main(String[] args) throws Exception {
        convert();
    }

}
