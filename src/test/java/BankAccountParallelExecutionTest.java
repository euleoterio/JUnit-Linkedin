import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {

    @Test
    @DisplayName("Deposit 500 successfully")
    public void testDeposit1(BankAccount account){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        account.deposit(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    @DisplayName("Deposit 500 successfully")
    public void testDeposit2(BankAccount account){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        account.deposit(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    @DisplayName("Deposit 500 successfully")
    public void testDeposit3(BankAccount account){
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        account.deposit(500);
        assertEquals(500, account.getBalance());
    }
}
