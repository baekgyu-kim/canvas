package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;

public class MovePropertyDto extends PropertyDtoAbstractClass {
    public MovePropertyDto(Integer newX, Integer newY) {
        this.xPos = newX;
        this.yPos = newY;
    }
}
