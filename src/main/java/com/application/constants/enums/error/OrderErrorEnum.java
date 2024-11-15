package com.application.constants.enums.error;

/**
 * @author zhuwenqin
 * @date 2022/4/5 16:19
 */
public enum OrderErrorEnum {
    NULL_WECHAT_OPENID_ERROR("CAR-01-001","微信支付openid不能为空"),
    ORDER_NOT_FOUND_ERROR("CAR-01-002","订单不存在"),
    ORDER_STATUS_CHANGE_ERROR("CAR-01-003","订单状态已改变，请刷新"),
    NO_SUPPORT_PAY_ERROR("CAR-01-004","不支持此种支付类型"),
    REPEAT_OPERATION_ERROR("CAR-01-005","您的操作请求已提交,请稍后"),
    BRANCH_NOT_FOUND_ERROR("CAR-01-006","网点不存在或已停用"),
    SITE_NOT_FOUND_ERROR("CAR-01-007","站点不存在或已停用"),
    CREATE_ORDER_FAIL_ERROR("CAR-01-008","下单失败，请重新下单"),
    UPDATE_VEHICLE_FAIL_ERROR("CAR-01-009","更新车辆信息失败"),
    USER_NOT_FOUND_FAIL_ERROR("CAR-01-010","未找到用户"),
    USER_NO_CERTIFICATION("CAR-01-011","用户未实名"),
    ORDER_NO_TRACK("CAR-01-012","订单无轨迹"),
    ORDER_COST_ERROR("CAR-01-013","支付金额有误"),
    SITE_LINE_ERROR("CAR-01-014","线路不存在"),
    EXIST_ORDER_ERROR("CAR-01-015","您有未完成订单"),
    USER_DISABLE("CAR-01-016","用户已禁用"),
    ORDER_SHIPMENT_ERROR("CAR-01-017","该订单出货异常")
    ;


    private String code;
    private String message;

    OrderErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
