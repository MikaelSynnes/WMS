package wms;


import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class VareReg extends Application {
 
    private final TableView<Vare> table = new TableView<>();
    private final ObservableList<Vare> data =
            FXCollections.observableArrayList(new Vare(1,1,1,"A", "B","C"));
    final HBox hb = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());

 
        //header
        Header head = new Header("Vare registrering");
        Label header = head.createHeader();
 
        //table column
        TableColumn vareNummer = new TableColumn("Varenummer");
        vareNummer.setMinWidth(100);
        vareNummer.setCellValueFactory(
                new PropertyValueFactory<>("varenummer"));
 
        TableColumn ordreNummer = new TableColumn("Ordrenummer");
        ordreNummer.setMinWidth(100);
        ordreNummer.setCellValueFactory(
                new PropertyValueFactory<>("ordrenummer"));
        
        TableColumn antall = new TableColumn("Antall");
        antall.setMinWidth(100);
        antall.setCellValueFactory(
                new PropertyValueFactory<>("antall"));
        
        TableColumn mottaker = new TableColumn("Mottaker");
        mottaker.setMinWidth(100);
        mottaker.setCellValueFactory(
                new PropertyValueFactory<>("mottaker"));
        
        TableColumn plassering = new TableColumn("Plassering");
        plassering.setMinWidth(100);
        plassering.setCellValueFactory(
                new PropertyValueFactory<>("plassering"));
        
        TableColumn dato = new TableColumn("Dato");
        dato.setMinWidth(100);
        dato.setCellValueFactory(
                new PropertyValueFactory<>("dato"));
 
        table.setItems(data);
        table.getColumns().addAll(vareNummer, ordreNummer, antall, mottaker, plassering, dato);
 
        //button
        /*final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            data.add(new Vare(2,2,2,"Y","Z","X"));
         });
 
        hb.getChildren().addAll(addButton);
        hb.setSpacing(3);*/
 
        Footer foot = new Footer();
        Label footer = foot.createFooter();
        
        //VBox
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(header, table, footer);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
        
        double minWidth;
        double minHeight;
        
        stage.setTitle("Vare Registrering");
        stage.setScene(scene);
        stage.show();
        minWidth = stage.getWidth();
        minHeight = stage.getHeight();
        stage.setWidth(minWidth);
        stage.setHeight(minHeight);
    }
 

} 