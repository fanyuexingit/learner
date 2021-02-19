/**
 * @description:
 * @author: Andy
 * @time: 2021/02/18 13:25
 */
package _7_socketsDemo;

import java.io.IOException;
import java.net.*;

/**
 * Created by fanyuexin on 2021/02/18
 */
public class UDPSend {
    public static void main(String[] args) throws IOException {
        //创建socket
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //创建packet 发送到指定地址 指定端口
        String text = "udp传输演示 哥们来了";
        byte[] bytes = text.getBytes();
        DatagramPacket datagramPacket =
                new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 10000);
        //发送
        datagramSocket.send(datagramPacket);
        //关闭
        datagramSocket.close();
    }
}
