import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class BankAccountConditionalTest {

    @Test
    @EnabledOnOs({OS.MAC})
    void testMac(){}

    @Test
    @EnabledOnOs({OS.WINDOWS})
    void testWindows(){}

    @Test
    @EnabledOnJre({JRE.JAVA_11})
    void testJRE(){}

    @Test
    @DisabledOnJre({JRE.JAVA_16})
    void testNoJRE16(){}
}
