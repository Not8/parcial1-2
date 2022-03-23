package estacion;

import java.util.ArrayList;

import tren.Tren;

public class Estacion {
    private Tren trenes[];
    private ArrayList<Integer> nTrenes;
    private ArrayList<Integer> llegada;
    private ArrayList<Integer> salida;

    public void setTrenes(int numeroTrenes, int llegadas[], int salidas[], int puestos){
        trenes = new Tren[numeroTrenes];
        ordenamiento(llegadas, salidas);
        for(int i=0; i<llegadas.length; i++){
            trenes[i].setHorarioLlegada(llegada.get(i));
            trenes[i].setHorarioSalida(salida.get(i));
            trenes[i].setPuestosDisponibles(puestos);
            trenes[i].setPuestosVendidos(0);
        }
    }

    public void venderPuesto(int trenesPasajeros[], int horarioPasajeros[]){
        int aux = llegada.size(), aux1 = trenesPasajeros.length;
        for(int i=0; i<aux; i++){
                for(int j=0; j<aux1; j++){
                    if(nTrenes.get(i)==trenesPasajeros[j]){
                    trenes[i].disponibilidadDePuesto(horarioPasajeros[i]);
                    break;
                }
            }
        }
    }

    public boolean verificarHorario(int llegadas[], int salidas[]){
        int aux=llegadas.length;
        for(int i=0; i<aux;i++)
            if(llegadas[i]<=salidas[i]){
                return true;
            }else { 
                return false; 
            }
        return false;
    }

    public int minPlataformas(){
        int aux=1, aux1;
        for(int i=0; i<llegada.size();i++){
            aux1=1;
            for(int j=i+1;j<llegada.size();j++){
                if(llegada.get(i)>llegada.get(j) && salida.get(i)<llegada.get(j)){
                    aux1++;
                }
            }
            if(aux1>aux) aux=aux1;
        }
        return aux;
    }
    
    public void ordenamiento(int llegadas[], int salidas[]){
        int aux=llegadas.length;
        int aux1;
        for(int i=0;i<aux;i++){ nTrenes.add(i,i+1); }
        
        
        for(int i=0; i < aux; i++){  
            for(int j=1; j < (aux-i); j++){  
                     if(llegadas[j-1] > llegadas[j]){  
                            //swap elements  
                            int temp = llegadas[j-1];  
                            llegadas[j-1] = llegadas[j];  
                            llegadas[j] = temp;  
                            
                            temp = salidas[j-1];  
                            salidas[j-1] = salidas[j];  
                            salidas[j] = temp; 
                            
                            aux1 = nTrenes.get(i);
                            nTrenes.set(i, nTrenes.get(j));
                            nTrenes.set(j, aux1);
                    }
            	}
                     
            }  
        for(int i=0; i < llegadas.length; i++){  
            System.out.print(llegadas[i] + " ");  
        }      
        
        if(llegada.isEmpty()){
            llegada.add(llegadas[0]);
        }
        /*for(int i=0;i<aux;i++){
            for(int j=i+1;j<aux;j++){
                if(llegada.get(i)>llegadas[j]){
                    llegada.add(i, llegadas[j]);
                    salida.add(i, salidas[j]);
                    aux1 = nTrenes.get(i);
                    nTrenes.set(i, nTrenes.get(j));
                    nTrenes.set(j, aux1);
                }
            }
        }*/
        
    }
}