package com.holub.life.colorchangetimer;

import com.holub.life.Resident;

import java.awt.*;
import java.util.ArrayList;

//싱글톤으로 구현하면 됨. + 옵저버로 신호 보내기
public class ColorChangeTimer {
    // (#Singleton1#)싱글톤으로 생성하기 위해 단 하나의 static 변수
    private volatile static ColorChangeTimer colorChangeTimer = null;
    // (##Observer##) 옵저버 패턴 적용을 위해 observers 리스트를 선언
    private ArrayList observers;

    //색깔을 change하라고 신호를 주는 기준이 되는 단위시간
    public static int changeUnitTime = 1;
    // 이 클래스 객체가 만들어진 시간
    private long formerTime;
    private long latterTime;


    // (#Singleton2#)싱글톤으로 생성하기 위해 생성자를 private로
    private ColorChangeTimer(){
        // 시간측정을 위함
        this.formerTime = System.currentTimeMillis();
        // (##Observer##) 생성자에서 observers 리스트 초기화
        observers = new ArrayList();
    }

    // (#Singleton3#)싱글톤으로 생성하기 위해 static 객체를 가져오는 함수 구현
    public static ColorChangeTimer getInstance(){
        if (colorChangeTimer == null){
            synchronized(ColorChangeTimer.class){
                if(colorChangeTimer == null)
                    colorChangeTimer = new ColorChangeTimer();
            }
        }
        return colorChangeTimer;
    }
    // (##Observer##)
    public void registerObserver(Resident r){
        observers.add(r);
    }
    public void removeObserver(Resident r){

    }
    //(##Observer패턴##)
    //기본 Observer패턴에서 아래 함수에서는 observers를 돌며 모두에게 update()함수를 호출하지만
    //나는 Resident의 static변수로 소통하면 되기에 반복문은 없앴다.
    public void notifyObservers(){
        Resident.changeTick = true;
    }

    //(##Observer패턴##)
    //Resident에 알려야할 조건을 만족하면 notify한다.
    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(){
        //여기서 시간을 계속 재다가 changeUnitTime을 지나가게 되면 notifyObserver하고 시간 초기화
        while(true){
            try {
                Thread.sleep(1000L);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            latterTime = System.currentTimeMillis();
            if ((latterTime - formerTime) / 1000 > ColorChangeTimer.changeUnitTime){
                System.out.println("Observer패턴 ColorChangeTime에서 notifyObservers 호출");
                notifyObservers();
                //다음 색깔 바꾸는 시점을 포착해야하므로, 방금 색깔을 바꾸라고 notify한 시간을 formerTime에 저장
                formerTime = latterTime;
            }
        }
    }
}
