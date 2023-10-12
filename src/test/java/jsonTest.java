import com.blockchain.Sample;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class jsonTest {
    @Test
    void test() {
        //given
        String input = "{\"name\" : \"Tobias\"}";

        //when
        String output = Sample.getNameFromJson(input);

        //then
        Assertions.assertEquals("Tobias", output);
    }

    @Test
    void testFalseJsonInput() {
        //given
        String input = "{\"nachname\" : \"Vilser\"}";

        //when
        // String output = Sample.getNameFromJson(input);

        //then
        final IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> Sample.getNameFromJson(input));
        Assertions.assertEquals("only name", ex.getMessage());
    }

    @Test
    void testBadInput() {
        //given
        String input = "BAD";

        //when
        // String output = Sample.getNameFromJson(input);

        //then
        final IllegalStateException ex = Assertions.assertThrows(IllegalStateException.class, () -> Sample.getNameFromJson(input));
        Assertions.assertEquals("input must be a JSON-Object:", ex.getMessage());
    }

    @Test
    void testNullInput() {
        //given
        String input = null;

        //then
        final NullPointerException ex = Assertions.assertThrows(NullPointerException.class, () -> Sample.getNameFromJson(input));
        Assertions.assertEquals("input must not be null", ex.getMessage());
    }
}
