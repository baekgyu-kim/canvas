package canvas.common.utils;

public class ZorderUtils {
    public int convertZorder(int z_order, int shapes_length){
        return shapes_length - 1 - z_order;
    }
}
