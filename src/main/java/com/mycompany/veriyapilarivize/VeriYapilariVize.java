/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.veriyapilarivize;

/**
 *
 * @author ziyab
 */

import java.util.Scanner;

public class VeriYapilariVize {
    
    
    //Doğrusal bir bağlı liste oluşturur.Listede node yoksa ekler
    static void addToTail(LinkedList list, int data)
    {
       
        Node newNode = new Node(data);
        Node currentNode = list.head;
        if(currentNode == null)
            {
                list.head = newNode;
                newNode.next = null;
            } 
        
        else
            {
                while(currentNode.next != null) //Listenin Sonuna Gider
                {
                    currentNode = currentNode.next;
                }
                
                currentNode.next = newNode;
            }
        list.size++;
    }
    
    //Doğrusal bir bağlı listeyi dairesel bağlı listeye çevirir
    static void convertToCircular(LinkedList list)
    {
        Node currentNode = list.head;
        
        while(currentNode.next != null) //Listenin Sonuna Gider
        {
            currentNode = currentNode.next;
        }
        
        currentNode.next = list.head;
    }
    
    static int popTheBaloon(LinkedList list, int baloonSpacing)
    {   
        Node currentNode = list.head;
        Node previousNode = list.head;
        
        while(currentNode.next != currentNode)  //Listede tek eleman kalana kadar devam eder
        {
            for(int i = 1;i<baloonSpacing;i++)  //M-1 balonu atlar
            {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            
            //Current Node'u listeden çıkarır
            previousNode.next = currentNode.next;
            currentNode = previousNode.next;
            
            list.size--;
        }
        
        return currentNode.data;    
    }
    
    static void positionOfLastBaloon(int m, int n)
    {
        LinkedList newList = new LinkedList();
        
            //N adet balon oluşturur
            for(int balonNumarasi = 1;balonNumarasi<=n;balonNumarasi++)
            {
                addToTail(newList,balonNumarasi);
            }
        
            convertToCircular(newList);
            
        int position = popTheBaloon(newList,m);
        System.out.print("Sona Kalan Balonun Pozisyonu:" + Integer.toString(position));
    }

    public static void main(String[] args) 
    {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Kaç Balon Var?");
        int n = input.nextInt();
        System.out.print("Kaçıncı balon patlatılacak?");
        int m = input.nextInt();
        
        positionOfLastBaloon(m,n);
        
        
    }
}
