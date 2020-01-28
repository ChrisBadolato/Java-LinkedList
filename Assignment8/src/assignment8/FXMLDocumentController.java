/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment8;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Chris Badolato
 * Ch432391
 * 12/1/17
 * This program will make a generic Node which will be copied and created into
 * a linked list of data that can be any type. The list will be entered in 
 * ascending order. If reset button is clicked the board list and
 * the buttons will all reset. 
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button Button1;
    @FXML
    private Button Button3;
    @FXML
    private Button Button2;
    @FXML
    private Button Button4;
    @FXML
    private Button Button5;
    @FXML
    private Button resetButton;
    @FXML
    private Button closeButton;
    
    public NodeList numberList = new NodeList();
    
    @FXML
    private void handleButtonAction(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    
    
    @FXML
        //When close button is clicked it will close the window.
    public void closeButton(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    

    @FXML
    private void onButtonClicked(MouseEvent event) {    
       
            //get our button Id
       Button buttonClicked = (Button)event.getSource();
       String buttonId = buttonClicked.getId();     
       String numberString = buttonId.substring(buttonId.length()-1);
            //Send it to load list to add to the nodeList
       loadList(numberList, numberString);          
            //disables the current button.
       buttonClicked.setDisable(true);
            //adds value to the label text.
       label.setText(numberList.showList());
       
    }
      
    @FXML
    private void resetClicked(MouseEvent event){
        
            //Resets the list and the label
        Button1.setDisable(false);
        Button2.setDisable(false);
        Button3.setDisable(false);
        Button4.setDisable(false);
        Button5.setDisable(false);
        removeList();
        label.setText("mHead -> ");               
    }
    
    private static void loadList(NodeList List, String number){ 
            //inserts an item on the number list with insertItem function.
        List.insertItem(new numberNode(number));                             
    } 
    
    public void removeList(){
            //send one node at a time to be deleted.
        while(numberList.head != null){
        numberList.removeNode(numberList.head);
        }
    }  
    
}
