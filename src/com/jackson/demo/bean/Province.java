package com.jackson.demo.bean;

/**
 * 省
 * @author gome_licy
 *
 */
public class Province {
    private String name;            //名字
    private int population;         //人口
    private String[] city;          //城市
    
    public Province(){}
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    public String[] getCity() {
        return city;
    }
    public void setCity(String[] city) {
        this.city = city;
    }
    
}
