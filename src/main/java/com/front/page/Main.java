package com.front.page;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage)  {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	        primaryStage.setTitle("Login Application");
	        primaryStage.setScene(new Scene(root, 300, 200));
	        primaryStage.show();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	 public static void main(String[] args) {
	        launch(args);
}
}