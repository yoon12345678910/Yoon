import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class Student implements Serializable{
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float average;
  
  Student(String name, int kor, int eng, int math){
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math= math;
  
    this.sum = kor + eng + math;
    this.average = sum / 3.0f;
  }
  
  public int hashCode(){
    return name.hashCode();
  }
  
  public boolean equals(Object obj){
    Student st = (Student) obj;
   if(name.compareTo(st.name)==0)
     return true;
     else
     return false;
  }
}

class StudentManager{
  
  private final File dataFile = new File("Score.dat");
  HashSet<Student> infoStorage = new HashSet<Student>();
  
  static StudentManager inst = null;
  public static StudentManager createManagerInst(){
    if(inst == null)
      inst = new StudentManager();
    return inst;
  }
  
  private StudentManager(){
    readFromFile();
  }
  
  private Student readStudentInfo(){
    System.out.println("이름 : ");
    String name = MenuViewer.keyboard.nextLine();
    System.out.println("국어 : ");
    int kor = Integer.parseInt(MenuViewer.keyboard.nextLine());
    System.out.println("영어 : ");
    int eng = Integer.parseInt(MenuViewer.keyboard.nextLine());
    System.out.println("수학 : ");
    int math = Integer.parseInt(MenuViewer.keyboard.nextLine());

    return new Student(name, kor, eng, math);
  }
  
  public void inputData(){
    System.out.println("데이터 입력을 시작하세요");
    
    Student info = null;
    
    info = readStudentInfo();
    
    boolean isAdded  = infoStorage.add(info);
    if(isAdded == true){
      System.out.println("데이터 입력이 완료되었습니다.\n");
    }else
        System.out.println("이미 저장된 데이터 입니다..\n");
    }
  
    
    public void storeToFile(){
      
      
      try{
        FileOutputStream file = new FileOutputStream(dataFile);
        ObjectOutputStream out = new ObjectOutputStream(file);
        
       Iterator<Student> itr = infoStorage.iterator();
       while(itr.hasNext())
       out.writeObject(itr.next());
       out.close();
      }
      catch(IOException e)
      {
        e.printStackTrace();
      }
    }
    
    public void readFromFile(){
      if(dataFile.exists() == false)
        return;
    
      try{
        FileInputStream file = new FileInputStream(dataFile);
        ObjectInputStream in = new ObjectInputStream(file);
        
        while(true){
          Student info = (Student)in.readObject();
          if(info == null)
            break;
          infoStorage.add(info);
        }
      in.close();
      }
      catch(IOException e){
        return;
      }
      
      catch(ClassNotFoundException e){
        return;
      }
    }
}


class MenuViewer{
  
  public static Scanner keyboard = new Scanner(System.in);
  
  public static void showMenu(){
    System.out.println("1.list");
    System.out.println("2.view");
    System.out.println("3.add ");
    System.out.println("5.update");
    System.out.println("6.exit");
    System.out.print("선택 : ");
      }
}


public class project {

  public static void main(String[] args) {
    
    StudentManager manager = StudentManager.createManagerInst();
    int choice;
    
    MenuViewer.showMenu();

    choice = Integer.parseInt(MenuViewer.keyboard.nextLine());
    
    switch(choice){
    case 1 : 
      manager.inputData();
      manager.storeToFile();
      break;
    }
  }

}
