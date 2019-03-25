package socket;

public class TestB {


    public String methodA(String s) {

        return get(s);
    }

    public String methodB() {

        return get("B类中的methodB方法");
    }

    private static String get(String msg){

        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Hello</title>\n" +
                "</head>\n" +
                "<body>\n" +msg+
                "        Class -----> B\n" +
                "</body>\n" +
                "</html>";

        return html;
    }

}
