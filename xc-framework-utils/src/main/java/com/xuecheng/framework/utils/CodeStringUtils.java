package com.xuecheng.framework.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 复制代码“\\uooAo”非法空格处理
 * @author xiboss
 * @create 2019-03-20 21:30
 */
public class CodeStringUtils {
    /**
     * 去除字符串中所包含的空格（包括:空格(全角，半角)、制表符、换页符等）
     * @param s
     * @return
     */
    public static String removeAllBlank(String s) {
        String result = "";
        if (null != s && !"".equals(s)) {
            result = s.replaceAll("[　*| *| *|//s*]*", "");
        }
        return result;
    }

    /**
     * 去除字符串中头部和尾部所包含的空格（包括:空格(全角，半角)、制表符、换页符等）
     * @param s
     * @return
     */
    public static String trim(String s) {
        String result = "";
        if (null != s && !"".equals(s)) {
            result = s.replaceAll("^[　*| *| *|//s*]*", "").replaceAll("[　*| *| *|//s*]*$", "");
        }
        return result;
    }

    /**
     * 全角转半角
     * @param s
     * @return 半角字符串
     */
    public static String ToBJ(String s){
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length ; i++) {
            if(c[i] == '\u3000'){
                c[i] = ' ' ;
            }else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
                c[i] = (char) (c[i] - 65248);
            }
        }
        return new String(c) ;
    }

    //界面输入与输出
    public static void GUI(){
        int gap = 10 ;

        //窗口制作
        JFrame f = new JFrame("JAVA非法字符转换") ;
        f.setSize(500,400);
        f.setLocation(300,300);
        f.setLayout(null);

        //输入面板
        JPanel pInput = new JPanel();
        pInput.setBounds(gap, gap, 375, 200);
        pInput.setLayout(new GridLayout(4,3,gap,gap));

        JLabel code = new JLabel("输入代码:");
        JTextArea codeText = new JTextArea();

        pInput.add(code) ;
        pInput.add(codeText) ;

        JButton button = new JButton("生成") ;
        //文本域
        JTextArea ta = new JTextArea();
        ta.setLineWrap(true);
        button.setBounds(150, 120 + 30, 80, 30);
        ta.setBounds(gap, 150 + 60, 375, 120);

        f.add(pInput) ;
        f.add(button);
        f.add(ta) ;
        f.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = ToBJ(String.valueOf(pInput)).replaceAll("\\u00A0", " ");
                ta.append(s);
            }
        });
    }

    public static void main(String[] args) {
        String input = "static{\n" +
                "        //在这里加入一些基础的异常类型判断\n" +
                "        builder.put(HttpMessageNotReadableException.class,CommonCode.INVALIDPARAM);\n" +
                "    }" ;
        String str = ToBJ(input).replaceAll("\\u00A0"," ") ;
        System.out.println(str);
    }
}
