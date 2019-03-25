package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;

/**
  *@Author:gyx
  *@Description:
  */

public class Server {

    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {

            try {

                Socket socket = serverSocket.accept();

                new Thread(
                        () -> {
                            BufferedReader br = null;
                            try {

                                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                                //获取请求路径
                                String[] lines = br.readLine().split(" ");

                                OutputStream outputStream = socket.getOutputStream();

                                //获取在配置文件中的相对路径
                                String respondingPath = Utils.getResource(lines[1]);

                                //设置状态行
                                StringBuilder sb = new StringBuilder("HTTP/1.1 200 OK\n\r");
                                sb.append("Content-Type:text/html\n\n");

                                //根据路径返回相应的页面,若不存在，即返回404
                                if ("unKnown".equals(respondingPath)) {

                                    sb.append(Utils.getNotFound());
                                } else {

                                    Optional<String> content = Utils.getContent(respondingPath);
                                    content.ifPresent(sb::append);
                                }

                                outputStream.write(sb.toString().getBytes());

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                ).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
