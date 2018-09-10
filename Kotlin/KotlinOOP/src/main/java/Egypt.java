public class Egypt {

    private           String first_name;
    private   final   String last_name;
    private           int age;

    public Egypt(String first_name, String last_name, int age) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;

    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getAge() {
        return age;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String returnString() {

        return "My first name is: " + first_name + ", And my last name is: " + last_name + ", And my age is: " + String.valueOf(age);

    }

}