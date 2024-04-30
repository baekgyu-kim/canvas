package canvas.common.utils;

public class ColorUtils {
    public static class Color {
        public int r, g, b;
        public Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }
    public static Color getOppositeColor(int r, int g, int b) {
        return new Color(255 - r, 255 - g, 255 - b);
    }
}
