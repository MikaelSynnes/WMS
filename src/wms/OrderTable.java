package wms;

import database.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Kristian on 24.04.2017.
 */
public class OrderTable {
    private final TableView<Order> table;
    private final ObservableList<Order> data;
    private WMSConnection con;
    private getJSON erp;

    public  OrderTable() throws Exception{
        getJSON erp = new getJSON();
        this.con = new WMSConnection();
        table = new TableView<>();
        this.data = FXCollections.observableArrayList(erp.getAllOrders());
    }

    public Scene getScene(Stage stage){
        Scene scene = new Scene(new Group());


        //header
        Header head = new Header("Ordre");
        Label header = head.createHeader();

        //searchfield
        TextField searchField = new TextField();


        //table column
        TableColumn ordreNummer = setTableColumn("Ordrenummer", 100, "orderID");
        TableColumn kunde = setTableColumn("KundeNr", 100, "customerID");
        TableColumn vekt = setTableColumn("AnsattNr", 100, "employeeID");
        TableColumn dato = setTableColumn("Laget Dato", 100, "placedDate");
        TableColumn antall = setTableColumn("Sent Dato", 100, "antall");
        TableColumn plassering = setTableColumn("Antall Varer", 100, "quantity");


        TableColumn col_action = new TableColumn<>("Action");


        table.setItems(data);

        table.getColumns().addAll(ordreNummer, kunde, vekt, dato, antall, plassering);

        //footer
        Footer foot = new Footer();
        VBox footer = foot.createFooter();

        //VBox
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(header, table, footer);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);


        double minWidth;
        double minHeight;

        stage.setTitle("Ordre");
        stage.setScene(scene);
        stage.show();

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
