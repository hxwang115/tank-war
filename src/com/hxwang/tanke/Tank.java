package com.hxwang.tanke;

import java.awt.*;

/**
 * <H2> 坦克类 </H2>
 *
 * @author hxwang
 * @data 2022/12/4
 */
public class Tank {
    private int x; // 坐标
    private int y; // 坐标
    private int speed = 10; // 速度
    private Dir dir = Dir.DOWN; // 方向
    private boolean moving = false;// 是否移动

    private TankFrame tf;

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isMoving() {
        return moving;
    }

    public Tank(int x, int y, int speed, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.dir = dir;
        this.tf = tf;
    }

    public Tank() {
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        move();
    }

    // 根据坦克的方向让其移动
    private void move() {
        if (!moving) return;
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
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public Dir getDir() {
        return dir;
    }

    public void fire() {
        tf.bullets.add(new Bullet(x, y, this.dir,tf));
    }
}
