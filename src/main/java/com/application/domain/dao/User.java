package com.application.domain.dao;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName(value = "public.user")
@ApiModel("用户实体类")
public class User extends Model<User> {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("用户名")
    @TableField(value = "username")
    private String username;

    @ApiModelProperty("用户密码")
    @TableField(value = "password")
    private String password;

    @ApiModelProperty("手机")
    @TableField(value = "phone")
    private String phone;

    @ApiModelProperty("邮箱")
    @TableField(value = "email")
    private String email;

    @ApiModelProperty("用户状态，0:启用 1:禁用")
    @TableField(value = "status")
    private Integer status;

    @ApiModelProperty("地址")
    @TableField(value = "address")
    private String address;

    @ApiModelProperty("用户角色id")
    @TableField(value = "userrole")
    private Integer userrole;

    @ApiModelProperty("公司")
    @TableField(value = "company")
    private String company;

    @ApiModelProperty("昵称")
    @TableField(value = "nickname")
    private String nickname;

    @ApiModelProperty("真实姓名")
    @TableField(value = "realname")
    private String realname;

    @ApiModelProperty("是否已删除，0未删除，1已删除")
    //@TableField(value = "isDelete")
    private Integer isDelete;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
    public static long count(LambdaQueryWrapper<User> wrapper) {
        return new User().selectCount(wrapper);
    }
    public static LambdaQueryWrapper<User> lambdaQuery() {
        return Wrappers.lambdaQuery();
    }
    public static User get(LambdaQueryWrapper<User> wrapper) {
        return new User().selectOne(wrapper);
    }
}
