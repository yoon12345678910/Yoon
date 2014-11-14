/* 페이징 처리
 * => DBMS마다 처리하는 방법이 다르다.    
 */
package java02.test19.server;

import java.util.HashMap;
import java.util.List;
import java02.test19.server.annotation.Component;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@Component
public class ProductDao {
  SqlSessionFactory sqlSessionFactory;
 
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
	this.sqlSessionFactory = sqlSessionFactory;
}

public ProductDao() {}

  public Product selectOne(int no) {
	  
	  	SqlSession sqlSession = sqlSessionFactory.openSession();
	  	//시그너처이란? 메서드 이름과 파라미터 타입
  	 try{
  	 return sqlSession.selectOne(
  			 "java02.test19.server.ProductDao.selectOne", 
  			 no); //new Integer(no) ==> auto-boxing 한 것
  	 }finally{
  		 sqlSession.close();
  	 }
  }
  
  public void update(Product product) {
	  SqlSession sqlSession = sqlSessionFactory.openSession();
	  	
	  	 try{
	  	  sqlSession.update( /*메서드 호출이름*/
	  			 "java02.test19.server.ProductDao.update", //네임스페이스 + SQL문 아이디 
	  			 product); //SQL문을 실행할 때 필요한 값 전달
	  	  sqlSession.commit();
	  	 }finally{
	  		 sqlSession.close();
	  	 }
  }
  
  public void delete(int no) {
	  SqlSession sqlSession = sqlSessionFactory.openSession();
	  	
	  	 try{
	  	  sqlSession.delete(
	  			 "java02.test19.server.ProductDao.delete", //네임스페이스 + SQL문 아이디 
	  			 no); //SQL문을 실행할 때 필요한 값 전달
	  	  sqlSession.commit();
	  	 }finally{
	  		 sqlSession.close();
	  	 }
  }
  
  public List<Product> selectList(int pageNo, int pageSize) {
	  
	  	SqlSession sqlSession = sqlSessionFactory.openSession();
	  	
   	 HashMap<String, Object> paramMap = new HashMap<>();
   	 paramMap.put("startIndex", ((pageNo - 1) * pageSize) );
   	 paramMap.put("pageSize", pageSize);
   	 try{
   	 return sqlSession.selectList(
   			 "java02.test19.server.ProductDao.selectList", //네임스페이스 + SQL문 아이디 
   			 paramMap); //SQL문을 실행할 때 필요한 값 전달
   	 }finally{
   		 sqlSession.close();
   	 }
  }
  
  public void insert(Product product) {
	 	SqlSession sqlSession = sqlSessionFactory.openSession();
	  	
  	 try{
  	  sqlSession.insert(
  			 "java02.test19.server.ProductDao.insert", //네임스페이스 + SQL문 아이디 
  			 product); //SQL문을 실행할 때 필요한 값 전달
  	  sqlSession.commit();
  	 }finally{
  		 sqlSession.close();
  	 }
  }
}
