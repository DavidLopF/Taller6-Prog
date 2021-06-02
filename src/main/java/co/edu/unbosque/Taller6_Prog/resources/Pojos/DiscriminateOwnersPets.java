package co.edu.unbosque.Taller6_Prog.resources.Pojos;

public class DiscriminateOwnersPets {
    private int count;
    private String name;
    public DiscriminateOwnersPets() {
    }

    public DiscriminateOwnersPets(int countOwners, String name) {
        this.count = countOwners;
        this.name = name;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
