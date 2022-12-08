import com.holub.life.cellcolor.BlueCellColor;
import com.holub.life.cellcolor.CellColor;
import com.holub.life.cellcolor.GreenCellColor;
import com.holub.ui.Colors;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreenCellColorTest {
    @Test
    void getNOW_ALIVED_COLOR() {
        CellColor greenCellColor = new GreenCellColor();
        Color result = greenCellColor.getNOW_ALIVED_COLOR(); // 에러
        assertEquals(Colors.DARK_GREEN, result);
    }
}
