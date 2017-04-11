package wms;


import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class tableAnsatt
{

    private final TableView<Ansatt> table;
    private final ObservableList<Ansatt> data;
    private WMSConnection con;
    final HBox hb;

    public tableAnsatt()
    {
        con = new WMSConnection();
        this.table = new TableView<Ansatt>();
        this.data = FXCollections.observableArrayList(con.getAnsatte());
        this.hb = new HBox();

    }


    public Scene getScene(Stage stage)
    {
        Scene scene = new Scene(new Group());
        stage.setTitle("Ansatt-tabell");


        Header head = new Header("Ansatt-tabell");
        Label label = head.createHeader();

        Label sokLabel = new Label("Søk: ");
        sokLabel.setFont(Font.font("Arial", 15));
        TextField sokFunksjon = new TextField();
        sokFunksjon.setOnKeyReleased(event -> search(sokFunksjon.getText()));
        Button resetButton = new Button("Tilbakestill søk");
        resetButton.setOnAction((ActionEvent event) ->
        {
            table.setItems(data);
            sokFunksjon.clear();
            sokFunksjon.requestFocus();
        });

        Button tilbakeButton = new Button();
        tilbakeButton.setText("Tilbake");
        tilbakeButton.setPrefSize(150, 20);
        tilbakeButton.setOnAction((ActionEvent event) ->
        {
            WMS w = new WMS();
            w.getScene(stage);
        });

        table.setEditable(true);
        Callback<TableColumn, TableCell> cellFactory =
                p -> new EditingCell();

        TableColumn ansattNrCol = new TableColumn("Ansattnr");
        ansattNrCol.setMinWidth(100);
        ansattNrCol.setCellValueFactory(
                new PropertyValueFactory<Ansatt, String>("AnsattID"));
        ansattNrCol.setCellFactory(cellFactory);
        ansattNrCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Ansatt, String>>()
                {
                    @Override
                    public void handle(CellEditEvent<Ansatt, String> t)
                    {
                        ((Ansatt) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setAnsattId(t.getNewValue());
                    }
                }
        );


        TableColumn navnCol = new TableColumn("Fornavn");
        navnCol.setMinWidth(100);
        navnCol.setCellValueFactory(
                new PropertyValueFactory<Ansatt, String>("Fornavn"));
        navnCol.setCellFactory(cellFactory);
        navnCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Ansatt, String>>()
                {
                    @Override
                    public void handle(CellEditEvent<Ansatt, String> t)
                    {
                        ((Ansatt) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setFornavn(t.getNewValue());
                    }
                }
        );

        TableColumn stillingCol = new TableColumn("Stilling");
        stillingCol.setMinWidth(30);
        stillingCol.setCellValueFactory(
                new PropertyValueFactory<Ansatt, String>("Stilling"));
        stillingCol.setCellFactory(cellFactory);
        stillingCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Ansatt, String>>()
                {
                    @Override
                    public void handle(CellEditEvent<Ansatt, String> t)
                    {
                        ((Ansatt) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setStilling(t.getNewValue());
                    }
                }
        );


        TableColumn avdelingCol = new TableColumn("Avdeling");
        avdelingCol.setMinWidth(30);
        avdelingCol.setCellValueFactory(
                new PropertyValueFactory<Ansatt, String>("Avdeling"));
        avdelingCol.setCellFactory(cellFactory);
        avdelingCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Ansatt, String>>()
                {
                    @Override
                    public void handle(CellEditEvent<Ansatt, String> t)
                    {
                        ((Ansatt) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setStilling(t.getNewValue());
                    }
                }
        );

        TableColumn epostCol = new TableColumn("E-post");
        epostCol.setMinWidth(200);
        epostCol.setCellValueFactory(
                new PropertyValueFactory<Ansatt, String>("Epost"));
        epostCol.setCellFactory(cellFactory);
        epostCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Ansatt, String>>()
                {
                    @Override
                    public void handle(CellEditEvent<Ansatt, String> t)
                    {
                        ((Ansatt) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setStilling(t.getNewValue());
                    }
                }
        );

        TableColumn telefonCol = new TableColumn("Telefon");
        telefonCol.setMinWidth(110);
        telefonCol.setCellValueFactory(
                new PropertyValueFactory<Ansatt, String>("Telefon"));
        telefonCol.setCellFactory(cellFactory);
        telefonCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Ansatt, String>>()
                {
                    @Override
                    public void handle(CellEditEvent<Ansatt, String> t)
                    {
                        ((Ansatt) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setStilling(t.getNewValue());
                    }
                }
        );


        table.setItems(data);
        table.getColumns().addAll(ansattNrCol, navnCol, stillingCol, avdelingCol, epostCol, telefonCol);

        final TextField addAnsattNr = new TextField();
        addAnsattNr.setPromptText("AnsattID");
        addAnsattNr.setMaxWidth(ansattNrCol.getPrefWidth());

        final TextField addNavn = new TextField();
        addNavn.setMaxWidth(navnCol.getPrefWidth());
        addNavn.setPromptText("Navn");

        final TextField addStilling = new TextField();
        addStilling.setMaxWidth(stillingCol.getPrefWidth());
        addStilling.setPromptText("Stilling");

        final TextField addAvdeling = new TextField();
        addAvdeling.setMaxWidth(avdelingCol.getPrefWidth());
        addAvdeling.setPromptText("Avdeling");

        final TextField addEpost = new TextField();
        addEpost.setMaxWidth(epostCol.getPrefWidth());
        addEpost.setPromptText("E-post");

        final TextField addTelefon = new TextField();
        addTelefon.setMaxWidth(telefonCol.getPrefWidth());
        addTelefon.setPromptText("Telefon");

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent e) {
                Ansatt ansatt = new Ansatt(

                        addAnsattNr.getText(),
                        addNavn.getText(),
                        addStilling.getText(),
                        addAvdeling.getText(),
                        addEpost.getText(),
                        addTelefon.getText());
                data.add(ansatt);
                con.addAnsatte(ansatt);
                addAnsattNr.clear();
                addNavn.clear();
                addStilling.clear();
                addAvdeling.clear();
                addEpost.clear();
                addTelefon.clear();
                tableAnsatt t = new tableAnsatt();
                t.getScene(stage);
            }
        });

        hb.getChildren().addAll(addAnsattNr, addNavn, addStilling, addAvdeling, addEpost, addTelefon, addButton);
        hb.setSpacing(3);

        //footer
        Footer foot = new Footer();
        VBox footer = foot.createFooter();

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, sokLabel, sokFunksjon, resetButton, table, hb, tilbakeButton, footer);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();

        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());

        return scene;
    }

    class EditingCell extends TableCell<Ansatt, String>
    {

        private TextField textField;

        public EditingCell()
        {
        }

        @Override
        public void startEdit()
        {
            if (!isEmpty())
            {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }

        @Override
        public void cancelEdit()
        {
            super.cancelEdit();

            setText((String) getItem());
            setGraphic(null);
        }

        @Override
        public void updateItem(String item, boolean empty)
        {
            super.updateItem(item, empty);

            if (empty)
            {
                setText(null);
                setGraphic(null);
            }
            else
            {
                if (isEditing())
                {
                    if (textField != null)
                    {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                }
                else
                {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }

        private void createTextField()
        {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            textField.focusedProperty().addListener(new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0,
                                    Boolean arg1, Boolean arg2)
                {
                    if (!arg2)
                    {
                        commitEdit(textField.getText());
                    }
                }
            });
        }

        private String getString()
        {
            return getItem() == null ? "" : getItem().toString();
        }
    }

    // TODO: Abstrahere ut søkefunksjonen i egen klasse
    private void search(String searchStr)
    {
        ObservableList<Ansatt> foundItems = FXCollections.observableArrayList();
        for (Ansatt ansatt : data)
        {
            if ((ansatt.getAnsattId().toLowerCase().contains(searchStr)) && (!foundItems.contains(ansatt)))
            {
                foundItems.add(ansatt);
            }
            else if ((ansatt.getFornavn().toLowerCase().contains(searchStr)) && (!foundItems.contains(ansatt)))
            {
                foundItems.add(ansatt);
            }
            else if ((ansatt.getAvdeling().toLowerCase().contains(searchStr)) && (!foundItems.contains(ansatt)))
            {
                foundItems.add(ansatt);
            }
            else if ((ansatt.getEpost().toLowerCase().contains(searchStr)) && (!foundItems.contains(ansatt)))
            {
                foundItems.add(ansatt);
            }
            else if ((ansatt.getStilling().toLowerCase().contains(searchStr)) && (!foundItems.contains(ansatt)))
            {
                foundItems.add(ansatt);
            }
            else if ((ansatt.getTelefon().toLowerCase().contains(searchStr)) && (!foundItems.contains(ansatt)))
            {
                foundItems.add(ansatt);
            }
        }

        table.setItems(foundItems);

        if (foundItems.isEmpty())
        {
            table.setPlaceholder(new Label("Beklager, fant ingenting for søket " + "'" + searchStr + "'"));
        }
    }
}