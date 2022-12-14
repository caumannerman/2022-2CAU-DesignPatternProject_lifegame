package com.holub.life.cellcolor;

import com.holub.ui.Colors;

import java.awt.*;

public class RedCellColor extends CellColor {
    private Color BORDER_COLOR = Colors.DARK_YELLOW;
    private Color LIVE_COLOR 	= Colors.LIGHT_RED;
    private Color DEAD_COLOR   = Colors.LIGHT_YELLOW;
    private Color NOW_ALIVED_COLOR = Colors.DARK_RED;


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

}
