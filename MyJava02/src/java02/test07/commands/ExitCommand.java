package java02.test07.commands;

import java.util.Map;

import java02.test07.Command;
import java02.test07.ScoreDao;
import java02.test07.annotation.Component;
@Component("exit")
public class ExitCommand implements Command {

  ScoreDao scoreDao;
  
  public void setScoreDao(ScoreDao scoreDao) {
    this.scoreDao = scoreDao;
  }
  
  @Override
  public String getCommandInfo() {
    return "exit";
  }

  @Override
  public void service(Map<String, Object> params) throws Exception {
    try {
      scoreDao.save();
    } catch (Exception e) {
      System.out.println("데이터 저장 중 오류가 발생했습니다.");
    }
  }

}
