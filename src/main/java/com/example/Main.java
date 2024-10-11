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
        
        do{

            System.out.println("scrivi la tua stringa:");
            Scanner scanner = new Scanner(System.in);
            stringMinuscola = scanner.nextLine();
          

            System.out.println("la stringa scritta è " + stringMinuscola);

            //invio stringa al server
            out.writeBytes(stringMinuscola + "\n");
            if(stringMinuscola.equals("exit")) break;
            //riprendo la stringa
            String stringRicevuta = in.readLine();
            System.out.println(stringRicevuta);
        }while(!(stringMinuscola.equals("exit")));

        System.out.println("comunicazione terminata");
         s.close();
    }
}