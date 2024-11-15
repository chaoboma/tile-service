package com.application.utils.uuid;

/**
 * ID生成器工具类
 *
 * @author ruoyi
 */
public class IdUtils {
    public static void main(String[] args) {
        System.out.println(randomUUID());
    }
    /**
     * 获取随机UUID
     *
     * @return 随机UUID
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String simpleUUID() {
        return UUID.randomUUID().toString(true);
    }

    /**
     * 获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 随机UUID
     */
    public static String fastUUID() {
        return UUID.fastUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String fastSimpleUUID() {
        return UUID.fastUUID().toString(true);
    }

    /**
     * 主编码生成规则:类型+五位编号（从1开始，不够前补0）
     *
     * @param numType
     * 				类型 编号前缀
     * @param numCurrent
     * 				最新编号
     * @param connector
     *              类型和编码连接符
     * @param bit
     *              类型后面编号位数
     * @return
     */
    public static String getNewEquipmentNo(String numType, String numCurrent,String connector,int bit){
        // 默认一个初始设备编号
        String newEquipmentNo = "";

        // 字符串数字解析为整数
        int no = Integer.parseInt(numCurrent);
        // 最新编号自增1
        int newEquipment = ++no;
        if(connector!=null && !connector.isEmpty()){
                // 将整数格式化为5位数字
                newEquipmentNo = String.format(numType+ connector + "%0"+bit+"d", newEquipment);
        }else{
            // 将整数格式化为5位数字
            newEquipmentNo = String.format(numType + "%0"+bit+"d", newEquipment);
        }
        return newEquipmentNo;
    }
    /**
     * 子编码生成规则:主编码+连接符+编号（从1开始）
     *
     * @param mainCode
     * 				主编码
     * @param numCurrent
     * 				最新编号
     * @param connector
     *              类型和编码连接符
     * @return
     */
    public static String getNewEquipmentNo(String mainCode, String numCurrent,String connector){
        // 默认一个初始设备编号
        String newEquipmentNo = "";

        // 字符串数字解析为整数
        int no = Integer.parseInt(numCurrent);
        // 最新编号自增1
        int newEquipment = ++no;
        if(connector!=null && !connector.isEmpty()){
            // 将整数格式化为5位数字
            newEquipmentNo = String.format(mainCode+ connector, newEquipment);
        }else{
            // 将整数格式化为5位数字
            newEquipmentNo = String.format(mainCode, newEquipment);
        }
        return newEquipmentNo;
    }
}
