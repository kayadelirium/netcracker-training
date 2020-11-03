package contract_entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    enum Sex {FEMALE, MALE}

    private int id;
    private String name;
    private Date birthDate;
    private String passport;
    private Sex sex;

    public Client(int id, String name, Date birthDate, String passport, Sex sex) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.passport = passport;
        this.sex = sex;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPassport() {
        return passport;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge(){
        DateFormat format = new SimpleDateFormat("yyyy");
        int d1 = Integer.parseInt(format.format(this.birthDate));
        int d2 = Integer.parseInt(format.format(new Date()));
        return (d2 - d1);
    }
}
