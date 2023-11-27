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

    private boolean isValidRGB(int color) { // This is checking if a particular 24-bit RGB color is valid for the table
        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = color & 0xFF;
        return red >= 0 && red <= 255 && green >= 0 && green <= 255 && blue >= 0 && blue <= 255;
    }


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

    public int getAddedColorsSize() {
        return addedColors.size();
    }




}

