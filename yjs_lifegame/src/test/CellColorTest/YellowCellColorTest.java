package CellColorTest;

import com.holub.life.cellcolor.CellColor;
import com.holub.life.cellcolor.YellowCellColor;
import com.holub.ui.Colors;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YellowCellColorTest {
    @Test
    void getBORDER_COLOR() {
        CellColor yellowCellColor = new YellowCellColor();
        Color result = yellowCellColor.getBORDER_COLOR();
        assertEquals(Colors.DARK_YELLOW, result);
    }

    @Test
    void getDEAD_COLOR() {
        CellColor yellowCellColor = new YellowCellColor();
        Color result = yellowCellColor.getDEAD_COLOR();
        assertEquals(Colors.LIGHT_YELLOW, result);
    }

    @Test
    void getLIVE_COLOR() {
        CellColor yellowCellColor = new YellowCellColor();
        Color result = yellowCellColor.getLIVE_COLOR();
        assertEquals(Colors.OCHRE, result);
    }

    @Test
    void getNOW_ALIVED_COLOR() {
        CellColor yellowCellColor = new YellowCellColor();
        Color result = yellowCellColor.getNOW_ALIVED_COLOR();
        assertEquals(Colors.LIGHT_ORANGE, result);
    }
}
