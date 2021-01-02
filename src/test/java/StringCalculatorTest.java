import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import domain.StringCalculator;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    public void null_혹은_빈값() {
        assertThat(StringCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    public void 값_하나() {
        assertThat(StringCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    public void 구분자() {
        assertThat(StringCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    public void 음수() {
        assertThrows(RuntimeException.class, () -> StringCalculator.splitAndSum("1,2:-3"));
    }

    @Test
    public void 숫자가_아닌_경우() {
        assertThrows(RuntimeException.class, () -> StringCalculator.splitAndSum("가#나,3"));
    }

    @Test
    public void 커스텀_구분자_찾기() {
        assertTrue(StringCalculator.hasCustomSeparator("//;/1;2,3:4"));
    }

    @Test
    public void 커스텀_구분자_추출() {
        assertThat(StringCalculator.findSeparator("//;/1;2,3:4")).isEqualTo(";");
    }

    @Test
    public void 커스텀_구분자_삭제() {
        assertThat(StringCalculator.getExpression("//;/1;2,3:4")).isEqualTo("1;2,3:4");
    }

    @Test
    public void 구분자_변환() {
        assertThat("1;2,3:4".replaceAll(";", ",")).isEqualTo("1,2,3:4");
    }


}
