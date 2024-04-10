package canvas.controller;
import canvas.model.Model;
import canvas.dto.ShapeDto;
import canvas.model.shape.Shape;

public class Controller {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    // 도형을 추가하는 메소드
    public void createShape(ShapeDto shapeDto) {
        model.createShape(shapeDto);
    }

    // 도형의 속성을 변경하는 메소드
    public void updateShape(int index, ShapeDto shapeDto) {
        model.updateShape(index, shapeDto);
    }

    // 도형 삭제하는 메소드
    public void deleteShape(int index){
        model.deleteShape(index);
    }

}
