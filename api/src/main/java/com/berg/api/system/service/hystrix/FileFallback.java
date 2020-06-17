package com.berg.api.system.service.hystrix;

import com.berg.api.system.service.FileService;
import com.berg.dao.page.PageInfo;
import com.berg.message.MessageConstant;
import com.berg.message.Result;
import com.berg.vo.common.DataVo;
import com.berg.vo.system.FilePathVo;
import com.berg.vo.system.FileVo;
import com.berg.vo.system.in.DelFileByNameInVo;
import com.berg.vo.system.in.GetFilePageInVo;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

public class FileFallback implements FileService {
    
    @Override
    public Result getFilePage(GetFilePageInVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result uploadFile(MultipartFile file, String name, String code, Integer type) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result delFileByName(DelFileByNameInVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

}
