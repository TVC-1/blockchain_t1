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
        final NullPointerException ex = Assertions.assertThrows(NullPointerException.class, () -> Sample.getNameFromJson(input));
        Assertions.assertEquals("Cannot invoke \"com.google.gson.JsonElement.getAsString()\" because the return value of \"com.google.gson.JsonObject.get(String)\" is null", ex.getMessage());
    }

    @Test
    void testBadInput() {
        //given
        String input = "BAD";

        //when
        // String output = Sample.getNameFromJson(input);

        //then
        final IllegalStateException ex = Assertions.assertThrows(IllegalStateException.class, () -> Sample.getNameFromJson(input));
        Assertions.assertEquals("Not a JSON Object: \"BAD\"", ex.getMessage());
    }

    @Test
    void testNullInput() {
        //given
        String input = null;

        //then
        final NullPointerException ex = Assertions.assertThrows(NullPointerException.class, () -> Sample.getNameFromJson(input));
        Assertions.assertEquals("input must be null", ex.getMessage());
    }
}
