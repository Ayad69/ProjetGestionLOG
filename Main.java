package src;

import src.DAO.LogDAO;
import src.DTO.LogDTO;
import src.TEST.TestConnexion;
import src.TEST.TestLogDAO;

import java.io.BufferedReader;
import java.io.FileReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TestConnexion testConnexion = new TestConnexion();
        testConnexion.testCon();

TestLogDAO testLogDAO = new TestLogDAO();

 //testLogDAO.TestLogDAOSELECTTOUT();

       try{


            String file = "/C:/Users/ayadh/Desktop/GeoIPCountryWhoi.csv";
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
                String[] fields = line.split(",");
                LogDAO l = new LogDAO();
                String code = fields[4];
                String pays = fields[5];
                TestLogDAO dd = new TestLogDAO();
                dd.TestLogDAOCREATE(code,pays);
            }
            br.close();

        }catch (Exception e){
            System.out.println(e);
        }

        }
    }
