package java01.test44;

public class Soldier extends Mover {

  int attack;
  int level;

  // Mover로부터 상속받은 move()메소드를
  // 서브 클래스의 역할에 맞게 재정의하는 것! = > 오버라이딩(Overriding)

  // 문법:재정의 하려는 클래스와 같은 시그너처(signature)를 갖는
  // 메소드를 만들어라

  // 단, 공개 범위는 축소되어서는 안된다.

  // ex) 부모는 public 인데 자식이 private 면 안됨!!!
  
   //파라미터 변수의 이름은 달라도 상관없다.
  
  // Signature란? 메소드의 이름과 리턴 타입, 파라미터 타입을 말함
  // c언어에서는 function prototype이라 부른다.

  // method signature, function signature
  
  
  //시그너쳐(파라미터값)이 달라 오버로딩됨..
  
  
  //애노테이션 
  
  //@Override //수퍼클래스의 메서드를 재정의 하는지 검사하라고 지시함.
  @Override
  public void move(int dir) {
    System.out.println("고고고고...;;;");
    
  }

}
