package com.berg.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ApplicationEditVo {

    @NotNull(message = "请求应用表id不能为空")
    @Min(value = 0,message = "请求应用表id不能小于0")
    @ApiModelProperty(value = "请求应用表id")
    Integer id;
    @Size(max = 20, message = "应用名称长度不能超过20个字符")
    @NotBlank(message = "应用名称不能为空")
    @ApiModelProperty(value = "应用名称")
    String name;
    @Size(max = 255, message = "应用描述长度不能超过255个字符")
    @ApiModelProperty(value = "应用描述")
    String remark;
    @ApiModelProperty(value = "请求接口id集合")
    List<Integer> apiIds;
}
