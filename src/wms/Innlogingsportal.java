package wms;/**
 * Created by aleksander on 3/20/17.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Innlogingsportal {


    public Scene getScene(Stage primaryStage)
    {
        primaryStage.setTitle("Innlogging");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Button btn = new Button("Logg inn");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1 ,6);

        Scene scene = new Scene(grid, 400, 275);

        Text scenetitle = new Text("Innlogging");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Brukernavn:");
        grid.add(userName, 0 , 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label password = new Label("Passord:");
        grid.add(password, 0 ,2);

        PasswordField passwordBox = new PasswordField();
        grid.add(passwordBox, 1, 2);


        btn.setOnAction((ActionEvent e)->{
            WMS w = new WMS();
        w.start(primaryStage);});




        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setWidth(primaryStage.getWidth());
        primaryStage.setHeight(primaryStage.getHeight());

        return scene;
    }
}
