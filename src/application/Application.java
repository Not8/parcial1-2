package application;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import estacion.Estacion;

//import your classes here

public class Application {
  public static void main(String[] args) {
  	//PARTE 1
  	//this portion of code reads a file with name obtained from the main input arguments list args
  	//and places it on a fixed size array
  	String filenamet = args[0];
  	String filenamep = args[1];
  	final int Ntrenes = Integer.parseInt(args[2]);
  	final int nPasajeros = Integer.parseInt(args[3]);
  	int nPuestos = Integer.parseInt(args[4]);
  	int[] llegadas = new int[Ntrenes];
  	int[] salidas = new int[Ntrenes];
  	int[] trenesPasajeros = new int[nPasajeros];
  	int[] horarioPasajeros = new int[nPasajeros];
  	int count = 0;
  	//leer trenes
    try {
      File myObj = new File(filenamet);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        int intdata = Integer.parseInt(data);
        if(count < Ntrenes) {
        	llegadas[count] = intdata;
        }
        else {
        	salidas[count%Ntrenes] = intdata;
        }
        count++;
      }
      //you can check the inputs with these lines
      //for(int i = 0; i<Ntrenes; i++) {
      //	System.out.println(llegadas[i] + " " + salidas[i] + "\n");
      //}
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    //leer pasajeros
    count = 0;
    try {
      File myObj = new File(filenamep);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        int intdata = Integer.parseInt(data);
        if(count < nPasajeros) {
        	trenesPasajeros[count] = intdata;
        }
        else {
        	horarioPasajeros[count%nPasajeros] = intdata;
        }
        count++;
      }
      //you can check the inputs with these lines
      //for(int i = 0; i<nPasajeros; i++) {
      //	System.out.println(trenesPasajeros[i] + " " + horarioPasajeros[i] + "\n");
      //}
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    //PARTE 2
    //your code should start here
    
    Estacion estacion = new Estacion();
    estacion.setTrenes(Ntrenes, llegadas, salidas, nPuestos);
    estacion.venderPuesto(trenesPasajeros, horarioPasajeros);
    estacion.minPlataformas();
  }
}