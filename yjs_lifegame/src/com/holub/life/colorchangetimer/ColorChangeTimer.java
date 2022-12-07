package com.holub.life.colorchangetimer;

import java.awt.*;

//싱글톤으로 구현하면 됨. + 옵저버로 신호 보내기
public class ColorChangeTimer {
    // (#1)싱글톤으로 생성하기 위해 단 하나의 static 변수
    private volatile static ColorChangeTimer colorChangeTimer = null;
    //이거는 없애도 될 듯?
    public static boolean changeColorTick = false;
    //색깔을 change하라고 신호를 주는 기준이 되는 단위시간
    public static int changeUnitTime = 1;
    // 이 클래스 객체가 만들어진 시간
    private long makeTime;

    // (#2)싱글톤으로 생성하기 위해 생성자를 private로
    private ColorChangeTimer(){
        this.makeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
    }

    // (#3)싱글톤으로 생성하기 위해 static 객체를 가져오는 함수 구현
    public static ColorChangeTimer getInstance(){
        if (colorChangeTimer == null){
            synchronized(ColorChangeTimer.class){
                if(colorChangeTimer == null)
                    colorChangeTimer = new ColorChangeTimer();
            }
        }
        return colorChangeTimer;
    }


    public long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
//    public long secDiffTime = (afterTime - beforeTime)/1000;

}
