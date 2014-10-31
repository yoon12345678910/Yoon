/*
  명령어를 처리하는 Command 객체를 자동 생성하여
  commandMap 에 등록하기
  1) application-context.properties 파일에 명령어 처리 클래스 정보를 둔다.
  2) 이 프로퍼티 파일을 읽고 클래스를 로딩하여 인스턴스를 생성한다.
  3) 생성한 인스턴스를 commandMap에 등록한다.


*/
package java02.test06;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Test01 {
  static Scanner scanner;
  static ScoreDao scoreDao;
//명령어를 처리할 객체를 담아둔 맵
  static HashMap<String, Command> commandMap;
                                
  public  void  init() throws Exception{
    commandMap = new HashMap<String, Command>();
    
    Properties props = new Properties();
    props.load(new FileReader("application-context.properties"));
    Set keySet = props.keySet();
    
    String classname = null;
    Class clazz = null;
    Command command = null;
    
    for(Object key : keySet){
      classname = (String) props.get(key);
      //System.out.println(classname);
      clazz = Class.forName(classname.trim());
      command = (Command) clazz.newInstance();
      commandMap.put((String) key, command);
    }

    scoreDao = new ScoreDao();
    
    try {
      scoreDao.load();
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류가 발생하였습니다.");
    }

    scanner = new Scanner(System.in);
  }
  
  
  public  void service(){
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
  }
  
  public  void destroy(){
    scanner.close();
  }
  
  private  String[] promptCommand() {
    System.out.print("명령>");
    String[] token = scanner.nextLine().split(" ");
    return token;
  }
  
  public static void main(String[] args) throws Exception {
    Test01 app = new Test01();
    app.init();
    app.service();
    app.destroy();
  }
}
