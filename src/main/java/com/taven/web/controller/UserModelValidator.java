package com.taven.web.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserModelValidator implements Validator {
	
	private static final Pattern USERNAME_PATTERN = Pattern.compile("[a-zA-Z]\\w{4,19}");

	private static final Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9]{5,20}");

	private static final Set<String> FORBINDDDEN_WORD_SET = new HashSet<String>();
	static {
		FORBINDDDEN_WORD_SET.add("fuck");
		FORBINDDDEN_WORD_SET.add("admin");
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserModel.class == clazz;//表示只对UserModel类型的目标对象实施验证
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		//这个表示如果目标对象的username属性为空，则表示错误（简化我们手工判断是否为空）
		ValidationUtils.rejectIfEmpty(errors, "username", "username.not.empty");
		
		UserModel user = (UserModel) target;
		
		if(!USERNAME_PATTERN.matcher(user.getUsername()).matches()) {
			errors.rejectValue("username", "username.not.illegal");//如果用户名不合法
		}
		
		for(String forbiddenWord : FORBINDDDEN_WORD_SET) {
			if(user.getUsername().contains(forbiddenWord)) {
				errors.rejectValue("username", "username.forbidden", new Object[]{forbiddenWord}, "您的用户名包含非法关键词");//用户名包含屏蔽关键字
				break;
			}
		}
		
		if(!PASSWORD_PATTERN.matcher(user.getPassword()).matches()) {
			errors.rejectValue("password", "password.not.illegal", "密码不合法");//密码不合法
		}
		
	}

}
