package contract_entities;

import java.util.Date;

public class InternetContract extends Contract{

    private int maxSpeed;

    public InternetContract(int id, Date startDate, Date endDate, int contractNumber, Client client, int maxSpeed) {
        super(id, startDate, endDate, contractNumber, client);
        this.maxSpeed = maxSpeed;
    }

}
