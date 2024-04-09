package canvas.controller;
import canvas.model.Model;
import canvas.dto.ShapeStateDto;

public class Controller {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    // 도형을 추가하는 메소드
    public void createShape(ShapeStateDto shapeStateDto) {
        model.createShape(shapeStateDto);
    }

    // 도형의 속성을 변경하는 메소드
    public void updateShape(ShapeStateDto shapeStateDto) {
    }

    // 도형 삭제하는 메소드
    public void deleteShape(ShapeStateDto shapeStateDto){}


}
