package com.hxwang.tanke;

import java.awt.*;

/**
 * <H2> </H2>
 *
 * @author hxwang
 * @data 2022/12/3
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        while (true){
            // 每隔50毫秒刷新一次
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
