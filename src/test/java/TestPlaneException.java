import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestPlaneException {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void customExceptionMessage() throws PlaneException {
        thrown.expect(PlaneException.class);
        thrown.expectMessage("Custom Error Message");
        throw new PlaneException("Custom Error Message");
    }

}