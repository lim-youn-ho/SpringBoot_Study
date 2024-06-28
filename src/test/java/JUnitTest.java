import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    @DisplayName("1+2 = 3") //테스트 이름을 명시
    @Test // 테스트끼리 영향 주지 않도록 하기 위해, 실행시 실행객체 생성 및 종료시 삭제됨
    public void junitTest(){
        int a = 1;
        int b = 2;
        int sum = 3;
        Assertions.assertEquals(sum,a+b);
    }
}
