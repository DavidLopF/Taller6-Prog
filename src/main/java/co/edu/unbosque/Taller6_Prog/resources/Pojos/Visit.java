package co.edu.unbosque.Taller6_Prog.resources.Pojos;

public class Visit {

    private int visit_id;
    private String create_at;
    private String type;
    private String descripcion;
    private String vet_id;
    private int pet_id;
    private int microchip;


    public Visit(int visit_id, String create_at, String type, String descripcion, String vet_id, int pet_id, int microchip) {
        this.visit_id = visit_id;
        this.create_at = create_at;
        this.type = type;
        this.descripcion = descripcion;
        this.vet_id = vet_id;
        this.pet_id = pet_id;
        this.microchip = microchip;
    }

    public Visit() {
    }

    public Visit(String type) {
        this.type = type;
    }

    public int getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(int visit_id) {
        this.visit_id = visit_id;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getVet_id() {
        return vet_id;
    }

    public void setVet_id(String vet_id) {
        this.vet_id = vet_id;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public int getMicrochip() {
        return microchip;
    }

    public void setMicrochip(int microchip) {
        this.microchip = microchip;
    }
}
