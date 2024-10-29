package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CreateBOMView {

    private double cost = 0;

    public Parent getCreateBOMView(Warehouse warehouse, BOMWarehouse bomWarehouse) {
        BorderPane layout = new BorderPane();


        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));

        Label id = new Label("ID");
        TextField idText = new TextField();
        Label name = new Label("Name");
        TextField nameText = new TextField();
        Label bomDescription = new Label("BOM Description");
        TextField bomDescriptionText = new TextField();

        //This section creates the bottom section of the view where the user shall enter the name of the part and desired quantity.
        Label addPart = new Label("Add Part to BOM");
        HBox hbox = new HBox();

        Label partName = new Label("Part Name");
        TextField addPartText = new TextField();
        Label qty = new Label("Quantity: ");
        TextField qtyText = new TextField();
        Button addPartButton = new Button("Add Part");
        hbox.getChildren().addAll(partName, addPartText, qty, qtyText, addPartButton);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(20, 20, 20, 20));

        //Creates the button "Create BOM" that will have a handler to act upon when clicked
        Button createBOMButton = new Button("Create BOM");

        //add all the labels and textFields to the vbox object created
        vbox.getChildren().addAll(id, idText, name, nameText, bomDescription, bomDescriptionText, addPart, hbox, createBOMButton);

        // Error message for no part found
        Label error = new Label("");
        error.setStyle("-fx-text-fill: red");
        Label qtyError = new Label("");
        qtyError.setStyle("-fx-text-fill: red");
        Label success = new Label("");
        vbox.getChildren().addAll(success, error, qtyError);

        ArrayList<Part> parts = new ArrayList<>();

        addPartButton.setOnMouseClicked(event -> {
            int setQty = Integer.valueOf(qtyText.getText());

            Part newPart = warehouse.getPartByName(addPartText.getText().trim());

            if (newPart != null) {
                if(newPart.getStock() >= setQty &&  newPart.getStock() - setQty >= 0) {
                    success.setText("Part Successfully added to the BOM!");
                    parts.add(newPart);
                    cost += newPart.getPrice();
                    error.setText(""); // Clear any previous error message
                    qtyError.setText(""); //Clear any previous qtyError message
                    addPartText.clear(); // Clear input only after adding successfully
                    qtyText.clear();
                    newPart.setStock(newPart.getStock() - setQty);
                } else {
                    qtyError.setText("Quantity exceeds the limit of what is in stock");
                }
            } else {
                error.setText("Invalid Part Name");
            }

        });

        createBOMButton.setOnMouseClicked(event -> {
            BillOfMaterial bom = new BillOfMaterial(idText.getText().trim(), nameText.getText().trim(), bomDescriptionText.getText().trim(), cost, parts);

            bomWarehouse.add(bom);

            // Clear input fields after creating BOM
            idText.clear();
            nameText.clear();
            bomDescriptionText.clear();

        });

        layout.setCenter(vbox);

        return layout;
    }
}
