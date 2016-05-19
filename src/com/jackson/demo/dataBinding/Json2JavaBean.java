package com.jackson.demo.dataBinding;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.demo.bean.Country;
import com.jackson.demo.bean.Province;

/**
 * json字符串反序列化为java对象
 * 
 * @author gome_licy
 *
 */
public class Json2JavaBean {
    public static void deserializeToJavaBean() throws Exception {
        File json = new File("country.json");
        // ObjectMapper类 序列化和反序列化映射器
        ObjectMapper mapper = new ObjectMapper();
        // 禁止未知属性打断反序列化
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 从json映射到javabean，得到country对象
        Country country = mapper.readValue(json, Country.class);
        System.out.println("country_id:" + country.getCountry_id());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthDate = dateFormat.format(country.getBirthDate());
        System.out.println("birthDate:" + birthDate);
        List<Province> provinces = country.getProvinces();
        for (Province province : provinces) {
            System.out.println("province:" + province.getName() + "_population:" + province.getPopulation());
        }

    }

    public static void main(String[] args) throws Exception {
        deserializeToJavaBean();
    }
}
