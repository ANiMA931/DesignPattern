package com.ballad.security.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Administrator
 * @Classname User
 * @date 2023-07-13 15:29
 * @comment
 */
@Getter
@Setter
@TableName("SYS_USER")
public class SysUser extends Model<SysUser> {
    //主键
    @TableId
    private Long id;
    //用户名
    @NotNull(message = "用户名不能为空")
    private String userName;
    //昵称
    private String nickName;
    //密码
    @NotNull(message = "密码不能为空")
    private String password;
    //用户类型：0代表普通用户，1代表管理员
    private String userType;
    //账号状态（0正常 1停用）
    private String status;
    //邮箱
    private String email;
    //手机号
    private String phonenumber;
    //用户性别（0男，1女，2未知）
    private String sex;
    //头像
    private String avatar;
    //创建人的用户id
    private Long createBy;
    //创建时间
    private Date createTime;
    //更新人
    private Long updateBy;
    //更新时间
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;
}