package Model;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Person {
    private String name1;
    private String name2;
    private String name3;
    private Long cnp;
    private String email;

    public Person(){
    }

    public Person(String name1, String name2, String name3, Long cnp, String email) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.cnp = cnp;
        this.email = email;
    }

    public Boolean isValid(){
        return isValidEmailAddress(email) && isValidName(name1) && isValidName(name2)
                && isValidName(name3) && cnp.toString().length()==13;
    }

    private Boolean isValidName(String name){
        return !name.equals("") && !name.equals("-") && !name.matches(".*\\d.*");
    }

    public Boolean isEmpty(){
        return name1==null && name2==null && name3==null && cnp==null && email==null;
    }

    private static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public String toFileFormat(){
        StringBuilder s = new StringBuilder();
        s.append(name1).append("~").append(name2).append("~").append(name3).append("~")
                .append(cnp.toString()).append("~").append(email).append("%");
        return s.toString();
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public Long getCnp() {
        return cnp;
    }

    public void setCnp(Long cnp) {
        this.cnp = cnp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Model.Person{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", name3='" + name3 + '\'' +
                ", cnp=" + cnp +
                ", email='" + email + '\'' +
                '}';
    }
}
