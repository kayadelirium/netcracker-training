package withFiles;

import au.com.bytecode.opencsv.CSVReader;
import ContractEntities.*;
import MyArrays.ContractArray;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * ReadFromCSV - class for parsing the .csv files to ContractArray repositories
 */
public class ReadFromCSV {

    /**
     * counter for Contract.id
     */
    private static int idContract = 1;
    /**
     * counter for Client.id
     */
    private static int idClient = 1;

    /**
     * counts the relevant value for Contract.id and renews it after getting
     * @return current value for Contract.id
     */
    public static int getAndIncrementIdContract(){
        return idContract++;
    }
    /**
     * counts the relevant value for Client.id and renews it after getting
     * @return current value for Client.id
     */
    public static int getAndIncrementIdClient(){
        return  idClient++;
    }

    /**
     * function for info translation from .csv file to ContractArray repository
     * @param filename the name of file should be parsed
     * @return ContractArray containing the information from .csv file
     */
    public static ContractArray readFrom(String filename){
        ContractArray result = new ContractArray();
        List<Client> clientList = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(filename), ';', '"', 1);
            String[] line;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            while ((line = reader.readNext()) != null) {
                Contract contract;
                Client client;
                switch (line[7]) {
                    case "1":
                        contract = new InternetContract();
                        ((InternetContract) contract).setMaxSpeed(Integer.parseInt(line[8]));
                        break;
                    case "2":
                        contract = new PhoneContract();
                        ((PhoneContract) contract).setMinutes(Integer.parseInt(line[8]));
                        ((PhoneContract) contract).setGigabytes(Integer.parseInt(line[9]));
                        ((PhoneContract) contract).setSms(Integer.parseInt(line[10]));
                        break;
                    case "3":
                        contract = new TelevisionContract();
                        ((TelevisionContract) contract).setChannelPack(line[8]);
                        break;
                    default:
                        continue;
                }
                contract.setId(getAndIncrementIdContract());
                contract.setStartDate(LocalDate.parse(line[0], formatter));
                contract.setEndDate(LocalDate.parse(line[1], formatter));
                contract.setContractNumber(Integer.parseInt(line[2]));

                client = new Client();

                client.setName(line[3]);
                client.setBirthDate(LocalDate.parse(line[4], formatter));
                client.setPassport(line[5]);
                if (line[6].equals("MALE")) client.setSex(Client.Sex.MALE);
                else if (line[6].equals("FEMALE")) client.setSex(Client.Sex.FEMALE);
                else client.setSex(null);

                boolean isClientInList = false;
                for(Client existingClient: clientList){
                    if(existingClient.getPassport().equals(client.getPassport())){
                        client = existingClient;
                        isClientInList = true;
                    }
                }
                if(!isClientInList){
                    client.setId(getAndIncrementIdClient());
                    clientList.add(client);
                }
                contract.setClient(client);

                result.add(contract);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return result;
    }
}
