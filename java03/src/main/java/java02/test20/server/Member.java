/* Value Object
 * => Class 문법을 사용하여 사용자 정의 데이터 타입 만들기
 * 
 * 1) Serializable 인터페이스 구현
 *    => SerialVersionUID 스태틱 변수 선언
 * 
 * 2) 인스턴스 변수 선언
 * 
 * 3) setter/getter 생성
 * 
 * 4) 기본 생성자와 파라미터 값을 받는 생성자 선언
 * 
 * 5) equals()/hashCode() 메서드 오버라이딩
 * 
 * 6) toString() 오버라이딩
 */
package java02.test20.server;

import java.io.Serializable;

public class Member implements Serializable, Cloneable {
  private static final long serialVersionUID = 1L;
  
  protected String   			    uid;
  protected String   			  pwd;
  protected String     		  uname;
  protected String   			 email;
  protected String    				   tel;
  protected String   				 fax;
  protected String       det_addr;
  protected String     			  phot;
  protected int       					ano;
  
  public Member() {}

public Member(String uid, String pwd, String uname, String email, String tel,
		String fax, String det_addr, String phot, int ano) {
	super();
	this.uid = uid;
	this.pwd = pwd;
	this.uname = uname;
	this.email = email;
	this.tel = tel;
	this.fax = fax;
	this.det_addr = det_addr;
	this.phot = phot;
	this.ano = ano;
}

public String getUid() {
	return uid;
}

public void setUid(String uid) {
	this.uid = uid;
}

public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	this.pwd = pwd;
}

public String getUname() {
	return uname;
}

public void setUname(String uname) {
	this.uname = uname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}

public String getFax() {
	return fax;
}

public void setFax(String fax) {
	this.fax = fax;
}

public String getDet_addr() {
	return det_addr;
}

public void setDet_addr(String det_addr) {
	this.det_addr = det_addr;
}

public String getPhot() {
	return phot;
}

public void setPhot(String phot) {
	this.phot = phot;
}

public int getAno() {
	return ano;
}

public void setAno(int ano) {
	this.ano = ano;
}
  
  
}













