package es.aitor.daofactory;


import es.aitor.dao.IGenericoDAO;

public abstract class DAOFactory {

    

    public abstract IGenericoDAO getGenericoDAO();
    

    public static DAOFactory getDAOFactory() {
        DAOFactory daof = null;

        daof = new MySQLDAOFactory();

        return daof;
    }

}
