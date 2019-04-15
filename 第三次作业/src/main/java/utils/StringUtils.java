package utils;

public class StringUtils {


    public static boolean isEmpty(String param) {
        
        if (param != null || "".equals(param.trim())) {

            return false;
        }else{
            
            return true;
        }
    }


}
