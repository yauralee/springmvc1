package com.liyu.springmvc.handlers;

import com.liyu.springmvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Created by twcn on 10/2/16.
 */
@SessionAttributes(value={"user"}, types={String.class})
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

    /**
     * 目标方法可以添加Map类型(也可以是Model或ModleMao类型)的参数
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        System.out.println(map.getClass().getName()); //BindingAwareModelMap
        map.put("names", Arrays.asList("tom","cat","rose"));
        return SUCCESS;
    }

    /**
     * SessionAttributes除了可以通过属性名指定需要放在session中的属性外（使用value属性值），
     * 也可以通过模型属性的对象类型指定那些模型属性需要放在session中（使用type属性值）
     * @SessionAttributes(value={"user"}, types={String.class}) 这个注解只能修饰类！！！
     * value表示直接将user这个属性放在session中
     * type表示也可以把String类型的属性放在session中
     * 例如：@SessionAttributes(types=User.class)
     * @param map
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map){
        User user = new User(1, "ly", "123", "111@qqwwq", 12);
        map.put("user", user);
        map.put("school", "tw");
        return SUCCESS;
    }

    /**
     * [@ModelAttribute修饰的方法]
     * 1. 有@ModleAttribute标记的方法， 会在每个目标方法执行之前被SpringMVC调用！！！
     * 2. 这个注解也可以修饰目标方法pojo类型的入参，其value属性值有如下作用：
     *  1). SpringMVC会使用value属性值在implicitModel中查找对应的对象，若存在则直接传入目标方法的入参
     *  2). SpringMVC会以value为key, pojo类型的对象为value，存入request中。
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value="id", required = false) Integer id, Map<String, Object> map){
        System.out.println("ModelAttribute method");
        if (id != null){
            //模拟从数据库中获取对象
            User user = new User(1, "tom", "123456", "tom@qq.com", 12);
            System.out.println("根据id从数据库中获取user");
            map.put("user", user);
        }
    }

    /**
     * ［目标方法］
     *
     * 运行流程：
     * 1. 执行@ModelAttribute修饰的方法： 从数据库中取出对象，把对象放入Map中，键为User
     * 2. SpringMVC从Map中取出User对象， 并把表单请求参数赋给该User对象的对应属性
     * 3. SpringMVC把上述对象传入目标方法的参数
     *
     * 注意：
     * 在ModelAttribute修饰的方法中，放入到Map中 的键需要和目标方法入参类型的第一字母消协的字符串一致！
     * 即 "map.put("user", user)中的键" 和 "public String testModelAttribute(User user){...}中的参数类型User小写" 一致
     *
     * SpringMVC确定目标方法pojo类型入参的过程：
     * 1. 确定一个key
     *  1). 若目标方法的pojo类型的参数没有使用@ModelAttribute作为修饰，则key为pojo类名第一个字母的小写
     *  2). 若使用了@ModelAttribute修饰，则key为@ModelAttribute注解的value属性值。
     * 2. 在implicitModel中查找key对应的对象，若存在，则作为入参传入
     *  1). 若在@ModelAttribute标记的方法中，在Map中保存过，且key和已确定的key一致，则会获取到
     * 3. 若implicitModel中不存在key对应的对象，则检查当前handler是否使用@SessionAttributes注解修饰，
     *    若使用了该注解，且@SessionAttributes注解的value属性值中包含了key,则会从HttpSession中获取key对应的value值，
     *    若存在，则直接将其传入目标方法的入参中，若不存在则抛出异常。
     * 4. 若handler没有标识@SessionAttributes注解，或@SessionAttributes注解的value中不包含key，则
     *    通过反射来创建pojo类型的参数，传入目标方法的参数
     * 5. SpringMVC会把key和pojo类型的对象保存到implicitModel中，再保存到request中。
     *
     *
     * 源码分析：
     * 1.调用@ModelAttribute修饰的方法。把ModelAttribute修饰的方法中的Map中的数据放在了implicitModel中。
     * 2.解析请求处理器的目标参数，实际上该目标参数来自于WebDataBinder对象的target属性
     *  1). 创建WebDataBinder对象：
     *      ＊确定ObjectName属性：
     *        若传入的attrName属性值为""，则ObjectName为类名第一个字母小写。
     *        注意：若目标方法的pojo属性使用了@ModelAttribute修饰，则attrName值为@ModelAttribute的value属性值
     *      ＊确定target属性：
     *        在implicitModel中查找attrName对应的属性值，若存在，OK；
     *        若不存在则验证当前handler是否使用了@SessionAttributes进行修饰，
     *        若是用了则尝试从session中获取attrName所对应的属性值，若session中没有对应的属性值，则抛出异常。
     *        若handler没有使用@SessionAttributes修饰或@SessionAttributes中没有使用value值指定的key和attrName相匹配，则通过反射创建了pojo对象
     *  2). SpringMVC把表单的请求参数赋给了WebDataBinder的target对应的属性。
     *  3). SpringMVC会把WebDataBinder的attrName和target给到implicitModel。再传到request域对象中。
     *  4). 把WebDataBinder的target作为参数传递给目标方法的入参。
     *
     * @param user
     * @return
     */
    @RequestMapping("/testModelAttribute")
//    public String testModelAttribute(@ModelAttribute({'user'}) User user){ //也可以
    public String testModelAttribute(User user){
        System.out.println("修改： " + user);
        return SUCCESS;
    }

    @RequestMapping("/testViewAndViewResolver")
    public String testViewAndViewResolver(){
        System.out.println("testViewAndViewResolver");
        return SUCCESS;
    }

    /**
     * 测试自定义视图HelloView
     * @return
     */
    @RequestMapping("/testView")
    public String testView(){
        System.out.println("testView");
        return "helloView";
    }

    /**
     * 
     * @return
     */
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect");
        return "redirect:/index.jsp";
    }

}
