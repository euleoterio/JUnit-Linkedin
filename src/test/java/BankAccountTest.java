import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount class")
public class BankAccountTest {

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
//        assertEquals(900, account.getBalance(), "Unexpected value, expected 900");
    }

    @Test
    @DisplayName("Withdraw woll become negative")
    public void testeWithdrawNotStuckAtZero() {
        BankAccount account = new BankAccount(500, -1000);
        account.withdraw(800);

        assertNotEquals(0, account.getBalance());
    }

    @Test
    @DisplayName("Test activation account after creation")
    public void testActive(){
        BankAccount account = new BankAccount(500,0);

        assertTrue(account.isActive());
    }

    @Test
    @DisplayName("Test set holder name")
    public void testHolderNameSet(){
        BankAccount account = new BankAccount(500,0);
        account.setHolderName("Maaike");

        assertNotNull(account.getHolderName());
    }

    @Test
    @DisplayName("Test that we can't withdraw below minimum")
    public void testNoWithdrawBelowMinimum(){
        BankAccount account = new BankAccount(500,-1000);

        assertThrows(RuntimeException.class, () -> account.withdraw(2000));
    }

    @Test
    @DisplayName("Test no exceptions for withdraw and deposit")
    public void testWithdrawAndDepositWithoutExceptions(){
        BankAccount account = new BankAccount(500,-1000);

        assertAll(() -> account.deposit(200), () -> account.withdraw(450));
    }

    @Test
    @DisplayName("Test speed deposit")
    public void testDepositTimeout() {
        BankAccount account = new BankAccount(400,0);

        assertTimeout(Duration.ofNanos(1), () -> account.deposit(200));
    }
}
