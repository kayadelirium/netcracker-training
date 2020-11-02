package contract_entities;

import java.util.Date;

public class Contract {
    private int id;
    private Date startDate;
    private Date endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
