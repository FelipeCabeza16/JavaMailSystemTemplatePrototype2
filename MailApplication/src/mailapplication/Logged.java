/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailapplication;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 
 */
public class Logged extends JFrame implements ActionListener{
    UsersConstructor searcher;
    Person indexperson = null, loggedperson;
    ArrayList<Person> contacts;
    ArrayList<JMenuItem> list;
    ArrayList<Message> messages;
    MessagesReader reader;
    
    
     JMenu menu;
     JMenuItem item;
    public Logged(Person loggedperson)
    {
        super("Bienvenido "+loggedperson.getName());
           searcher   = new UsersConstructor();
           contacts = new ArrayList<>();
           list =  new ArrayList<>();
           messages = new ArrayList<>();
           reader = new MessagesReader(loggedperson);    
           this.loggedperson = loggedperson;
                   
        setResizable(false);
    setBounds(400,300,250,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    createMenu();    
        
    } 

   
           private void createMenu() 
    {        
             final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
       
        
        // create the File menu
        menu = new JMenu("Opciones");
        menubar.add(menu);
        
        item = new JMenuItem("Añadir contacto");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, SHORTCUT_MASK));
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { registerUser(); }

 

                 private void registerUser() {
String inputmail;

             inputmail = JOptionPane.showInputDialog("Por favor, ingrese el CORREO del contacto a añadir : ");
             
             indexperson = searcher.searchMail(inputmail.toLowerCase());
             
             if (indexperson == null)
                 
                 JOptionPane.showMessageDialog(null, "No se encontró a esa persona");
else
             {                 JOptionPane.showMessageDialog(null, "Se añadió a "+indexperson.getName());
                                contacts.add(indexperson);
                                //item = new JMenuItem(indexperson.getName());
                                //menu.add(item);
                            
                                list.add(item);
                                
                                item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { JOptionPane.showMessageDialog(null, indexperson.toString()); }

                                
                                
                            });

             
             }
                         

                 
                 }   
                           });
        menu.add(item);

        
            item = new JMenuItem("Redactar mensaje");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, SHORTCUT_MASK));
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { 
                                   writeMessage();
                                   
                                   }

    
 

                 private void writeMessage()  {
                  String messageSended ;
                  String inputmail = JOptionPane.showInputDialog("Por favor, ingrese el CORREO del contacto a Escribir el mensaje: ");
                  
                 
                  
                  if (!(inputmail == null)){
                  Person per = searcher.searchMail(inputmail.toLowerCase());    
                    if (per != null)
                    {              
                        messageSended = JOptionPane.showInputDialog("Correo a enviar : ");
                    Message men = new Message(per, loggedperson, messageSended); 
                    
                                                       
                            }
                    else
                        JOptionPane.showMessageDialog(null,"CORREO NO ENCONTRADO : ");
                 
                  }
                 else
                      JOptionPane.showMessageDialog(null,"Correo vacio");
                 }
            });
        menu.add(item);

        
                item = new JMenuItem("Ver mensajes");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, SHORTCUT_MASK));
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { readMessage(); }

 

                 private void readMessage() {
                   

                     
                     ArrayList<String> s = reader.read();
                     
                     //Inbox i = new Inbox(s);
                 
           
                 }
                           });
        menu.add(item);

        
        
        item = new JMenuItem("Salir");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, SHORTCUT_MASK));
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { exit(); }

                 private void exit() {

                     System.exit(0);
                 }
            });
            menu.add(item);
            
       
            menu = new JMenu("Contactos");
        
            item = new JMenuItem("Actualizar");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, SHORTCUT_MASK));
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { reload(); }

                 private void reload() {

                     for (Person contact: contacts){
                             
                         
                         
                         item = new JMenuItem(contact.getName());
                                menu.add(item);
                     
                      item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { JOptionPane.showMessageDialog(null, contact.toString()); }

                                
                                
                            });
                     
                     }
                     }
                 }
            );

            menu.add(item);
            
            
            menubar.add(menu);
        
        
         
       
       }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
       
}
       

    
        
        
    

 


