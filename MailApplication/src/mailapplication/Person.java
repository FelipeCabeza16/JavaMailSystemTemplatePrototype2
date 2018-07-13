/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailapplication;

/**
 *
 * @author Felipe Cabeza @felipecabeza16
 */
public class Person {


    private String mail, password, name;
         private  int age;
          private long phone;
          
            
                  
    public Person(String mail, String password, String name, int age, long phone) {
        this.mail = mail;
        this.password = password;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
    


    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    

public String toString(){
return "Nombre : "+this.name +"\n Correo : "+this.mail;    
    
}
    
    
}
