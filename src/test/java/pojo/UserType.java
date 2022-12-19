package pojo;

public class UserType {



        private String usertype;

    public UserType(String usertype) {
        this.usertype = usertype;
    }

    public UserType() {
    }

    public String getUsertype() {
            return usertype;
        }

        public void setUsertype(String usertype) {
            this.usertype = usertype;
        }

        @Override
        public String toString() {
            return "Usertype{" +
                    "usertype='" + usertype + '\'' +
                    '}';
        }

    }


