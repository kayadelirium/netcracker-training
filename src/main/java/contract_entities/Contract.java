package contract_entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;

/**
 * Contract - superclass for contract entity - contains properties:
 * contract id;
 * date when contract starts;
 * date when contract ends;
 * contract number;
 * client with whom contract is signed;
 */
public class Contract{
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int contractNumber;
    private Client client;

    public Contract(int id, LocalDate startDate, LocalDate endDate, int contractNumber, Client client) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractNumber = contractNumber;
        this.client = client;
    }

    public Contract() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id &&
                contractNumber == contract.contractNumber &&
                Objects.equals(startDate, contract.startDate) &&
                Objects.equals(endDate, contract.endDate) &&
                Objects.equals(client, contract.client);
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "{" + id +
                ", " + startDate +
                ", " + endDate +
                ", " + contractNumber +
                ", " + client.toString()+
                '}';
    }

    /**
    all comparators for super class contract to sort
     */

    public static class CompareById implements Comparator<Contract>{
        @Override
        public int compare(Contract o1, Contract o2) {
            return o1.getId() - o2.getId();
        }
    }
    public static class CompareByStartDate implements Comparator<Contract>{
        @Override
        public int compare(Contract o1, Contract o2) {
            return o1.getStartDate().compareTo(o2.getStartDate());
        }
    }

    public static class CompareByEndDate implements Comparator<Contract>{
        @Override
        public int compare(Contract o1, Contract o2) {
            return o1.getEndDate().compareTo(o2.getEndDate());
        }
    }

    public static class CompareByContractNumber implements Comparator<Contract>{
        @Override
        public int compare(Contract o1, Contract o2) {
            return o1.contractNumber - o2.contractNumber;
        }
    }

    public static class CompareByClient implements Comparator<Contract>{
        @Override
        public int compare(Contract o1, Contract o2) {
            return o1.getClient().compareTo(o2.getClient());
        }
    }
}
