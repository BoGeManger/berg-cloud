package com.berg.dao.system.res.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 请求接口表
 * </p>
 *
 * @author 
 * @since 2020-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("res_api_tbl")
public class ApiTbl implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求接口表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 调用服务名称
     */
    private String serviceName;

    /**
     * 控制器
     */
    private String controller;

    /**
     * 方法
     */
    private String method;

    /**
     * 接口描述
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 更新时间
     */
    private LocalDateTime modifyTime;

    /**
     * 修改用户
     */
    private String modifyUser;

    /**
     * 删除时间
     */
    private LocalDateTime delTime;

    /**
     * 删除用户
     */
    private String delUser;

    /**
     * 是否删除(0 否,1 是)
     */
    private Integer isdel;


}
