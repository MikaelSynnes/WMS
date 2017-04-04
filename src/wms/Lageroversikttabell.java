package wms;/**
 * Created by aleksander on 3/14/17.
 */

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Lageroversikttabell
{


    private final TableView<Produkt> table;
    private final ObservableList<Produkt> data;
    private final WMSConnection con;
    final HBox hb;
    final HBox hbox;
    final HBox lhb;


    public Lageroversikttabell() {
        this.con = new WMSConnection();

        this.hb = new HBox();
        this.hbox = new HBox();
        this.lhb = new HBox();
        this.data = FXCollections.observableArrayList(con.getProdukt());
        this.table = new TableView<>();
    }


    public Scene getScene(Stage stage)
    {
        Scene scene = new Scene(new Group());
        stage.setTitle("Lager oversikt");


        final Label label = new Label("Lager oversikt");
        label.setFont(new Font("Arial", 20));


        TextField textField = new TextField();
        textField.setMaxWidth(130);
        //textField.setOnKeyReleased(event -> search(textField.getText()));

        // Knapp for tilbakestilling av søk
        Button resetButton = new Button("Tilbakestill søk");
        resetButton.setOnAction((ActionEvent event) ->
        {
            table.setItems(data);
            textField.clear();
        });

        table.setEditable(true);

        //kollonner
        TableColumn vareNummer = setTableColumn("Varenummer", 125, "vareId");
        TableColumn beskrivelse = setTableColumn("Beskrivelse", 125, "Vnavn");
        TableColumn type = setTableColumn("Type",125,"type");
        TableColumn antall = setTableColumn("Kategori",125,"kategori");
        TableColumn plassering = setTableColumn("Plassering",125,"plassering");
        TableColumn dato = setTableColumn("Dato",125,"dato");


        table.setItems(data);
        table.getColumns().addAll(vareNummer, beskrivelse, type, antall, plassering, dato);

        //tilbake kanpp
        final Button tilbake = new Button("Tilbake");
        tilbake.setPrefSize(150, 20);

        tilbake.setOnAction((ActionEvent e) ->
        {
            WMS w = new WMS();
            w.getScene(stage);
        });
        hb.getChildren().addAll(tilbake);

        // legg til labels
        final TextField addVareNummer = new TextField();
        addVareNummer.setPromptText("Varenummer");
        addVareNummer.setMaxWidth(110);

        final TextField addBeskrivelse = new TextField();
        addBeskrivelse.setPromptText("Beskrivelse");
        addBeskrivelse.setMaxWidth(110);

        final TextField addType = new TextField();
        addType.setPromptText("Type");
        addType.setMaxWidth(110);

        final TextField addAntall = new TextField();
        addAntall.setPromptText("Antall");
        addAntall.setMaxWidth(110);

        final TextField addPlassering = new TextField();
        addPlassering.setPromptText("Plassering");
        addPlassering.setMaxWidth(110);


        final TextField addDato = new TextField();
        addDato.setPromptText("Dato");
        addDato.setMaxWidth(110);

        // legg til knapp
        final Button addButton = new Button("Legg til");




      /*  addButton.setOnAction(new EventHandler<ActionEvent>() {

        {

            @Override
            public void handle(ActionEvent e)
            {
                data.add(new Vare3(
                        addVareNummer.getText(),
                        addBeskrivelse.getText(),
                        addType.getText(),
                        addAntall.getText(),
                        addPlassering.getText(),
                        addDato.getText()
                ));
                addVareNummer.clear();
                addBeskrivelse.clear();
                addType.clear();
                addAntall.clear();
                addPlassering.clear();
                addDato.clear();
            }
        });*/


        lhb.getChildren().addAll(addVareNummer, addBeskrivelse, addType, addAntall, addPlassering, addDato, addButton);


        lhb.setSpacing(3);

        hbox.setSpacing(5);

        hbox.getChildren().addAll(textField, resetButton);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, hbox, table, lhb, hb);

        hb.setAlignment(Pos.BASELINE_LEFT);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);

        stage.show();
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());

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


  /*  // TODO: Abstrahere ut søkefunksjonen i egen klasse
    private void search(String searchStr)
    {
        ObservableList<Vare3> foundItems = FXCollections.observableArrayList();
        for (Vare3 vare : data)
        {
            if ((vare.getBeskrivelse().toLowerCase().contains(searchStr)) && !foundItems.contains(vare))
            {
                foundItems.add(vare);
            }
            else if ((vare.getPlassering().toLowerCase().contains(searchStr)) && !foundItems.contains(vare))
            {
                foundItems.add(vare);
            }
            else if ((vare.getType().toLowerCase().contains(searchStr)) && !foundItems.contains(vare))
            {
                foundItems.add(vare);
            }
            else if ((vare.getDato().toLowerCase().contains(searchStr)) && !foundItems.contains(vare))
            {
                foundItems.add(vare);
            }
        }

        table.setItems(foundItems);

        if (foundItems.isEmpty())
        {
            table.setPlaceholder(new Label("Beklager, fant ingenting for søket " + "'" + searchStr + "'"));
        }
    }*/

}
