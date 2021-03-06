package java02.test07.commands;

import java.util.ArrayList;
import java.util.Map;
import java02.test07.Command;
import java02.test07.Score;
import java02.test07.ScoreDao;
import java02.test07.annotation.Component;

@Component("add")
public class AddCommand implements Command {

  ScoreDao scoreDao;
  
  public void setScoreDao(ScoreDao scoreDao) {
    this.scoreDao = scoreDao;
  }
  
  @Override
  public String getCommandInfo() {
    return "add";
  }

  @Override
  public void service(Map<String, Object> params) 
      throws Exception {
    
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
