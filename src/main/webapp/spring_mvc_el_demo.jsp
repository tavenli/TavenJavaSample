<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

 <%@ page isELIgnored="false" %>
 <%-- 
 JSP支持EL表达式
 页面中加上 isELIgnored=false
 
 如果不想每个页面加，也可以修改web.xml的根节点 web-app，注意版本号，例如：
 <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_DIPIPI" version="2.5">
 
 
或者web.xml中配置
<jsp-config>
<jsp-property-group>
<url-pattern>*.jsp</url-pattern>
<el-ignored>false</el-ignored>
</jsp-property-group>
</jsp-config>
 --%>
 
<%
List<String[]> navs = new ArrayList<String[]>();

 %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帮助</title>

<link id="skin" rel="stylesheet" href="../css/jBox/Blue/jbox.css" />
<script type="text/javascript" src="../js/jquery.jBox.min.js"></script>
<script type="text/javascript" src="../js/jquery.jBox-zh-CN.js"></script>
 
<script type="text/javascript"> 

function addCard(){
	$.jBox("iframe:<s:url value='/u/cardadd'/>", {
	    title: "添加新卡密",
	    width: 500,
	    height: 350,
	    submit: addCardPost,
	    buttons: { '确定': 'ok','关闭': 'close' }
	});
}

function addCardPost(v, h, f){
	if(v == 'ok'){
		alert("提交...");
		
	}
	return true;
}

function editCard(cardId){
	$.jBox("iframe:<s:url value='/u/cardedit'/>", {
	    title: "修改卡密",
	    width: 500,
	    height: 350,
	    submit: addCardPost,
	    buttons: { '确定': 'ok','关闭': 'close' }
	});
}

function delCard(cardId){

	$.jBox.confirm("确定删除吗？", "确认操作", function (v, h, f) {
	    if (v == 'ok'){
	    	
	    	$.post("<s:url value='/u/delcard'/>",{},function(data){
	    		
	    		$.jBox.tip("删除成功", "success",{top: '40%'});
	    	});

	    	
		}
	    return true; 
	},{top: '40%'});
	
}

function importCards(){
	$.jBox("iframe:<s:url value='/u/cardimport'/>", {
	    title: "批量导入卡密",
	    width: 700,
	    height: 500,
	    submit: addCardPost,
	    buttons: { '确定': 'ok','关闭': 'close' }
	});
}

function delCards(){
	
	$.jBox.confirm("确定批量删除吗？", "批量操作确认", function (v, h, f) {
	    if (v == 'ok'){
	    	
	    	$.post("<s:url value='/u/delcard'/>",{},function(data){
	    		
	    		$.jBox.tip("批量删除成功", "success",{top: '40%'});
	    		
	    	});
	    	
		}
	    return true; 
	},{top: '40%'});
	
}
</script> 

</head>
<body>

${sessionScope.userInfo.userName} 用户成功登录！ accessToken：${sessionScope.userInfo.accessToken} 
<br/>
SPEL：<s:eval expression="T(java.lang.Math).random() * 100.0 "></s:eval>

<c:out value="${sessionScope.userInfo.userName}" />

<fmt:formatDate value="${user.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>

<c:if test="${user.userName!=null}">
userName
</c:if>

<c:forEach var="i" begin="1" end="${5}">
${i}    
</c:forEach>

<c:forEach items="${messages}" var="item" begin="0" end="9" step="1" varStatus="var" >
${item} 

当前循环索引号 ${var.index}
成员总数 ${var.count}
当前成员是否是首位成员 ${var.first}
当前成员是否是末位成员 ${var.last}

<c:if test="${var.index%2==0}">
偶数
</c:if>

<c:choose>
   <c:when test="${var.index==0}">
    *
   </c:when>
   <c:otherwise>
    !
   </c:otherwise>
</c:choose> 
   
</c:forEach>

<c:forEach items="${users}"  var="user" >
${user}
</c:forEach>

<% 
  Map map = new HashMap(); 
  map.put("a", "12345"); 
  map.put("b", "abcde"); 
  out.println(map.get("a")); 
  request.setAttribute("map",map); 
%> 
<c:forEach items="${map}" var="mymap" > 
  <c:out value="${mymap.key}" /> 
  <c:out value="${mymap.value}" /> 
</c:forEach>

<%

	Map<String,String> versionMap = new HashMap<String,String>();
	versionMap.put("0", "免费版");
	versionMap.put("1", "VIP版");
	versionMap.put("2", "VIP高级版");
	request.setAttribute("versionMap",versionMap); 
 %>
<select onchange="changeUserVersion(this,${user.userId});" style="width:100px;">
	<c:forEach items="${versionMap}" var="version" >
		<option value="${version.key}"  label="${version.value}" <c:if test="${user.version eq version.key}">selected="selected"</c:if> />
	</c:forEach>
</select>
 
<c:set var="path" value="<%=request.getContextPath() %>"></c:set>

<c:set var="userLevel" scope="session" value="Cowboy"/>

<c:set var="fido" value="${person.dog}"/>

<c:set var="user" scope="session">
Sheriff, Bartender, Cowgirl
</c:set>

<!-- var“版本”用于设置作用域属性，target“版本”用于设置bean属性或Map值 -->
<c:set target="${petMap}" property="dogName" value="Clover" scope="session"/> 

<c:set target="${person}" property="name">
${foo.name}
</c:set>


<form:select path="cateId"  items="${cateIds}"  itemValue="key"  itemLabel="value" ></form:select>

<form:select path="cateId" > 
<form:option value=""  label="--请选择--"/>
<form:options items="${cateIds}" itemValue="key" itemLabel="value" />

</form:select> 

<form:select path="cardInfoEntity.status" > 						
	<form:option value="-1"  label="已售出"/>
	<form:option value="0"  label="仓库"/>
	<form:option value="1"  label="待售" />
</form:select>

<form:textarea path="notes" rows="3" cols="20" />


<form:radiobuttons path="rateSettingEntity.rateType" items="${orders }" itemLabel="name" itemValue="id"/>

<form:radiobutton path="rateRuleEntity.rateType" value="1"/><img src="<s:url value='/images/good.png'/>" />好评&nbsp;&nbsp;
<form:radiobutton path="rateRuleEntity.rateType" value="0"/><img src="<s:url value='/images/neutral.png'/>" />中评&nbsp;&nbsp;
<form:radiobutton path="rateRuleEntity.rateType" value="-1"/><img src="<s:url value='/images/bad.png'/>" />差评&nbsp;

<c:forEach items="${favoriteMap}" var="favorite">
<form:checkbox path="favorites" value="${favorite.key}" />${favorite.value}  
</c:forEach> 

<c:forEach items="${allRoles}" var="role">
<input type="checkbox" value="${role.id}" <c:if test='${fn:contains(userEntity.roles,role)}'>checked="true" </c:if>/>${role.roleName} 
</c:forEach>

<form:checkboxes items="${allRolesMap }" path="roles" delimiter="&nbsp;" />

<form:checkboxes items="${allRoles }" path="roles" itemValue="id" itemLabel="roleName"  delimiter="&nbsp;" />

<%= new Date().toLocaleString()%>

<fmt:formatDate value="<%=new java.util.Date() %>" pattern="yyyy-MM-dd HH:mm:ss"/>

<fmt:formatNumber value="${n}" pattern="###,###.##" />  

将输出 12.300. 应用样式 ”.000”, 将使格式化后的小数部分有 3 位。不足 3 位将以 0 补齐。 
<fmt:formatNumber value ="12.3" pattern=".000"/>

<fmt:formatNumber value="${order.payment }" pattern=".00"/>


 
旺旺：<a target="_blank" href="http://www.taobao.com/webww/ww.php?ver=3&touid=lixyvip&siteid=cntaobao&status=1&charset=utf-8"><img border="0" src="http://amos.alicdn.com/realonline.aw?v=2&uid=lixyvip&site=cntaobao&s=1&charset=utf-8" alt="点击这里给我发消息" /></a>
QQ：<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=17020415&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:17020415:41" alt="点击这里给我发消息" title="点击这里给我发消息"></a>


<!-- 1、格式化单个命令/表单对象的值  -->
<s:bind path="dataBinderTest.phoneNumber">${status.value}</s:bind>   
<%-- 2、<spring:eval>标签，自动调用ConversionService并选择相应的Converter SPI进行格式化展示   --%>
<s:eval expression="dataBinderTest.phoneNumber"></s:eval> 
<!-- 3、通过form标签，内部的表单标签会自动调用命令/表单对象属性对应的PropertyEditor进行格式化显示 -->  
<form:form commandName="dataBinderTest">  
    <form:input path="phoneNumber"/><!-- 如果出错会显示错误之前的数据而不是空 -->  
</form:form>   
<!-- 4、显示验证失败后的错误信息 -->  
<form:errors></form:errors>   



国际化

<fmt:message key="Web.Name" />

<s:text name="hello"></s:text>

getText("username.invalid") 

<message key="username.xml.invalid"></message>  

<s:textfield name="username" key="username.name"></s:textfield>    

<s:i18n name="temp"></s:i18n>

</body>
</html>