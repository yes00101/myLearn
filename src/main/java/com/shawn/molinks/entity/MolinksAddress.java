package com.shawn.molinks.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * excel导入实体类
 */
public class MolinksAddress {

    /**
     * 序号
     */
    @JsonIgnore
    @Excel(name="序号", orderNum = "0", isImportField = "true")
    private String id;
    /**
     * 省份
     */
    @Excel(name="省份", orderNum = "1", isImportField = "true")
    private String province;
    /**
     * 城市
     */
    @Excel(name="城市", orderNum = "2", isImportField = "true")
    private String city;
    /**
     * 区县
     */
    @Excel(name="区县", orderNum = "3", isImportField = "true")
    private String district;
    /**
     * 经销商名称
     */
//    @JsonProperty("name")
    @Excel(name="经销商名称", orderNum = "4", isImportField = "true")
    private String shopName;
    /**
     * 高德地图坐标
     */
    @JsonIgnore
    @Excel(name="高德地图坐标", orderNum = "5", isImportField = "true")
    private String amapCoor;
    /**
     * 高德地图坐标反查结果
     */
    @JsonProperty("address")
    @Excel(name="高德地图坐标反查结果", orderNum = "6", isImportField = "true")
    private String address;
    /**
     * gps经度
     */
    @JsonIgnore
    @Excel(name="经度", orderNum = "7", isImportField = "true")
    private double gmapLon;
    /**
     * gps纬度
     */
    @JsonIgnore
    @Excel(name="纬度", orderNum = "8", isImportField = "true")
    private double gmapLat;
    /**
     * 百度经度
     */
//    @JsonProperty("lon")
    @Excel(name="百度经度", orderNum = "9", isImportField = "true")
    private double bmapLon;
    /**
     * 百度纬度
     */
//    @JsonProperty("lat")
    @Excel(name="百度纬度", orderNum = "10", isImportField = "true")
    private double bmapLat;



    public MolinksAddress() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAmapCoor() {
        return amapCoor;
    }

    public void setAmapCoor(String amapCoor) {
        this.amapCoor = amapCoor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGmapLon() {
        return gmapLon;
    }

    public void setGmapLon(double gmapLon) {
        this.gmapLon = gmapLon;
    }

    public double getGmapLat() {
        return gmapLat;
    }

    public void setGmapLat(double gmapLat) {
        this.gmapLat = gmapLat;
    }

    public double getBmapLon() {
        return bmapLon;
    }

    public void setBmapLon(double bmapLon) {
        this.bmapLon = bmapLon;
    }

    public double getBmapLat() {
        return bmapLat;
    }

    public void setBmapLat(double bmapLat) {
        this.bmapLat = bmapLat;
    }


    @Override
    public String toString() {
        return "MolinksAddress{" +
                "id='" + id + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", shopName='" + shopName + '\'' +
                ", amapCoor='" + amapCoor + '\'' +
                ", address='" + address + '\'' +
                ", gmapLon=" + gmapLon +
                ", gmapLat=" + gmapLat +
                ", bmapLon=" + bmapLon +
                ", bmapLat=" + bmapLat +
                '}';
    }
}
