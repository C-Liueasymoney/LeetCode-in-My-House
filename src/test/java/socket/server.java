package socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/28 3:01 下午
 */
public class server extends Thread{
    private ServerSocket serverSocket;

    public server(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(1000000);
    }

    public void run()
    {
        while(true)
        {
            try
            {
                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");
//                server.close();
            }catch(SocketTimeoutException s)
            {
                System.out.println("Socket timed out!");
                break;
            }catch(IOException e)
            {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入端口号");
        Scanner in = new Scanner(System.in);
        int port = in.nextInt();
        try
        {
            Thread t = new server(port);
            t.run();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
