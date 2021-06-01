package co.edu.unbosque.Taller6_Prog.resources.Pojos;

import java.util.Date;

public class Picture {
    private String ruta;
    private String description;
    private String data;
    public Picture(){

    }
    public Picture(String ruta, String description){
        this.ruta = ruta;
        this.description = description;
        Date dataCreation = new Date();
        data = dataCreation.toString();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
