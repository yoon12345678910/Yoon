package java02.Refactoring.commands;

import java.util.ArrayList;
import java.util.Map;

import java02.Refactoring.Command;
import java02.Refactoring.Score;
import java02.Refactoring.ScoreDao;

public class AddCommand implements Command {

  @Override
  public String getCommandInfo() {
    return "add";
  }

  @Override
  public void service(Map<String, Object> params) 
      throws Exception {
    
    ScoreDao scoreDao = (ScoreDao) params.get("scoreDao");
    
    //내가 list에 option넣었다고 경고 하지 마라!
    @SuppressWarnings("unchecked")
    ArrayList<String> options = 
        (ArrayList<String>) params.get("options");
    //여기
    Score score = new Score(options.get(0), 
        Integer.parseInt(options.get(1)),
        Integer.parseInt(options.get(2)), 
        Integer.parseInt(options.get(3)));

    scoreDao.add(score);
    System.out.println("저장하였습니다.");
  }

}
