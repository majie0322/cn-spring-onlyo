package cn.spring.onlyo.socketTest3;

import java.io.*;
import java.net.Socket;

/**
 * mina框架 开源的socket框架 很多游戏服务器的通信架构全用它
 * 客户端
 */
public class ClientDemo3 {

    private Socket socket;

    /**
     * 建立连接并向服务器发送信息
     * 步骤：
     * 1：通过服务器的地址及端口与服务器连接
     * 创建socket时需要以上两个数据
     * 2：连接成功后可以通过socket获取输入输出流使用输入流接收服务端发送过来的信息
     * 使用输出流将信息发送给服务器
     * 3 关闭连接
     */
    public void send() {

        System.out.println("开始连接服务器");
        try {
            /**
             * 1 连接服务器
             * 一旦socket被实例化 那么他就开始通过给定的地址和端口去尝试与服务器进行连接
             * 我们自身的端口是系统分配 无需知道
             */
            socket = new Socket("localhost", 8088);

            /**
             * 和服务器通信
             * 使用socket获取输入和输出流
             */
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            /**
             * 将输出流变成处理字符串的缓冲字符输出流
             */
            PrintWriter wirter = new PrintWriter(out);
            wirter.println("你好服务器");
            wirter.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            /**
             * 读取服务器过来消息
             */
            String info = reader.readLine();
            System.err.println(info);

            wirter.println("再见！ 服务器！！");
            wirter.flush();

            info = reader.readLine();
            System.out.println(info);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClientDemo3 cd = new ClientDemo3();
        cd.send();// 连接服务器 并通信
    }

}
