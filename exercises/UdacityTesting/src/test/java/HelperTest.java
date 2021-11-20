import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HelperTest {


    @BeforeClass
    public static void initClass() {
        System.out.println("init Class executed");

    }

    @AfterClass
    public static void teardownclass() {
        System.out.println("teardown Class executed");
    }

    @Before
    public void init() {
        System.out.println("init executed");

    }

    @After
    public void teardown() {
        System.out.println("teardown executed");
    }


    @Test
    public void verifyGetCount() {
        List<String> empNames = Arrays.asList("ssss","fffff");
        long actual  =  Helper.getCount(empNames);
        assertEquals(2,actual);
    }

    @Test
    public void verifyGetStats() {
        List<Integer> yrsOfExperience = Arrays.asList(13,4,15,6,17,8,19,1,2,3);
        IntSummaryStatistics actual  =  Helper.getStats(yrsOfExperience);
        assertEquals(yrsOfExperience.stream().mapToInt(Integer::intValue).max().getAsInt(),actual.getMax());
        assertEquals(yrsOfExperience.stream().mapToInt(Integer::intValue).min().getAsInt(),actual.getMin());
        assertEquals(yrsOfExperience.stream().mapToInt(Integer::intValue).sum(),actual.getSum());
        Double delta = Math.abs(yrsOfExperience.stream().mapToDouble(Integer::intValue).sum()/yrsOfExperience.size() - actual.getAverage());
        assertEquals(yrsOfExperience.stream().mapToDouble(Integer::intValue).sum()/yrsOfExperience.size(),actual.getAverage(),delta);
    }

    @Test
    public void verifyGetMergedList(){
        List<String> empNames = Arrays.asList("sareeta", "", "john","");
         String actual = Helper.getMergedList(empNames);
         String expected = "sareeta, john";
         assertEquals(expected,actual);
    }

    @Test
    public void validate_3lengthString() {
        List<String> empNames = Arrays.asList("sareeta", "", "Jeff","sam");
        assertEquals(1, Helper.getStringsOfLength3(empNames));
    }


    @Test
    public void verify_getMax(){
        List<Integer> empLevel = Arrays.asList(3,3,3,5,7,2,2,5,7,5);
        assertEquals(7, Helper.getStats(empLevel).getMax());
    }

    @Test
    public void verify_ArrayListTest(){
        int[] yrsOfExperience = {13,4,15,6,17,8,19,1,2,3};
        int[] expected = {13,4,15,6,17,8,19,1,2,3};
        assertArrayEquals(expected, yrsOfExperience);
    }

    @Test
    public void verify_GetSquareList(){
        List<Integer> yrsOfExperience = Arrays.asList(13,4,15,6,17,8,19,1,2,3);
        List<Integer> actual = Helper.getSquareList(yrsOfExperience);
        List<Integer>expected = yrsOfExperience.stream().map(i-> i*i).collect(Collectors.toList());
        assertEquals(expected,actual);
    }

    @Test
    public void verify_GetFilteredList(){
        List<String> empNames = Arrays.asList("sareeta", "", "john","");
        List<String>actual = Helper.getFilteredList(empNames);
        assertEquals(Arrays.asList(new String[]{"sareeta","john"}),actual);

    }




}