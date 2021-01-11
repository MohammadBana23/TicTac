package Active;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyGame extends Application {
    @Override
    public void start(Stage primaryStage) {
        MyCodeHandel myCodeHandel= new MyCodeHandel();
        Scene scene = new Scene(myCodeHandel.getRoot(),990,800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe game!");
        primaryStage.show();
    }
}
