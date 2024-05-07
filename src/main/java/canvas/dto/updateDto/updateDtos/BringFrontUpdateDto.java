package canvas.dto.updateDto.updateDtos;

import canvas.dto.updateDto.UpdateDtoAbstractClass;

import java.awt.*;

public class BringFrontUpdateDto extends UpdateDtoAbstractClass {
    public BringFrontUpdateDto(int xPos, int yPos, int width, int height, Color color, int opacity, int zOrder, boolean shadow, boolean frame) {
        super(xPos, yPos, width, height, color, opacity, zOrder, shadow, frame);
    }
}
