package contract_entities;

import java.util.Date;
import java.util.Objects;

/**
 * Contract - superclass for contract entity - contains properties:
 * contract id;
 * date when contract starts;
 * date when contract ends;
 * contract number;
 * client with whom contract is signed;
 */
public class Contract {
    private int id;
    private Date startDate;
    private Date endDate;
    private int ContractNumber;
    private Client client;

    public Contract(int id, Date startDate, Date endDate, int contractNumber, Client client) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        ContractNumber = contractNumber;
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id &&
                ContractNumber == contract.ContractNumber &&
                Objects.equals(startDate, contract.startDate) &&
                Objects.equals(endDate, contract.endDate) &&
                Objects.equals(client, contract.client);
    }

    public int getContractNumber() {
        return ContractNumber;
    }

    public void setContractNumber(int contractNumber) {
        ContractNumber = contractNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
