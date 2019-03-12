package com.xcloud.framework.common.exception;

import com.alibaba.fastjson.JSON;
import com.xcloud.framework.common.base.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 全局异常处理
 * @author: administered
 * @date: 2019/3/12
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    private static Logger LOG = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    /**
     * @Description:捕获参数异常
     * @param: e:异常信息
     * @returns: com.xcloud.framework.common.base.ResultInfo
     * @author: administered
     * @date: 2019/3/12
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultInfo handleValidException(MethodArgumentNotValidException e) {
        LOG.error("》》》 handleValidException");
        if (LOG.isDebugEnabled()) {
            e.printStackTrace();
            for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
                LOG.error("错误参数：：" + objectError.getDefaultMessage());
            }
        }
        return new ResultInfo<>(ResultInfo.FAIL, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * @Description:捕获参数异常
     * @param: e:异常信息
     * @returns: com.xcloud.framework.common.base.ResultInfo
     * @author: administered
     * @date: 2019/3/12
     */
    @ResponseBody
    @ExceptionHandler(BindException.class)
    public ResultInfo handleBindException(BindException e) {
        LOG.error("》》》 BindException");
        if (LOG.isDebugEnabled()) {
            e.printStackTrace();
            for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
                LOG.error("错误参数：：" + objectError.getDefaultMessage());
            }
        }
        return new ResultInfo<>(ResultInfo.FAIL, e.getBindingResult().getFieldError().getDefaultMessage());
    }


    /**
     * @Description: 捕获自定义异常
     * @param: [e]
     * @returns: com.xcloud.framework.common.base.ResultInfo<?>
     * @author: administered
     * @date: 2019/3/12
     */
    @ResponseBody
    @ExceptionHandler(value = XcloudBaseException.class)
    public ResultInfo<?> xcloudBaseException(XcloudBaseException e) {
        LOG.error("》》》 XcloudBaseException ");
        if (LOG.isDebugEnabled()) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
        return new ResultInfo<>(e.getCode(), e.getMessage());
    }


    /**
     * @Description: 捕获未知异常
     * @param: [e]
     * @returns: com.xcloud.framework.common.base.ResultInfo<?>
     * @author: administered
     * @date: 2019/3/12
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    private ResultInfo<?> defaultExceptionHandler(Exception e) {
        LOG.error("》》》 defaultExceptionHandler ");
        if (LOG.isDebugEnabled()) {
            e.printStackTrace();
            LOG.error(JSON.toJSONString(e.getStackTrace()));
        }
        return new ResultInfo<>(ResultInfo.ERROR, e.getMessage());
    }
}
