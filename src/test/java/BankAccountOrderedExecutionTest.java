import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountOrderedExecutionTest {

    static  BankAccount account = new BankAccount(0,0);

    @Test
    @Order(2)
    @DisplayName("Test withdraw using Order Annotation")
    public void testWithdraw(){
        account.withdraw(300);
        assertEquals(200, account.getBalance());
    }

    @Test
    @Order(1)
    @DisplayName("Test Deposit using Order Annotation")
    void testDeposit(){
        account.deposit(500);
        assertEquals(500, account.getBalance());
    }

}
