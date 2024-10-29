package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{


    @Override
    public void start(Stage window) throws Exception {

        Warehouse warehouse = new Warehouse();
        BOMWarehouse bomWarehouse = new BOMWarehouse();

        AddPartView partView = new AddPartView();
        SearchPart  searchView = new SearchPart();
        CreateBOMView bomView = new CreateBOMView();

        BorderPane layout = new BorderPane();
        layout.setPrefSize(600,600);
        layout.setStyle("-fx-background-color: #6699CC");


        //Create HBox of main buttons and add them to the top of layout BorderPane
        HBox topButtons = new HBox();
        topButtons.setSpacing(10);
        topButtons.setAlignment(Pos.CENTER);
        Button addPart = new Button("Add Part");
        Button createBOM = new Button("Create BOM");
        Button searchPart = new Button("Search Part");
        Button searchBOM = new Button("Search BOM");
        topButtons.getChildren().addAll(addPart, createBOM, searchPart, searchBOM);

        layout.setTop(topButtons);

        //If the Add Part button is clicked, the view in the center changes so that it shows fields to add a part.
        addPart.setOnMouseClicked(event -> {
            layout.setCenter(partView.getAddPartView(warehouse));
        });

        searchPart.setOnMouseClicked(event -> {
            layout.setCenter(searchView.getSearchView(warehouse));
        });

        createBOM.setOnMouseClicked(event -> {
            layout.setCenter(bomView.getCreateBOMView(warehouse, bomWarehouse));
        });


        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();




    }
    public static void main(String[] args) {
        launch(args);
    }
}