/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Main.AbstractFactory;
import Main.Convertor.Convertor;
import Main.FactoryProducer;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author LN710Q
 */
public class Ventana extends JPanel {
    public int WIDTH = 300, widthTF = 120, widthB = 80;
    public int HEIGHT = 300, heightTF = 30, heightB = 30;
    public JTextField textF1,textF2;
    public JButton button;
    public AbstractFactory factory;

    public Ventana() {
        
        
        textF1 = new JTextField();
        textF1.setBounds(new Rectangle(100,40,widthTF,heightTF));
        
        textF2 = new JTextField();
        textF2.setBounds(new Rectangle(100,200,widthTF,heightTF));
        
        button = new JButton("Convertir");
        button.setBounds(new Rectangle(120,115,widthB,heightB));
        
        textF1.setEditable(true);
        textF2.setEditable(false);
        
        button.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0){
               System.out.println("1");
               factory = FactoryProducer.getFactory("convertir");
               System.out.println("2");
               Convertor conversion = factory.getConvertor("convertir");
               System.out.println("3");
                textF2.setText(Integer.toString(conversion.convertir(Integer.parseInt(textF1.getText()))));
                System.out.println("4");

           }
        });
        
        add(textF1);
        add(button);
        add(textF2);
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        
    }
            
    
}