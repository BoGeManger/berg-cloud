package com.berg.api.system.controller;

import com.berg.api.system.service.FileService;
import com.berg.dao.page.PageInfo;
import com.berg.message.Result;
import com.berg.vo.common.DataVo;
import com.berg.vo.system.FilePathVo;
import com.berg.vo.system.FileVo;
import com.berg.vo.system.in.DelFileByNameInVo;
import com.berg.vo.system.in.GetFilePageInVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/system/file")
@Api(tags = "文件管理")
public class FileController {

    @Autowired
    FileService fileService;

    @ApiOperation("获取文件列表")
    @GetMapping(value = "getFilePage")
    public Result<PageInfo<FileVo>> getFilePage(@Validated GetFilePageInVo input){
        return fileService.getFilePage(input);
    }


    @ApiOperation("上传文件")
    @PostMapping(value = "uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<FilePathVo> uploadFile(@ApiParam(value = "文件",required = true) @RequestPart(value = "file") MultipartFile file,
                                         @ApiParam(value = "名称",required = true) @RequestParam(value = "name")String name,
                                         @ApiParam(value = "编码") @RequestParam(value = "code",required = false)String code,
                                         @ApiParam(value = "类型(0 模板文件 1 其他)") @RequestParam(value = "type",required = false,defaultValue = "1")Integer type){
        return fileService.uploadFile(file,name,code,type);
    }

    @ApiOperation(value = "删除文件",notes = "data为文件名称")
    @DeleteMapping(value = "delFileByName")
    public Result delFileByName(@RequestBody @Validated DelFileByNameInVo input){
        return fileService.delFileByName(input);
    }

}
