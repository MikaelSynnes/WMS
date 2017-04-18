package wms;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.awt.*;

/**
 * Created by Kristian on 17.04.2017.
 */
public class HistorikkTabell {
    private final TableView<Historikk> table;
   // private final ObservableList<Historikk> data;
    private WMSConnection con;
    private final HBox hb;

    public HistorikkTabell(){
        con = new WMSConnection();
        this.table = new TableView<>();
        //this.data = FXCollections.observableArrayList(con.getHistorikk());
        this.hb = new HBox();
    }

    public Scene getScene(Stage stage){
        Scene scene = new Scene((new Group()));

        Header head = new Header("Historikk");
        Label header = head.createHeader();

        //searchfield
        TextField searchField = new TextField();
        HBox hbox = new HBox();
        Button searchBtn = new Button("Søk");
        hbox.getChildren().addAll(searchField, searchBtn);
        hbox.setSpacing(10);

        //table column
        TableColumn dato = setTableColumn("Dato", 100, "dato");
        TableColumn plassering = setTableColumn("Plassering", 100, "plassering");
        TableColumn vareId = setTableColumn("Vare Id", 100, "vareId");
        TableColumn ordreId = setTableColumn("Ordre Id", 100, "ordreId");

        TableColumn col_action = new TableColumn<>("Action");



        table.getColumns().addAll(dato, plassering, vareId, ordreId);

        Button backButton = new Button("Tilbake");
        backButton.setPrefSize(150, 20);
        backButton.setOnAction((ActionEvent b)->{
            WMS w = new WMS();
            w.getScene(stage);
        });

        //buttonbox
        hb.getChildren().addAll(backButton);
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

        stage.setTitle("Historikk Tabell");
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
