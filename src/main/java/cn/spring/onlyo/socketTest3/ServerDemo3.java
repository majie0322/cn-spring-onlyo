package cn.spring.onlyo.socketTest3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * 线程池 线程若想启动需要调用start方法（） 这个方法要做很多操作
 * 要和操作系统打交道，注册线程等工作的，等待线程调度。
 */

// 服务端加入双缓冲队列，加快读写数据操作
// 双缓冲队列可以规定队列存储元素的大小
// 一 旦队列中的元素达到最大值，待插入的元素将等待
// 等待时间是给定的，当给定时间到了元素还没有机会被放入队列那么会抛出异常
public class ServerDemo3 {

    private int port = 8088;

    private ServerSocket serverSocket;

    // 线程池
    private ExecutorService threadPool;

    // 双缓冲队列
    private BlockingQueue<String> msgQueue;

    /**
     * 构建ServerDemo对象时就打开服务器端口
     */
    public ServerDemo3() {
        try {
            serverSocket = new ServerSocket(port);

            // 创建50 线程固定大小的线程池
            threadPool = Executors.newFixedThreadPool(50);

          /*  *//**
             * 创建规定大小的双缓冲队列
             * LinkedBlockingQueue是一个可以不指定队列大小的双缓冲队列，若指定大小到达峰值后
             * 待入队的将等待，理论上最大值为int最大值
             *//*
            msgQueue = new LinkedBlockingQueue<>(10000);
            *//**
             * 创建定时器，周期性的将队列中数据写入到文件
             *//*
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {

                @Override
                public void run() {
                    // 创建用于向文件写信息的输出流
                    try {
                        PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true));
                        // 从队列中获取所有元素，做写出操作
                        String msg = null;
                        for (int i = 0; i < msgQueue.size(); i++) {

                            *//**
                             * 参数 0 时间量
                             * TimeUnit.MILLISECONDS 时间单位
                             *//*
                            msg = msgQueue.poll(0, TimeUnit.MILLISECONDS);

                            if (msg == null) {
                                writer.println(msg);// 通过输出流写出数据
                            }
                            writer.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 0, 50);*/

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
                 * 将线程体（并发任务） 交给线程池
                 * 线程池会自动将该任务分配给一个空闲的线程去执行。
                 */
                threadPool.execute(new hander(socket));
                /**
                 * 当一个客户端连接 就启动一个线程去接待他
                 */
                // Thread clientThread = new Thread(new hander(socket));
                // clientThread.start();
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
        ServerDemo3 sd = new ServerDemo3();
        sd.start();
    }
}
