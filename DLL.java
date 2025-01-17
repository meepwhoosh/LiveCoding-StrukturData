package com.strukdat;

public class DLL{
    Node head;

    static class Node{
        int tahun;
        String nama_proyek;
        String[] nama_anggota;
        Node prev, next;

        Node(int tahun, String nama_proyek, String[] nama_anggota){
            this.tahun = tahun;
            this.nama_proyek = nama_proyek;
            this.nama_anggota = nama_anggota;
            this.prev = null;
            this.next = null;
        }
    }

    public void printList(){
        Node current = head;
        Node last = null;
        System.out.println("\nTraversal in forward Direction");
        while(current != null){
            System.out.print("Tahun dimulai : " + current.tahun + " | Nama Proyek : " + current.nama_proyek + " | Nama Anggota Tim : ");
            for(String anggota : current.nama_anggota){
                System.out.print(anggota + ", ");
            }
            System.out.print( "-> ");
            last = current;
            current = current.next;
        }
        System.out.println("Null");

        System.out.println("\nTraversal in reverse direction");
        while(last != null){
            System.out.print("Tahun dimulai : " + last.tahun + " | Nama Proyek : " + last.nama_proyek + " | Nama Anggota Tim : ");
            for(String anggota : last.nama_anggota){
                System.out.print(anggota + ", ");
            }
            System.out.print( "<- ");
            last = last.prev;
        }
        System.out.println("Null");
    }


    public void insertAfter(Node prev_node, int tahun, String nama_proyek, String[] nama_anggota){

        if(prev_node == null){
            System.out.println("The given previous node cannot be NULL");
            return;
        }
        Node new_node = new Node(tahun, nama_proyek, nama_anggota);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
        new_node.prev = prev_node;

        if(new_node.next != null ){
            new_node.next.prev = new_node;
        }
    }

    public void deletionNode (String nama_proyek) {
        Node current = head;

        while (current != null && current.nama_proyek.equals(nama_proyek)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Proyek tidak ditemukan");
            return;
        }

        if (current == head) {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }

        System.out.println("Proyek yang dihapus : " + nama_proyek);
    }
    

    public static void main(String[] args){
        DLL list = new DLL();
        System.out.println("\n--- SISTEM MANAJEMEN PROYEK ---");
        Node node1 = new Node(2020, "Website", new String[] {"La Ode", "Julius"});   
        Node node2 = new Node(2021, "Software", new String[] {"Sofia", "Dinar"});   
        Node node3 = new Node(2022, "Aplikasi Mobile Banking", new String[] {"La Ode", "Mayra"});   
        Node node4 = new Node(2023, "E-Commerce Platform", new String[] {"Julius", "Sofia"});   
        Node node5 = new Node(2024, "Aplikasi E-Learning", new String[] {"Dinar", "Mayra"});   

        list.head = node1;
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;

        list.insertAfter(node5, 2025, "INSERT AKHIR", new String[]{"Dinar", "Julius"});
        list.printList();

        list.deletionNode("Website");
        list.printList();









        
    }
}