package com.ballad.security.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Administrator
 * @Classname User
 * @date 2023-07-13 15:29
 * @comment
 */
@Getter
@Setter
@TableName("SYS_USER_INFO")
public class User extends Model<User> {

    @TableId("id")
    private String id;
    @TableField("`USERNAME`")
    private String name;
    @TableField("`PASSWORD`")
    private String password;

}
