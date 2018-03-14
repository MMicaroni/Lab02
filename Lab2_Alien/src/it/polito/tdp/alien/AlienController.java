package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	AlienDictionary dictionary = new AlienDictionary();
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
    
    
    @FXML
    void doTranslate(ActionEvent event) {
    	    	
    	String input = txtWord.getText();
    	String array[] = input.trim().split("\\s+");
    	
    	if(array.length==2) {
    		
    		String alienW = array[0];
    		String transl=array[1];
    	 
    		if(alienW.matches("[a-zA-Z]+")==false || transl.matches("[a-zA-Z]+")==false) {
        		txtResult.setText("Hai inserito dei caratteri non validi\n");
        		return;  
    		}
    	    
    		
    		//if(dictionary.isIn(alienW)==false)
    		  dictionary.addWord(alienW, transl);    	
    	}
    	if(array.length==1) {
    		
    		String alienW=array[0];
    		if(alienW.matches("[a-zA-Z]+")==false) {
        		txtResult.setText("Hai inserito dei caratteri non validi\n");
        	    return;
    		}
    		
    		if(dictionary.isIn(alienW)==true)
    			txtResult.setText(dictionary.translateWord(alienW));
    		else
    			txtResult.setText("La parola non è presente nel database, inserisci la parola nel dizionario specificando la traduzione\n");

    	}
    	
    
    	}
    	
    		
    	
    	
    
    
    @FXML
    void doReset(ActionEvent event) {

    }
    
}
