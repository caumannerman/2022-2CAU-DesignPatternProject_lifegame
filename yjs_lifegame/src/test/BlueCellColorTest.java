import com.holub.life.cellcolor.BlueCellColor;
import com.holub.life.cellcolor.CellColor;
import com.holub.ui.Colors;
import org.junit.jupiter.api.Test;

import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlueCellColorTest {
    @Test
    void getLIVE_COLOR() {
        CellColor blueCellColor = new BlueCellColor();
        Color result = blueCellColor.getLIVE_COLOR(); // 에러
        assertEquals(Colors.LIGHT_BLUE, result);
    }
}
