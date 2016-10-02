package com.liyu.springmvc.entities;

/**
 * Created by twcn on 10/2/16.
 */
public class Address {

    private String province;
    private String city;

    @Override
    public String toString() {
        return "Address[province=" + province + ", city=" + city + "]";
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
