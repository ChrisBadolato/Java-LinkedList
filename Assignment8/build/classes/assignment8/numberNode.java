/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment8;

/**
 *
 * @author Chris Badolato
 * ch432391
 * 12/1/17
 * @param <TExtendsNumber>
 */

    //This class creates a generic type class.
    //used for nodes of our nodelist.
public class numberNode<TExtendsNumber> {
    
    TExtendsNumber data;
    
    numberNode next;
    
    public numberNode(TExtendsNumber t){
        data = t;    
        next = null;
    }

    public String show(){
        return  data.toString();
    }   
}
