import java.util.HashSet; //importing hashset

public class ColourTable { //initiating class ColourTable

    //setting scope of variables
    private int paletteSize;
    private int[] colorPalette;
    private HashSet<Integer> addedColors; //storing colors in a hash set

    //creating main structure to set table size
    public ColourTable(int numberOfColors) throws IllegalArgumentException { // throw exception if trying to add no less than 2 or greater than 1024 and other than power of 2
        if (numberOfColors < 2 || numberOfColors > 1024 || (numberOfColors & (numberOfColors - 1)) != 0) {
            throw new IllegalArgumentException("No of colours must be a power of 2 and between 2 and 1024");
        }
        paletteSize = numberOfColors;
        colorPalette = new int[paletteSize];
        addedColors = new HashSet<>();
    }

   //creating method to check whether color added is valid 24 bit RGB or not
    private boolean isValidRGB(int color) {
        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = color & 0xFF;
        int additional = color & 0xFF000000 ; // Masking off bits above the 24-bit range

        return additional == 0 && red >= 0 && red <= 255 && green >= 0 && green <= 255 && blue >= 0 && blue <= 255;
    }



    //creating method add to add the specfied color.
    public void add(int rgbColor) throws IllegalStateException, IllegalArgumentException {
        if (addedColors.size() >= paletteSize) {
            throw new IllegalStateException("Exceeded capacity of the ColourTable");
        }
        if (!isValidRGB(rgbColor)) {
            throw new IllegalArgumentException("Invalid RGB color value");
        }
        if (!addedColors.contains(rgbColor)) {
            int index = addedColors.size();
            colorPalette[index] = rgbColor;
            addedColors.add(rgbColor);
        }
    }

    //simple method to get size of our hashset
    public int getAddedColorsSize() {
        return addedColors.size();
    }

}

