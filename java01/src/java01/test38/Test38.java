package java01.test38;

import java.util.Scanner;

public class Test38 {
  static Scanner scan = new Scanner(System.in);
  static String name;
  static int kor;
  static int eng;
  static int math;
  
  public static void output(){
    System.out.println("입력하세요");
    
    System.out.print("이름:");
    name = scan.nextLine();
    
    System.out.print("국어:");
    kor = Integer.parseInt(scan.nextLine());
    
    System.out.print("영어:");
    eng = Integer.parseInt(scan.nextLine());
    
    System.out.print("수학:");
    math = Integer.parseInt(scan.nextLine());
  }
  

  public static void main(String[] args) {
    // TODO Auto-generated method stub


    Scores s = new Scores();
    output();
    
    
   

    
  }

}
 