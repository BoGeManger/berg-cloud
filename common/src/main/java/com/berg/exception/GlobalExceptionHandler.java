package com.berg.exception;

import com.berg.message.MessageConstant;
import com.berg.message.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex) {
		Result r;
		if (ex instanceof AppException) {
			AppException e = (AppException) ex;
			r = new Result(e.getErrorCode(), e.getErrorMsg(), null);
			log.error(e.getErrorMsg());
		} else if (ex instanceof MethodArgumentNotValidException) {
			log.error("请求参数错误", ex);
			List<String> errList = new ArrayList<>();
			MethodArgumentNotValidException e = (MethodArgumentNotValidException) ex;
			List<ObjectError> list = e.getBindingResult().getAllErrors();
			list.forEach(item -> {
				errList.add(item.getDefaultMessage());
			});
			r = new Result(MessageConstant.PARAMETER_ERROR_CODE, StringUtils.join(errList, ";"), null);
		} else if (ex instanceof ConstraintViolationException) {
			log.error("请求参数错误", ex);
			ConstraintViolationException e = (ConstraintViolationException) ex;
			String errMsg = e.getConstraintViolations().stream().map((cv) -> cv.getMessage()).collect(Collectors.joining(";"));
			r = new Result(MessageConstant.PARAMETER_ERROR_CODE, errMsg, null);
		} else if (ex instanceof AuthenticationException) {
			log.error("授权错误", ex);
			AuthenticationException e = (AuthenticationException) ex;
			String errMsg = e.getMessage();
			r = new Result(MessageConstant.UNAUTH_ERROR_CODE, errMsg, null);
		} else if (ex instanceof UnauthorizedException) {
			log.error("授权错误", ex);
			UnauthorizedException e = (UnauthorizedException) ex;
			r = new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE, "您没有对应的权限操作，请联系管理员授权", null);
		} else {
			log.error("运行异常", ex);
			r = new Result(MessageConstant.SYSTEM_ERROR_CODE, "运行异常", ex.getMessage());
		}
		return new ResponseEntity<Object>(r, HttpStatus.OK);
	}
}
