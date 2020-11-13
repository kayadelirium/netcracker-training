package ContractEntities;

import java.time.LocalDate;

/**
 * InternetContract - Contract subclass {@link Contract}
 * also contains
 * maximal speed of internet connection
 */
public class InternetContract extends Contract{

    private int maxSpeed;

    public InternetContract(int id, LocalDate startDate, LocalDate endDate, int contractNumber, Client client, int maxSpeed) {
        super(id, startDate, endDate, contractNumber, client);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
