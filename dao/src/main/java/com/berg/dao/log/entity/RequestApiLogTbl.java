package com.berg.dao.log.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 请求日志表
 * </p>
 *
 * @author 
 * @since 2020-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("request_api_log_tbl")
public class RequestApiLogTbl implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求日志表id
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
     * 请求控制器
     */
    private String controller;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 返回编码(00：请求成功,99：系统异常，10：参数异常，11：未授权，66：业务友好提示)
     */
    private String code;

    /**
     * 输入信息
     */
    private String input;

    /**
     * 输出信息
     */
    private String output;

    /**
     * 描述
     */
    private String description;

    /**
     * 操作人
     */
    private String operateUser;

    /**
     * 请求时间
     */
    private LocalDateTime requestTime;

    /**
     * 响应时间
     */
    private LocalDateTime responseTime;

    /**
     * 耗时(秒)
     */
    private BigDecimal timeout;


}
