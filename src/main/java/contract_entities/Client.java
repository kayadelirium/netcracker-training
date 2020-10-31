package contract_entities;

import java.util.Date;

public class Client {
    enum Sex {FEMALE, MALE}

    private int id;
    private String name;
    private Date birthDate;
    private String passport;
    private Sex sex;
}
