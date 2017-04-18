/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wms;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

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
        con = new WMSConnection();
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
 
        //footer
        Footer foot = new Footer();
        VBox footer = foot.createFooter();
        
        //VBox
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(header, hbox, table, hb, footer);
 
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
        /*
        FilteredList<Produkt> filteredData = new FilteredList<>(data, e-> true);
        searchField.setOnKeyReleased(e ->{
            searchField.textProperty().addListener((observableValue, oldValue, newValue) ->{
                filteredData.setPredicate((Predicate<? super Produkt>) prod->{
                    if(newValue == null || newValue.isEmpty()){
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase();

                    if(prod.getVareId().contains(newValue)){
                        return true;
                    }else if(prod.getVnavn().toLowerCase().contains(newValue)){
                        return true;
                    }else if(prod.getKategori().toLowerCase().contains(newValue)){
                        return true;
                    }else if(prod.getDato().toLowerCase().contains(newValue)){
                        return true;
                    }

                    return false;
                });
            });
            SortedList<Produkt> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(table.comparatorProperty());
            table.setItems(sortedData);*/

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
