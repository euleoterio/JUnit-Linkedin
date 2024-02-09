import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTestTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 400, 800, 1000})
    @DisplayName("Test with Dependency Injection and Parameterized test- Deposit 400 successfully")
    public void testDepositRepetitionInf(int amount, BankAccount account){
        account.deposit(amount);
        assertEquals(amount, account.getBalance());
    }

    //example using @ParameterizedTest with days of week
    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"TUESDAY", "THURSDAY"})
    public void testDayOfWeek(DayOfWeek day){
        assertTrue(day.toString().startsWith("T"));
    }

    @ParameterizedTest
//    @CsvSource({"100, Mary", "200, Rachid", "150, Ted"})
    @CsvFileSource(resources = "details.csv", delimiter = ';') //delimiter default is ,
    public void depositAndNameTest(double amount, String name, BankAccount account){
        account.deposit(amount);
        account.setHolderName(name);
        assertEquals(amount, account.getBalance());
        assertEquals(name, account.getHolderName());
    }
}
