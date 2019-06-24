package utils;

import dao.BaseDAO;
import service.BaseService;
import utils.factory.AbstractFactory;

public  class DaoFactory extends AbstractFactory {


    public static final String USER_DAO_CLASS_PATH= "dao.impl.instance.UserDAOImpl";

    public static final String AUTION_TYPE_DAO_CLASS_PATH="dao.impl.instance.AutionTypeDAOImpl";

    public static final String  AUTION_INFO_DAO_CLASS_PATH="dao.impl.instance.AutionInfoDAOImpl";

    public static final String SHOPCART_DAO_CLASS_PATH="dao.impl.instance.ShopCartDAOImpl";





    @Override
    public BaseDAO getDao(String className) {


            if (className!=null &&!"".equals(className)){

                try {

                    Class<? extends BaseDAO> clazz=(Class<? extends BaseDAO>)Class.forName(className);
                    return clazz.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }

            return null;

        }

    @Override
    public BaseService getService(String service) {
        return null;
    }
}
