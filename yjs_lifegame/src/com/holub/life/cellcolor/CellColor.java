package com.holub.life.cellcolor;

import com.holub.ui.Colors;

import java.awt.*;

public abstract class CellColor {

    private Color BORDER_COLOR;
    private Color LIVE_COLOR;
    private Color DEAD_COLOR;
    private Color NOW_ALIVED_COLOR;
    private Color NOW_DEAD_COLOR;

    private int changeColorCount;

//    public CellColor(Color a, Color b, Color c, Color d, Color e){
//        BORDER_COLOR = a;
//        LIVE_COLOR = b;
//        DEAD_COLOR = c;
//        NOW_ALIVED_COLOR = d;
//        NOW_DEAD_COLOR = e;
//    }

    public Color getBORDER_COLOR() {
        return BORDER_COLOR;
    }

    public Color getDEAD_COLOR() {
        return DEAD_COLOR;
    }

    public Color getLIVE_COLOR() {
        return LIVE_COLOR;
    }

    public Color getNOW_ALIVED_COLOR() {
        return NOW_ALIVED_COLOR;
    }

    public Color getNOW_DEAD_COLOR() {
        return NOW_DEAD_COLOR;
    }

}
