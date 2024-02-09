import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountNestedTest {

    @Test
    @DisplayName("Withdraw 500 successfully")
    public void testWithdraw() {
        BankAccount account = new BankAccount(500, -1000);
        account.withdraw(300);

        assertEquals(200, account.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit(){
        BankAccount account = new BankAccount(400, 0);
        account.deposit(500);
        assertEquals(900, account.getBalance());
    }

    @Nested
    class WhenBalanceEqualsZero {

        @Test
        @DisplayName("Withdrawing below minimum balance: exception")
        public void testWithdrawMinimumBalanceIs0(){
            BankAccount account = new BankAccount(0,0);
            assertThrows(RuntimeException.class, () -> account.withdraw(500));
        }

        @Test
        @DisplayName("Withdrawing and getting a negative balance")
        public void testWithdrawMinimumBalanceNegative1000(){
            BankAccount account = new BankAccount(0,-1000);
            account.withdraw(500);
            assertEquals(-500, account.getBalance());
        }
    }
}
