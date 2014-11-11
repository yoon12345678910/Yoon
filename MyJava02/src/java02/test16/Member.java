/*	Value Object
 * => Class 문법을 사용하여 사용자 정의 데이터 타입 만들기

	1)Serializable 인터페이스, 구현 데이터가 내부에 나가질때 그것을 허락하는 
	SerialVersionUID 스태틱 변수 선언
	
	2)인스턴스 변수 선언
	
	3) setter/getter 생성

	4)기본생성자와 파라미터 값을 받는 생성자 선언

	5)equals() / hashCode() 메서드 오버라이딩
	
	6)toString() 오버라이딩 
*/

package java02.test16;

import java.io.Serializable;

public class Member implements Serializable, Cloneable{
	private static final long serialVersionUID = 1L;

	protected String                 id;
	protected String                  pwd;
	protected String           name;
	protected String  		   email;
	protected String  		 		  tel;
	protected String               fax;
	protected String      det_addr;
	protected String             phot;
	protected int              ano;
	 
	public Member() {}

	public Member(String id, String pwd, String name, String email, String tel) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.tel = tel;
	}

	public Member(String id, String pwd, String name, String email, String tel,
			String fax) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.fax = fax;
	}

	public Member(String id, String pwd, String name, String email, String tel,
			String fax, String det_addr) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.fax = fax;
		this.det_addr = det_addr;
	}

	public Member(String id, String pwd, String name, String email, String tel,
			String fax, String det_addr, String phot) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.fax = fax;
		this.det_addr = det_addr;
		this.phot = phot;
	}

	public Member(String id, String pwd, String name, String email, String tel,
			String fax, String det_addr, String phot, int ano) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.fax = fax;
		this.det_addr = det_addr;
		this.phot = phot;
		this.ano = ano;
	}
	@Override
	public  Member clone() throws CloneNotSupportedException {
		return (Member) super.clone();
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
