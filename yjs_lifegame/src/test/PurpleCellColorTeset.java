import com.holub.life.cellcolor.CellColor;
import com.holub.life.cellcolor.PurpleCellColor;
import com.holub.ui.Colors;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurpleCellColorTeset {
    @Test
    void getBORDER_COLOR() {
        CellColor purpleCellColor = new PurpleCellColor();
        Color result = purpleCellColor.getBORDER_COLOR();
        assertEquals(Colors.DARK_YELLOW, result);
    }

    @Test
    void getDEAD_COLOR() {
        CellColor purpleCellColor = new PurpleCellColor();
        Color result = purpleCellColor.getDEAD_COLOR();
        assertEquals(Colors.LIGHT_YELLOW, result);
    }

    @Test
    void getLIVE_COLOR() {
        CellColor purpleCellColor = new PurpleCellColor();
        Color result = purpleCellColor.getLIVE_COLOR();
        assertEquals(Colors.MEDIUM_PURPLE, result);
    }

    @Test
    void getNOW_ALIVED_COLOR() {
        CellColor purpleCellColor = new PurpleCellColor();
        Color result = purpleCellColor.getNOW_ALIVED_COLOR();
        assertEquals(Colors.LIGHT_PURPLE, result);
    }
}
