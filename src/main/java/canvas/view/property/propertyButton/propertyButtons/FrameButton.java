package canvas.view.property.propertyButton.propertyButtons;

import canvas.controller.Controller;
import canvas.controller.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.controller.dto.propertyDto.propertyDtos.FramePropertyDto;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FrameButton extends PropertyButton {
    private Boolean hasFrame = null;
    private JRadioButton activateFrameButton;
    private JRadioButton deactivateFrameButton;

    public FrameButton(ShapeComposite shapeComposite, Controller controller) {
        super(shapeComposite, controller);
        initializeButton("Frame Effect");

        // 라디오 버튼 초기화
        activateFrameButton = new JRadioButton("Activate frame effect");
        deactivateFrameButton = new JRadioButton("Deactivate frame effect");

        // ButtonGroup을 사용하여 두 버튼이 한 그룹에 속하도록 설정
        ButtonGroup group = new ButtonGroup();
        group.add(activateFrameButton);
        group.add(deactivateFrameButton);

        // 버튼에 ActionListener 추가
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 라디오 버튼 패널 생성
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.add(activateFrameButton);
                panel.add(deactivateFrameButton);

                // 라디오 버튼 상태 설정
                setRadioButtonState();

                // 팝업 창으로 라디오 버튼 패널 표시
                int result = JOptionPane.showConfirmDialog(null, panel, "Frame", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                // OK 버튼을 누르면 상태 업데이트
                if (result == JOptionPane.OK_OPTION) {
                    if (activateFrameButton.isSelected()) {
                        hasFrame = true;
                    } else if (deactivateFrameButton.isSelected()) {
                        hasFrame = false;
                    }
                    createPropertyDto(hasFrame);
                }
            }
        });
    }

    public void createPropertyDto(Boolean newFrame) {
        if (shapeComposite == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        }
        PropertyDtoAbstractClass frameDto = new FramePropertyDto(shapeComposite, newFrame);
        controller.updateShape(shapeComposite, frameDto);
    }

    @Override
    public void updateClickedShapes(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
        if (shapeComposite == null) {
            throw new NullPointerException("shapeComposite is null");
        }
        if (shapeComposite.shapesCount() == 1) {
            this.hasFrame = shapeComposite.getChildren().get(0).getFrame();
        } else {
            this.hasFrame = null;
        }
        setRadioButtonState();
    }

    @Override
    public void updateAllShapes(List<ShapeAbstractClass> shapes) {
        if (shapeComposite != null && shapeComposite.shapesCount() == 1) {
            this.hasFrame = shapeComposite.getChildren().get(0).getFrame();
        } else {
            this.hasFrame = null;
        }
        setRadioButtonState();
    }

    private void setRadioButtonState() {
        if (hasFrame == null) {
            activateFrameButton.setSelected(false);
            deactivateFrameButton.setSelected(false);
        } else if (hasFrame) {
            activateFrameButton.setSelected(true);
        } else {
            deactivateFrameButton.setSelected(true);
        }
    }
}
