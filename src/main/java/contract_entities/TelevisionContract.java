package contract_entities;

import java.util.Date;

/**
 * TelevisionContract - Contract subclass {@link Contract}
 * also contains
 * info about linked pack of channels
 */
public class TelevisionContract extends Contract{

    private String channelPack;

    public TelevisionContract(int id, Date startDate, Date endDate, int contractNumber, Client client, String channelPack) {
        super(id, startDate, endDate, contractNumber, client);
        this.channelPack = channelPack;
    }

    public String getChannelPack() {
        return channelPack;
    }

    public void setChannelPack(String channelPack) {
        this.channelPack = channelPack;
    }
}
