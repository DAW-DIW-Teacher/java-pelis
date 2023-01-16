module com.profesor.pelis {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens com.profesor.pelis to javafx.fxml;
    exports com.profesor.pelis;
}