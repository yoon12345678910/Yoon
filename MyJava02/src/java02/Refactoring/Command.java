package java02.Refactoring;

import java.util.Map;

public interface Command {

  String getCommandInfo();
  
  void service(Map<String, Object> params) throws Exception;
  
  
}
