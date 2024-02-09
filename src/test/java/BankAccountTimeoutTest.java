import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

//for all tests in class
//@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void testDepositTimeoutAssertion(BankAccount account){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        account.deposit(300);
        assertEquals(300, account.getBalance());
    }

    @Test
    void testDepositTimeoutAnnotation(BankAccount account){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        account.deposit(300);
        assertTimeout(Duration.ofMillis(500), () -> {
            Thread.sleep(100);
        });
    }
}
