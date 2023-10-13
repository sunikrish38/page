module com.front.page {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens com.front.page to javafx.fxml;
    exports com.front.page;
}
