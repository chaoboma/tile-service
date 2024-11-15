package com.application.constants;

/**
 * 其他常量池
 * @author lyw
 */
public class OtherConstants {

    /**
     * mysql 租户id 字段的名称
     */
    public static final String TENANT_ID_FIELD_NAME= "tenant_id";

    /**
     * 租户id 的 http Header 名称
     */
    public static final String TENANT_ID_HTTP_HEADER_NAME = "Tenant-Id";

    /**
     * 用户id 的 http Header 名称
     */
    public static final String USER_ID_HTTP_HEADER_NAME = "User-Id";

    /**
     * 请求链路追踪 的 http Header 名称
     */
    public static final String TRACE_ID_HTTP_HEADER_NAME = "Trace-Id";


    /**
     * 逻辑标示 - 是
     */
    public static final Integer TRUE = 1;

    /**
     * 逻辑标示 - 否
     */
    public static final Integer FALSE = 0;




    /**
     * 公共数据表字段名称 - id
     */
    public static final String ID = "id";


    /**
     * 公共数据表字段名称 - is_delete
     */
    public static final String IS_DELETE = "is_delete";

    /**
     * 公共数据表字段名称 - is_delete
     */
    public static final String EVENT_TRUE = "有活动";

    /**
     * 公共数据表字段名称 - is_delete
     */
    public static final String EVENT_FALSE = "无活动";


    /**
     * 在线
     */
    public static final String ONLINE = "1";


    /**
     * 离线
     */
    public static final String OFFLINE = "0";



    /**
     * 车辆
     */
    public static final String VEHICLE_CATEGORY = "vehicle";

    /**
     * 设备
     */
    public static final String DEVICE_CATEGORY = "device";


    /**
     * 系统用户名
     */
    public static final String SYSUSER_NAME = "system";


    /**
     * BD09 坐标系(百度坐标系，GCJ02 坐标系加密后的坐标系)
     */
    public static final String BD09 = "bd09";


    /**
     * WGS84 坐标系(地球坐标系，国际通用坐标系，GPS 系统使用的坐标系)
     */
    public static final String WGS84  = "wgs84";

    /**
     * GCJ02 坐标系(火星坐标系，WGS84 坐标系加密后的坐标系；Google 国内地图、高德、腾讯地图使用)
     */
    public static final String GCJ02 = "gcj02";

    /**
     * 实时调度-调度执行人
     */
    public static final String DISPATCHER = "User-Id";

}
