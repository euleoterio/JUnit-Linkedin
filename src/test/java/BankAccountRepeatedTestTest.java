import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTestTest {

    @RepeatedTest(5)
    @DisplayName("Test with Dependency Injection and Repeat test- Deposit 400 successfully")
    public void testDepositRepetitionInf(BankAccount account, RepetitionInfo repetitionInfo){
        account.deposit(500);
        assertEquals(500, account.getBalance());
    }
}
