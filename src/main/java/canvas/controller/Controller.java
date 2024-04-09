package canvas.controller;
import canvas.model.Model;
import canvas.dto.ShapeStateDto;

public class Controller {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    // 도형을 추가하는 메소드
    public void addShape(ShapeStateDto shapeStateDto) {
        model.addShape(shapeStateDto);
    }

    // 도형의 속성을 변경하는 메소드
    public void modifyShape(ShapeStateDto shapeStateDto) {
        // 이 메소드는 Model에서 특정 도형의 상태를 변경하는 로직을 구현해야 합니다.
        // Model의 구현에 따라 도형을 식별하고, 그 상태를 변경하는 방법이 달라질 수 있습니다.
        // 예제 코드에서는 Model의 구체적인 메소드 구현을 보여주지 않았기 때문에, 여기서는 메소드의 시그니처만 제공합니다.
    }
}
