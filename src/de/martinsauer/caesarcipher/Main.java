package de.martinsauer.caesarcipher;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * GUI Application for Caesar Cipher.
 * 
 * @author Martin Sauer, 10th Dec 2020
 */
public class Main extends Application {
	
	private int shiftValue = 9;
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Caesar Cipher");
		Pane root = new Pane(); 
		
		/*
		 * Little prompt for the user.
		 */
		Label taskText = new Label("Enter a string in the text field below to encrypt or decrypt it.");
		
		/*
		 * Text field for user input.
		 */
		TextField tf = new TextField();
		tf.setLayoutY(20);
		tf.setLayoutX(50);
		tf.setPrefWidth(300);
		
		/*
		 * Button to encrypt a string on press.
		 */
		Button encryptButton = new Button("Encrypt");
		encryptButton.setLayoutX(120);
		encryptButton.setLayoutY(100/2);
		encryptButton.setOnAction(event -> {
			String inputText = tf.getText();
			CaesarCipher cs = new CaesarCipher();
			String outputText = cs.encrypt(inputText, shiftValue);
			tf.setText(outputText);
		});
		
		/*
		 * Button to decrypt a string on press.
		 */
		Button decryptButton = new Button("Decrypt");
		decryptButton.setLayoutX(205);
		decryptButton.setLayoutY(100/2);
		decryptButton.setOnAction(event -> {
			String inputText = tf.getText();
			CaesarCipher cs = new CaesarCipher();
			String outputText = cs.decrypt(inputText, -1 * shiftValue);
			tf.setText(outputText);
		});
		
		root.getChildren().addAll(taskText, tf, encryptButton, decryptButton);
		
		primaryStage.setScene(new Scene(root, 400, 100));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}