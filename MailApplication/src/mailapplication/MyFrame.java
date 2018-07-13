/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailapplication;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Felipe Cabeza @felipecabeza16
 */
public class MyFrame extends JFrame implements ActionListener{
        private JLabel lusername, lpassword;
        private JTextField username;
        private JPasswordField password;
        private JButton submit;
        private Container cn;
        private JPanel loginpanel;
        int attemps=0;
    public MyFrame(){
    super("Aplicación correos");
    
    
    cn = getContentPane();
    
    cn.setLayout(new BorderLayout());
    
    username = new JTextField(20);
    password = new JPasswordField(20);
    submit = new JButton("Enviar");
    lpassword = new JLabel("Contraseña");
    lusername = new JLabel("Usuario");
    
    
    loginpanel = new JPanel();
    loginpanel.add(lusername);
    loginpanel.add(username);
    loginpanel.add(lpassword);
    loginpanel.add(password);
    loginpanel.add(submit);

    
    
    username.addActionListener(this);
    password.addActionListener(this);
    submit.addActionListener(this);
    
    cn.add(loginpanel, BorderLayout.CENTER);
//initializeComponents();
    createMenu();    

    setResizable(false);
    setBounds(400,300,250,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);

    }   

    public void initializeComponents() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Person verify=null;
        Logged logged;
        attemps++;
        if (e.getSource() == username || e.getSource() == password || e.getSource()==submit )
        {
            
            UsersConstructor control = new UsersConstructor();
            verify = control.search(username.getText(), password.getText());
            
            if (verify==null)
                   JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos");
            else
logged = new Logged(verify);    

        }
        
        if (attemps == 4){
       JOptionPane.showMessageDialog(null, "Excedió los 3 intentos, cerrando el programa...");
            System.exit(1);
            }
    }
    
    private void createMenu() 
    {        
             final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu menu;
        JMenuItem item;
        
        // create the File menu
        menu = new JMenu("Opciones");
        menubar.add(menu);
        
        item = new JMenuItem("Registrarse");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, SHORTCUT_MASK));
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { registerUser(); }

 

                 private void registerUser() {
                     RegisterForm registerform = new RegisterForm(); 
                 }
                           });
        menu.add(item);

        
           item = new JMenuItem("Contactar desarrollador");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, SHORTCUT_MASK));
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { contact("https://www.twitter.com/FelipeCabeza16"); }

                 private void contact(String url) {

         //            String url = "https://www.twitter.com/FelipeCabeza16";
        Runtime aplication = Runtime.getRuntime();
        
        if (System.getProperty("os.name").equals("Linux"))
          
        {
                try{
                 aplication.exec("firefox --new-window https://www.twitter.com/FelipeCabeza16");
                } catch (Exception e){ 
                }
            
        }
        else{
           String osName = System.getProperty("os.name");
        try {
            if (osName.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (osName.startsWith("Mac OS X")) {
                // Runtime.getRuntime().exec("open -a safari " + url);
                // Runtime.getRuntime().exec("open " + url + "/index.html");
                Runtime.getRuntime().exec("open " + url);
            } else {
                System.out.println("Please open a browser and go to "+ url);
            }
        } catch (IOException e) {
            System.out.println("Failed to start a browser to open the url " + url);
            e.printStackTrace();
        } 
            
        }
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
                    
    
    }
    
    

    
}

