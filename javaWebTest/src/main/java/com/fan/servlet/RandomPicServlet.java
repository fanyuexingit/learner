/**
 * @description:
 * @author: Andy
 * @time: 2021/02/01 14:39
 */
package com.fan.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by fanyuexin on 2021/02/01
 */
public class RandomPicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedImage bufferedImage = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font(null, Font.BOLD, 20));
        graphics.drawString("123456", 0, 20);

//        graphics.setColor(Color.white);
//        graphics.fillRect(0, 0, 80, 20);

        resp.setHeader("ContentType", "jpeg");
        ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());
    }

    private String makeNum() {
        Random random = new Random();
        int anInt = random.nextInt(9999999);
        String num = String.valueOf(anInt);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 7 - num.length(); i++) {
            stringBuffer.append("0");
        }
        return stringBuffer.append(num).toString();
    }
}
