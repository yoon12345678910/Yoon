/* getXXX(칼럼인덱스)사용하기
 * => 컬럼인덱스는 1부터 시작한다.
 *  문제점: 인덱스는 코드를 해석하기 어렵게 만든다.
 *  
 *  select *from 테이블명
 *  => 컬럼 선택절에 와일드 카드를 사용하면 실행 속도가 느리다.
 * */

package java02.test14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc05 {
//참조변수가 인터페이스일때는 인터페이스를 구현한 클래스들의 주소(객체)를 담을 수 있다.
	
	
	//Connection 구현체다
	public static void main(String[] args)  {
		Connection con =null;
		Statement stmt = null;
		ResultSet rs = null;
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
		
		//4. SELECT문 실행하기
		//=>서버에서 결과를 하나씩 가져오는 역할자를 리턴한다.
		//=>즉, java.wql.ResultSet 구현체를 리턴한다.
		rs = stmt.executeQuery("SELECT * FROM PRODUCTS");
		System.out.println("서버에 질의 완료. ResultSet 준비 완료.");
		
		
		//5.결과 가져오기
		//=> 현재 결과를 가져온 상태가 아님!
		while(rs.next()){
			//결과를 가져왔다면 데이터는 ResultSet 객체에 들어 있다.
			System.out.print(rs.getInt(1)+ ",");
			System.out.print(rs.getString(2)+ ",");
			System.out.print(rs.getInt(3)+ ",");
			System.out.println(rs.getInt(4));
			
		}
		
		}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		try{rs.close();}catch(Exception ex){}
		System.out.println("ResultSet 객체의 자원을 해제함");
		
		try{stmt.close();}catch(Exception ex){}
		System.out.println("Statement 객체의 자원 해제함");
		
		try{con.close();}catch(Exception ex){}
		System.out.println("DBMS와 연결끊음");
	}
	}
}
