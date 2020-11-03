package contract_entities;

import java.util.Date;

public class PhoneContract extends Contract{

    private int minutes;
    private int gigabytes;
    private int sms;

    public PhoneContract(int id, Date startDate, Date endDate, int contractNumber, Client client, int minutes, int gigabytes, int sms) {
        super(id, startDate, endDate, contractNumber, client);
        this.minutes = minutes;
        this.gigabytes = gigabytes;
        this.sms = sms;
    }
}
