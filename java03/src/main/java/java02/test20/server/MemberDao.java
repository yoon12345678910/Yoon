/* 페이징 처리
 * => DBMS마다 처리하는 방법이 다르다.    
 */
package java02.test20.server;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDao {
  SqlSessionFactory sqlSessionFactory;
 
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
	this.sqlSessionFactory = sqlSessionFactory;
}

public MemberDao() {}

  public Member selectOne(String uid) {
	  
	  	SqlSession sqlSession = sqlSessionFactory.openSession();
	  	//시그너처이란? 메서드 이름과 파라미터 타입
  	 try{
  	 return sqlSession.selectOne(
  			 "java02.test20.server.MemberDao.selectOne", 
  			uid); //new Integer(no) ==> auto-boxing 한 것
  	 }finally{
  		 sqlSession.close();
  	 }
  }
  
  public void update(Member member) {
	  SqlSession sqlSession = sqlSessionFactory.openSession();
	  	
	  	 try{
	  	  sqlSession.update( /*메서드 호출이름*/
	  			 "java02.test20.server.MemberDao.update", //네임스페이스 + SQL문 아이디 
	  			 member); //SQL문을 실행할 때 필요한 값 전달
	  	  sqlSession.commit();
	  	 }finally{
	  		 sqlSession.close();
	  	 }
  }
  
  public void delete(String uid) {
	  SqlSession sqlSession = sqlSessionFactory.openSession();
	  	
	  	 try{
	  	  sqlSession.delete(
	  			 "java02.test20.server.MemberDao.delete", //네임스페이스 + SQL문 아이디 
	  			uid); //SQL문을 실행할 때 필요한 값 전달
	  	  sqlSession.commit();
	  	 }finally{
	  		 sqlSession.close();
	  	 }
  }
  
  public List<Member> selectList(int pageNo, int pageSize) {
	  
	  	SqlSession sqlSession = sqlSessionFactory.openSession();
	  	
   	 HashMap<String, Object> paramMap = new HashMap<>();
   	 paramMap.put("startIndex", ((pageNo - 1) * pageSize) );
   	 paramMap.put("pageSize", pageSize);
   	 try{
   	 return sqlSession.selectList(
   			 "java02.test20.server.MemberDao.selectList", //네임스페이스 + SQL문 아이디 
   			 paramMap); //SQL문을 실행할 때 필요한 값 전달
   	 }finally{
   		 sqlSession.close();
   	 }
  }
  
  public void insert(Member member) {
	 	SqlSession sqlSession = sqlSessionFactory.openSession();
	  	
  	 try{
  	  sqlSession.insert(
  			 "java02.test20.server.MemberDao.insert", //네임스페이스 + SQL문 아이디 
  			 member); //SQL문을 실행할 때 필요한 값 전달
  	  sqlSession.commit();
  	 }finally{
  		 sqlSession.close();
  	 }
  }
}
