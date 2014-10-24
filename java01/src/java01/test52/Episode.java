package java01.test52;

public class Episode {
  static int global;
  int value;
  
  static void m(){
    global = 20;
    
    //클래스 메소드는 this변수가 없다.
    //this.value = 20; //오류!
    //this.m2();//오류!
    
  }    
  
  void m2(){
  }
  
  public static void main(String[] args) {
    Episode p = new Episode();

    //static이 붙은 메소드(클래스 메소드)도 인스턴스 주소로 호출할 수 있다.
    //그러나, 클래스 메소드에는 this라는 내부 변수가 없기때문에
    //인스턴스 주소를 전달할 길이 없다.
    p.m();
    m(); //같은 클래스에 소속되어 있으면 클래스명 생략가능.
    Episode.m();
    
  }
    
  
}
