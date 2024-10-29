package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AddPartView {


    public Parent getAddPartView(Warehouse warehouse) {
        BorderPane layout = new BorderPane();

        Button addPartButton = new Button("Add New Part");


        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20,20,20,20));

        Label id = new Label("ID:");
        TextField idField = new TextField();
        Label name = new Label("Name:");
        TextField nameField = new TextField();
        Label price = new Label("Price:");
        TextField priceField = new TextField();
        Label stock = new Label("Stock:");
        TextField stockField = new TextField();
        Label partType = new Label("Part Type:");
        TextField partTypeField = new TextField();
        Label weight = new Label("Weight:");
        TextField weightField = new TextField();
        Label manufacturer = new Label("Manufacturer:");
        TextField manufacturerField = new TextField();
        Label supplier = new Label("Supplier:");
        TextField supplierField = new TextField();

        Label confirmationMessage = new Label();
        layout.setBottom(confirmationMessage);

        vbox.getChildren().addAll(id,idField, name, nameField, price, priceField, stock, stockField, partType, partTypeField, weight, weightField, manufacturer, manufacturerField, supplier, supplierField);



        addPartButton.setOnAction(e -> {
            Part part = new Part(idField.getText().trim(), nameField.getText().trim(), Double.valueOf(priceField.getText()), Integer.valueOf(stockField.getText()), partTypeField.getText().trim(),
                    Double.valueOf(weightField.getText()), manufacturerField.getText().trim(), supplierField.getText().trim());

            confirmationMessage.setText("Part Added to the Warehouse!");

            warehouse.add(part);
            idField.clear();
            nameField.clear();
            priceField.clear();
            stockField.clear();
            partTypeField.clear();
            weightField.clear();
            manufacturerField.clear();
            supplierField.clear();



        });
        layout.setTop(addPartButton);
        layout.setCenter(vbox);
        return layout;

    }
}
