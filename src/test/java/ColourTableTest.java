import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColourTableTest {

    private ColourTable table;

    @BeforeEach //this is used to signal the annotated method should be executed before each Test method
    public void setUp() {
        table = new ColourTable(3); // Setting up a ColourTable with 4 colors for testing
    }

    @Test
    public void testValidColorTableCreation() {
        assertNotNull(table); //testing if our table is created or not. if Null, display error
    }



}