package contract_entities;

import java.util.Date;

public class TelevisionContract extends Contract{

    private String channelPack;

    public TelevisionContract(int id, Date startDate, Date endDate, int contractNumber, Client client, String channelPack) {
        super(id, startDate, endDate, contractNumber, client);
        this.channelPack = channelPack;
    }
}
