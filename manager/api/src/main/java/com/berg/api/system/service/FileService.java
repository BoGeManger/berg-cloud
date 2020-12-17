package com.berg.api.system.service;

import com.berg.api.system.service.hystrix.FileFallback;
import com.berg.common.constant.Result;
import com.berg.vo.system.in.DelFileByNameInVo;
import com.berg.vo.system.in.GetFilePageInVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "system",contextId="file", fallback = FileFallback.class)
public interface FileService {

    @ApiOperation("获取文件列表")
    @GetMapping(value = "/system/file/getFilePage")
    Result getFilePage(@Validated GetFilePageInVo input);


    @ApiOperation("上传文件")
    @PostMapping(value = "/system/file/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Result uploadFile(@ApiParam(value = "文件",required = true) @RequestPart(value = "file") MultipartFile file,
                                         @ApiParam(value = "名称",required = true) @RequestParam(value = "name")String name,
                                         @ApiParam(value = "编码") @RequestParam(value = "code",required = false)String code,
                                         @ApiParam(value = "类型(0 模板文件 1 其他)") @RequestParam(value = "type",required = false,defaultValue = "1")Integer type);

    @ApiOperation(value = "删除文件",notes = "data为文件名称")
    @DeleteMapping(value = "/system/file/delFileByName")
    Result delFileByName(@RequestBody @Validated DelFileByNameInVo input);

}
