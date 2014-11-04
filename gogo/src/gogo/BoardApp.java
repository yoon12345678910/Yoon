package gogo;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {
  static ArrayList<Board> list = new ArrayList<Board>();
  static Scanner scanner;
  static Board board;

  public static void main(String[] args) throws Exception {

    board = new Board();
    scanner = new Scanner(System.in);

    loop: while (true) {
      String[] token = prompt();

      switch (token[0]) {
      case "add":
        doAdd();
        break;

      case "list":
        doList();
        break;

      case "view":
        System.out.println("상세보기");
        break;

      case "delete":
        System.out.println("삭제");
        break;

      case "update":
        System.out.println("업데이트");
        break;

      case "exit":
        System.out.println("종료");
        break loop;

      }
    }
  }

  private static String[] prompt() {
    System.out.print(">");
    String[] temp = scanner.nextLine().split(" ");
    return temp;
  }

  private static void doAdd() throws CloneNotSupportedException  {
    Board tempBoard = board.clone();
    String temp;

      System.out.print("제목:" );
      temp = scanner.nextLine();
      tempBoard.setTitle(temp);

      System.out.print("내용:" );
      while(true){
        temp.concat(scanner.nextLine());
        System.out.println(temp);
        if(temp.equals("")){
          break;
        }
      }
        tempBoard.setContent(temp);
     

      System.out.print("비밀번호:" );
      temp = scanner.nextLine();
      tempBoard.setPassword(temp);

      
      
  
    

    System.out.println("저장 완료");
  }

  private static void doList() {
    for (int i = 0; i < list.size(); i++) {
      System.out.printf("%d %s %s", i, list.get(i).getTitle(), list.get(i)
          .getDate());
    }
  }

}
