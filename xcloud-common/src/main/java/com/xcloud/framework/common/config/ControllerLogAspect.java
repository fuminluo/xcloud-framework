package com.xcloud.framework.common.config;


import com.alibaba.fastjson.JSON;
import com.xcloud.framework.common.base.LoggerInfo;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * @author administered
 * @data 2018/8/7
 */
@Aspect
@Component
public class ControllerLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLogAspect.class);

    @Pointcut("execution(public * *..*.controller..*.*(..))")
    public void executeService() {
    }

    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        try {
            Signature signature = joinPoint.getSignature();
            HttpServletRequest request = (HttpServletRequest) RequestContextHolder.getRequestAttributes().resolveReference(RequestAttributes.REFERENCE_REQUEST);
            long beginTime = System.currentTimeMillis();
            request.setAttribute("beginTime", beginTime);
            LoggerInfo loggerInfo = new LoggerInfo();
            loggerInfo.setTimestamp(beginTime);
            loggerInfo.setMethod(request.getMethod());
            Object[] args = joinPoint.getArgs();
            //LOGGER.info("》》 args ："+ ObjectSizeCalculator.getObjectSize(args));
            //数据内容大于1000字节不转换
            if (ObjectSizeCalculator.getObjectSize(args) > 1000) {
                loggerInfo.setParameters("参数过大不解析！");
            } else {
                loggerInfo.setParameters(args);
            }
            loggerInfo.setUrl(request.getRequestURI());
            loggerInfo.setSessionId(request.getSession().getId());
            LOGGER.info("》》 [CLS] - " + signature.getDeclaringTypeName() + "." + signature.getName());
            LOGGER.info("》》 [IN] - " + JSON.toJSONString(loggerInfo));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @AfterReturning(
            value = "execution(* *..*.controller..*.*(..))",
            returning = "keys"
    )
    public void doAfterReturningAdvice(JoinPoint joinPoint, Object keys) {
        try {
            HttpServletRequest request = (HttpServletRequest) RequestContextHolder.getRequestAttributes().resolveReference("request");
            long beginTime = Long.parseLong(String.valueOf(request.getAttribute("beginTime")));
            String taskuuid = String.valueOf(request.getAttribute("taskuuid"));
            long endTime = System.currentTimeMillis();
            LoggerInfo loggerInfo = new LoggerInfo();
            loggerInfo.setTimestamp(beginTime);
            loggerInfo.setDuration(endTime - beginTime);
            loggerInfo.setTaskuuid(taskuuid);
            loggerInfo.setResult(keys);
            LOGGER.info("[OUT] - " + JSON.toJSONString(loggerInfo));
        } catch (Exception e) {

        }
    }

    @AfterThrowing(
            value = "executeService()",
            throwing = "exception"
    )
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        LOGGER.info("[IN] exception- " + exception.getStackTrace());
    }


}

