import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Scanner;

public class SimpleNote extends JFrame {
    
    private final String FILENAME = "mynote.txt";
    public static void main(String[] args) {

        SimpleNote note = new SimpleNote();
    }
    
    public SimpleNote () {

        super();
        this.setTitle("SimpleNote");
        this.setSize(500,600);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}