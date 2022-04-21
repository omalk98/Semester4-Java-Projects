/**
 * Module Info
 */
module com.lab4.server {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.xml.crypto;

    opens com.lab4.server to javafx.fxml;
    exports com.lab4.server;
}