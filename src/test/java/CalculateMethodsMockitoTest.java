import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculateMethodsMockitoTest {

    @Mock
    CalculateMethods calculateMethods;

    // can be use with APIs, mock the return that
    @BeforeEach
    void setupMocks(){
        Mockito.when(calculateMethods.divide(6,3)).thenReturn(2.0);
    }

    @Test
    void testDivide() {
        assertEquals(2.0, calculateMethods.divide(6,3));
    }
}
