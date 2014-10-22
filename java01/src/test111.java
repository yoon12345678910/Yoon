import java.util.Scanner;


class phoneInfo{
  String name;
  String phoneNumber;
  String birthday;

  phoneInfo(String name, String phoneNumber){
    this.name = name;
    this.phoneNumber = phoneNumber;
  
  }

  phoneInfo(String name, String phoneNumber, String birthday){
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.birthday = birthday;
    }
    
    void print(){
      System.out.println("이름:" + name);
      System.out.println("전화번호:" + phoneNumber);
      if(birthday!=null)
      System.out.println("생년월일:" + birthday);
    }
}

public class test111 {
  static Scanner s = new Scanner(System.in);
  
 static void input(){
    System.out.println("선택하세요");
    System.out.println("1.데이터 입력");
    System.out.println("2.프로그램 종료");
    System.out.print("선택:");
  }
  
 static void read(){
    

    System.out.print("name:");
    String name = s.nextLine();
    
    System.out.print("phone:");
    String phoneNumber = s.nextLine();
    
    System.out.print("birthday:");
    String birthday = s.nextLine();

    
      phoneInfo p1 = new phoneInfo(name, phoneNumber, birthday);
      p1.print();
    
   
   
      
  }
  
  
  public static void main(String[] args) {

    
    
   int count; 
   while(true){
     input();
  count = Integer.parseInt(s.nextLine());   
     s.nextLine();
     
  switch(count){
   case 1: read(); break;
   case 2: System.out.println("종료합니다."); return;
   }
   }
   
    
  }

}
