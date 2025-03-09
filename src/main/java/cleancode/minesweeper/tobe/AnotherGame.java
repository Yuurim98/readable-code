package cleancode.minesweeper.tobe;

public class AnotherGame implements Game{

    @Override
    public void initialize() {
        // 초기화 과정 필요 없는 게임
        // initialize() 메서드의 시그니처가 변경되는 경우
        // AnotherGame도 영향을 받게 됨

    }

    @Override
    public void run() {

    }
}
