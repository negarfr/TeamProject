package pojo;

public class CategoryPojo {


    private String usertype;
    private String category;

    public CategoryPojo(String usertype, String category) {
        this.usertype = usertype;
        this.category = category;

    }

    public CategoryPojo() {
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "usertype=" + usertype +
                ", category='" + category + '\'' +
                '}';
    }
}

