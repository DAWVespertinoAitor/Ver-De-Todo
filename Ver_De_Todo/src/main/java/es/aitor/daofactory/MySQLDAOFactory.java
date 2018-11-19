package es.aitor.daofactory;


import es.aitor.dao.GenericoDAO;
import es.aitor.dao.IGenericoDAO;


public class MySQLDAOFactory extends DAOFactory{

    @Override
    public IGenericoDAO getGenericoDAO() {
        return new GenericoDAO();
    }

}
