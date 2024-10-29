package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SearchPart {

    public Parent getSearchView(Warehouse warehouse){

        BorderPane layout = new BorderPane();

        //BorderPane object that will hold search results
        BorderPane partInfo = new BorderPane();
        Label info = new Label();

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);

        Label search = new Label("Enter Part Name:");
        TextField searchField = new TextField();
        Button searchButton = new Button("Search");

        vbox.getChildren().addAll(search, searchField, searchButton);

        searchButton.setOnMouseClicked(e -> {
            //resets the info object to blank from the last displayed part search
            info.setText("");

            //created a new Part object by using the getPartByName method. This method returns an entire Part object
            Part searchedPart = warehouse.getPartByName(searchField.getText().trim());

            //If the searchedPart is in the warehouse array list, then the toString method in the Part class is displayed as the Label object named 'info'
            if(searchedPart != null){
                info.setText(searchedPart.toString());
            } else {
                info.setText("Part not found!");
            }

            //
            partInfo.setCenter(info);
            layout.setRight(partInfo);


        });

        layout.setCenter(vbox);

        return layout;

    }
}
