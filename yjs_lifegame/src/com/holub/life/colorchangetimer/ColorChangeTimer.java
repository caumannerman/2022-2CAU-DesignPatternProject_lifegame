package com.holub.life.colorchangetimer;

import java.awt.*;

//싱글톤으로 구현하면 됨.
public class ColorChangeTimer {
    //이거는 없애도 될 듯?
    public static boolean changeColorTick = false;
    //색깔을 change하라고 신호를 주는 기준이 되는 단위시간
    public static int changeUnitTime;
    // 이 클래스 객체가 만들어진 시간
    private long makeTime;

    public ColorChangeTimer(){
        this.makeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
    }


    public long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
//    public long secDiffTime = (afterTime - beforeTime)/1000;

}
