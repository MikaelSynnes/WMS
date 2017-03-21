package wms;/**
 * Created by aleksander on 3/20/17.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Lageroversikttabell lageroversikttabell = new Lageroversikttabell();
        Innlogingsportal innlogingsportal = new Innlogingsportal();

        Scene scene = lageroversikttabell.getScene(primaryStage);
        primaryStage.setScene(scene);






    }
}
