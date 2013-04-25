package com.taven.app.javabase.socket.senior.server;

public interface CrazyitProtocol
{
	//定义协议字符串的长度
	int PROTOCOL_LEN = 2;
	//下面是一些协议字符串，服务器和客户端交换的信息
	//都应该在前、后添加这种特殊字符串。
	String MSG_ROUND = "§γ";
	String USER_ROUND = "∏∑";
	String LOGIN_SUCCESS = "1";
	String NAME_REP = "-1";
	String PRIVATE_ROUND = "★【";
	String SPLIT_SIGN = "※";
}