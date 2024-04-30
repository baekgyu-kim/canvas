package canvas.common.utils;

public class colorUtils {
    public static String getOppositeColor(String hexColor) {
        int r = Integer.parseInt(hexColor.substring(0, 2), 16);
        int g = Integer.parseInt(hexColor.substring(2, 4), 16);
        int b = Integer.parseInt(hexColor.substring(4, 6), 16);
        r = 255 - r;
        g = 255 - g;
        b = 255 - b;

        return String.format("%02X%02X%02X", r, g, b);
    }
}
