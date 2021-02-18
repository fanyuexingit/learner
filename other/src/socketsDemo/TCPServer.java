/**
 * @description:
 * @author: Andy
 * @time: 2021/02/18 13:47
 */
package socketsDemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by fanyuexin on 2021/02/18
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建serverSocket
        ServerSocket serverSocket = new ServerSocket(10002);
        //得到socket
        Socket socket = serverSocket.accept();//获取客户端对象
        //String ip = socket.getInetAddress().getHostAddress();
        //得到输入流
        InputStream inputStream = socket.getInputStream();
        //读入
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String text = new String(bytes, 0, len);
        System.out.println(text);
        //关闭
        socket.close();
        serverSocket.close();
    }

}
