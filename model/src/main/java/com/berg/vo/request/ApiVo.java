package com.berg.vo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiVo {

    @ApiModelProperty(value = "请求接口表id")
    Integer id;
    @ApiModelProperty(value = "调用服务名称")
    String serviceName;
    @ApiModelProperty(value = "控制器")
    String controller;
    @ApiModelProperty(value = "方法")
    String method;
    @ApiModelProperty(value = "接口描述")
    String remark;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    LocalDateTime createTime;
    @ApiModelProperty(value = "创建用户")
    String createUser;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    LocalDateTime modifyTime;
    @ApiModelProperty(value = "修改用户")
    String modifyUser;
}
