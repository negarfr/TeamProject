package pojo;

public class Put_Pojo {
private int id;
private String brand;

    public Put_Pojo(int id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public Put_Pojo() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Put_Pojo{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                '}';
    }
}



