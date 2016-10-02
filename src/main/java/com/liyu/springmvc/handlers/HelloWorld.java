package com.liyu.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by twcn on 10/2/16.
 */
@Controller
public class HelloWorld {
    /**
     * 1.使用@RequestMapping映射请求的url
     * 2.返回值通过试图解析器解析为视图：InternalResourceViewResolver解析为
     *   prefix + return value + suffix,  （/WEB-INF/views/success.jsp）
     *   然后转发
     * @return
     */
    @RequestMapping("/helloworld")
    public String hello(){
        System.out.println("hello world");
        return "success";
    }
}
