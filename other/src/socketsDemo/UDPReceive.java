/**
 * @description:
 * @author: Andy
 * @time: 2021/02/18 13:32
 */
package socketsDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by fanyuexin on 2021/02/18
 */
public class UDPReceive {
    public static void main(String[] args) throws IOException {
        //创建socket 指定端口
        DatagramSocket datagramSocket = new DatagramSocket(10000);
        //创建packet 接收
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        //接收
        datagramSocket.receive(datagramPacket);
        //处理
        String ip = datagramPacket.getAddress().getHostAddress();
        int port = datagramPacket.getPort();
        String text = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        System.out.println(ip+" "+port+" "+text);
        //关闭
        datagramSocket.close();
    }
}
