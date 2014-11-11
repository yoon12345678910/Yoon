/* Connection 객체 얻기
 * => DBMS에 SQL문을 보내는 역할을 수행한다.
	=> java.sql.Connection 구현체를 통해서 얻을 수 있다.


 */

package java02.test14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc03 {
//참조변수가 인터페이스일때는 인터페이스를 구현한 클래스들의 주소(객체)를 담을 수 있다.
	
	
	//Connection 구현체다
	public static void main(String[] args)  {
		Connection con =null;
		Statement stmt = null;
		try{
		//1. java.sql.Driver 구현체 로딩한다.
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("JDBC 드라이버 로딩됨");
		
		//2. DriverManager에게 Connection구현체를 부탁한다.
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb", //jdbc 접속을 위한 URL 정보, DBMS 마다 형식이 약간 다르다.
				"study", //사용자 아이디
				"study"//사용자 암호
				);
		System.out.println("DBMS에 연결됨");
		
		//3.Statement 객체 얻기
		stmt = con.createStatement();
		System.out.println("Statement 객체 준비 완료.");
		}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		try{stmt.close();}catch(Exception ex){}
		System.out.println("Statement 객체의 자원 해제함");
		
		try{con.close();}catch(Exception ex){}
		System.out.println("DBMS와 연결끊음");
	}
	}
}
