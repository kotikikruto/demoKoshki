module com.example.demokoshki {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demokoshki to javafx.fxml;
    exports com.example.demokoshki;
}