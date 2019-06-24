package utils.factory;

import dao.BaseDAO;
import service.BaseService;

public abstract class AbstractFactory {





    public abstract BaseService getService(String service);


    public abstract BaseDAO getDao(String dao);
}
