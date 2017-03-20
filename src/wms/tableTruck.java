
import javafx.application.Application;
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
 
public class tableTruck extends Application {
 
    private TableView<Truck> table = new TableView<Truck>();
    private final ObservableList<Truck> data =
            FXCollections.observableArrayList(
            new Truck("3442", "Smith", "Ja", "b200", "02.02.2018"),
            new Truck("9344", "Johnson", "Ja", "nimbus2000", "02.07.2017"),
            new Truck("2048", "Williams", "Ja", "up!", "18.12.2017"),
            new Truck("4653", "Jones", "Nei", "Terminator", "09.11.2017"),
            new Truck("1164", "Brown", "Ja", "Wakiki", "06.10.2018"));
    final HBox hb = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Truck Tabell");
        
 
        final Label label = new Label("Truck Tabell");
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
 
        TableColumn truckNrCol = new TableColumn("Truck Nr");
        truckNrCol.setMinWidth(100);
        truckNrCol.setCellValueFactory(
            new PropertyValueFactory<Truck, String>("truckNr"));
        truckNrCol.setCellFactory(cellFactory);
        truckNrCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Truck, String>>() {
                @Override
                public void handle(CellEditEvent<Truck, String> t) {
                    ((Truck) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setTruckNr(t.getNewValue());
                }
             }
        );
 
 
        TableColumn ansvarligCol = new TableColumn("Ansvarlig");
        ansvarligCol.setMinWidth(100);
        ansvarligCol.setCellValueFactory(
            new PropertyValueFactory<Truck, String>("ansvarlig"));
        ansvarligCol.setCellFactory(cellFactory);
        ansvarligCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Truck, String>>() {
                @Override
                public void handle(CellEditEvent<Truck, String> t) {
                    ((Truck) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setAnsvarlig(t.getNewValue());
                }
            }
        );
 
        TableColumn operativCol = new TableColumn("Operativ");
        operativCol.setMinWidth(30);
        operativCol.setCellValueFactory(
            new PropertyValueFactory<Truck, String>("operativ"));
        operativCol.setCellFactory(cellFactory);
        operativCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Truck, String>>() {
                @Override
                public void handle(CellEditEvent<Truck, String> t) {
                    ((Truck) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setOperativ(t.getNewValue());
                }
            }
        );
        
        
        TableColumn modelCol = new TableColumn("Model");
        modelCol.setMinWidth(30);
        modelCol.setCellValueFactory(
            new PropertyValueFactory<Truck, String>("model"));
        modelCol.setCellFactory(cellFactory);
        modelCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Truck, String>>() {
                @Override
                public void handle(CellEditEvent<Truck, String> t) {
                    ((Truck) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setOperativ(t.getNewValue());
                }
            }
        );
        
        TableColumn serviceCol = new TableColumn("Neste Service");
        serviceCol.setMinWidth(80);
        serviceCol.setCellValueFactory(
            new PropertyValueFactory<Truck, String>("service"));
        serviceCol.setCellFactory(cellFactory);
        serviceCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Truck, String>>() {
                @Override
                public void handle(CellEditEvent<Truck, String> t) {
                    ((Truck) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setOperativ(t.getNewValue());
                }
            }
        );
        
        
 
        table.setItems(data);
        table.getColumns().addAll(truckNrCol, ansvarligCol, operativCol, modelCol, serviceCol);
 
        final TextField addTruckNr = new TextField();
        addTruckNr.setPromptText("Truck Nr");
        addTruckNr.setMaxWidth(truckNrCol.getPrefWidth());
        
        final TextField addAnsvarlig = new TextField();
        addAnsvarlig.setMaxWidth(ansvarligCol.getPrefWidth());
        addAnsvarlig.setPromptText("Ansvarlig");
        
        final TextField addOperativ = new TextField();
        addOperativ.setMaxWidth(operativCol.getPrefWidth());
        addOperativ.setPromptText("Operativ");
 
        final TextField addModel = new TextField();
        addModel.setMaxWidth(modelCol.getPrefWidth());
        addModel.setPromptText("Model");
        
        final TextField addService = new TextField();
        addService.setMaxWidth(modelCol.getPrefWidth());
        addService.setPromptText("Neste Service");
        
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Truck(
                        addTruckNr.getText(),
                        addAnsvarlig.getText(),
                        addOperativ.getText(),
                        addModel.getText(),
                        addService.getText()));
                addTruckNr.clear();
                addAnsvarlig.clear();
                addOperativ.clear();
                addModel.clear();
                addService.clear();
            }
        });
 
        hb.getChildren().addAll(addTruckNr, addAnsvarlig, addOperativ, addModel, addService, addButton);
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
 
        private final SimpleStringProperty truckNr;
        private final SimpleStringProperty ansvarlig;
        private final SimpleStringProperty operativ;
        private final SimpleStringProperty model;
        private final SimpleStringProperty service;
 
        private Truck(String tNr, String ansvarlig, String operativ, String model, String service) {
            this.truckNr = new SimpleStringProperty(tNr);
            this.ansvarlig = new SimpleStringProperty(ansvarlig);
            this.operativ = new SimpleStringProperty(operativ);
            this.model = new SimpleStringProperty(model);
            this.service = new SimpleStringProperty(service);            
        }
 
        public String getTruckNr() {
            return truckNr.get();
        }
 
        public void setTruckNr(String tNr) {
            truckNr.set(tNr);
        }
 
        public String getAnsvarlig() {
            return ansvarlig.get();
        }
 
        public void setAnsvarlig(String tNr) {
            ansvarlig.set(tNr);
        }
 
        public String getOperativ() {
            return operativ.get();
        }
 
        public void setOperativ(String tNr) {
            operativ.set(tNr);
        }
        
        public String getModel() {
            return model.get(); 
        }
        
        public void setModel(String tNr) {
            model.set(tNr);
        }
        
        public String getService() {
            return service.get();
        }
        
        public void setService(String tNr) {
            service.set(tNr);
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