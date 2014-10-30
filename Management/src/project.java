import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Student implements Serializable {

  private static final long serialVersionUID = 1L;
  String name;
  String kor;
  String eng;
  String math;
  int sum;
  float average;

  Student(String name, String kor, String eng, String math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = Integer.parseInt(kor) + Integer.parseInt(eng)
        + Integer.parseInt(math);
    this.average = sum / 3.0f;
  }
}

class StudentManager {
  private final File datafile = new File("Score.dat");
  ArrayList<Student> infoStorage = new ArrayList<Student>();
  static StudentManager inst = null;

  public static StudentManager createManagerInst() {
    if (inst == null)
      inst = new StudentManager();
    return inst;
  }

  private StudentManager() {
    readFromFile();
  }

  public void inputData(String name, String kor, String eng, String math) {
    infoStorage.add(new Student(name, kor, eng, math));
    System.out.println("저장되었습니다.");
  }

  public void viewInfo(String index) {
    System.out.println("인덱스: " + Integer.parseInt(index));
    System.out.println("이름: " + infoStorage.get(Integer.parseInt(index)).name);
    System.out.println("국어: " + infoStorage.get(Integer.parseInt(index)).kor);
    System.out.println("영어: " + infoStorage.get(Integer.parseInt(index)).eng);
    System.out.println("수학: " + infoStorage.get(Integer.parseInt(index)).math);
    System.out.println("총점: " + infoStorage.get(Integer.parseInt(index)).sum);
    System.out.println("평균: "
        + infoStorage.get(Integer.parseInt(index)).average);
  }

  public void listInfo() {
    if (infoStorage.size() < 1) {
      System.out.println("저장된 데이터가 없습니다.");
    } else {
      for (int i = 0; i < infoStorage.size(); i++) {
        System.out.print(i);
        System.out.print(" " + infoStorage.get(i).name);
        System.out.print(" " + infoStorage.get(i).kor);
        System.out.print(" " + infoStorage.get(i).eng);
        System.out.println(" " + infoStorage.get(i).math);
      }
    }
  }

  public void Delete(String index) {
    if (Integer.parseInt(index) >= 0
        && Integer.parseInt(index) < infoStorage.size()) {
      System.out.print(infoStorage.get(Integer.parseInt(index)).name
          + "의 성적을 삭제하시겠습니까?(y/n)");
      String dicision = MenuViewer.keyboard.nextLine();
      if (dicision.equals("y") || dicision.equals("Y")) {
        infoStorage.remove(Integer.parseInt(index));
        System.out.println("삭제하였습니다.");
      } else if (dicision.equals("n") || dicision.equals("N")) {
        System.out.println("삭제 취소하였습니다.");
      }
    } else
      System.out.println("존재하지 않는 인덱스입니다.");
  }

  public void update(String index) {
    String name = null;
    String kor = null;
    String eng = null;
    String math = null;
    int no = Integer.parseInt(index);
    System.out.print("이름 :" + "(" + infoStorage.get(no).name + ")");
    String input = MenuViewer.keyboard.nextLine();
    if (input.equals(""))
      name = infoStorage.get(no).name;
    else
      name = input;
    System.out.print("국어 :" + "(" + infoStorage.get(no).kor + ")");
    input = MenuViewer.keyboard.nextLine();
    if (input.equals(""))
      kor = infoStorage.get(no).kor;
    else
      kor = input;
    System.out.print("영어 :" + "(" + infoStorage.get(no).eng + ")");
    input = MenuViewer.keyboard.nextLine();
    if (input.equals(""))
      eng = infoStorage.get(no).eng;
    else
      eng = input;
    System.out.print("수학 :" + "(" + infoStorage.get(no).math + ")");
    input = MenuViewer.keyboard.nextLine();
    if (input.equals(""))
      math = infoStorage.get(no).math;
    else
      math = input;
    System.out.print("정말 변경하시겠습니까?(y/n)");
    input = MenuViewer.keyboard.nextLine();
    if (input.equals("y") || input.equals("Y")) {
      System.out.println("변경하였습니다.");
      infoStorage.set(no, new Student(name, kor, eng, math));
    } else if (input.equals("n") || input.equals("N")) {
      System.out.println("변경을 취소하였습니다.");
    }
  }

  public void storeToFile() {
    try {
      FileOutputStream file = new FileOutputStream(datafile);
      ObjectOutputStream out = new ObjectOutputStream(file);
      Iterator<Student> itr = infoStorage.iterator();
      while (itr.hasNext())
        out.writeObject(itr.next());
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void readFromFile() {
    try {
      FileInputStream file = new FileInputStream(datafile);
      ObjectInputStream in = new ObjectInputStream(file);
      while (true) {
        Student info = (Student) in.readObject();
        if (info == null)
          break;
        infoStorage.add(info);
      }
      in.close();
    } catch (IOException e) {
      return;
    } catch (ClassNotFoundException e) {
      return;
    }
  }
}

class MenuViewer {
  public static Scanner keyboard = new Scanner(System.in);

  public static void showMenu() {
    System.out.println("list");
    System.out.println("view 인덱스");
    System.out.println("add 이름 국어 영어 수학");
    System.out.println("delete 인덱스");
    System.out.println("update 인덱스");
    System.out.println("exit");
  }
}

public class project {
  public static void main(String[] args) {
    StudentManager manager = StudentManager.createManagerInst();
    while (true) {
      System.out.print("명령>");
      String input = MenuViewer.keyboard.nextLine();
      String arr[] = input.split(" ");
      switch (arr[0]) {
      case "help":
        MenuViewer.showMenu();
        break;
      case "list":
        manager.listInfo();
        break;
      case "view":
        manager.viewInfo(arr[1]);
        break;
      case "add":
        manager.inputData(arr[1], arr[2], arr[3], arr[4]);
        break;
      case "delete":
        manager.Delete(arr[1]);
        break;
      case "update":
        manager.update(arr[1]);
        break;
      case "exit":
        manager.storeToFile();
        return;
      default:
        System.out.println("잘못된 명령어입니다.");
        break;
      }
    }
  }
}