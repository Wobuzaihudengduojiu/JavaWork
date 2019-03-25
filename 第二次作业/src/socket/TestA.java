package socket;


public class TestA {

    public String methodA(String s) {

        return get(s);
    }

    public String methodB() {

        return get("A类中的methodA方法");
    }

    private static String get(String msg){

        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Hello</title>\n" +
                "</head>\n" +
                "<body>\n" +msg+
                "        Class -----> A\n" +
                "</body>\n" +
                "</html>";

        return html;
    }
}
