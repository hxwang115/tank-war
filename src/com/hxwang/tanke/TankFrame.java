package com.hxwang.tanke;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * <H2> 窗口类 </H2>
 *
 * @author hxwang
 * @data 2022/12/3
 */

public class TankFrame extends Frame {

    Tank myTank = new Tank(200, 200, 5, Dir.DOWN, this);
    List<Bullet> bullets = new ArrayList<Bullet>();
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
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

    /**
     * <h2>消除闪烁问题</h2>
     * 双缓存
     *
     * @author hxwang
     * @date 2022/12/4
     */
    Image offScreenImage = null; // 定义一个图片

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics graphics = offScreenImage.getGraphics();// 获取图片的画笔
        Color color = graphics.getColor();// 记录当前画笔的颜色
        graphics.setColor(Color.green);
        graphics.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        graphics.setColor(color);// 颜色画好后再恢复
        paint(graphics);
        g.drawImage(offScreenImage, 0, 0, null);// 将图片整体画到窗口上

    }

    /**
     * 将所有子弹都画出来
     *
     * @author hxwang
     * @date 2022/12/20
     */
    @Override
    public void paint(Graphics g) {
        g.drawString("子弹的数量:"+bullets.size(),10,60);
        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
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
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        // 判断坦克的方向
        private void setMainTankDir() {
            if (!bD && !bL && !bR && !bU) myTank.setMoving(false);
            else {
                myTank.setMoving(true);
                if (bD) myTank.setDir(Dir.DOWN);
                if (bL) myTank.setDir(Dir.LEFT);
                if (bU) myTank.setDir(Dir.UP);
                if (bR) myTank.setDir(Dir.RIGHT);
            }
        }
    }
}
