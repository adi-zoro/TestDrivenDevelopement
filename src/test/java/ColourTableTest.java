import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColourTableTest {

    private ColourTable table;

    @BeforeEach //this is used to signal the annotated method should be executed before each Test method
    public void setUp() {
        table = new ColourTable(4); // Setting up a ColourTable with 4 colors for testing
    }

    @Test //test to see if table is valid or not
    public void testValidColorTableCreation() {
        assertNotNull(table); //testing if our table is created or not. if Null, display error
    }


    @Test //test to check whether illegal argument exceptions are working or not.
    public void testInvalidColorTableCreation() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(13)); // Palette size not a power of two
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(2048)); // Palette size exceeds limit
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1)); // Palette size less than 2
    }


    @Test //tests whether color is being added to table or not
    public void testAddColor() { //
        table.add(0xFF0000); // Adding red color
        assertEquals(1, table.getAddedColorsSize());
    }


    @Test //testing if duplicates are getting counter or not
    public void testAddDuplicateColor() {
        table.add(0x00FF00); // Adding green color
        table.add(0x00FF00); // Adding green color again to check
        assertEquals(1, table.getAddedColorsSize());
    }

    @Test //tests whether different colors are getting counted separately.
    public void testAddValidColors() {
        // Add valid colors
        table.add(0xFF0000); // Red
        table.add(0x00FF00); // Green
        assertEquals(2, table.getAddedColorsSize()); // Check the count of added colors
    }
    

}