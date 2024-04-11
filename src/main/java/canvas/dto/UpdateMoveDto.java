package canvas.dto;

public class UpdateMoveDto implements UpdateDtoInterface{

    private int newXPos;
    private int newYPos;
    public UpdateMoveDto(int newXPos, int newYPos) {
        this.newXPos = newXPos;
        this.newYPos = newYPos;
    }
    public int getNewXPos() {
        return newXPos;
    }

    public int getNewYPos() {
        return newYPos;
    }
}
