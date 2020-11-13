package contract_entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Client - class, containing client properties -
 * client id;
 * name;
 * birthdate;
 * passport data;
 * sex;
 */
public class Client implements Comparable<Client>{
    @Override
    public int compareTo(Client o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Client{" + id + ", " + name + ", " + birthDate + ", " + passport + ", " + sex + '}';
    }

    public enum Sex {FEMALE, MALE}

    private int id;
    private String name;
    private LocalDate birthDate;
    private String passport;
    private Sex sex;

    public Client(int id, String name, LocalDate birthDate, String passport, Sex sex) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.passport = passport;
        this.sex = sex;
    }

    public Client(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(name, client.name) &&
                Objects.equals(birthDate, client.birthDate) &&
                Objects.equals(passport, client.passport) &&
                sex == client.sex;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPassport() {
        return passport;
    }

    public Sex getSex() {
        return sex;
    }

    /**
     * function, counting the age of the client
     * @return client age at the moment of calling the function
     */
    public int getAge() {

        LocalDate now = LocalDate.now();
        return birthDate.getYear() - now.getYear();
        /*
        this.birthDate.setYear(this.birthDate.getYear() - 1900);
        DateFormat format = new SimpleDateFormat("yyyy");
        int d1 = Integer.parseInt(format.format(this.birthDate));
        System.out.println(this.birthDate);
        int d2 = Integer.parseInt(format.format(new LocalDate()));
        System.out.println(d1);
        System.out.println(d2);
        return (d2 - d1);
        */
    }
}
