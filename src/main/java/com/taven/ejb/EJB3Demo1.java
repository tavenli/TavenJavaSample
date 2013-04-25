package com.taven.ejb;

public class EJB3Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
			EJB3.0知识点
			
			EJB容器一般都有提供EJB所依赖的jar包，如果是JBoss，一般包在 “jboss-5.1.0.GA\common\lib”下
			一般需要的包有：
			jboss-javaee.jar
			jboss-ejb3-core.jar
			
			
			业务方法不应该使用static final修饰。			
			从EJB3.0开始，Entity Bean改由JPA方式。
			如果没有指定mappedName，JBoss服务器为EJB生成JNDI绑定名为 Bean类名/remote 。
			@Local修饰的本地调用的EJB，指定的mappedName属性对于生成JNDI绑定名没有任何影响。
			@Remote修饰的EJB允许远程调用；而@Local修饰的EJB则只允许本地调用。
			@Stateless来修饰该Bean类；如果该EJB是一个有状态的Session Bean，则使用@Stateful来修饰该Bean类。

			发布EJB程序：将EJB的接口类和实现类打包成jar包，然后部署到EJB容器中（支持EJB容器的中间件有WebLogic、JBoss 等）
			
			//远程调用无状态Session Bean
			ejbClientTest(); 
			
			//本地调用无状态Session Bean
			ejbLocalClientTest();

		 */

	}

	/*	public void ejbClientTest()
				throws NamingException
		{
			//获取JBoss中JNDI服务的Context  
			Context jbossCtx = getJBossInitialContext();
			Hello h1 = (Hello) jbossCtx.lookup("Hello");
			//调用JBoss容器中EJB的业务方法  
			System.out.println(h1.hello("孙悟空"));
			//获取WebLogic中JNDI服务的Context  
			Context ctx = getInitialContext();
			Hello h2 = (Hello) ctx.lookup("Hello#org.crazyit.service.Hello");
			//调用WebLogic容器中EJB的业务方法  
			System.out.println(h2.hello("白骨精"));
		}

		//工具方法，用来获取WebLogic中JNDI服务的Context  
		private Context getInitialContext()
		{
			final String INIT_FACTORY =
					"weblogic.jndi.WLInitialContextFactory";
			final String SERVER_URL = "t3://localhost:7001";
			Context ctx = null;
			try
			{
				Properties props = new Properties();
				props.put(Context.INITIAL_CONTEXT_FACTORY
						, INIT_FACTORY);
				props.put(Context.PROVIDER_URL, SERVER_URL);
				ctx = new InitialContext(props);
			}
			catch (NamingException ne)
			{
				System.err.println("不能连接WebLogic Server在:"
						+ SERVER_URL);
				ne.printStackTrace();
			}
			return ctx;
		}

		//工具方法，用来获取JBoss中JNDI服务的Context  
		private Context getJBossInitialContext()
		{
			final String INIT_FACTORY =
					"org.jnp.interfaces.NamingContextFactory";
			final String SERVER_URL = "localhost:1099";
			Context ctx = null;
			try
			{
				Properties props = new Properties();
				props.put(Context.INITIAL_CONTEXT_FACTORY
						, INIT_FACTORY);
				props.put(Context.PROVIDER_URL, SERVER_URL);
				ctx = new InitialContext(props);
			}
			catch (NamingException ne)
			{
				System.err.println("不能连接JBoss Server在:" + SERVER_URL);
				ne.printStackTrace();
			}
			return ctx;
		}*/

	/*	public void ejbLocalClientTest() throws NamingException {

			InitialContext ctx = new InitialContext();
			//通过JNDI查找获得EJB  
			Object stub = ctx.lookup("Hello/local");
			HelloLocal helloLocal = (HelloLocal) stub;
			System.out.println(helloLocal.hello("孙悟空"));
		}*/

}
