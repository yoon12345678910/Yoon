//(UI)Boundary , control

//명령을 처리하는 메서드를 별도의 클래스 분리 =>Command 패턴
//-새로운 명령어를 추가하더라도 기존 코드를 손대지 않고
//명령을 처리할 수 있게 하자.
//명령어를 처리하는 메서드를 클래스로 만든다.
//클래스는 외부 파일이기 때문에 추가하기 쉽다.
package java02.Refactoring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java02.Refactoring.commands.AddCommand;
import java02.Refactoring.commands.DeleteCommand;
import java02.Refactoring.commands.ExitCommand;
import java02.Refactoring.commands.HelpCommand;
import java02.Refactoring.commands.ListCommand;
import java02.Refactoring.commands.TestCommand;
import java02.Refactoring.commands.UpdateCommand;
import java02.Refactoring.commands.ViewCommand;

public class Test01 {
  static Scanner scanner;
  static ScoreDao scoreDao;

  public static void main(String[] args) {
    // 명령어를 처리할 객체를 담아둔 맵
    HashMap<String, Command> commandMap = new HashMap<String, Command>();

    commandMap.put("list", new ListCommand());
    commandMap.put("add", new AddCommand());
    commandMap.put("view", new ViewCommand());
    commandMap.put("delete", new DeleteCommand());
    commandMap.put("update", new UpdateCommand());
    commandMap.put("exit", new ExitCommand());
    commandMap.put("help", new HelpCommand());
    commandMap.put("test", new TestCommand());
    scoreDao = new ScoreDao();

    try {
      scoreDao.load();
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류가 발생하였습니다.");
    }

    scanner = new Scanner(System.in);
    // 인터페이스참조변수란? 인터페이스를 구현한 규칙에 따라서 만든 객체라면 주소를 저장할 수 있다.
    Command command = null;//초기값 null.. 리턴값없으면 null

    loop: while (true) {
      try {
        String[] token = promptCommand(); // 명령>add 홍길동 100 100 100
        command = commandMap.get(token[0]); //AddCommand

        if (command == null) {
          System.out.println("해당 명령을 지원하지 않습니다.");
          continue;//다시 위로~
        }

        // Command 객체에게 넘겨줄 바구니 준비
        // 해당 바구니에 Command 객체가 사용할 도구를 넣어 준다.
        HashMap<String, Object> params = new HashMap<String, Object>();
        
        
        //직관성을 위해 이름과 같게 이름 주고 객체 넣음
        params.put("scoreDao", scoreDao);
        params.put("scanner", scanner);
        
        
        //명령어 다음에 오는 파라미터 값을 ArrayList에 담는다.
        //예) add 홍길동 100 20 90
        //즉, 위의 예에서 "홍길동", "100", "20", "90"을
        //ArrayList에 담는다.
        ArrayList<String> options = new ArrayList<String>();
        for(int i = 1; i < token.length ; i++){
          options.add(token[i]);
        }
        //여기
        params.put("options", options);

        command.service(params);

        if (token[0].equals("exit"))
          break loop;

      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("명령어 처리 중 오류 발생. 다시 시도해 주세요.");
      }
    }
    scanner.close();
  }

  private static String[] promptCommand() {
    System.out.print("명령>");
    String[] token = scanner.nextLine().split(" ");
    return token;
  }
}
