package com.berg.vo.request.in;

import com.berg.vo.common.PageInVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GetApplicationPageInVo extends PageInVo {

    @ApiModelProperty(value = "应用名称")
    String name;
    @ApiModelProperty(value = "应用描述")
    String remark;
}
