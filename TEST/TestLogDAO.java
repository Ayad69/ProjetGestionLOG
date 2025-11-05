package src.TEST;

import com.mysql.cj.log.Log;
import src.DAO.LogDAO;
import src.DTO.LogDTO;

public class TestLogDAO {

    public void TestLogDAOCREATE(String code,String pays) {
        LogDAO logDAO = new LogDAO();
        LogDTO log = new LogDTO(code,pays);
        logDAO.create(log);
    }

    public void TestLogDAODELETE(String code) {
        LogDAO logDAO = new LogDAO();
        LogDTO log = new LogDTO(code,null);
        logDAO.delete(log);
    }

    public void TestLogDAOUPDATE(String code) {
        LogDAO logDAO = new LogDAO();
        LogDTO log = new LogDTO(code,null);
        logDAO.update(log);
    }

  public  void TestLogDAOSELECTTOUT() {
        LogDAO logDAO = new LogDAO();
        logDAO.findAll();
  }
    public void TestLogDAOSELECT(String code) {
        LogDAO logDAO = new LogDAO();
        logDAO.find(code);
    }

}
