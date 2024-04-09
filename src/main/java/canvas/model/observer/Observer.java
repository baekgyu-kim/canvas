package canvas.model.observer;

import canvas.dto.ShapeStateDto;

import java.util.List;

// MVC에서 View가 Observer
public interface Observer {
    void update(List<ShapeStateDto> shapes);
}