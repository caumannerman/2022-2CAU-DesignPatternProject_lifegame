package CellColorTest;

import com.holub.life.cellcolor.CellColor;
import com.holub.life.cellcolor.RedCellColor;
import com.holub.ui.Colors;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedCellColorTest {
    @Test
    void getBORDER_COLOR() {
        CellColor redCellColor = new RedCellColor();
        Color result = redCellColor.getBORDER_COLOR();
        assertEquals(Colors.DARK_YELLOW, result);
    }

    @Test
    void getDEAD_COLOR() {
        CellColor redCellColor = new RedCellColor();
        Color result = redCellColor.getDEAD_COLOR();
        assertEquals(Colors.LIGHT_YELLOW, result);
    }

    @Test
    void getLIVE_COLOR() {
        CellColor redCellColor = new RedCellColor();
        Color result = redCellColor.getLIVE_COLOR();
        assertEquals(Colors.LIGHT_RED, result);
    }

    @Test
    void getNOW_ALIVED_COLOR() {
        CellColor redCellColor = new RedCellColor();
        Color result = redCellColor.getNOW_ALIVED_COLOR();
        assertEquals(Colors.DARK_RED, result);
    }
}
