package contract_entities;

import java.util.Date;

/**
 * PhoneContract - Contract subclass {@link Contract}
 * also contains
 * number of minutes, gigabytes, sms in the phone calling plan;
 */
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

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getGigabytes() {
        return gigabytes;
    }

    public void setGigabytes(int gigabytes) {
        this.gigabytes = gigabytes;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }
}
