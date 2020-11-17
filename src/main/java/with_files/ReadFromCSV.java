package with_files;

import au.com.bytecode.opencsv.CSVParser;
import au.com.bytecode.opencsv.CSVReader;
import contract_entities.*;
import my_arrays.ContractArray;

import javax.swing.text.DateFormatter;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReadFromCSV {
    public static ContractArray readFrom() throws IOException {

        CSVReader reader = new CSVReader(new FileReader("input.csv"), ';', '"', 1);
        String[] line = null;
        Scanner scanner = null;
        ContractArray result = null;


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while ((line = reader.readNext())!=null) {
            Contract contract;
            Client client;
            switch (line[1]) {
                case "1":
                    contract = new InternetContract();
                    ((InternetContract) contract).setMaxSpeed(Integer.parseInt(line[10]));
                    break;
                case "2":
                    contract = new PhoneContract();
                    ((PhoneContract) contract).setMinutes(Integer.parseInt(line[10]));
                    ((PhoneContract) contract).setGigabytes(Integer.parseInt(line[11]));
                    ((PhoneContract) contract).setSms(Integer.parseInt(line[12]));
                    break;
                case "3":
                    contract = new TelevisionContract();
                    ((TelevisionContract) contract).setChannelPack(line[10]);
                    break;
                default:
                    continue;
            }
            client = new Client();

            contract.setId(Integer.parseInt(line[0]));
            contract.setStartDate(LocalDate.parse(line[2], formatter));
            contract.setEndDate(LocalDate.parse(line[3], formatter));
            contract.setContractNumber(Integer.parseInt(line[4]));
            client.setId(Integer.parseInt(line[5]));
            client.setName(line[6]);
            client.setBirthDate(LocalDate.parse(line[7], formatter));
            client.setPassport(line[8]);
            if (line[9].equals("MALE")) client.setSex(Client.Sex.MALE);
            else if (line[9].equals("FEMALE")) client.setSex(Client.Sex.FEMALE);
            else client.setSex(null);
            contract.setClient(client);

            result.add(contract);
        }
        return result;
    }
}
