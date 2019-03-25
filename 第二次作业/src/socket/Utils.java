package socket;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;

public class Utils {


    private static String PATH = "src//config.properties";


    /**
     * 根据反射动态生成类，并调用相应方法
     *
     * @param path
     * @return
     */
    public static Optional<String> getContent(String path) {

        String[] params = path.split("/");

        Optional<String> content = Optional.empty();

        try {

            //利用反射动态加载类
            Class newClass = Class.forName("socket." + params[0]);

            Object obj = newClass.newInstance();

            //根据方法名调用相应方法
            content = Arrays.asList(newClass.getMethods())
                    .stream()
                    .filter(v -> params[1].equals(v.getName()))
                    .map(
                            v1 -> {

                                String contents = null;
                                try {
                                    contents = (String) v1.invoke(obj);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                }

                                return contents;
                            }
                    )
                    .findAny();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return content;

    }


    /**
     * 用于获取在配置文件中的相对路径，若存在,返回;不存在,返回404
     *
     * @param path 资源路径
     */

    public static String getResource(String path) throws IOException {

        return Optional.ofNullable(getProperties(path))
                .orElse("unKnown");

    }


    /**
     * 从配置文件中获取对应的路径
     *
     * @param path
     * @return
     */

    public static String getProperties(String path) throws IOException {

        Properties properties = new Properties();

        FileInputStream fis = new FileInputStream(PATH);

        properties.load(fis);

        return (String) properties.get(path);
    }


    /**
     * 用于返回404界面
     *
     * @return
     */
    public static StringBuffer getNotFound() {


        String fileName = "//404.html";

        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;

        StringBuffer sb =new StringBuffer();
        String data=null;
        try {
            fileInputStream = new FileInputStream("src" + fileName);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            while ((data = bufferedReader.readLine()) != null) {
                sb.append(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb;
    }

}
