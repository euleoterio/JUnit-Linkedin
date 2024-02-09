import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDisabledTest {

    @Test
    @Disabled("Temporarily disabled due to maintenance")
    @DisplayName("Deposit 500 successfully")
    public void testDepositRepetitionInf(BankAccount account, RepetitionInfo repetitionInfo){
        account.deposit(500);
        assertEquals(500, account.getBalance());
    }
}
