 import org.junit.Test;
 import org.junit.After;
 import org.junit.Before;
 import static org.junit.Assert.*;

 import static org.hamcrest.MatcherAssert.assertThat;
 import static org.hamcrest.CoreMatchers.*;

/**
 * The test class for QuicksortFixedPivot class.
 *
 * @author  Tilda Jansson
 * @version 2021-02-28
 */
public class QuicksortFixedPivotTest extends IntSorterTest
{
    
    /**
     * Returns an implementation of the IntSorter interface. 
     *
     * @return An implementation of IntSorter.
     */
    protected IntSorter getIntSorter(){
        return new QuicksortFixedPivot();
    }

    @Override
    @Before
    public void setUp()
    {
        super.setUp();
    }

}
