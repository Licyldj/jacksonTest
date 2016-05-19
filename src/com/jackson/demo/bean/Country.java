package com.jackson.demo.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 国家
 * @author gome_licy
 *
 */
public class Country {
    private String country_id;                            //ID
    private Date birthDate;                               //创建日期
    private List<String> nation = new ArrayList<String>();//国家
    private String[] lakes;                                //湖
    private List<Province> provinces = new ArrayList<Province>();//省
    private Map<String, Integer> traffic = new HashMap<String, Integer>();
    
    public Country(){}
    
    public Country(String countryId){
        this.country_id=countryId;
    }
    
    public String getCountry_id() {
        return country_id;
    }
    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public List<String> getNation() {
        return nation;
    }
    public void setNation(List<String> nation) {
        this.nation = nation;
    }
    public String[] getLakes() {
        return lakes;
    }
    public void setLakes(String[] lakes) {
        this.lakes = lakes;
    }
    public List<Province> getProvinces() {
        return provinces;
    }
    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }
    public Map<String, Integer> getTraffic() {
        return traffic;
    }
    public void setTraffic(Map<String, Integer> traffic) {
        this.traffic = traffic;
    }
    
}
