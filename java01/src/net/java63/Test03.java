/* 
main(): JVM이 클래스를 실행할 때 호출하는 함수
     =>start entry

     자바 클래스 실행
     java -classpath [클래스 파일이 있는 경로] [클래스명]
     
     -만약 클래스가 특정 패키지에 소속된 멤버라면,
     java -classpath[패키지가 있는 경로][패키지명.클래스명]
     
     -classpath 대신 -cp라고 해도됨
     
     패키지명.클래스 = Fully Qualified Name(QName)
     
     
     
 */




package net.java63;

//하나의 소스 파일에는 public 클래스가 오직 하나만 올 수 있따.
public class Test03{
  public static void main(String[] args){
    System.out.println("하하하");
    
  }
}
