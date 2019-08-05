package com.fly.demo.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.Random;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.07.31 11:17  
 */
public class ImageCodeGenerator {

    /**
     * 图片的宽度
     */
    private int width = 120;
    /**
     * 图片的高度
     */
    private int height = 40;
    /**
     * 验证码字符个数
     */
    private int codeCount = 4;
    /**
     * 验证码干扰线数
     */
    private int lineCount = 10;
    /**
     * 验证码
     */
    private String code = null;
    /**
     * 验证码图片Buffer
     */
    private BufferedImage buffImg = null;

    private int[] fs={7,8,9,10,11,12};

    private int[] es={3,4,5,6};

    private char[] operator={'+','×'};
    /**
     * 生成随机数
     */
    private Random random = new Random();

    public ImageCodeGenerator() {

    }

    /**
     * @param width  图片宽
     * @param height 图片高
     */
    public ImageCodeGenerator(int width, int height) {
        this.width = width;
        this.height = height;

    }

    /**
     * @param width     图片宽
     * @param height    图片高
     * @param codeCount 字符个数
     * @param lineCount 干扰线条数
     */
    public ImageCodeGenerator(int width, int height, int codeCount, int lineCount) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        this.createCode();
    }

    public void createCode() {
        int codeX = 0;
        int fontHeight = 0;
        // 字体的高度
        fontHeight = height - 5;
        // 每个字符的宽度
        codeX = width / (codeCount + 3);

        // 图像buffer
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();

        // 将图像填充为白色
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, width, height);

        //生成干扰xian线
        createRandomLine(this.width,this.height,lineCount,g,100);

        // 创建字体
        ImgFontByte imgFont = new ImgFontByte();
        Font font = imgFont.getFont(fontHeight);

        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        StringBuffer randomCode = new StringBuffer();

        // 随机产生验证码字符
        String first = fs[random.nextInt(fs.length)] + "";
        // 设置字体颜色
        g.setColor(getRandomColor());
        // 设置字体位置
        g.drawString(first, (0 + 1) * codeX, getRandomNumber(height / 2) + 25);

        String fuhao = String.valueOf(operator[random.nextInt(operator.length)]);
        // 设置字体颜色
        g.setColor(Color.RED);
        // 设置字体位置
        g.drawString(fuhao, (2 + 1) * codeX, getRandomNumber(height / 2) + 25);


        String end = es[random.nextInt(es.length)]+"";
        // 设置字体颜色
        g.setColor(getRandomColor());
        // 设置字体位置
        g.drawString(end, (3 + 1) * codeX, getRandomNumber(height / 2) + 25);

        // 设置字体颜色
        g.setColor(getRandomColor());
        // 设置字体位置
        g.drawString("=", (4 + 1) * codeX, getRandomNumber(height / 2) + 25);

        int res=0;
        switch (fuhao){
            case "+":
                 res = Integer.valueOf(first) + Integer.valueOf(end);
                code=res+"";
                break;
            case "-":
                 res = Integer.valueOf(first) - Integer.valueOf(end);
                code=res+"";
                break;
            case "×":
                 res = Integer.valueOf(first) * Integer.valueOf(end);
                code=res+"";
                break;
                default:
                    break;

        }
    }

    /**
     * 获取随机颜色
     */
    private Color getRandomColor() {
        int r = getRandomNumber(255);
        int g = getRandomNumber(255);
        int b = getRandomNumber(255);
        return new Color(r, g, b);
    }

    /**
     * 获取随机数
     */
    private int getRandomNumber(int number) {
        return random.nextInt(number);
    }

    public void write(String path) throws IOException {
        OutputStream sos = new FileOutputStream(path);
        this.write(sos);
    }

    public void write(OutputStream sos) throws IOException {
        ImageIO.write(buffImg, "png", sos);
        sos.close();
    }

    public BufferedImage getBuffImg() {
        return buffImg;
    }

    public String getCode() {
        return code;
    }


    public String getBase64() throws IOException {
        this.createCode();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        this.write(outputStream);
        Base64.Encoder encoder = Base64.getEncoder();
        StringBuilder builder = new StringBuilder("data:image/jpeg;base64,");
        return builder.append(encoder.encodeToString(outputStream.toByteArray())).toString();
    }

    /**
     * 随机产生干扰线条
     * @param width
     * @param height
     * @param minMany 最少产生的数量
     * @param g
     * @param alpha 透明度0~255 0表示全透
     */
    private void createRandomLine(int width, int height, int minMany, Graphics g, int alpha) {  // 随机产生干扰线条
        for (int i = 0; i < getIntRandom(minMany, minMany + 6); i++) {
            int x1 = getIntRandom(0, (int) (width * 0.6));
            int y1 = getIntRandom(0, (int) (height * 0.6));
            int x2 = getIntRandom((int) (width * 0.4), width);
            int y2 = getIntRandom((int) (height * 0.2), height);
            g.setColor(getColor(alpha));
            g.drawLine(x1, y1, x2, y2);
        }
        //随机生成一些点
        for (int i = 0, n = random.nextInt(minMany); i < n; i++) {
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }
    }

    /*** 随机返回一种颜色,透明度0~255 0表示全透
     * @return 随机返回一种颜色
     * @param alpha 透明度0~255 0表示全透
     */
    private Color getColor(int alpha) {
        int R = (int) (Math.random() * 255);
        int G = (int) (Math.random() * 255);
        int B = (int) (Math.random() * 255);
        return new Color(R, G, B, alpha);
    }


    private int getIntRandom(int start, int end) {
        if (end < start) {
            int t = end;
            end = start;
            start = t;
        }
        int i = start + (int) (Math.random() * (end - start));
        return i;
    }

    /**
     * 字体样式类
     */
    class ImgFontByte {
        public Font getFont(int fontHeight) {
            try {
                Font baseFont = Font.createFont(Font.HANGING_BASELINE, new ByteArrayInputStream(
                        hex2byte(getFontByteStr())));
                return baseFont.deriveFont(Font.PLAIN, fontHeight);
            } catch (Exception e) {
                return new Font("Arial", Font.PLAIN, fontHeight);
            }
        }

        private byte[] hex2byte(String str) {
            if (str == null) {
                return null;
            }
            str = str.trim();
            int len = str.length();
            if (len == 0 || len % 2 == 1) {
                return null;
            }

            byte[] b = new byte[len / 2];
            try {
                for (int i = 0; i < str.length(); i += 2) {
                    b[i / 2] = (byte) Integer.decode("0x" + str.substring(i, i + 2)).intValue();
                }
                return b;
            } catch (Exception e) {
                return null;
            }
        }

        // 字体文件的十六进制字符串
        private String getFontByteStr() {
            //防止报字符串长度过长错误，改为从配置文件读取
            return "微软雅黑";
        }
    }
}
