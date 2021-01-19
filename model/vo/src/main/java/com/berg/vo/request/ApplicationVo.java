package com.berg.vo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationVo {

    @ApiModelProperty(value = "请求应用表id")
    Integer id;
    @ApiModelProperty(value = "应用名称")
    String name;
    @ApiModelProperty(value = "密钥")
    String secret;
    @ApiModelProperty(value = "应用描述")
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
