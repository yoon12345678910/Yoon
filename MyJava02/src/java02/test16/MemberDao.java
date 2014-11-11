/* DAO(Data Access Object)
 - 데이터의 퍼시스턴스(Persistence) 담당
   => 데이터의 보관(등록,조회,변경,삭제) 
 * 
 */
package java02.test16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
  
  public MemberDao() {}
  
  public Member selectOne(String uid) {
	  Connection con =null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb", 
				"study", 
				"study"
				);
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(
				"SELECT UID, PWD, UNAME, EMAIL, TEL, FAX, DET_ADDR, PHOT, ANO FROM MEMBERS"
				+ " WHERE UID =" + "\'"+uid +"\'");
		
		System.out.println();
		if(rs.next()){
			Member member = new Member();
			member.setId(rs.getString("UID"));
			member.setPwd(rs.getString("PWD"));
			member.setName(rs.getString("UNAME"));
			member.setEmail(rs.getString("EMAIL"));
			member.setTel(rs.getString("TEL"));
			member.setFax(rs.getString("FAX"));
			member.setDet_addr(rs.getString("DET_ADDR"));
			member.setPhot(rs.getString("PHOT"));
			member.setAno(rs.getInt("ANO"));
			return member;
		}else{
			return null;
		}
		
		}catch(Exception ex){
			throw new RuntimeException(ex);
	}finally{
		try{rs.close();}catch(Exception ex){}
		try{stmt.close();}catch(Exception ex){}
		try{con.close();}catch(Exception ex){}
	}
  }
  
  public void update(Member member) {
	  Connection con =null;
		Statement stmt = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb" + 
				"?useUnicode=true&characterEncoding=utf8",
				"study", 
				"study"
				);
		
		stmt = con.createStatement();
		
		stmt.executeUpdate("UPDATE MEMBERS SET" 
		 + " UNAME='" + member.getName()
		  + "', PWD='" + member.getPwd()
		 + "', EMAIL='" + member.getEmail()
		 + "', TEL='" + member.getTel()
		 + "', FAX='" + member.getFax()
		 + "', DET_ADDR='" + member.getDet_addr()
		 + "', PHOT='" + member.getPhot()
		 + "', ANO=" + member.getAno()
		 + "  WHERE UID=" + "\'"+member.getId()+"\'");
		}catch(Exception ex){
			throw new RuntimeException(ex);
	}finally{
		try{stmt.close();}catch(Exception ex){}
		try{con.close();}catch(Exception ex){}
	}
  }
  
  public void delete(String uid) {
	  Connection con =null;
		Statement stmt = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb" + 
				"?useUnicode=true&characterEncoding=utf8",
				"study", 
				"study"
				);
		stmt = con.createStatement();
		
		stmt.executeUpdate("DELETE FROM MEMBERS "
				+ "WHERE UID =" +"\'"+ uid +"\'");
		
		}catch(Exception ex){
			throw new RuntimeException(ex);
	}finally{
		try{stmt.close();}catch(Exception ex){}
		try{con.close();}catch(Exception ex){}
	}
  }
  
  public List<Member> selectList() {
		Connection con =null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb", 
				"study", 
				"study"
				);
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(
				"SELECT UID, PWD, UNAME, EMAIL, TEL, FAX, DET_ADDR, PHOT, ANO FROM MEMBERS");
		
		ArrayList<Member> list = new ArrayList<Member>();
		Member member =null;
		while(rs.next()/*레코드*/){
			member = new Member();
			
			member.setId(rs.getString("UID"));
			member.setPwd(rs.getString("PWD"));
			member.setName(rs.getString("UNAME"));
			member.setEmail(rs.getString("EMAIL"));
			member.setTel(rs.getString("TEL"));
			member.setFax(rs.getString("FAX"));
			member.setDet_addr(rs.getString("DET_ADDR"));
			member.setPhot(rs.getString("PHOT"));
			member.setAno(rs.getInt("ANO"));
			
			list.add(member);
			}		
		return list;
		
		}catch(Exception ex){
			throw new RuntimeException(ex);
	}finally{
		try{rs.close();}catch(Exception ex){}
		try{stmt.close();}catch(Exception ex){}
		try{con.close();}catch(Exception ex){}
	}
  }
  
  public void insert(Member member) {
	  Connection con =null;
		Statement stmt = null;
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb" + 
				"?useUnicode=true&characterEncoding=utf8",
				"study", 
				"study"
				);
		
		stmt = con.createStatement();
		
		stmt.executeUpdate("INSERT INTO MEMBERS(UID, PWD, UNAME, EMAIL, TEL, FAX, DET_ADDR, PHOT, ANO)" +
		" VALUES('" + member.getId()
		+ "'," + member.getPwd()
		+ "," + member.getName()
		+ "," + member.getEmail()
		+ "," + member.getTel() 
		+ "," + member.getFax() 
		+ "," + member.getDet_addr() 
		+ "," + member.getPhot() 
		+ "," + member.getAno() 
		+ " )");
		
		}catch(Exception ex){
			throw new RuntimeException(ex);
	}finally{
		try{stmt.close();}catch(Exception ex){}
		try{con.close();}catch(Exception ex){}
	}
  }
}
