package Active;

import com.sun.javafx.css.Size;
import com.sun.scenario.effect.impl.state.BoxRenderState;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import static javafx.scene.paint.Color.*;

public class MyCodeHandel {
    private int tern = 0;
    private final Pane _root;
    private final Button[] buttons = new Button[9];
    private Label WhoseWin;
    private Boolean IsWinner = false;

    public MyCodeHandel() {
        _root = new Pane();
        for (int i = 0; i < 9; i++) {
            buttons[i] = new Button();
        }
        buttons[0].setLayoutX(0);
        buttons[0].setLayoutY(0);
        buttons[1].setLayoutX(234);
        buttons[1].setLayoutY(0);
        buttons[2].setLayoutX(468);
        buttons[2].setLayoutY(0);
        buttons[3].setLayoutX(0);
        buttons[3].setLayoutY(200);
        buttons[4].setLayoutX(234);
        buttons[4].setLayoutY(200);
        buttons[5].setLayoutX(468);
        buttons[5].setLayoutY(200);
        buttons[6].setLayoutX(0);
        buttons[6].setLayoutY(400);
        buttons[7].setLayoutX(234);
        buttons[7].setLayoutY(400);
        buttons[8].setLayoutX(468);
        buttons[8].setLayoutY(400);
        MyBackground myBackground = new MyBackground();
        _root.getChildren().add(myBackground.setBackground());

        for (int i = 0; i < 9; i++) {
            buttons[i].setOnMouseClicked(new clickHandler(buttons[i]));
            buttons[i].setMinWidth(234);
            buttons[i].setMinHeight(200);
            buttons[i].setBorder(new Border(new BorderStroke(BLACK, BorderStrokeStyle.SOLID, null, BorderWidths.DEFAULT)));
        }
        for (int i = 0; i < 9; i++) {
            _root.getChildren().add(buttons[i]);
        }
    }

    public void checkWinner() {
        Line line;
        if (buttons[0].getText().equals(buttons[1].getText()) && buttons[1].getText().equals(buttons[2].getText()) && !buttons[0].getText().equals("")) {

            line = new Line(0, 100, 702, 100);
            line.setStrokeWidth(10);
            buttons[0].setTextFill(BLACK);
            buttons[1].setTextFill(BLACK);
            buttons[2].setTextFill(BLACK);
            _root.getChildren().addAll(line);
            IsWinner = true;
            buttonDisable();
        } else if (buttons[3].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[5].getText()) && !buttons[3].getText().equals("")) {

            line = new Line(0, 300, 702, 300);
            line.setStrokeWidth(10);
            buttons[3].setTextFill(BLACK);
            buttons[4].setTextFill(BLACK);
            buttons[5].setTextFill(BLACK);
            _root.getChildren().addAll(line);
            IsWinner = true;
            buttonDisable();
        } else if (buttons[6].getText().equals(buttons[7].getText()) && buttons[7].getText().equals(buttons[8].getText()) && !buttons[6].getText().equals("")) {

            line = new Line(0, 500, 702, 500);
            line.setStrokeWidth(10);
            buttons[6].setTextFill(BLACK);
            buttons[7].setTextFill(BLACK);
            buttons[8].setTextFill(BLACK);
            _root.getChildren().addAll(line);
            IsWinner = true;
            buttonDisable();
        } else if (buttons[0].getText().equals(buttons[3].getText()) && buttons[3].getText().equals(buttons[6].getText()) && !buttons[0].getText().equals("")) {

            line = new Line(117, 0, 117, 600);
            line.setStrokeWidth(10);
            buttons[0].setTextFill(BLACK);
            buttons[3].setTextFill(BLACK);
            buttons[6].setTextFill(BLACK);
            _root.getChildren().addAll(line);
            IsWinner = true;
            buttonDisable();
        } else if (buttons[1].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[7].getText()) && !buttons[1].getText().equals("")) {

            line = new Line(351, 0, 351, 600);
            line.setStrokeWidth(10);
            buttons[4].setTextFill(BLACK);
            buttons[1].setTextFill(BLACK);
            buttons[7].setTextFill(BLACK);
            _root.getChildren().addAll(line);
            IsWinner = true;
            buttonDisable();
        } else if (buttons[2].getText().equals(buttons[5].getText()) && buttons[5].getText().equals(buttons[8].getText()) && !buttons[2].getText().equals("")) {

            line = new Line(585, 0, 585, 600);
            line.setStrokeWidth(10);
            buttons[5].setTextFill(BLACK);
            buttons[8].setTextFill(BLACK);
            buttons[2].setTextFill(BLACK);
            _root.getChildren().addAll(line);
            IsWinner = true;
            buttonDisable();
        } else if (buttons[0].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[8].getText()) && !buttons[0].getText().equals("")) {

            line = new Line(0, 0, 702, 600);
            line.setStrokeWidth(10);
            buttons[0].setTextFill(BLACK);
            buttons[4].setTextFill(BLACK);
            buttons[8].setTextFill(BLACK);
            _root.getChildren().addAll(line);
            IsWinner = true;
            buttonDisable();
        } else if (buttons[2].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[6].getText()) && !buttons[2].getText().equals("")) {

            line = new Line(702, 0, 0, 600);
            line.setStrokeWidth(10);
            buttons[4].setTextFill(BLACK);
            buttons[6].setTextFill(BLACK);
            buttons[2].setTextFill(BLACK);
            _root.getChildren().addAll(line);
            IsWinner = true;
            buttonDisable();
        } else {
            IsDraw();
        }
    }

    public void buttonDisable() {
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                buttons[i].setDisable(true);
            }
        }
        if (tern == 1) {
            WhoseWin = new Label("Player X Is Winner!");
        } else {
            WhoseWin = new Label("Player O Is Winner!");
        }
        WhoseWin.setLayoutX(230);
        WhoseWin.setLayoutY(650);
        WhoseWin.setFont(Font.font(60));
        WhoseWin.setTextFill(BLACK);
        WhoseWin.setBackground(new Background(new BackgroundFill(WHITE, null, null)));
        _root.getChildren().add(WhoseWin);
    }

    public void IsDraw() {
        int counter = 0;
        for (int i = 0; i < 9; i++) {
            if (!buttons[i].getText().equals("")) {
                counter++;
            }
        }
        if (counter == 9 && IsWinner.equals(false)) {
            WhoseWin = new Label("This game don't have winner!");
            WhoseWin.setLayoutX(230);
            WhoseWin.setLayoutY(650);
            WhoseWin.setFont(Font.font(45));
            WhoseWin.setTextFill(BLACK);
            WhoseWin.setBackground(new Background(new BackgroundFill(WHITE, null, null)));
            _root.getChildren().add(WhoseWin);

        }
    }

    public class clickHandler implements EventHandler<MouseEvent> {
        private final Button index;

        public clickHandler(Button button) {
            index = button;
        }

        @Override
        public void handle(MouseEvent event) {
            if (index.getText().equals("")) {
                if (tern == 0) {
                    index.setText("X");
                    index.setTextFill(RED);
                    index.setFont(Font.font(90));
                    tern = 1;

                } else if (tern == 1) {
                    index.setText("O");
                    index.setTextFill(BLUE);
                    index.setFont(Font.font(90));
                    tern = 0;
                }
            }
            checkWinner();
        }
    }

    public Pane getRoot() {
        return _root;
    }
}
