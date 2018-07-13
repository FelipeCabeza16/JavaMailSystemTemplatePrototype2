/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class Message {
private   String content,issue;
public static int append=0;
private Scanner sc;
private File file;
private Person to,from;
    public Message(Person to, Person from,  String content) 
    {
   this.content = content;
   this.to = to;
this.from = from;   
   
sendMessage();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public int getAppend() {
        return append;
    }

    public void setAppend(int append) {
        this.append = append;
    }

 public void sendMessage() {
     
try{
            
FileWriter fw = new FileWriter( "Information.txt", true );
BufferedWriter bw = new BufferedWriter( fw );
    
bw.write(to.getMail()+ ",");
bw.write(content + ",");
bw.write(from.getMail()+ ",");


System.out.println(to.getMail()+ ",");
System.out.println(content + ",");
System.out.println(from.getMail()+ ",");


//bw.write("Correo2@gmail.com,");
//bw.write("XD,");
//bw.write("Correo@gmail.com,");

bw.newLine();
bw.close();
        }
     catch ( FileNotFoundException fnfe )
   {
     System.exit(1 );
   } catch (IOException ex) {
        System.exit(1);
    }
 
 
 }
    
    
    
}
