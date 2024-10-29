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

public class SearchBOM {

    public Parent getSearchBOMView(BOMWarehouse bomWarehouse) {
        HBox layout = new HBox();
        VBox content = new VBox();
        HBox inputFields = new HBox();

        Label searchLabel = new Label("Enter BOM by Name");
        TextField searchField = new TextField();
        Button searchButton = new Button("Search");

        VBox returnValue = new VBox();
        Label foundLabel = new Label("");
        Label bomInfo = new Label("");

        inputFields.setAlignment(Pos.CENTER);
        inputFields.setSpacing(10);
        inputFields.setPadding(new Insets(10, 10, 10, 10));
        inputFields.getChildren().addAll(searchLabel, searchField);

        content.setAlignment(Pos.CENTER);
        content.setSpacing(10);
        content.setPadding(new Insets(10, 10, 10, 10));
        content.getChildren().addAll(inputFields, searchButton);

        returnValue.getChildren().addAll(foundLabel, bomInfo);

        searchButton.setOnMouseClicked(event -> {
            BillOfMaterial bom = bomWarehouse.getBOMByName(searchField.getText().trim());
            foundLabel.setText("");
            bomInfo.setText("");
            searchField.clear();

            if (bom != null) {
                foundLabel.setText("BOM Found!");
                bomInfo.setText(bom.toString());
            } else {
                foundLabel.setText("BOM not found! Please try a different name.");
            }


        });

        layout.getChildren().addAll(content, returnValue);

        return layout;
    }
}
