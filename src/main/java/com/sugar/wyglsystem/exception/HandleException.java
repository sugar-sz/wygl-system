package com.sugar.wyglsystem.exception;

import com.sugar.wyglsystem.common.api.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/18 17:51
 * @description：
 */
@ControllerAdvice
@RestController
public class HandleException {

    @ExceptionHandler(NullPointerException.class)
    public CommonResult<Object> NullPointerException() {
        System.out.println("异常");
        return CommonResult.failed("查询信息不存在");
    }
}
