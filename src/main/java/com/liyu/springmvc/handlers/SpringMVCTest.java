package com.liyu.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    /**
     * 使用method属性来指定http请求方式
     * @return
     */
    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("test Method");
        return SUCCESS;
    }

    /**
     * 使用params和headers更加精确的映射请求
     * @return
     */
    @RequestMapping(value="/testParamsAndHeaders", params={"username", "age!=10"}, headers={"Cache-Control:max-age=1"})
    public String testParamsAndHeaders(){
        System.out.println("test Params And Headers");
        return SUCCESS;
    }

    @RequestMapping("/testAntPath/*/abc")
    public String testAntPath(){
        System.out.println("test Ant Path");
        return SUCCESS;
    }


    /**
     * @PathVariable 可以映射URL中的占位符到目标方法的参数中
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println("test Path Variable " + id);
        return SUCCESS;
    }
}
