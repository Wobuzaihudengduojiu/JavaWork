package utils;

import dao.BaseDAO;
import service.BaseService;
import utils.factory.AbstractFactory;

public class ServiceFactory extends AbstractFactory {


    public static final String USER_SERVICE_CLASS_PATH = "service.impl.UserServiceImpl";


    public static final String AUTION_INFO_SERVICE_CLASS_PATH="service.impl.AutionServiceImpl";


    public static final String SHOPCART_SERVICE_CLASS_PATH="service.impl.ShopCartServiceImpl";




    @Override
    public BaseService getService(String service) {


        if (service != null && !"".equals(service)) {

            try {

                Class<? extends BaseService> clazz = (Class<? extends BaseService>) Class.forName(service);
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
    public BaseDAO getDao(String dao) {
        return null;
    }
}
