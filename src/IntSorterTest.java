 import org.junit.Test;
 import org.junit.Before;
 import static org.junit.Assert.*;
 import org.junit.Rule;
import org.junit.rules.Timeout;

 import static org.hamcrest.MatcherAssert.assertThat;
 import static org.hamcrest.CoreMatchers.*;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;

 /** 
  * Abstract test class for  implementations.
  *
  * Implementing test classes must override the getIntSorter method.
  *
  * @author Simon Larsén
  * @author Tilda Jansson
  * @version 2021-02-28
  */
 public abstract class IntSorterTest {     
     /* An instance of the IntSorter */
     private IntSorter a;

     /* The length of the even length list used in the tests */
     private final int EVEN_LIST_LENGTH = 99999;
     /* The length of the odd length list used in the tests */
     private final int ODD_LIST_LENGTH = 100000;

     /* An array of even length, RANDOM */
     private int[] evenArrayRANDOM;
     /* An array of odd length, RANDOM */
     private int[] oddArrayRANDOM;

     /* An array of even length, ASCENDING */
     private int[] evenArrayASCENDING;
     /* An array of odd length, ASCENDING*/
     private int[] oddArrayASCENDING;

     /* An array of even length, DESCENDING */
     private int[] evenArrayDESCENDING;
     /* An array of odd length, DESCENDING */
     private int[] oddArrayDESCENDING; 
     
     /* An array of even length, EQUAL elements */
     private int[] evenArrayEQUAL;
     /* An array of odd length, EQUAL elements */
     private int[] oddArrayEQUAL;
          
     /**
      * Returns an implementation of the IntSorter interface. Extending classes
      * must override this method.
      *
      * @return An implementation of IntSorter.
      */
     protected abstract IntSorter getIntSorter();

     @Before
     public void setUp() {
        //Arrange
        a = getIntSorter();
        
        evenArrayEQUAL = (new Data(EVEN_LIST_LENGTH, 1, Data.Order.RANDOM)).get();
        oddArrayEQUAL = (new Data(ODD_LIST_LENGTH, 1, Data.Order.RANDOM)).get();
                
        evenArrayRANDOM = (new Data(EVEN_LIST_LENGTH, 100, Data.Order.RANDOM)).get();
        oddArrayRANDOM = (new Data(ODD_LIST_LENGTH, 100, Data.Order.RANDOM)).get();

        evenArrayASCENDING = (new Data(EVEN_LIST_LENGTH, 100, Data.Order.ASCENDING)).get();
        oddArrayASCENDING = (new Data(ODD_LIST_LENGTH, 100, Data.Order.ASCENDING)).get();

        evenArrayDESCENDING = (new Data(EVEN_LIST_LENGTH, 100, Data.Order.DESCENDING)).get();
        oddArrayDESCENDING = (new Data(ODD_LIST_LENGTH, 100, Data.Order.DESCENDING)).get();

    }

    /**
     * Assert that sorting an empty array has no effects.
     */
    @Test
    public void sortHasNoEffectWhenArrayIsEmpty() {
        // Arrange
        int[] emptyArray = (new Data(0, 20, Data.Order.RANDOM)).get();
        // Act
        a.sort(emptyArray);
        // Assert
        assertThat(emptyArray.length, equalTo(0));
    }

    /**
     * Assert that sorting an array with a single element has no effects.
     */
    @Test
    public void sortHasNoEffectWhenArrayHasSingleElement() {
        //Arrange
        int[] SingleElemArray = (new Data(1, 20, Data.Order.RANDOM)).get();
        int[] expected = SingleElemArray.clone();
        //Act 
        a.sort(expected);
        //Assert
        assertThat(expected, equalTo(SingleElemArray));
        
    }

    /**
     * Assert that sorting a multiple even random element array results
     * in a correct ordering of the elements.
     */
    @Test
    public void sortMultipleEvenRandomElementArrayGivesCorrectOrdering() {
        // Arrange
        int[] actual = evenArrayRANDOM;
        int[] expected = actual.clone();
        // Act
        Arrays.sort(expected);
        a.sort(actual);
        // Assert
        assertThat(actual, equalTo(expected));
    }
   
    /**
     * Assert that sorting a multiple odd random element array results in a correct
     * ordering of the elements.
     */
    @Test
    public void sortMultipleOddRandomElementArrayGivesCorrectOrdering() {
        // Arrange
        int[] actual = oddArrayRANDOM;
        int[] expected = actual.clone();
        // Act
        Arrays.sort(expected);
        a.sort(actual);
        // Assert
        assertThat(actual, equalTo(expected));
    }
    
    /**
     * Assert that sorting a multiple even ascending element array results in a correct
     * ordering of the elements.
     */
    @Test
    public void sortMultipleEvenAscendingElementArrayGivesCorrectOrdering() {
        // Arrange
        int[] actual = evenArrayASCENDING;
        int[] expected = actual.clone();
        // Act
        Arrays.sort(expected);
        a.sort(actual);
        // Assert
        assertThat(actual, equalTo(expected));
    }    
    
    /**
     * Assert that sorting a multiple odd ascending element array results in a correct
     * ordering of the elements.
     */
    @Test
    public void sortMultipleOddAscendingElementArrayGivesCorrectOrdering() {
        // Arrange
        int[] actual = oddArrayASCENDING;
        int[] expected = actual.clone();
        // Act
        Arrays.sort(expected);
        a.sort(actual);
        // Assert
        assertThat(actual, equalTo(expected));
    }   
    
    /**
     * Assert that sorting a multiple even descending element array results in a correct
     * ordering of the elements.
     */
    @Test
    public void sortMultipleEvenDescendingElementArrayGivesCorrectOrdering() {
        // Arrange
        int[] actual = evenArrayDESCENDING;
        int[] expected = actual.clone();
        // Act
        Arrays.sort(expected);
        a.sort(actual);
        // Assert
        assertThat(actual, equalTo(expected));
    }  
    
    /**
     * Assert that sorting a multiple odd descending element array results in a correct
     * ordering of the elements.
     */
    @Test
    public void sortMultipleOddDescendingElementArrayGivesCorrectOrdering() {
        // Arrange
        int[] actual = oddArrayDESCENDING;
        int[] expected = actual.clone();
        // Act
        Arrays.sort(expected);
        a.sort(actual);
        // Assert
        assertThat(actual, equalTo(expected));
    }   
    
    /**
     * Assert that sorting an even array with equal elements results in a correct
     * ordering of the elements.
     */
    @Test
    public void sortMultipleEvenEqualElementArrayGivesCorrectOrdering() {
        // Arrange
        int[] actual = evenArrayEQUAL;
        int[] expected = actual.clone();
        // Act
        Arrays.sort(expected);
        a.sort(actual);
        // Assert
        assertThat(actual, equalTo(expected));
    }  
    
    /**
     * Assert that sorting an odd array with equal elements results in a correct
     * ordering of the elements.
     */
    @Test
    public void sortMultipleOddEqualElementArrayGivesCorrectOrdering() {
        // Arrange
        int[] actual = oddArrayEQUAL;
        int[] expected = actual.clone();
        // Act
        Arrays.sort(expected);
        a.sort(actual);
        // Assert
        assertThat(actual, equalTo(expected));
    }     
}
