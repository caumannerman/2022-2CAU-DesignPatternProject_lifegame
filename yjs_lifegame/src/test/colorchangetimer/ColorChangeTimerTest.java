package colorchangetimer;
import com.holub.life.Resident;
import com.holub.life.colorchangetimer.ColorChangeTimer;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ColorChangeTimerTest {
    @Test
    void getInstance() {
        ColorChangeTimer colorChangeTimer = ColorChangeTimer.getInstance();
        // 항상 같은 객체를 return하는지 check
        // 즉, Singleton패턴으로 잘 실행되는지 확인
        ColorChangeTimer result1 = colorChangeTimer.getInstance();
        ColorChangeTimer result2 = colorChangeTimer.getInstance();
        // 주소값으로 비교
        assertEquals(true, result1 == result2);
    }

    @Test
    void notifyObservers() {
        ColorChangeTimer colorChangeTimer = ColorChangeTimer.getInstance();
        // 옵저버패턴으로서 Resident의 static변수인 changeTick을 true로 바꿔줌
        colorChangeTimer.notifyObservers();
        // notifyObservers()가 잘 수행되어 Resident의 static 변수인 changeTick을 true로 바꿔주었는지 확인
        assertEquals(true, Resident.changeTick);
    }

}
