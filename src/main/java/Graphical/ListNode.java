/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphical;

/**
 *
 * @author NEXT STORE
 */
public class ListNode<T> {
    private T data;
    private ListNode next;
     
    // Constructor: No reference to next node provided so make it null 
    public ListNode( T nodeData ) {
        this( nodeData, null);
    }
     
    // Constructor: Set data and reference to next node.
    public ListNode( T nodeData, ListNode nodeNext ) {
        data = nodeData;
        next = nodeNext;
    }
     
    // Accessor: Return the data for current ListNode object
    public T getData() {
        return data;
    }
     
    // Accessor: Return reference to next ListNode object
    public ListNode getNext() {
        return next;
    }
     
    // Mutator: Set new data for current ListNode object
    public void setData( T newData ) {
        data = newData;
    }
     
     
    // Mutator: Set new reference to the next node object
    public void setNext( ListNode newNext ) {
        next = newNext;
    }
}