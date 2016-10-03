package com.liyu.springmvc.handlers;

import com.liyu.springmvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

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

    /**
     * @RequestParam映射请求参数
     * value值为请求参数的参数名
     * required：请求参数是否必须
     * defaltValue: 默认值
     * @param username
     * @param age
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value="username") String username,
                                   @RequestParam(value="age", required = false, defaultValue = "0") int age){
        System.out.println("test request param, username = " + username + ", age = " + age);
        return SUCCESS;
    }

    /**
     * 用法同@RequestParam
     * 作用：映射请求头信息
     * @param language
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value="Accept-Language") String language){
        System.out.println("test Request Header, Accept-Language: " + language);
        return SUCCESS;
    }


    /**
     * @CookieValue;
     * 映射一个cookie值
     * 属性和@RequestParam相同
     * @param sessionID
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("_myhome_session") String sessionID){
        System.out.println("testCookieValue, sessionID: " + sessionID);
        return SUCCESS;
    }


    /**
     * springMVC会按请求参数名和pojo属性名进行自动匹配
     * 自动为该对象填充属性
     * 支持级联属性，如address.city
     * @param user
     * @return
     */
    @RequestMapping("/testPojo")
    public String testPojo(User user){
        System.out.println("testPojo " + user);
        return SUCCESS;
    }


    /**
     * 可以使用servlet原生api作为目标方法的参数，具体支持类型：
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     * java.security.Principal
     * Locale
     * InputStream
     * OutputStream
     * Reader
     * Writer
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
        System.out.println("testServletAPI, request= " + request + ", response= "+ response);
        out.write("hello springMVC");
//        return SUCCESS;
    }

    /**
     * 目标方法的返回值可以是ModelAndView类型
     * 其中可以包含视图和模型信息
     * SpringMvc会把ModelAndView中的数据放入到request的请求域里
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        String viewName = SUCCESS;
        ModelAndView modelAndView= new ModelAndView(viewName);
        //添加模型数据到ModelAndView, 将map放到请求域里
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }


}
