package com.hxwang.tanke;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <H2> </H2>
 *
 * @author hxwang
 * @data 2022/12/3
 */

public class TankFrame extends Frame {
    int x = 200, y = 200; // 坦克起始的位置
    Dir dir = Dir.DOWN; // 坦克的默认的方向
    private static final int SPEED = 10;// 坦克默认的速度

    public TankFrame() {
        setSize(800, 600);
        setResizable(false);// 是否可以改变大小
        setTitle("tank war");
        setVisible(true);
        //添加窗口监听器
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);// 退出程序
            }
        });
        // 添加键盘监听时间
        this.addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        // 根据坦克的方向让其移动
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
//        x += 10;
    }

    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        // 键盘上的键按下时调用
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }


        // 键盘上的按键松开时调用
        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        // 判断坦克的方向
        private void setMainTankDir() {
            if (bL) dir = Dir.LEFT;
            if (bU) dir = Dir.UP;
            if (bR) dir = Dir.RIGHT;
            if (bD) dir = Dir.DOWN;

        }
    }
}
