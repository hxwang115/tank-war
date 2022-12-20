package com.hxwang.tanke;

import java.awt.*;

import static com.hxwang.tanke.TankFrame.GAME_HEIGHT;
import static com.hxwang.tanke.TankFrame.GAME_WIDTH;

/**
 * <H2> 炮弹类 </H2>
 *
 * @author hxwang
 * @data 2022/12/4
 */

public class Bullet {
    private int speed = 10;// 炮弹的速度
    private static int WIDTH = 5, HEIGHT = 5;// 炮弹的大小
    private int x, y;// 坐标
    private Dir dir;// 方向
    private boolean live = true;
    private TankFrame tf;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        // 如果子弹消失，将其从容器中删除，防止内存溢出
        if (!live) {
            tf.bullets.remove(this);
        }
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);// 正方形的内切圆
        g.setColor(color);

        move();

    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= speed;
                break;
            case UP:
                y -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case DOWN:
                y += speed;
                break;
        }
        if (x < 0 || y < 0 || x > GAME_WIDTH || y > GAME_HEIGHT) live = false;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public static void setWIDTH(int WIDTH) {
        Bullet.WIDTH = WIDTH;
    }

    public static void setHEIGHT(int HEIGHT) {
        Bullet.HEIGHT = HEIGHT;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public int getSpeed() {
        return speed;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Dir getDir() {
        return dir;
    }
}
