package cleancode.studycafe.tobe.model.order;

import static org.junit.jupiter.api.Assertions.*;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafePassOrderTest {

    @DisplayName("할인 가격을 반환한다")
    @Test
    void testGetDiscountPrice() {

        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1);
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, null);

        // when
        int discountPrice = passOrder.getDiscountPrice();

        // then
        assertEquals(10000, discountPrice);
    }

    @DisplayName("총 가격을 계산한다 (락커 포함)")
    @Test
    void testGetTotalPriceWithLocker() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 250000, 0.1); // 10% 할인
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 10000);
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        int totalPrice = passOrder.getTotalPrice();

        // then
        assertEquals(235000, totalPrice);
    }

    @DisplayName("총 가격을 계산한다 (락커 없음)")
    @Test
    void testGetTotalPriceWithoutLocker() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 250000, 0.1); // 10% 할인
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, null);

        // when
        int totalPrice = passOrder.getTotalPrice();

        // then
        assertEquals(225000, totalPrice);
    }
}