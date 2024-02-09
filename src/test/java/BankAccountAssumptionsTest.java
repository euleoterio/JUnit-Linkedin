import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class BankAccountAssumptionsTest {

    @Test
    @DisplayName("Test activation account after creation")
    public void testActive(){
        BankAccount account = new BankAccount(500,0);

//        assumeTrue(account == null);
//        test not funcionally
        assumingThat(account != null, () -> assertTrue(account.isActive()));
    }
}
