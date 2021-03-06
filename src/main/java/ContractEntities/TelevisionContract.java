package ContractEntities;

import java.time.LocalDate;

/**
 * TelevisionContract - Contract subclass {@link Contract}
 * also contains
 * info about linked pack of channels
 */
public class TelevisionContract extends Contract{

    private String channelPack;

    public TelevisionContract(int id, LocalDate startDate, LocalDate endDate, int contractNumber, Client client, String channelPack) {
        super(id, startDate, endDate, contractNumber, client);
        this.channelPack = channelPack;
    }

    public TelevisionContract(){

    }
    public String getChannelPack() {
        return channelPack;
    }

    public void setChannelPack(String channelPack) {
        this.channelPack = channelPack;
    }
}
