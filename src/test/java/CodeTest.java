import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CodeTest {

    @Test
    public void sayHello() {
        Code code = new Code();
        assertEquals("Hello World!", code.sayHello());
    }
}
