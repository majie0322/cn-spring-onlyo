package cn.spring.onlyo.socketTest2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 线程池 线程若想启动需要调用start方法（） 这个方法要做很多操作
 * 要和操作系统打交道，注册线程等工作的，等待线程调度。
 */
public class ServerDemo2 {

    private int port = 8088;

    private ServerSocket serverSocket;

    /**
     * 构建ServerDemo对象时就打开服务器端口
     */
    public ServerDemo2() {
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

        try {
            /**
             * 使服务器开始等待 接收客户端连接
             * 该方法是一个阻塞方法
             * 直到客户端与其连接 否则该方法不会结束
             */
            while (true) {
                System.out.println("等待客户端连接。。。。。。。。");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端连接了，分配线程去接待他   ");
                /**
                 * 当一个客户端连接 就启动一个线程去接待他
                 */
                Thread clientThread = new Thread(new hander(socket));
                clientThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 定义线程体 该线程的作用是与连接到服务器端的客户端进行交互操作
     */
    class hander implements Runnable {

        private Socket socket;

        private hander(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream in = null;
            try {
                in = socket.getInputStream();

                OutputStream out = socket.getOutputStream();

                PrintWriter wirter = new PrintWriter(out);
                /*
                 * wirter.println("你好服务器");
                 * wirter.flush();
                 */

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String info = reader.readLine();// 会阻塞
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
    }

    public static void main(String[] args) {

        System.out.println("服务器启动中");
        ServerDemo2 sd = new ServerDemo2();
        sd.start();
    }
}
