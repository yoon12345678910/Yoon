package java02.test07;

import java.util.Map;

public interface Command {

  String getCommandInfo();
  
  void service(Map<String, Object> params) throws Exception;
}
