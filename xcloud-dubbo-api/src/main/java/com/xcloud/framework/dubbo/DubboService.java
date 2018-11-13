package com.xcloud.framework.dubbo;

import java.util.List;

/**
 * @Author administered
 * @Description
 * @Date 2018/10/19 22:28
 **/
public interface DubboService {

   String hello(String str);

   List findAllList();
}
