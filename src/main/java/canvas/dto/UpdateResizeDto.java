package canvas.dto;

public class UpdateResizeDto implements UpdateDtoInterface {
    private final int newWidth;
    private final int newHeight;

    public UpdateResizeDto(int newWidth, int newHeight) {
        this.newWidth = newWidth;
        this.newHeight = newHeight;
    }

    // Getter 메서드
    public int getNewWidth() {
        return newWidth;
    }

    public int getNewHeight() {
        return newHeight;
    }
}