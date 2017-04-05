/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wms;

import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
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
    private final TableView<Produkt> table ;
    final ObservableList<Produkt> data ;
    final ObservableList<Vare> data2 = FXCollections.observableArrayList();
    private WMSConnection con;
    final HBox hb;
    TextField searchField;
    
    public VareRegistrering(){
        con = new WMSConnection();
        this.table = new TableView<>();
        this.data = FXCollections.observableArrayList(con.getProdukt());
        this.hb = new HBox();
    }
    
    public Scene getScene(Stage stage){
        Scene scene = new Scene(new Group());

 
        //header
        Header head = new Header("Vare registrering");
        Label header = head.createHeader();
        
        //searchfield
        searchField = new TextField();
        HBox hbox = new HBox();
        Button searchBtn = new Button("Søk");
        hbox.getChildren().addAll(searchField, searchBtn);
        hbox.setSpacing(10);
 
        //table column
        TableColumn vareNummer = setTableColumn("Varenummer", 100, "VareId");
        TableColumn navn = setTableColumn("Navn", 100, "Vnavn");
        TableColumn kategori = setTableColumn("Kategori", 100, "Kategori");
        TableColumn antall = setTableColumn("Antall", 100, "antall");
        TableColumn mottaker = setTableColumn("Mottaker", 100, "mottaker");
        TableColumn plassering = setTableColumn("Plassering", 100, "plassering");
        TableColumn dato = setTableColumn("Dato", 100, "dato");
 
        table.setItems(data);
        table.getColumns().addAll(vareNummer, navn, kategori, antall, mottaker, plassering, dato);
 
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
            table.setItems(sortedData);
        });
        
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
