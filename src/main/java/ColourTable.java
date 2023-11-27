import java.util.HashSet;

public class ColourTable {
    private int paletteSize;
    private int[] colorPalette;
    private HashSet<Integer> addedColors;

    public ColourTable(int numberOfColors) throws IllegalArgumentException {
        if (numberOfColors < 2 || numberOfColors > 1024 || (numberOfColors & (numberOfColors - 1)) != 0) {
            throw new IllegalArgumentException("No of colours must be a power of 2 and between 2 and 1024");
        }
        paletteSize = numberOfColors;
        colorPalette = new int[paletteSize];
        addedColors = new HashSet<>();
    }



}

