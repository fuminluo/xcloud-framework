package com.xcloud.framework.common.config;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xcloud.framework.common.base.LoggerInfo;
import com.xcloud.framework.common.util.JSONUtils;
import com.xcloud.framework.common.util.JsonFormatUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LuoFuMin
 * @data 2018/8/7
 */
@Aspect
@Component
public class ControllerLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLogAspect.class);

    @Pointcut("execution(public * com.*.*.controller.*.*(..))")
    public void executeService() {
    }

    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        try {
            Signature signature = joinPoint.getSignature();
            HttpServletRequest request = (HttpServletRequest) RequestContextHolder.getRequestAttributes().resolveReference("request");
            long beginTime = System.currentTimeMillis();
            request.setAttribute("beginTime", beginTime);
            LoggerInfo loggerInfo = new LoggerInfo();
            loggerInfo.setTimestamp(beginTime);
            loggerInfo.setMethod(request.getMethod());
            List<String> argList = new ArrayList();
            Object[] args = joinPoint.getArgs();
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; ++i) {
                    try {
                        //请求数据 解析是为 JSONObject，如果解析不成功 catch 进行下一步处理
                        String requestDate = JSONUtils.toJson(args[i]);
                        JSONObject requestJson = JSONObject.parseObject(requestDate);
                        Object contentType = requestJson.get("contentType");
                        //如果是上传文件类型就跳出
                        if ("application/octet-stream".equals(contentType)) {
                            argList.add("file");
                            break;
                        }
                        for (Map.Entry<String, Object> entry : requestJson.entrySet()) {
                            argList.add(entry.getKey() + ":" + entry.getValue());

                        }
                    } catch (Exception e) {
                        try {
                            //请求数据 解析是为 JSONArray，如果解析不成功 catch 进行下一步处理
                            String requestDate = JSONObject.toJSONString(args[i]);
                            JSONArray requestJSONArray = JSONArray.parseArray(requestDate);
                            for (int j = 0; j < requestJSONArray.size(); ++j) {
                                argList.add(requestJSONArray.get(i).toString());
                            }
                        } catch (Exception e1) {
                            //请求数据 解析是为 String （form-data数据为字符串的形式），未知数据也转成String
                            argList.add(args[i].toString());
                        }

                    }
                }
            }
            loggerInfo.setParameters(argList);
            loggerInfo.setUrl(request.getRequestURI());
            loggerInfo.setSessionId(request.getSession().getId());
            LOGGER.info("[CLS] - " + signature.getDeclaringTypeName() + "." + signature.getName());
            LOGGER.info("[IN] - " + JsonFormatUtils.formatJson(JSON.toJSONString(loggerInfo)));
        } catch (Exception e) {

        }
    }

    @AfterReturning(
            value = "execution(* com.*.*.controller.*.*(..))",
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
            LOGGER.info("[OUT] - " + JsonFormatUtils.formatJson(JSON.toJSONString(loggerInfo)));
        } catch (Exception e) {

        }
    }

    @AfterThrowing(
            value = "executeService()",
            throwing = "exception"
    )
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        LOGGER.info("[IN] - " + exception.getStackTrace());
    }


}

