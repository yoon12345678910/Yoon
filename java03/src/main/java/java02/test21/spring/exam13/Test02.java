package java02.test21.spring.exam13;
/*
	스프링 설정
	=> 호출할 생성자 지정하기
	
*/

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

	@SuppressWarnings({"unused","resource"})
	public static void main(String[] args) {
			
		ApplicationContext ctx = 	
				new ClassPathXmlApplicationContext(
						new String[]{"java02/test21/spring/exam13/application-context02.xml"});
		
		Car02 c01 =  (Car02) ctx.getBean("c01");
		System.out.println(c01);
		 
	}

}
