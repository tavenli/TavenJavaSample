package com.taven.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.security.Principal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.taven.utils.DateUtil;

@Controller
//类级别,可以不需要,如果要了,下面所有的请求路径前都需要加 /page
@RequestMapping("/page")
//@SessionAttributes(value = {"user"})
public class HelpController {

	private static Log log = LogFactory.getLog(HelpController.class);

	//方法级别,必须有,决定这个方法处理哪个请求
	@RequestMapping("/help")
	public String index() {
		
		/*
		 * 
		 * @RequestParam绑定单个请求参数值；
		 * @PathVariable绑定URI模板变量值；
		 * @CookieValue绑定Cookie数据值
		 * @RequestHeader绑定请求头数据；
		 * @ModelValue绑定参数到命令对象；
		 * @SessionAttributes绑定命令对象到session；
		 * @RequestBody绑定请求的内容区数据并能进行自动类型转换等。
		 * @RequestPart绑定“multipart/data”数据，除了能绑定@RequestParam能做到的请求参数外，还能绑定上传的文件等。
		 * 
		 */

		//帮助文档
		//http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/mvc.html#mvc-ann-requestmapping
		return "index";

	}
	
	@RequestMapping(value={"/help","/test1", "/user/create"})
	public void index_01() {
		//多个URL路径可以映射到同一个处理器的功能处理方法
		
	}
	
	@RequestMapping(value={"/users/**"})
	public void index_02() {
		//可以匹配“/users/abc”“/users/abc/abc”
	}
	
	@RequestMapping(value={"/product?"})
	public void index_03() {
		//可匹配“/product1”或“/producta”，但不匹配“/product”或“/productaa”
	}
	
	@RequestMapping(value={"/product*"})
	public void index_04() {
		//可匹配“/productabc”或“/product”，但不匹配“/productabc/abc”
	}
	
	@RequestMapping(value={"/product/*"})
	public void index_05() {
		//可匹配“/product/abc”，但不匹配“/productabc”
	}
	
	@RequestMapping(value={"/product/**/{productId}"})
	public void index_06() {
		//可匹配“/products/abc/abc/123”或“/products/123”
	}

	@ModelAttribute("cityList")
	public List<String> cityList() {
	    return Arrays.asList("北京", "山东");
	}
	
	@RequestMapping("/help")
	public void index(Model model) {
		boolean hasCityList = model.containsAttribute("cityList");
	}
	
	
	public void index(@ModelAttribute("cityList") List<String> cityList) {
		
	}
	
	@RequestMapping("/session2")   //③  
	public String session(@ModelAttribute("user") UserModel user, SessionStatus status) {  
		//通过SessionStatus的setComplete()方法清除@SessionAttributes指定的会话数据 
	    if(true) { //④  
	        status.setComplete();  
	    }  
	    return "success";  
	}   
	
	@RequestMapping(value = "/help2", method = RequestMethod.GET)
	public String index2() {
		return "index";
	}

	@RequestMapping(params="create", method=RequestMethod.POST)    
    public String submit() {  
		//表示请求中有“create”的参数名且请求方法为“POST”即可匹配
        System.out.println("================submit");  
        return "redirect:/success";          
    }  
	
	@RequestMapping(params="!create", method=RequestMethod.POST)    
    public void submit2() {  
		//表示请求中没有“create”参数名且请求方法为“GET”即可匹配
        System.out.println("================submit");  
    }
	
	@RequestMapping(params = "h3=3")
	public String index3() {
		//有参数 h3=3 则匹配
		return "index";
	}

	@RequestMapping(params = { "h1=1", "h2=2", "h3" })
	public ModelAndView index4(String h3, ModelMap modelMap) {
		//多个参数匹配 (h1=1,h2=2，h3任意值)
		modelMap.put("h3", h3);
		return new ModelAndView("/login/index", modelMap);
	}

	@RequestMapping(headers = { "Content-Type=application/x-www-form-urlencoded" })
	public String index51() {
		//设置请求头“Content-Type: application/x-www-form-urlencoded”表示请求的数据为key/value数据
		//例如：username=li&password=123
		
		//设置请求头“Content-Type:application/json;charset=GBK”表示请求的内容区数据为json类型数据，且内容区的数据以GBK进行编码
		
		//Accept=application/json
		//Accept=application/xml
		
		return "index";
	}

	@RequestMapping(headers = { "Connection=keep-alive" })
	public String index52() {
		//请求的header中包含值匹配
		return "index";
	}
	
	@RequestMapping("/help6/{catename}")
	public String index6(@PathVariable String catename) {
		//参数变量匹配，可以包含多个参数
		return "index";
		//URL改变的跳转
		//return "redirect:files/{catename}";
		//return "redirect:index.html";
		//return "redirect:http://www.163.com";
		//URL不改变的跳转
		//return "forward:../../welcome.jsp";
	}

	@RequestMapping("/help/{catename}")
	public String index7(@PathVariable("catename") String cate) {
		//参数变量匹配，可以包含多个参数
		return "index";
	}

	@RequestMapping
	public String index7() {
		//默认方法名匹配
		return "view/login/index";
	}

	@RequestMapping
	public String index8(String username, @RequestParam("username") String nickname, String password) {
		//自动匹配参数名 username 和 password
		return "index";
	}

	@RequestMapping
	public void index9() {
		//无返回值
		log.info("无返回值");
	}

	@RequestMapping("/spring-web/{symbolicName:[a-z-]+}-{version:\\d\\.\\d\\.\\d}.{extension:\\.[a-z]}")
	public void handle(@PathVariable String version, @PathVariable String extension) {
		//可匹配URL：/spring-web/spring-web-3.0.5.jar
		//格式：{varName:regex}
	}
	
	@RequestMapping(value="/users/{userId}/topics/{topicId}")
	public void handle2(@PathVariable(value="userId") int userId,@PathVariable(value="topicId") int topicId){
		
	}


	@RequestMapping("/index10")
	public void index10(HttpServletRequest request, HttpServletResponse response) {

		try {
			PrintWriter writer = response.getWriter();

			writer.print("{msg:\"ok\"}");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/index11")
	@ResponseBody
	public Map<String, Object> index11(HttpServletRequest request, HttpServletResponse response) {
		//需要增加 org.springframework.http.converter.json.MappingJacksonHttpMessageConverter 的配置

		Map<String, Object> msg = new HashMap<String, Object>();

		msg.put("msg", "成功");
		msg.put("time", DateUtil.getCurrentTime());
		msg.put("status", true);

		return msg;

	}
	
	@RequestMapping
	public String requestOrResponse(ServletRequest servletRequest, HttpServletRequest httpServletRequest,
	        ServletResponse servletResponse, HttpServletResponse httpServletResponse){
		
		return "";
	}
	
	public void inputOrOutBody(InputStream requestBodyIn, OutputStream responseBodyOut) throws IOException {
		
		//requestBodyIn：获取请求的内容区字节流，等价于request.getInputStream();
		//responseBodyOut：获取相应的内容区字节流，等价于response.getOutputStream()
		
		responseBodyOut.write("success".getBytes());
	}
	
	public void readerOrWriteBody(Reader reader, Writer writer) throws IOException {
		//reader：获取请求的内容区字符流，等价于request.getReader();
		//writer：获取相应的内容区字符流，等价于response.getWriter()
	    writer.write("hello");
	}

	public String webRequest(WebRequest webRequest, NativeWebRequest nativeWebRequest) {
		
			/*
			 * webRequest.getParameter：访问请求参数区的数据，可以通过getHeader()访问请求头数据；
			 * 
			 * webRequest.setAttribute/getAttribute：到指定的作用范围内取/放属性数据，Servlet定义的三个作用范围分别使用如下常量代表：
			 * SCOPE_REQUEST ：代表请求作用范围
			 * SCOPE_SESSION ：代表会话作用范围
			 * SCOPE_GLOBAL_SESSION ：代表全局会话作用范围，即ServletContext上下文作用范围
			 * 
			 * nativeWebRequest.getNativeRequest/nativeWebRequest.getNativeResponse：得到本地的Servlet API
			 * 
			 */
		    System.out.println(webRequest.getParameter("test"));//①得到请求参数test的值
		    webRequest.setAttribute("name", "value", WebRequest.SCOPE_REQUEST);//②
		    System.out.println(webRequest.getAttribute("name", WebRequest.SCOPE_REQUEST));
		    
		    HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);//③
		    HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
		    
	        return "success";
	    }



	@RequestMapping
	public String session(HttpSession session) {
		//此处的session永远不为null
		
		/*
		 * session访问不是线程安全的，如果需要线程安全，
		 * 需要设置AnnotationMethodHandlerAdapter或
		 * RequestMappingHandlerAdapter的synchronizeOnSession属性为true，
		 * 即可线程安全的访问session
		 * 
		 */
		
	    System.out.println(session);
	    return "success";
	}

	
	@RequestMapping(value = "/model")
	public String createUser(Model model, Map model2, ModelMap model3) {
		//虽然此处注入的是三个不同的类型（Model model, Map model2, ModelMap model3），但三者是同一个对象
	    model.addAttribute("a", "a");
	    model2.put("b", "b");
	    model3.put("c", "c");
	    System.out.println(model == model2);
	    System.out.println(model2 == model3);
	    return "success";
	}

	
	@RequestMapping(value = "/mergeModel")
	public ModelAndView mergeModel(Model model) {
	    model.addAttribute("a", "a");//①添加模型数据
	    ModelAndView mv = new ModelAndView("success");
	    mv.addObject("a", "update");//②在视图渲染之前更新③处同名模型数据
	    model.addAttribute("a", "new");//③修改①处同名模型数据
	    //视图页面的a将显示为"update" 而不是"new"
	    return mv;
	}
	
	@RequestMapping(value = "/error1")
	public String error1(UserModel user, BindingResult result){
		return "";
		
	}
	
	@RequestMapping(value = "/error2")
	public String error2(UserModel user, BindingResult result, Model model) {
		return "";
	}
	    
	@RequestMapping(value = "/error3")
	public String error3(UserModel user, Errors errors){
		//错误对象必须紧跟在命令对象/表单对象之后
		//错误的方式： public String error3(UserModel user, Model model, Errors errors)
		
		
		return "";
	}
	
	@RequestMapping
	public String other(Locale locale, Principal principal){
		
		/*
		 * java.util.Locale：得到当前请求的本地化信息，默认等价于ServletRequest.getLocale()
		 * 
		 * java.security.Principal：该主体对象包含了验证通过的用户信息，等价于HttpServletRequest.getUserPrincipal()
		 */
		
		
		return "";
	}
	
	public String requestparam4(@RequestParam(value="username",required=false) String username) {
		return "";
	}
	
	public String requestparam5(@RequestParam(value="username", required=true, defaultValue="zhang") String username){
		return "";
	}
	
	public String requestparam7(@RequestParam(value="role") String[] roleList){
		//请求中有多个同名的参数名
		//或 public String requestparam8(@RequestParam(value="list") List<String> list)
		
		return "";
	}
			        
	public void test(@CookieValue(value="JSESSIONID", defaultValue="") String sessionId){
		//或 public String test2(@CookieValue(value="JSESSIONID", defaultValue="") Cookie sessionId)
	}
	
	@RequestMapping(value="/header")
	public void testRequestHeader(@RequestHeader("User-Agent") String userAgent,@RequestHeader(value="Accept") String[] accepts){
		
		
	}

	public void getSysProperties(@Value("#{systemProperties['java.vm.version']}") String jvmVersion){
		
	}

	@RequestMapping(value = "/format2")
	public String testFormatRequest(@DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam("date") Date date) {
	    	System.out.println(date);
	    	return "format/success2";
	}
	
	private UserModelValidator validator = new UserModelValidator();  
	  
    @ModelAttribute("user")        //① 暴露表单引用对象为模型数据  
    public UserModel getUser() {  
        return new UserModel();  
    }  
    @RequestMapping(value = "/validator", method = RequestMethod.GET)  
    public String showRegisterForm() {   //② 表单展示  
        return "validate/registerAndValidator";  
    }  
    
    @RequestMapping(value = "/validator", method = RequestMethod.POST)  
    public String submitForm(@ModelAttribute("user") UserModel user,Errors errors) {
    	//③ 表单提交  
        validator.validate(user, errors);  //1 调用UserModelValidator的validate方法进行验证  
        if(errors.hasErrors()) { //2如果有错误再回到表单展示页面  
            return showRegisterForm();  
        }  
        return "redirect:/success";  
    }
    
    /*@RequestMapping("/validate/hello")  
    public String validate(@Valid @ModelAttribute("user") UserModel user, Errors errors) {  
        ////需JSR-303验证框架支持 
        if(errors.hasErrors()) {  
            return "validate/error";  
        }  
        return "redirect:/success";  
    }  */
	
    /*@RequestMapping("/validate/multi")
    public String multi(@Valid @ModelAttribute("a") A a, BindingResult aErrors,
    		    @Valid @ModelAttribute("b") B b, BindingResult bErrors) {
    		
    		if(aErrors.hasErrors()) { //如果a模型对象验证失败
    			return "validate/error";
    		}
    		if(bErrors.hasErrors()) { //如果a模型对象验证失败
    			return "validate/error";
    		}
    		return "redirect:/success";
    }*/
    
}
