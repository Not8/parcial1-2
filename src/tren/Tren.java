package tren;

public class Tren {
    private int puestosVendidos;
    private int puestosDisponibles;
    private int horarioLlegada;
    private int horarioSalida;

    public String disponibilidadDePuesto(int horario){
        if(puestosDisponibles==0) { 
            return "No hay puestos disponibles para este tren"; 
        } else{
            if((horarioSalida)<=horario) {
                return "Tren no disponible";
            } else{
                puestosVendidos++;
                puestosDisponibles--;
                return("Asiento vendido: "+tipoDePuesto());
            }
        } 
    }

    public String tipoDePuesto(){
        if(puestosVendidos>4){
            if((puestosVendidos%4)==1 || (puestosVendidos%4)==4){
            return "ventana";
            }else{
                return "pasillo";
            }
        }else{
            if(puestosVendidos==1 || puestosVendidos==4){
                return "ventana";
                }else{
                    return "pasillo";
                }
        }
    }


    public int getPuestosVendidos() {
        return this.puestosVendidos;
    }

    public void setPuestosVendidos(int puestosVendidos) {
        this.puestosVendidos = puestosVendidos;
    }

    public int getPuestosDisponibles() {
        return this.puestosDisponibles;
    }

    public void setPuestosDisponibles(int puestosDisponibles) {
        this.puestosDisponibles = puestosDisponibles;
    }

    public int getHorarioLlegada() {
        return this.horarioLlegada;
    }

    public void setHorarioLlegada(int horarioLlegada) {
        this.horarioLlegada = horarioLlegada;
    }

    public int getHorarioSalida() {
        return this.horarioSalida;
    }

    public void setHorarioSalida(int horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

}    
