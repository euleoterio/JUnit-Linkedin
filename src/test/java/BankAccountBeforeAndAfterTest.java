import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountBeforeAndAfterTest {

    static  BankAccount account;

    @BeforeAll
//    @BeforeEach
    void preTest(){
        System.out.println("Hi!");
        account = new BankAccount(500,0);
    }

    @Test
    public void testWithdraw(){
        account.withdraw(300);
        assertEquals(200, account.getBalance());
    }

    @Test
    void testDeposit(){
        account.deposit(500);
        assertEquals(700, account.getBalance());
    }

    @AfterAll
//    @AfterEach
    void endTest(){
        System.out.println("Bye!");
    }

}
