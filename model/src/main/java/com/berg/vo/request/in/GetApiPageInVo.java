package com.berg.vo.request.in;

import com.berg.vo.common.PageInVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GetApiPageInVo extends PageInVo {

    @ApiModelProperty(value = "调用服务名称")
    String serviceName;
    @ApiModelProperty(value = "接口描述")
    String remark;
}
