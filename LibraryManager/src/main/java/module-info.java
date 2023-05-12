module com.it3330.librarymanager {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.it3330.librarymanager to javafx.fxml;
    exports com.it3330.librarymanager;
}