package wms;


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
 
public class tableTruck{
 
    private TableView<Truck> table;
    private final ObservableList<Truck> data;
    private WMSConnection con;       
    final HBox hb ;
 
public tableTruck(){
    con = new WMSConnection();
    this.table = new TableView<Truck>();
    this.data = FXCollections.observableArrayList(con.getTruck());
    this.hb = new HBox();
}
 

    public Scene getScene(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Truck Tabell");
        
 
        Header head = new Header("Truck Tabell");
        Label label = head.createHeader();
        
        Label sokLabel = new Label("Søk: ");
        sokLabel.setFont(Font.font("Arial", 15));
        TextField sokFunksjon = new TextField ();
        
        Button tilbakeButton = new Button();
        tilbakeButton.setText("Tilbake");
        tilbakeButton.setPrefSize(150, 20);
        tilbakeButton.setOnAction((ActionEvent event) -> {
            WMS w = new WMS();
            w.getScene(stage);
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
            new PropertyValueFactory<Truck, String>("TruckId"));
        truckNrCol.setCellFactory(cellFactory);
        truckNrCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Truck, String>>() {
                @Override
                public void handle(CellEditEvent<Truck, String> t) {
                    ((Truck) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setTruckId(t.getNewValue());
                }
             }
        );
 
 
        TableColumn ansvarligCol = new TableColumn("Ansvarlig");
        ansvarligCol.setMinWidth(100);
        ansvarligCol.setCellValueFactory(
            new PropertyValueFactory<Truck, String>("Ansvarlig"));
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
        operativCol.setMinWidth(100);
        operativCol.setCellValueFactory(
            new PropertyValueFactory<Truck, String>("Operativ"));
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
        modelCol.setMinWidth(100);
        modelCol.setCellValueFactory(
            new PropertyValueFactory<Truck, String>("Model"));
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
        serviceCol.setMinWidth(100);
        serviceCol.setCellValueFactory(
            new PropertyValueFactory<Truck, String>("Neste_service"));
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