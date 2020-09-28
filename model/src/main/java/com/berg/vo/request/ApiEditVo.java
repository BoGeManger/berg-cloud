package com.berg.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ApiEditVo {

    @NotNull(message = "请求接口表id不能为空")
    @Min(value = 0,message = "请求接口表id不能小于0")
    @ApiModelProperty(value = "请求接口表id")
    Integer id;
    @Size(max = 20, message = "调用服务名称长度不能超过20个字符")
    @NotBlank(message = "调用服务名称不能为空")
    @ApiModelProperty(value = "调用服务名称")
    String serviceName;
    @Size(max = 20, message = "控制器长度不能超过20个字符")
    @NotBlank(message = "控制器不能为空")
    @ApiModelProperty(value = "控制器")
    String controller;
    @Size(max = 20, message = "方法长度不能超过20个字符")
    @NotBlank(message = "方法不能为空")
    @ApiModelProperty(value = "方法")
    String method;
    @Size(max = 255, message = "接口描述长度不能超过255个字符")
    @ApiModelProperty(value = "接口描述")
    String remark;
}
