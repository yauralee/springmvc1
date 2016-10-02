package com.liyu.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by twcn on 10/2/16.
 */
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
    public static final String SUCCESS = "success";
    /**
     * 1. @RequestMapping不但可以修饰方法，也可以修饰类
     * 2.类定义处：提供初步的请求映射信息，相对于WEB应用的根目录
     * 3.方法定义出：相对于类定义出的URL, 提供进一步的细分映射信息
     * @return
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("RequestMapping can embellish class, not only method");
        return SUCCESS;
    }
}
