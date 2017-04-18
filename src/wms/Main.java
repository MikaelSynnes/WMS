package wms;

/**
 * Created by Computer on 27.03.2017.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application
{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Innloggingsportal innloggingsportal = new Innloggingsportal();
        //HistorikkTabell hist = new HistorikkTabell();

        Scene scene = innloggingsportal.getScene(primaryStage);
        primaryStage.setScene(scene);
    }




}
