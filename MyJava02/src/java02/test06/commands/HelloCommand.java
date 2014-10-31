package java02.test06.commands;

import java.util.Map;

import java02.test06.Command;

public class HelloCommand implements Command {

  @Override
  public String getCommandInfo() {
    // TODO Auto-generated method stub
    return "hello";
  }

  @Override
  public void service(Map<String, Object> params) throws Exception {
    System.out.println("안녕하세요.");
  }

}
