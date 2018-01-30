package cn.spring.onlyo.socketTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

    private int port = 8088;

    private ServerSocket serverSocket;

    /**
     * 构建ServerDemo对象时就打开服务器端口
     */
    public ServerDemo() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 开启服务
     * 等待接收客户端的请求并与其通信
     */
    public void start() {
        System.out.println("等待客户端连接。。。。。。。。");
        try {
            /**
             * 使服务器开始等待 接收客户端连接 该方法是一个阻塞方法 直到客户端与其连接 否则该方法不会结束
             */
            Socket socket = serverSocket.accept();

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            PrintWriter wirter = new PrintWriter(out);
            /*
             * wirter.println("你好服务器");
             * wirter.flush();
             */

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String info = reader.readLine();
            System.out.println(info);

            // 发送 信息给客户端
            wirter.println("你好客户端");
            wirter.flush();

            info = reader.readLine();
            System.out.println(info);

            wirter.println("再见客户端");
            wirter.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("服务器启动中");
        ServerDemo sd = new ServerDemo();
        sd.start();
    }
}
