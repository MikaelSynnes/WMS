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
 
public class tableAnsatt{
 
    private final TableView<Ansatt> table;
    private final ObservableList<Ansatt> data ;
    private WMSConnection con;
    final HBox hb;
 
    public tableAnsatt(){
        con = new WMSConnection();
        this.table = new TableView<Ansatt>();
        this.data = FXCollections.observableArrayList(con.getAnsatte());
        this.hb = new HBox();
        
    }
 
    
    public Scene getScene(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Ansatt Tabell");
        
 
        Header head = new Header("Ansatt Tabell");
        Label label = head.createHeader();
        
        Label sokLabel = new Label("Søk: ");
        sokLabel.setFont(Font.font("Arial", 15));
        TextField sokFunksjon = new TextField ();
        
        Button tilbakeButton = new Button();
        tilbakeButton.setText("Tilbake");
        tilbakeButton.setPrefSize(150, 20);
        tilbakeButton.setOnAction((ActionEvent event) -> {
            WMS w = new WMS();
            w.start(stage);
        });
 
        table.setEditable(true);
        Callback<TableColumn, TableCell> cellFactory =
             new Callback<TableColumn, TableCell>() {
                 public TableCell call(TableColumn p) {
                    return new EditingCell();
                 }
             };
 
        TableColumn ansattNrCol = new TableColumn("Ansatt Nr");
        ansattNrCol.setMinWidth(100);
        ansattNrCol.setCellValueFactory(
            new PropertyValueFactory<Ansatt, String>("AnsattId"));
        ansattNrCol.setCellFactory(cellFactory);
        ansattNrCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Ansatt, String>>() {
                @Override
                public void handle(CellEditEvent<Ansatt, String> t) {
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
            new EventHandler<CellEditEvent<Ansatt, String>>() {
                @Override
                public void handle(CellEditEvent<Ansatt, String> t) {
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
            new EventHandler<CellEditEvent<Ansatt, String>>() {
                @Override
                public void handle(CellEditEvent<Ansatt, String> t) {
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
            new EventHandler<CellEditEvent<Ansatt, String>>() {
                @Override
                public void handle(CellEditEvent<Ansatt, String> t) {
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
            new EventHandler<CellEditEvent<Ansatt, String>>() {
                @Override
                public void handle(CellEditEvent<Ansatt, String> t) {
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
            new EventHandler<CellEditEvent<Ansatt, String>>() {
                @Override
                public void handle(CellEditEvent<Ansatt, String> t) {
                    ((Ansatt) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setStilling(t.getNewValue());
                }
            }
        );
        
 
        table.setItems(data);
        table.getColumns().addAll(ansattNrCol, navnCol, stillingCol, avdelingCol, epostCol, telefonCol);
 
        final TextField addAnsattNr = new TextField();
        addAnsattNr.setPromptText("Ansatt Id");
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
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Ansatt(
                        addAnsattNr.getText(),
                        addNavn.getText(),
                        addStilling.getText(),
                        addAvdeling.getText(),
                        addEpost.getText(),
                        addTelefon.getText()));
                addAnsattNr.clear();
                addNavn.clear();
                addStilling.clear();
                addAvdeling.clear();
                addEpost.clear();
                addTelefon.clear();
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
        vbox.getChildren().addAll(label, sokLabel, sokFunksjon, table, hb, tilbakeButton, footer);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
        
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());
        
        return scene;
    }
 
    class EditingCell extends TableCell<Ansatt, String> {
 
        private TextField textField;
 
        public EditingCell() {
        }
 
        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }
 
        @Override
        public void cancelEdit() {
            super.cancelEdit();
 
            setText((String) getItem());
            setGraphic(null);
        }
 
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
 
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }
 
        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
            textField.focusedProperty().addListener(new ChangeListener<Boolean>(){
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, 
                    Boolean arg1, Boolean arg2) {
                        if (!arg2) {
                            commitEdit(textField.getText());
                        }
                }
            });
        }
 
        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }
}