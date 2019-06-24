package socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static final int PORT = 8888;

    public static void main(String[] args) {

        Socket socket = null;
        ServerSocket serverSocket = null;
        BufferedReader br = null;
        try {

            serverSocket = new ServerSocket(PORT);

            socket = serverSocket.accept();

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //获取请求路径
            String[] lines = br.readLine().split(" ");

            OutputStream outputStream = socket.getOutputStream();
            getResource(outputStream, lines[1]);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (br != null) {
                    br.close();
                }

                if (socket != null) {
                    socket.close();
                }

                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 用于获取响应信息
     *
     * @param outputStream 输出流
     * @param path 资源路径
     */

    private static void getResource(OutputStream outputStream, String path) {

        //设置状态行
        StringBuilder sb = new StringBuilder("HTTP/1.1 200 OK\n\r");

        if (path.contains("/")) {
            sb.append("Content-Type:text/html\n\n");
            String fileName = "//index.html";
            //如果是根目录
            if (!path.contains("/")) {
                fileName = fileName.replaceAll("/", "//");
            }
            FileInputStream fileInputStream = null;

            try {
                fileInputStream = new FileInputStream("src" + fileName);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

                String data = "";
                while ((data = bufferedReader.readLine()) != null) {
                    sb.append(data);
                }

                outputStream.write(sb.toString().getBytes());
                outputStream.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
