package com.application.utils;

import org.geotools.geojson.geom.GeometryJSON;
import org.geotools.geometry.jts.JTS;
import org.geotools.geometry.jts.WKBReader;
import org.geotools.referencing.CRS;
import org.geotools.referencing.GeodeticCalculator;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.*;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;

import java.io.IOException;

/**
 * @Author yaoct
 * @Date 2022/9/16 10:55
 * @Version 1.0
 * @description
 */
public class GisUtil {

    /**
     * WKB字符串转Geometry格式
     * @param WKB
     * @return
     */
    public static Geometry WKB2Geometry(String WKB){
        WKBReader reader = new WKBReader();
        Geometry geometry = null;
        try {
            geometry = reader.read(WKBReader.hexToBytes(WKB));
        } catch (ParseException e) {
            //转换失败
            throw new RuntimeException("转换失败",e);
        }
        return geometry;
    }

    /**
     * Geometry格式转WKB字符串
     * @param geometry
     * @return
     */
    public static String Geometry2WKB(Geometry geometry){
        WKBWriter wkbWriter = new WKBWriter(2, ByteOrderValues.BIG_ENDIAN,true);
        byte[] write = wkbWriter.write(geometry);
        String ret = WKBWriter.toHex(write);
        return ret;
    }

    /**
     * WKT字符串转Geometry格式
     * @param WKT
     * @return
     */
    public static Geometry WKT2Geometry(String WKT){
        WKTReader reader = new WKTReader();
        Geometry geometry = null;
        try {
            geometry = reader.read(WKT);
        } catch (ParseException e) {
            //转换失败
            throw new RuntimeException("转换失败",e);
        }
        System.out.println("geometry:"+geometry);
        return geometry;
    }

    /**
     * Geometry格式转WKT字符串
     * @param geometry
     * @return
     */
    public static String Geometry2WKT(Geometry geometry){
        WKTWriter wktWriter = new WKTWriter();
        String wkt= wktWriter.write(geometry);
        return wkt;
    }

    /**
     * 转换Geometry坐标
     * @param geometry
     * @param targetSrid 新坐标
     * @return
     */
    public static Geometry coordinateTransfer(Geometry geometry, int targetSrid){
        int originSrid = geometry.getSRID();
        CoordinateReferenceSystem sourceCRS = null;
        CoordinateReferenceSystem targetCRS = null;
        MathTransform transform=null;
        try {
            sourceCRS = CRS.decode("EPSG:"+originSrid,true);
            targetCRS = CRS.decode("EPSG:"+targetSrid,true);
            transform = CRS.findMathTransform(sourceCRS, targetCRS,true);
        } catch (FactoryException e) {
            throw new RuntimeException("坐标错误",e);
        }
        Geometry ret = null;
        try {
            ret = JTS.transform(geometry, transform);
        } catch (TransformException e) {
            throw new RuntimeException("坐标转换错误",e);
        }
        return ret;
    }

    /**
     * Geometry->geoJson
     * @param geometry
     * @return
     */
    public static String geometry2GeoJson(Geometry geometry){
        // 设置保留6位小数，否则GeometryJSON默认保留4位小数
        GeometryJSON geometryJson = new GeometryJSON(7);
        String json = geometryJson.toString(geometry);
//        JSONObject jsonObject = JSONObject.parseObject(json);
//        jsonObject.put("srid",geometry.getSRID());
//        return jsonObject.toJSONString();
        return json;
    }

    /**
     * geoJson->Geometry
     * @param geoJson
     * @return
     */
    public static Geometry geoJson2Geometry(String geoJson){
        GeometryJSON geometryJson = new GeometryJSON(7);
        Geometry ret=null;
        try {
            Geometry read = geometryJson.read(geoJson);
        } catch (IOException e) {
            throw new RuntimeException("转换失败",e);
        }
        return ret;
    }

    /**
     * 计算两点间的距离
     * @param lon1
     * @param lat1
     * @param lon2
     * @param lat2
     * @return
     */
    public static double calculateDistance(double lon1,double lat1,double lon2,double lat2){
        //CoordinateReferenceSystem sourceCRS = CRS.decode("EPSG:"+srid,true);
        GeodeticCalculator geodeticCalculator = new GeodeticCalculator(DefaultGeographicCRS.WGS84);
        // 起点经纬度
        geodeticCalculator.setStartingGeographicPoint(lon1,lat1);
        // 末点经纬度
        geodeticCalculator.setDestinationGeographicPoint(lon2,lat2);
        // 计算距离，单位：米
        double distance = geodeticCalculator.getOrthodromicDistance();
        return distance;
    }

    public static void main(String[] args) {
        String pointz = "POINT(113.15789948611 27.6439988611111)";
        String pointx = "POINT(113.1578 27.643)";
        System.out.println(WKT2Geometry(pointx).distance(WKT2Geometry(pointz)));
    }
}