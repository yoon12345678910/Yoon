/* 
  조건문
  -명령어의 흐름을 조건에 따라 분기하는 것
  if (조건) ~else~
  if(조건){...}else{...}
 */

package net.java63;

public class Test16 {
  
  
  static void output(int age){
    System.out.println(age+"입니다.");
  }

  static  public void main(String[] abc) {

    int age = 20;
    if (age < 18) {
    
    } else if (age >= 20 && age < 40) {
      System.out.println("청년입니다.");
    } else if (age >= 40 && age < 50) {
      System.out.println("장년입니다.");
    } else if (age >= 50 && age < 65) {
      System.out.println("중년입니다.");
    } else {
      System.out.println("노인입니다.");
    }
  }
}
