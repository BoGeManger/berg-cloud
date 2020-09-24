package com.berg.dao.log.entity;

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
 * 系统日志表
 * </p>
 *
 * @author 
 * @since 2020-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("system_log_tbl")
public class SystemLogTbl implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 通用日志表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 调用服务
     */
    private String service;

    /**
     * 调用端口
     */
    private Integer port;

    /**
     * 日志信息
     */
    private String message;

    /**
     * 详细日志信息
     */
    private String content;

    /**
     * 操作时间
     */
    private LocalDateTime operateTime;

    /**
     * 操作人
     */
    private String operateUser;

    /**
     * 日志类型(info error debug)
     */
    private String type;


}
