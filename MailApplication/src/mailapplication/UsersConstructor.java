//import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailapplication;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
/**
 *
 * @author Felipe Cabeza @felipecabeza16
 */
public class UsersConstructor {
    
   public ArrayList<Person> allusers;
    
    public UsersConstructor() {
        allusers = new ArrayList<Person>();
        read();
     Person p1 = new Person("Correo@gmail.com", "123456", "Felipe", 19, 3000000);   
     allusers.add(p1);   
     
          Person p2 = new Person("Correo2@gmail.com", "123456", "Andres", 19, 3000000);   
     allusers.add(p2);   
    

    }
    
    public Person search(String username, String password){
        
        for (Person searched : allusers)
        {
        if (searched.getMail().equalsIgnoreCase(username) && searched.getPassword().equals(password))    
            return searched;
        }
        
        return null;
            
            
        }
    
 public Person searchMail(String mail){
        
        for (Person searched : allusers)
        {
        if (searched.getMail().equalsIgnoreCase(mail))    
            return searched;
        }
        
        return null;
            
            
        }

    public void constructUsers(Person writerPerson) {
     

  try
      
        {
            FileWriter fw = new FileWriter( "Personas.txt", true);


            BufferedWriter bf = new BufferedWriter( fw );

                
        bf.write(writerPerson.getMail()+",");
        bf.write(writerPerson.getPassword()+",");
        bf.write(writerPerson.getName()+",");
        bf.write(writerPerson.getAge() +",");
             bf.write(writerPerson.getPhone() +",");
                bf.newLine();
        allusers.add(writerPerson);
                bf.close( );    
        }
catch( IOException ioe )
        {
            ioe.printStackTrace( );
        }
          

//To change body of generated methods, choose Tools | Templates.
    }

    public void read() {

         
       try
   {
        Scanner reader = new Scanner( new File ( "Personas.txt" ) );

        while( reader.hasNext( ) ) // test for the end of the file
        {
            // read a line
            String stringRead = reader.nextLine( );

             // process the line read
            StringTokenizer st = new
                     StringTokenizer( stringRead, "," );
            String correo = st.nextToken( );
            String contraseña = st.nextToken( );
            String nombre = st.nextToken( );

            try
            {
               int edad =
                   Integer.parseInt( st.nextToken( ) );
               long telefono =
                   Long.parseLong( st.nextToken( ) );

               Person frTemp = new Person(
                                      correo, contraseña, nombre,
                                      edad, telefono );

               // add FlightRecord obj to listFlightRecords
               allusers.add( frTemp );
            }

           catch ( NumberFormatException nfe )
           {
               JOptionPane.showMessageDialog(null, "Verifica Personas.txt");
               System.exit(1);
           }
       }

      // release resources associated with flights.txt
      reader.close( );
   }

   catch ( FileNotFoundException fnfe )
   {
     System.exit(1 );
   }

   catch ( IOException ioe )
   {
     System.exit(1 );
   }

      // for (Person p : allusers)
          // System.out.println(p);
}

}
