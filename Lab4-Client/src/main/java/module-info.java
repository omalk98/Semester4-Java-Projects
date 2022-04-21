/**
 * Module Info
 */
module com.lab4.client {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.lab4.client to javafx.fxml;
    exports com.lab4.client;
}