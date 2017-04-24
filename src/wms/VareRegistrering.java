/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wms;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.Order;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    private static getJSON erp;

    private final HBox hbh;
    private final ArrayList<Ordre> ordrer;

    public VareRegistrering() throws Exception {
        getJSON erp = new getJSON();
        ordrer = new ArrayList<>();
        for (Order ord : erp.getAllOrders()) {
            int id = ord.getCustomerID();

            ordrer.add(new Ordre(ord.getOrderID(),erp.getCustomer(id).getName(),null,ord.getPlacedDate(),null,ord.getEmployeeID()));

        }
        con = new WMSConnection();

        this.table = new TableView<>();
        this.data = FXCollections.observableArrayList(ordrer);

        this.hb = new HBox();
        this.hbh = new HBox();
    }

    public Scene getScene(Stage stage) throws Exception {
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
        TableColumn kunde = setTableColumn("Kunde", 100, "butikk");
        TableColumn vekt = setTableColumn("AnsattNr", 100, "ansatt");
        TableColumn dato = setTableColumn("Laget Dato", 100, "dato");
        TableColumn antall = setTableColumn("Sent Dato", 100, "null");
        TableColumn plassering = setTableColumn("Antall Varer", 100, "antall");

        TableColumn col_action = new TableColumn<>("Action");
        
        table.setItems(data);

        table.getColumns().addAll(ordreNummer, kunde, vekt, dato, antall, plassering);

        table.setRowFactory(new Callback<TableView<Ordre>, TableRow<Ordre>>() {
            @Override
            public TableRow<Ordre> call(TableView<Ordre> tableView) {
                final TableRow<Ordre> row = new TableRow<>();
                final ContextMenu contextMenu = new ContextMenu();
                final MenuItem removeMenuItem = new MenuItem("Slett");
                final MenuItem newWindow = new MenuItem("Åpne");
                removeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        table.getItems().remove(row.getItem());
                    }
                });
                newWindow.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            OrderTable o = new OrderTable();
                            o.getScene(stage);
                        }
                        catch (Exception ex){

                        }
                    }
                });
                contextMenu.getItems().add(removeMenuItem);
                // Set context menu on row, but use a binding to make it only show for non-empty rows:
                row.contextMenuProperty().bind(
                        Bindings.when(row.emptyProperty())
                                .then((ContextMenu)null)
                                .otherwise(contextMenu)
                );
                return row ;
            }
        });

        //button
        Button saveButton = new Button("Lagre");
        saveButton.setOnAction((ActionEvent e) -> {

        });

        Button backButton = new Button("Tilbake");
        backButton.setPrefSize(150, 20);
        backButton.setOnAction((ActionEvent b) -> {
            WMS w;
            try {
                w = new WMS();
                w.getScene(stage);
            } catch (Exception ex) {
                Logger.getLogger(VareRegistrering.class.getName()).log(Level.SEVERE, null, ex);
            }

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
     *
     * @param title, title of column
     * @param minwidth, width of column
     * @param value, same as in Vare class variable
     * @return tblCol, a table column
     */
    public TableColumn setTableColumn(String title, int minwidth, String value) {
        TableColumn tblCol = new TableColumn(title);
        tblCol.setMinWidth(minwidth);
        tblCol.setCellValueFactory(
                new PropertyValueFactory<>(value));

        return tblCol;
    }

}
