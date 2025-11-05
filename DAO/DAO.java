package src.DAO;

import src.DTO.LogDTO;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class DAO<T> {
    protected Connection connect = DataBase.getInstance();
    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    public abstract boolean create(T obj);
    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    public abstract boolean delete(T obj);
    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    public abstract boolean update(T obj);
    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */


    public abstract LogDTO find(String co);

    /**
     * Méthode de recherche des informations
     * @param aucun
     * @return un arrauliste de T
     */
    public abstract ArrayList<T> findAll();
}
