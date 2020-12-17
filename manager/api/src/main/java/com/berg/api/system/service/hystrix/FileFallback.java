package com.berg.api.system.service.hystrix;

import com.berg.api.system.service.FileService;
import com.berg.common.constant.MessageConstants;
import com.berg.common.constant.Result;
import com.berg.vo.system.in.DelFileByNameInVo;
import com.berg.vo.system.in.GetFilePageInVo;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileFallback implements FileService {
    
    @Override
    public Result getFilePage(GetFilePageInVo input) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试",null);
    }

    @Override
    public Result uploadFile(MultipartFile file, String name, String code, Integer type) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试",null);
    }

    @Override
    public Result delFileByName(DelFileByNameInVo input) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试",null);
    }

}
