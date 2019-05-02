/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turing;

/**
 *
 * @author IvanAranda
 */
public class Tape {
    
    Cell head;
    Cell current;
    /**
     * Constructor to start a tape with one cell filled with a space char
     * without this space char the machine breaks
     */
    public Tape(){
        head = new Cell();
        head.prev = new Cell();
        head.prev.content = ' ';
        head.prev.next = head;
        current = head.prev;
    }
    /**
     * getter fn to the get current cell
     * @return the current cell
     */
    public Cell getCurrentCell(){
        
        return current;
    } //-- returns the pointer that points to the current cell. 

    public char getContent(){
        return current.content;
    } //-- returns the char from the current cell.

    public void setContent(char ch){
        current.content = ch;
    } //-- changes the char in the current cell to the specified value. 

    public void moveLeft(){
        if(current.prev == null){
            Cell newCell = new Cell();
            newCell.content = ' ';
            current.prev = newCell; 
            newCell.next = current;
        }
        current = current.prev;
        
    } //-- moves the current cell one position to the left along the tape. Note that if the current cell is the leftmost cell that exists, then a new cell must be created and added to the tape at the left of the current cell, and then the current cell pointer can be moved to point to the new cell. The content of the new cell should be a blank space. (Remember that the Turing machine's tape is conceptually infinite, so your linked list must must be prepared to expand on demand, when the machine wants to move past the current end of the list.) 

    public void moveRight(){
        if(current.next == head){
            Cell tempCurrent = current;
            Cell newCell = new Cell();
            newCell.content = ' ';
            tempCurrent.next = newCell;
            newCell.prev = tempCurrent;
            newCell.next = head;
            head.prev = newCell;
            current = newCell;
//            getCurrentCell().next = head.prev;
        }else{
            current = current.next;
        }
        
    } //-- moves the current cell one position to the right along the tape. Note that if the current cell is the rightmost cell that exists, then a new cell must be created and added to the tape at the right of the current cell, and then the current cell pointer can be moved to point to the new cell. The content of the new cell should be a blank space.
    public String getTapeContents(){
        String strOutput = "";
        Cell node = head;
        while(node.prev != null){
//            if(node.prev.content != ' '){
//                strOutput += Character.toString(node.prev.content);
//            }
            strOutput += Character.toString(node.prev.content);
            node = node.prev;
        }
        StringBuilder sb = new StringBuilder(strOutput);
        return sb.reverse().toString().trim();
    } //-- returns a String consisting of the chars from all the cells on the tape, 
//    read from left to right, except that leading or trailing blank characters should 
//            be discarded. The current cell pointer should not be moved by this method; 
//            it should point to the same cell after the method is called as it did before. 
//            You can create a different pointer to move along the tape and get the full contents. 
//            (This method is the hardest one to implement.)
}
