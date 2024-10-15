package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client partito");
        Socket s = new Socket("localhost", 3000); // può esserci una eccezione se il serve non c'è
        System.out.println("il client si è collegato");
    
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String stringMinuscola ="";
        String scelta ="";
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("\n" + " -  - scrivi cosa vuoi fare :  -  -" + "\n" + "1 - stringa da minuscola a maiuscola"+ "\n" + "2 - stringa da maiuscola a minuscola"+ "\n" + "3 - ribaltare i caratteri della stringa"+ "\n" + "4 - contare numero caratteri" + "\n" + "digita exit per uscire " + "\n" );    
            scelta = scanner.nextLine();
          
           
            System.out.println("scrivi la tua stringa:");   // input scelta        
            stringMinuscola = scanner.nextLine();
          

           

            System.out.println("la stringa scritta è " + stringMinuscola);
            System.out.println("scelta numero : " + scelta); // scelta di cosa fare 
              
            //invio stringa al server
            out.writeBytes(stringMinuscola + "\n");
            out.writeBytes(scelta + "\n");

            
            //riprendo la stringa
           
            String stringRicevuta = in.readLine();
            if(stringRicevuta == null){
              System.out.println(  "volontà di chiudere accettata");
            }else{
                System.out.println(stringRicevuta);
            }

            
        }while(!(stringMinuscola.equals("exit")));

        System.out.println("comunicazione terminata");
         s.close();
    }
}