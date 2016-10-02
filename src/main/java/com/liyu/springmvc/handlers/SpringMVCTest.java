package com.liyu.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.HiddenHttpMethodFilter;

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


    /**
     * REST风格的URL
     * CRUD:
     * GET: /order/1
     * POST: /order
     * PUT: /order/1
     * DELETE: /order/1
     *
     * form表单默认只支持GET / POST请求，如何发送PUT / DELETE 请求？
     * 1. 配置HiddenHttpMethodFilter
     * 2. 发送POST请求
     * 3. 需要在发送请求时携带一个name="_method"的隐藏域，值为PUT活着DELETE
     *
     * 在springMVC的目标方法中如何得到参数id？
     * 使用@PathVariable注解
     * @param id
     * @return
     */
    @RequestMapping(value="/testRest/{id}", method=RequestMethod.GET)
    public String testRestGet(@PathVariable Integer id){
        System.out.println("TestRest Get " + id);
        return SUCCESS;
    }

    @RequestMapping(value="/testRest", method=RequestMethod.POST)
    public String testRestPost(){
        System.out.println("TestRest Post");
        return SUCCESS;
    }

    @RequestMapping(value="/testRest/{id}", method=RequestMethod.PUT)
    public String testRestPut(@PathVariable Integer id){
        System.out.println("TestRest Put " + id);
        return SUCCESS;
    }

    @RequestMapping(value="/testRest/{id}", method=RequestMethod.DELETE)
    public String testRestDelete(@PathVariable Integer id){
        System.out.println("TestRest Delete " + id);
        return SUCCESS;
    }

}
