package co.edu.unbosque.Taller6_Prog.resources.Pojos;

public class Case {

    private String create_at;
    private String type;
    private String descrip;
    private int id;

    public Case(String create_at, String type, String descrip, int id) {
        this.create_at = create_at;
        this.type = type;
        this.descrip = descrip;
        this.id = id;
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

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
