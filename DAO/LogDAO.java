package src.DAO;

import src.DTO.LogDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LogDAO extends DAO<LogDTO>{

    @Override
    public boolean create(LogDTO obj) {
        String sql = "INSERT INTO log (codePays, pays) VALUES (?, ?)";

        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, obj.getCodePays());
            pstmt.setString(2, obj.getPays());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Log ajoutee avec succes !");
                return true;
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l’ajout de la categorie : " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(LogDTO obj) {
        String sql = "DELETE FROM log WHERE codePays = ?";

        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, obj.getCodePays());
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("🗑 Log supprimee avec succes !");
                return true;
            }

        } catch (SQLException e) {
            System.err.println(" Erreur lors de la suppression du log : " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }
    @Override
    public boolean update(LogDTO obj) {
        String sql = "UPDATE log SET pays = ? WHERE codePays = ?";

        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, obj.getPays());
            pstmt.setString(2, obj.getCodePays());
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println(" Pays de log mise a jour avec succes !");
                return true;
            }

        } catch (SQLException e) {
            System.err.println(" Erreur lors de la mise a jour du log : " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }


    @Override
public LogDTO find(String co) {
    LogDTO log = null;
    String sql = "SELECT * FROM log WHERE codePays = ?";

    try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
        pstmt.setString(1, co);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String c = rs.getString("codePays");
            String p = rs.getString("pays");

            log = new LogDTO(c,p);
        }

        rs.close();
    } catch (SQLException e) {
        System.err.println("Erreur lors de la récupération de la log : " + e.getMessage());
        e.printStackTrace();
    }

    return log;
    }

    @Override
    public ArrayList<LogDTO> findAll() {
        ArrayList<LogDTO> logs = new ArrayList<>();
        String sql = "SELECT * FROM log";

        try (Statement stmt = connect.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String c = rs.getString("codePays");
                String p = rs.getString("pays");

                LogDTO log = new LogDTO(c, p);
                logs.add(log);
            }
            for(LogDTO log : logs) {
                System.out.println(log);
            }
            System.out.println(" " + logs.size() + " log(s) recuperee(s)");

        } catch (SQLException e) {
            System.err.println(" Erreur lors de la recuperation des logs : " + e.getMessage());
            e.printStackTrace();
        }

        return logs;
    }
    }

