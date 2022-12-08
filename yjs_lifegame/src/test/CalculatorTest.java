
import com.holub.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    void plus() {
        int result = Calculator.plus(1, 3); // 에러
        assertEquals(3, result);
    }
}