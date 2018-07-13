
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailapplication;

import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 *
 * @author Felipe Cabeza @felipecabeza16
 */
public class MessagesReader extends JFrame{
    public ArrayList <String> allmessages;
    private Scanner scan;
    private         File inputFile;
    String answer;
    Person loggedperson;
    int counter=0;
//    String to, mes, from;
    
   public MessagesReader(Person loggedperson){
    super("Messages");
    this.loggedperson = loggedperson;
    answer = "";
       scan = new Scanner("Information.txt");

       
   
} 
  public ArrayList<String> read(){
  //createFrame();
  ArrayList <String> responseMessages = new ArrayList <String>(); 
  try
   {
        Scanner file = new Scanner( new File ( "Information.txt" ) );

        while( file.hasNext( ) ) // test for the end of the file
        {
            // read a line
            String stringRead = file.nextLine( );

             // process the line read
            StringTokenizer st = new
                     StringTokenizer( stringRead, "," );
            String to = st.nextToken( );
            String message = st.nextToken( );
            String from = st.nextToken( );

            if (to.equalsIgnoreCase(loggedperson.getMail()))
            {
                
               answer +="                   Para :          "+ to + "\t          Mensaje : " +  message +"\t            De : "+from+"\n";               
               responseMessages.add(answer);
            counter++;
            }
                
                try
            {
           
           
                                                
               //FlightRecord frTemp = new FlightRecord(
                 //                     flightNumber, origin, destination,
                   //                   numPassengers, avgTicketPrice );

               // add FlightRecord obj to listFlightRecords
               //listFlightRecords.add( frTemp );
            }

           catch ( NumberFormatException nfe )
           {
                System.out.println( "Error "
                                              + stringRead
                                              + "; record ignored" );
           }
       }

      // release resources associated with flights.txt
      file.close( );

   }

   catch ( FileNotFoundException fnfe )
   {
     System.out.println( "Unable to find Information.txt" );
   }

   catch ( IOException ioe )
   {
     ioe.printStackTrace( );
   }

  System.out.println(responseMessages);
      return responseMessages;
}

    private void createFrame() {
       
setBounds(400,400,400,400);
setVisible(true);
//To change body of generated methods, choose Tools | Templates.
    }

}
