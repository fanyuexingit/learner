/**
 * @description:
 * @author: Andy
 * @time: 2021/02/18 13:45
 */
package _7_socketsDemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by fanyuexin on 2021/02/18
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //创建socket
        Socket socket = new Socket("127.0.0.1", 10002);
        //得到输出流
        OutputStream outputStream = socket.getOutputStream();
        //输出
        String text = "tcp演示，哥们又来了!";
        outputStream.write(text.getBytes());
        //关闭
        socket.close();
    }
}
