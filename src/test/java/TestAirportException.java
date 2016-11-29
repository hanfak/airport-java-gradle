import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestAirportException {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void customExceptionMessage() throws AirportException {
        thrown.expect(AirportException.class);
        thrown.expectMessage("Custom Error Message");
        throw new AirportException("Custom Error Message");
    }
}
