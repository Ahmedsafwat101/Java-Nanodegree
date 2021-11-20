import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class HelperParameterizedTest {
    private String input;
    private String output;

    public HelperParameterizedTest(String input,String output) {
        super();
        this.input = input;
        this.output = output;
    }

    @Parameters
    public static Collection initData() {
        String[][] empName = {{"Ahmed", "Safwat"}, {"Ali", "Ahmed"}};
        return Arrays.asList(empName);
    }

    @Test
    public void verify_input_name_is_not_the_same_as_output_name(){
        Assert.assertNotEquals(input,output);
    }


}
