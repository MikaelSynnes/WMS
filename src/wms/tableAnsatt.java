
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
 
public class tableAnsatt extends Application {
 
    private TableView<Truck> table = new TableView<Truck>();
    private final ObservableList<Truck> data =
            FXCollections.observableArrayList(
            new Truck("9432", "Per", "Boss man", "A", "Per@lager.no", "99443322"),
            new Truck("6538", "Lars", "Truck man", "A4", "Lars@lager.no", "86547762"),
            new Truck("1932", "Kari", "IT", "A", "Kari@lager.no", "99233451"),
            new Truck("6543", "Mari", "Truck Woman", "A2", "Mari@lager.no","99343216"),
            new Truck("9931", "Mons", "Lager Arbeider", "A2", "Mons@lager.no", "44753234"));
    final HBox hb = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Ansatt Tabell");
        
 
        final Label label = new Label("Ansatt Tabell");
        label.setFont(new Font("Arial", 20));
        
        Label sokLabel = new Label("Søk: ");
        sokLabel.setFont(Font.font("Arial", 15));
        TextField sokFunksjon = new TextField ();
        
        Button tilbakeButton = new Button();
        tilbakeButton.setText("Tilbake");
        tilbakeButton.setPrefSize(150, 20);
        tilbakeButton.setOnAction((ActionEvent event) -> {
            System.out.println("Tilbake!");
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
            new PropertyValueFactory<Truck, String>("ansattNr"));
        ansattNrCol.setCellFactory(cellFactory);
        ansattNrCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Truck, String>>() {
                @Override
                public void handle(CellEditEvent<Truck, String> t) {
                    ((Truck) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setAnsattNr(t.getNewValue());
                }
             }
        );
 
 
        TableColumn navnCol = new TableColumn("Navn");
        navnCol.setMinWidth(100);
        navnCol.setCellValueFactory(
            new PropertyValueFactory<Truck, String>("navn"));
        navnCol.setCellFactory(cellFactory);
        navnCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Truck, String>>() {
                @Override
                public void handle(CellEditEvent<Truck, String> t) {
                    ((Truck) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setNavn(t.getNewValue());
                }
            }
        );
 
        TableColumn stillingCol = new TableColumn("Stilling");
        stillingCol.setMinWidth(30);
        stillingCol.setCellValueFactory(
            new PropertyValueFactory<Truck, String>("stilling"));
        stillingCol.setCellFactory(cellFactory);
        stillingCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Truck, String>>() {
                @Override
                public void handle(CellEditEvent<Truck, String> t) {
                    ((Truck) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setStilling(t.getNewValue());
                }
            }
        );
        
        
        TableColumn avdelingCol = new TableColumn("Avdeling");
        avdelingCol.setMinWidth(30);
        avdelingCol.setCellValueFactory(
            new PropertyValueFactory<Truck, String>("avdeling"));
        avdelingCol.setCellFactory(cellFactory);
        avdelingCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Truck, String>>() {
                @Override
                public void handle(CellEditEvent<Truck, String> t) {
                    ((Truck) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setStilling(t.getNewValue());
                }
            }
        );
        
        TableColumn epostCol = new TableColumn("E-post");
        epostCol.setMinWidth(80);
        epostCol.setCellValueFactory(
            new PropertyValueFactory<Truck, String>("epost"));
        epostCol.setCellFactory(cellFactory);
        epostCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Truck, String>>() {
                @Override
                public void handle(CellEditEvent<Truck, String> t) {
                    ((Truck) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setStilling(t.getNewValue());
                }
            }
        );
        
        TableColumn telefonCol = new TableColumn("Telefon");
        telefonCol.setMinWidth(110);
        telefonCol.setCellValueFactory(
            new PropertyValueFactory<Truck, String>("telefon"));
        telefonCol.setCellFactory(cellFactory);
        telefonCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Truck, String>>() {
                @Override
                public void handle(CellEditEvent<Truck, String> t) {
                    ((Truck) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setStilling(t.getNewValue());
                }
            }
        );
        
 
        table.setItems(data);
        table.getColumns().addAll(ansattNrCol, navnCol, stillingCol, avdelingCol, epostCol, telefonCol);
 
        final TextField addAnsattNr = new TextField();
        addAnsattNr.setPromptText("Ansatt Nr");
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
                data.add(new Truck(
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
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, sokLabel, sokFunksjon, table, hb, tilbakeButton);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
        
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());
    }
 
    public static class Truck {
 
        private final SimpleStringProperty ansattNr;
        private final SimpleStringProperty navn;
        private final SimpleStringProperty stilling;
        private final SimpleStringProperty avdeling;
        private final SimpleStringProperty epost;
        private final SimpleStringProperty telefon;
 
        private Truck(String tNr, String navn, String stilling, String avdeling, String epost, String telefon) {
            this.ansattNr = new SimpleStringProperty(tNr);
            this.navn = new SimpleStringProperty(navn);
            this.stilling = new SimpleStringProperty(stilling);
            this.avdeling = new SimpleStringProperty(avdeling);
            this.epost = new SimpleStringProperty(epost);    
            this.telefon = new SimpleStringProperty(telefon);
        }
 
        public String getAnsattNr() {
            return ansattNr.get();
        }
 
        public void setAnsattNr(String tNr) {
            ansattNr.set(tNr);
        }
 
        public String getNavn() {
            return navn.get();
        }
 
        public void setNavn(String tNr) {
            navn.set(tNr);
        }
 
        public String getStilling() {
            return stilling.get();
        }
 
        public void setStilling(String tNr) {
            stilling.set(tNr);
        }
        
        public String getAvdeling() {
            return avdeling.get(); 
        }
        
        public void setAvdeling(String tNr) {
            avdeling.set(tNr);
        }
        
        public String getEpost() {
            return epost.get();
        }
        
        public void setEpost(String tNr) {
            epost.set(tNr);
        }
        
        public String getTelefon() {
            return telefon.get();
        }
        
        public void setTelefon(String tNr) {
            telefon.set(tNr);
        }
    }
 
    class EditingCell extends TableCell<Truck, String> {
 
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