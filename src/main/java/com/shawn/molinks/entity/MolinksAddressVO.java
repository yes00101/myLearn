package com.shawn.molinks.entity;

/**
 * 给前台返回的数据
 */
public class MolinksAddressVO {

    /**
     * 实际距离
     */
    private String distance;

    private double lat;

    private double lon;

    private String address;

    private String name;

    private String district;

    private String city;

    private String province;

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public MolinksAddressVO() {
    }

    @Override
    public String toString() {
        return "MolinksAddressVO{" +
                "distance='" + distance + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
