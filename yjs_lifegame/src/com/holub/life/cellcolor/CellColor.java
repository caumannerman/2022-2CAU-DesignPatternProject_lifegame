package com.holub.life.cellcolor;

import com.holub.ui.Colors;

import java.awt.*;

public abstract class CellColor {

    private Color BORDER_COLOR;
    private Color LIVE_COLOR;
    private Color DEAD_COLOR;
    private Color NOW_ALIVED_COLOR;
    private Color NOW_DEAD_COLOR;

//    public CellColor(Color a, Color b, Color c, Color d, Color e){
//        BORDER_COLOR = a;
//        LIVE_COLOR = b;
//        DEAD_COLOR = c;
//        NOW_ALIVED_COLOR = d;
//        NOW_DEAD_COLOR = e;
//    }

    public abstract Color getBORDER_COLOR();

    public abstract Color getDEAD_COLOR();

    public abstract Color getLIVE_COLOR();

    public abstract Color getNOW_ALIVED_COLOR();

    public abstract Color getNOW_DEAD_COLOR();

}
