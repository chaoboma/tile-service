package com.application.constants.enums.error;

/**
 * 公共异常
 * @author lyw
 */

public enum BasicErrorEnum {

    // code不能重复
    TOKEN_TIMEOUT("B-00-999", "您的登录已过期，请重新登录！"),

    SYSTEM_ERROR("E-00-000","系统内部出错"),
    PARAMETER_VALIDATION_FAILED("E-00-001","参数校验不通过"),
    ILLEGAL_PARAMS("E-00-002","请求参数缺失"),
    NOT_ALLOWED("E-00-003","当前请求方法不支持"),
    NOT_FOUND_HANDLER("E-00-004","资源不存在"),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED("E-00-005","请求内容的类型不支持"),
    ILLEGAL_JSON("E-00-006","JSON不合法" ),
    DISPATCH_TIME_ERROR("E-00-007","调度时间校验失败！" ),
    NULL_TENANT_ID_ERROR("E-00-008","租户Id不能为空！" ),
    NOTHINGNESS_TENANT_ID_ERROR("E-00-009","租户Id不存在！" ),
    NO_OBU_DEVICE_IS_BOUND("E-00-010","该车辆未绑定OBU设备！" ),
    THE_LICENSE_PLATE_IS_INVALID("E-00-011","该车辆牌号无效，请选择有效车辆！" ),

    EXCEL_GENERATE_FAIL("E-00-012","Excel生成失败" ),

    NULL_USER_ID_ERROR("B-00-012","用户Id不能为空！" ),
    PHONE_FOUND_HANDLER("A-00-012","电话号码资源已存在，不能重复添加"),
    FOUND_HANDLER("E-00-013","资源已存在，不能重复添加"),
    ISSUE_TIME_ERROR("A-00-014","发布时间校验失败！"),
    MYSQL_OPERATION_ERROR("A-00-015","mysql语句运行失败"),
    LINE_FOUND_HANDLER("A-00-016","线路名称或编号号已存在，不能重复添加"),
    VEHICLE_IS_INVALID("E-00-017","该线路正常车辆查询异常"),
    PLAN_TIME_IS_INVALID("E-00-018","首班时间和末班时间异常"),
    SAFE_OFFICE_IS_INVALID("E-00-019","安全员数据查询异常"),
    VEHICLE_HAS_SCHEDULE("E-00-020","当前车辆已有排班计划，不能进行增发"),
    SAFETYOFFICER_HAS_SCHEDULE("E-00-021","当前安全员已有排班计划，不能进行增发或者删除"),
    VEHICLE_NOT_DISPATCH_ORDER("E-00-022","部分勾选车辆未设置调度信息，请检查后勾选！"),
    VEHICLE_DISPATCH_ORDER_PUBLISH("E-00-023","部分勾选车辆调度信息已发布，无法取消！"),
    VEHICLE_IS_RUNNING("E-00-024", "部分勾选车辆正在运行，请重新勾选！"),
    FUNCTION_SUPPORT_TWO_VEHICLE("E-00-025", "本功能仅支持两个车辆，请检查后勾选！"),
    VEHICLE_PLATE_REPEAT("E-00-026", "车牌号重复"),
    ABNORMAL_VEHICLE_NONPARTICIPATION_DISPATCH("E-00-027", "异常车辆不参与调度"),
    VEHICLE_NOT_PUBLISH_INFO("E-00-028","该车无调度记录，请先添加调度信息！"),
    NOT_FIND_BUSMANAGEMENT("E-00-029","没有找到该车的信息！"),
    WORKSCHEDULE_HAD_BUSMANAGEMENT("E-00-030","该车已经处于排班调度中！"),
    NOT_ENOUGH_BUSMANAGEMENT("E-00-031","没有足够数量的正常车进行排班！"),
    LINE_HAD_WORK("E-00-032","该线路已经参与了排班计划在那时无法删除！"),
    RUNTIME_CAR_CANNOT_DEL("E-00-033","运行车辆无法删除！"),
    NOT_SCHEDULE_PLAN_EXCHANGE("E-00-034","当前没有可执行调度操作的计划！"),
    LINE_NO_FOUND("E-00-035","线路不存在！"),
    SCHEDULE_WAS_FINISHED("E-00-036","调度任务已执行完成，不允许修改！"),
    SAFETY_OFFICER_HAS_BEEN_BIND("E-00-037","该安全员已经被绑定"),
    CAN_NOT_FIND_VEHICLE("E-00-038","找不到该车辆"),
    PATH_STATUS_ISON("E-00-039","该车辆已在接管中不允许再次接管"),
    TASK_IN_PROGRESS("E-00-040","任务执行中或已执行,无法删除！"),
    RELEASE_SUCCESS("E-00-041","该任务已发布成功,无法再次发布！"),
    REVOCATION_SUCCESS("E-00-042","该任务已撤销或者发布失败,无法再次撤销！"),
    NULL_TENANT_CODE_ERROR("E-00-043","租户Code不能为空！" ),
    DELETE_AUDIO_FILE_ERROR("E-00-044","已使用的语音素材不能被删除！" ),
    EELLING_UNDERSTOCK("E-00-045","售货车库存不足！" ),
    RELEASE_SUCCESS_NO_UPDATE("E-00-046","该任务处于发布成功,无法执行此操作任务！"),
    TASK_IN_PROGRESS_NO_REPEAL("E-00-047","任务执行中或已执行,无法撤销！"),
    TIME_SCOPE_CLASH("E-00-048","生效时间段与当前模板中的其他时间段重复"),
    NULL_EXCEL_ERROR("E-00-049","Excel表格字段不全！" ),
    NULL_GOODS_ERROR("E-00-050","商品不存在！" ),

    NULL_GOODS_COUNT_ERROR("E-00-050","商品库存不足！" ),

    NOT_NULL_NUMBER_ERROR("E-00-051","采购单号已存在！" ),
    OPERATE_AREA_BINDING_USINGLINE("E-00-052","当前运营区域下存在启用线路,无法停用！"),
    OPERATE_AREA_BINDING_LINE("E-00-053","当前运营区域下存在线路,无法删除！"),
    DELETE_OPERATE_AREA_BEFORE_DISABLE("E-00-054","删除运营区域前请先停用"),
    DELETE_LINE_BEFORE_DISABLE("E-00-055","删除线路前请先停用"),
    DELETE_SITE_BEFORE_UNBIND_LINE("E-00-056","删除站点前请先解绑线路"),
    DELETE_TEMPLATE_BEFORE_UNBIND_TASK("E-00-057","删除模板前请先解绑任务"),
    CRUISE_PATTERN_NOT_LINE("E-00-058", "巡游模式下线路不能为空"),
    CRUISE_PATTERN_NOT_CRUISENUMBER("E-00-059", "巡游模式下巡游圈数不能为空"),
    CRUISE_PATTERN_CRUISENUMBER_ILLEGAL("E-00-060", "巡游模式下巡游圈数不合法"),
    SITE_PATTERN_NOT_SITE("E-00-061", "站点模式下站点不能为空"),
    CURRENT_TASK_NOT_EDIT("E-00-062","当前任务不允许修改"),
    CURRENT_TASK_NOT_DELETE("E-00-063","当前任务不允许删除"),
    CURRENT_TASK_NOT_CHANGE_STATE("E-00-064","当前任务状态不允许进行此操作"),
    TASK_TIME_IS_CONFLICT("E-00-065","任务时间冲突"),
    CURRENT_TEMPLATE_NOT_TASK("E-00-066","当前模板下不存在模板任务"),
    EXIST_TASK_USING_LINE("E-00-067","存在任务使用当前线路，不允许停用"),
    NO_GOODS("E-00-068","商品已经卖完"),
    THIS_CARGO_LANE_IS_NOT_SUPPORTED("E-00-070","不支持该货道"),
    NOT_FIND_LANE("E-00-029","没有找到该货道的信息！"),
    ORDERE_NO_USER_APPLIES_FOR_REFUND("E-00-080","该订单未付款成功，不满足申请退款请求"),
    VEHICLE_TASK_STATE_NOT_CONFIG("E-00-081","存在车辆任务状态为不允许配置的车辆"),
    ERROR_GOODS_TYPE("E-00-082","该商家不支持该商品类型"),
    NO_TASK_TIME("E-00-083","该时段当前车辆无人执行该任务"),
    VEHICLE_OR_QUID_ISNO("E-00-083","车辆或区域id不存在"),
    NO_LANE("E-00-084","该模板目前没有货道信息"),
    ERROR_MERCHANT("E-00-085","没有此商家"),
    ORDER_NO_FINDE("E-00-086","没有该订单"),
    PAYED_NO_CANLE("E-00-087","该订单已支付成功无法取消，如有需要请申请退款"),
    GOODS_FOUND_ERROR("E-00-088","该货道已有此商品"),
    MERCHANT_EXIST_GOODS_DELETE_ERROR("E-00-089","该商家已关联商品，无法删除，请先删除关联商品"),

    TASK_NO_FOUND("E-00-100","任务不存在！"),
    ROOT_TASK_NO_FOUND("E-00-101","根任务不存在！"),
    TASK_START_ERROR("E-00-102","任务开始失败！"),
    TASK_PAUSE_ERROR("E-00-103","当前状态不允许停车！"),
    TASK_CHANGE_SPEED_ERROR("E-00-104","更改速度失败！"),
    TASK_TERMINAL_ERROR("E-00-105","当前状态不允许结束！"),
    TASK_BACK_ROLL_ERROR("E-00-106","当前状态不允许重跑！"),
    TASK_CANCEL_ERROR("E-00-107","删除失败！"),
    TASK_START_MULTIPLE_ERROR("E-00-108","当前存在正在执行的任务！"),
    TASK_LINE_NO_FOUND_ERROR("E-00-109","未查询到线路信息！"),
    TASK_POINT_NO_ERROR("E-00-110","任务坐标点与线路不匹配！"),
    ;


    private String code;
    private String message;

    BasicErrorEnum(String code, String message) {
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