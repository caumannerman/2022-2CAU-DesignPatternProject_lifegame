package CellColorTest;

import com.holub.life.cellcolor.CellColor;
import com.holub.life.cellcolor.GreenCellColor;
import com.holub.life.cellcolor.OrangeCellColor;
import com.holub.ui.Colors;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrangeCellColorTest {

    @Test
    void getBORDER_COLOR() {
        CellColor orangeCellColor = new OrangeCellColor();
        Color result = orangeCellColor.getBORDER_COLOR();
        assertEquals(Colors.DARK_YELLOW, result);
    }

    @Test
    void getDEAD_COLOR() {
        CellColor orangeCellColor = new OrangeCellColor();
        Color result = orangeCellColor.getDEAD_COLOR();
        assertEquals(Colors.LIGHT_YELLOW, result);
    }

    @Test
    void getLIVE_COLOR() {
        CellColor orangeCellColor = new OrangeCellColor();
        Color result = orangeCellColor.getLIVE_COLOR();
        assertEquals(Colors.DARK_ORANGE, result);
    }

    @Test
    void getNOW_ALIVED_COLOR() {
        CellColor orangeCellColor = new OrangeCellColor();
        Color result = orangeCellColor.getNOW_ALIVED_COLOR();
        assertEquals(Colors.MEDIUM_ORANGE, result);
    }
}


