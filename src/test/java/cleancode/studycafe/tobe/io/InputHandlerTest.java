package cleancode.studycafe.tobe.io;

import static org.junit.jupiter.api.Assertions.*;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    @DisplayName("사용자가 1을 입력하면 HOURLY를 반환한다")
    @Test
    void testHourlyInput() {

        // given
        InputStream input = new ByteArrayInputStream("1".getBytes());
        System.setIn(input);

        InputHandler inputHandler = new InputHandler();

        // when
        StudyCafePassType passType = inputHandler.getPassTypeSelectingUserAction();

        // then
        assertEquals(StudyCafePassType.HOURLY, passType);
    }

    @DisplayName("사용자가 2를 입력하면 WEEKLY를 반환한다")
    @Test
    void testWeeklyInput() {

        // given
        InputStream input = new ByteArrayInputStream("2".getBytes());
        System.setIn(input);

        InputHandler inputHandler = new InputHandler();

        // when
        StudyCafePassType passType = inputHandler.getPassTypeSelectingUserAction();

        // then
        assertEquals(StudyCafePassType.WEEKLY, passType);
    }

    @DisplayName("사용자가 3을 입력하면 FIXED를 반환한다")
    @Test
    void testFixedInput() {

        // given
        InputStream input = new ByteArrayInputStream("3".getBytes());
        System.setIn(input);

        InputHandler inputHandler = new InputHandler();

        // when
        StudyCafePassType passType = inputHandler.getPassTypeSelectingUserAction();

        // then
        assertEquals(StudyCafePassType.FIXED, passType);
    }

    @DisplayName("1, 2, 3이 아닌 다른 값을 입력 시 예외가 발생한다")
    @Test
    void testInvalidInput() {
        // given
        InputStream input = new ByteArrayInputStream("6".getBytes());
        System.setIn(input);

        InputHandler inputHandler = new InputHandler();

        // when & then
        assertThrows(AppException.class, inputHandler::getPassTypeSelectingUserAction);
    }

}