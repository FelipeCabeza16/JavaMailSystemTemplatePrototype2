/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailapplication;

import java.io.FileNotFoundException;

/**
 *
 * @author Felipe Cabeza @felipecabeza16
 */
public class MailApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        UsersConstructor usersconstructor = new UsersConstructor();
       // usersconstructor.read();
        MyFrame myframe = new MyFrame();
    }
    
}
