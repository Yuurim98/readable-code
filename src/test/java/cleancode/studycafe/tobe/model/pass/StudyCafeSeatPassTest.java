package cleancode.studycafe.tobe.model.pass;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafeSeatPassTest {

    @DisplayName("패스 타입이 일치하는지 확인한다")
    @Test
    void testIsSamePassType() {

        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1);

        // when
        boolean isSame = seatPass.isSamePassType(StudyCafePassType.WEEKLY);

        // then
        assertTrue(isSame);
    }

    @DisplayName("락커 사용 불가 여부를 확인한다")
    @Test
    void testCannotUseLocker() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1);

        // when
        boolean cannotUseLocker = seatPass.cannotUseLocker();

        // then
        assertTrue(cannotUseLocker);
    }
}