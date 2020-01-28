/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment8;

import static java.lang.Integer.parseInt;

/**
 *
 * @author Chris Badolato
 * ch432391
 * 12/1/17
 */
public class NodeList {
    
    numberNode head;
    
    
    public NodeList(){
        head = null;
    }
    
        //Prints the list when called to the textfield. Will update as nodes are
        // added
    public String showList(){      
        StringBuilder builder = new StringBuilder(); 
        builder.append("mHead ->");
            //root is the head of the list.
        numberNode root = head;
            //While it isn't empty show the list.
        while(root != null){
            builder.append(root.show()+ " -> ");
            root = root.next;
            
        }
            //returns current string to build.
        return builder.toString();     
    }
    
    public void insertItem(numberNode newNode){
            //
        numberNode root = head;
        int insertedInt = parseInt((String)newNode.data);
            //we need to compare the values so I changed them to ints.
            //if the head is null the list is empty.
        if(root == null ){
            head = newNode;
        }  
            //otherwise check if the current value of the node is on the list already
        else{
                //Make a new int to compare to current head to the next value
                //if lower store before the current head.           
            int headInt = parseInt((String)root.data);             
            if(insertedInt < headInt){
                
                newNode.next = root;
                head = newNode;
                return;             
            }
                //loop through the list
            while(root.next != null){   
                        //get the new inserted int and compare it to 
                        //the value next as long as its less than that 
                        //value place it on the list
                    int ComparedInt = parseInt((String)root.next.data);                   
                    if(insertedInt < ComparedInt){                       
                        numberNode temp = root.next;                       
                        root.next = newNode;
                        newNode.next = temp;
                        break;
                    }
                        //otherwise if it is greater than any value on the list
                        //insert it at the end.
                    else{                       
                        root = root.next;
                    } 
                    
            }
            root.next = newNode;
        }                  
    }
    
    
        //removes individual nodes one at a time.
    public void removeNode(numberNode currentNode){
        numberNode root = head;     
            //Makes the next node the head if the current node is not null.removing it.          
        if(currentNode != null){
            if(root == currentNode){
            head = root.next;           
            }
                //moves the rest of the nodes down the list to the next positions.
            else{
                while(root.next != null){
                    if(root.next == currentNode){
                        root.next = root.next.next;                       
                        break;
                    }
                    root = root.next;
                }
            }          
        }             
    }
    
}
