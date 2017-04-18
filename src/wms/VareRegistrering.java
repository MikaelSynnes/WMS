/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wms;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Kristian
 */
public class VareRegistrering {
    private final TableView<Ordre> table ;
    private final ObservableList<Ordre> data ;
    private WMSConnection con;
    private final HBox hb;
    private final HBox hbh;
    
    public VareRegistrering(){
        this.con = new WMSConnection();
        this.table = new TableView<>();
        this.data = FXCollections.observableArrayList(con.getOrdre());
        this.hb = new HBox();
        this.hbh = new HBox();
    }
    
    public Scene getScene(Stage stage){
        Scene scene = new Scene(new Group());

 
        //header
        Header head = new Header("Vare registrering");
        Label header = head.createHeader();
        
        //searchfield
        TextField searchField = new TextField();
        HBox hbox = new HBox();
        Button searchBtn = new Button("Søk");
        hbox.getChildren().addAll(searchField, searchBtn);
        hbox.setSpacing(10);
 
        //table column
        TableColumn ordreNummer = setTableColumn("Ordrenummer", 100, "ordreId");
        TableColumn butikk = setTableColumn("Butikk", 100, "butikk");
        TableColumn vekt = setTableColumn("Vekt", 100, "vekt");
        TableColumn dato = setTableColumn("Dato", 100, "dato");
        TableColumn antall = setTableColumn("Antall", 100, "antall");
        TableColumn plassering = setTableColumn("Plassering", 100, "plassering");


        TableColumn col_action = new TableColumn<>("Action");

 
        table.setItems(data);
        table.getColumns().addAll(ordreNummer, butikk, vekt, dato, antall, plassering);

        final TextField addOrdreNummer = new TextField();
        addOrdreNummer.setPromptText("Ordrenummer");
        addOrdreNummer.setMaxWidth(ordreNummer.getPrefWidth());

        final TextField addButikk = new TextField();
        addButikk.setMaxWidth(dato.getPrefWidth());
        addButikk.setPromptText("Butikk");
        
        final TextField addVekt = new TextField();
        addVekt.setMaxWidth(vekt.getPrefWidth());
        addVekt.setPromptText("Vekt");
        
        final TextField addDato = new TextField();
        addDato.setMaxWidth(dato.getPrefWidth());
        addDato.setPromptText("Dato");

        final TextField addAntall = new TextField();
        addAntall.setMaxWidth(antall.getPrefWidth());
        addAntall.setPromptText("Antall");

        final TextField addPlassering = new TextField();
        addPlassering.setMaxWidth(plassering.getPrefWidth());
        addPlassering.setPromptText("Plassering");

        final Button addButton = new Button("Registrer");
        addButton.setOnAction(new EventHandler<ActionEvent>()  {
            
            @Override

            public void handle(ActionEvent e) {
                Ordre ordre = new Ordre(
                        
                        addOrdreNummer.getText(),
                        addButikk.getText(),
                        addVekt.getText(),
                        addDato.getText(),
                        addAntall.getText(),
                        addPlassering.getText());
                      
                data.add(ordre);
                con.addOrdre(ordre);
                addOrdreNummer.clear();
                addVekt.clear();
                addDato.clear();
                addAntall.clear();
                addPlassering.clear();
                VareRegistrering t = new VareRegistrering();
                t.getScene(stage);
            }
        });
       
        
        //button
        Button saveButton = new Button("Lagre");
        saveButton.setOnAction((ActionEvent e) -> {
            
         });
        
        Button backButton = new Button("Tilbake");
        backButton.setPrefSize(150, 20);
        backButton.setOnAction((ActionEvent b)->{
            WMS w = new WMS();
            w.getScene(stage);
        });
        
        //buttonbox
        hb.getChildren().addAll(backButton, saveButton);
        hb.setAlignment(Pos.BASELINE_LEFT);
        hb.setSpacing(3);
        hbh.getChildren().addAll(addOrdreNummer, addButikk, addVekt, addDato, addAntall, addPlassering, addButton);
        //footer
        Footer foot = new Footer();
        VBox footer = foot.createFooter();
        
        //VBox
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(header, hbox, table,hbh, hb, footer);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
        
        double minWidth;
        double minHeight;

        stage.setTitle("Vare Registrering");
        stage.setScene(scene);
        stage.show();
               
        //width and height of window
        minWidth = stage.getWidth();
        minHeight = stage.getHeight();
        stage.setWidth(minWidth);
        stage.setHeight(minHeight);
        
        return scene;
    }
    

    /**
     * create tablecolumn for table
     * @param title, title of column 
     * @param minwidth, width of column
     * @param value, same as in Vare class variable
     * @return tblCol, a table column
     */
    public TableColumn setTableColumn(String title, int minwidth, String value){
        TableColumn tblCol = new TableColumn(title);
        tblCol.setMinWidth(minwidth);
        tblCol.setCellValueFactory(
                new PropertyValueFactory<>(value));
        
        return tblCol;
    }
    
}
