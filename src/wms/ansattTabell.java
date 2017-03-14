
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
/**
 *
 * @author JørgenH
 */

public class ansattTabell extends Application {
 
    private TableView table = new TableView();
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setMinWidth(805);
        stage.setHeight(500);
        
 
        final Label label = new Label("Ansatte");
        label.setFont(new Font("Arial", 20));
        
        table.setEditable(true);
 
        TableColumn ansattNrCol = new TableColumn("Ansatt nr");
        TableColumn nameCol = new TableColumn("Navn");
        TableColumn stillingCol = new TableColumn("Stilling");
        TableColumn avdelingCol = new TableColumn("Avdeling");
        TableColumn epostCol = new TableColumn("E-post");
        TableColumn tlfCol = new TableColumn("Telefon"); 
        
        table.getColumns().addAll(ansattNrCol, nameCol, stillingCol, avdelingCol, epostCol, tlfCol);
        
        ScrollPane sp = new ScrollPane();
        sp.setContent(table);
        sp.setPrefSize(500, 340);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        
        Button tilbakeButton = new Button();
        tilbakeButton.setText("Tilbake");
        tilbakeButton.setPrefSize(150, 20);
        tilbakeButton.setOnAction((ActionEvent event) -> {
            System.out.println("Tilbake!");
        });
        
        
        Button nyAnsattButton = new Button();
        nyAnsattButton.setText("Ny Ansatt");
        nyAnsattButton.setPrefSize(150, 20);
        nyAnsattButton.setOnAction((ActionEvent event) -> {
            System.out.println("Legg til ny ansatt!");
        });
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, sp, nyAnsattButton, tilbakeButton);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
        
 
        stage.setScene(scene);
        stage.show();
    }
}