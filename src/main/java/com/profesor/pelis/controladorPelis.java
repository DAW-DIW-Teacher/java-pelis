package com.profesor.pelis;

import com.mongodb.client.MongoCollection;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.bson.Document;

public class controladorPelis {

    @FXML
    private TableColumn<Document, String> columnaTitle;

    @FXML
    private TableColumn<Document, String> columnaType;

    @FXML
    private TableColumn<Document, Integer> columnaYear;

    @FXML
    private TableView<Document> tablaPeliculas;
    private MongoCollection<Document> coleccionMovies;
    private ObservableList<Document> datosMovies;


    public void initialize () {

        columnaTitle.setCellValueFactory( param -> {
            String dato = param.getValue().getString("title");
            return new SimpleStringProperty(dato);
        });

        columnaType.setCellValueFactory( param -> {
            String dato = param.getValue().getString("type");
            return new SimpleStringProperty(dato);
        });

        columnaYear.setCellValueFactory( param -> {
            Integer dato = param.getValue().getInteger("year");
            return new SimpleObjectProperty<Integer>(dato);
        });

        coleccionMovies = Main.dataBaseMongo.getCollection("movies");

        datosMovies = coleccionMovies.find().into(FXCollections.observableArrayList());

        tablaPeliculas.setItems(datosMovies);

    }

}

