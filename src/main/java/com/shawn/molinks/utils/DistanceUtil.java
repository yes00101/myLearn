package com.shawn.molinks.utils;
import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GlobalCoordinates;

import java.text.DecimalFormat;

/**
 * 通过地图上的两个坐标计算距离
 * @apiNote 直接通过jar包完事
 */
public class DistanceUtil {

    /**
     * 地球半径
     */
    private static double EARTH_RADIUS = 6378.137;

    /**
     * 经纬度转化成弧度
     *
     * @param d 经度/纬度
     * @return
     */
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：)
     *
     * @param lat1 纬度1
     * @param lon1 经度1
     * @param lat2 纬度2
     * @param lon2 经度2
     * @return 距离
     */
    @Deprecated
    public static String getDistanceByHand(double lat1, double lon1,double lat2, double lon2) {

        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);

        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);

        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        // 特别计算单位为米
        s = s * 1000;

        //格式化，区小数后两位
        DecimalFormat df = new DecimalFormat("0.00");

        return df.format(s);
    }

    /**
     * 根据geo计算两点之间的距离
     * @param longitudeFrom
     * @param latitudeFrom
     * @param longitudeTo
     * @param latitudeTo
     * @return
     */
    public static double getDistance(double longitudeFrom, double latitudeFrom, double longitudeTo, double latitudeTo) {
        GlobalCoordinates source = new GlobalCoordinates(latitudeFrom, longitudeFrom);
        GlobalCoordinates target = new GlobalCoordinates(latitudeTo, longitudeTo);

        return new GeodeticCalculator().calculateGeodeticCurve(Ellipsoid.Sphere, source, target).getEllipsoidalDistance();
    }

}
