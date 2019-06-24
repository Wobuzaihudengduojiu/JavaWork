package utils.factory;

import utils.factory.AbstractFactory;

public class FactoryProducer {


    public static final String DAO_FACTORY = "utils.DaoFactory";
    public static final String SERVICE_FACTORY = "utils.ServiceFactory";


    public static AbstractFactory getFactory(String path) {


        if (path != null && !"".equals(path)) {

            try {

                Class<? extends AbstractFactory> clazz = (Class<? extends AbstractFactory>) Class.forName(path);
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


}
