package filter_predicates;

import contract_entities.*;

import java.time.LocalDate;
import java.util.function.Predicate;

/**
 * Predicates - class with equal predicate expressions for every contract field
 */
public class Predicates {

    public static Predicate<Contract> isId(int id){
        return p -> p.getId() == id;
    }
    public static Predicate<Contract> isStartDate(LocalDate startDate){
        return p -> p.getStartDate() == startDate;
    }
    public static Predicate<Contract> isEndDate(LocalDate endDate){
        return p -> p.getEndDate() == endDate;
    }
    public static Predicate<Contract> isContractNumber(int contractNumber){
        return p -> p.getContractNumber() == contractNumber;
    }

    public static Predicate<Contract> isClientId(int clientId){
        return p -> p.getClient().getId() == clientId;
    }
    public static Predicate<Contract> isClientName(String name){
        return p -> p.getClient().getName().equals(name);
    }
    public static Predicate<Contract> isClientBirthDate(LocalDate birthDate){
        return p -> p.getClient().getBirthDate() == birthDate;
    }
    public static Predicate<Contract> isClientPassport(String passport){
        return p -> p.getClient().getPassport().equals(passport);
    }
    public static Predicate<Contract> isClientSex(Client.Sex sex){
        return p -> p.getClient().getSex() == sex;
    }

    public static Predicate<Contract> isPhoneMinutes(int minutes){
        return p -> p instanceof PhoneContract && ((PhoneContract) p).getMinutes() == minutes;
    }
    public static Predicate<Contract> isPhoneGigabytes(int gigabytes){
        return p -> p instanceof PhoneContract && ((PhoneContract) p).getMinutes() == gigabytes;
    }
    public static Predicate<Contract> isPhoneSms(int sms){
        return p -> p instanceof PhoneContract && ((PhoneContract) p).getMinutes() == sms;
    }

    public static Predicate<Contract> isInternetMaxSpeed(int maxSpeed){
        return p -> p instanceof InternetContract && ((InternetContract) p).getMaxSpeed() == maxSpeed;
    }

    public static Predicate<Contract> isTelevisionChannelPack(String channelPack){
        return p -> p instanceof TelevisionContract && ((TelevisionContract) p).getChannelPack().equals(channelPack);
    }
}
