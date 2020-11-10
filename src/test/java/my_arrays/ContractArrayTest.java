package my_arrays;

import contract_entities.Client;
import contract_entities.Contract;
import filter_predicates.Predicates;
import junit.framework.TestCase;
import sorters.BubbleSort;
import sorters.QuickSort;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.function.Predicate;

public class ContractArrayTest extends TestCase {

    public void testRemove() {
        ContractArray contractArray = new ContractArray();
        Array<Contract> expected = new Array<Contract>();

        for(int i=0; i<10; i++){
            expected.add(new Contract(i, LocalDate.now(), LocalDate.now(), 1000*i, new Client(i, "name", LocalDate.now(), " ", Client.Sex.FEMALE)));
            contractArray.add(new Contract(i, LocalDate.now(), LocalDate.now(), 1000*i, new Client(i, "name", LocalDate.now(), " ", Client.Sex.FEMALE)));
        }
        for(int i=0; i<10; i++){
            assertEquals(i, expected.get(i).getId());
        }
        expected.remove(4);
        contractArray.remove(4);

        assertEquals("removing would take place",expected.size(), contractArray.size());

        int exp2 = contractArray.size();
        contractArray.remove(-1);
        assertEquals("removing would not take place", exp2, contractArray.size());
    }

    public void testGet() {
        ContractArray contractArray = new ContractArray();
        Array<Contract> expected = new Array<Contract>();

        for(int i=0; i<10; i++){
            expected.add(new Contract(i,LocalDate.now(), LocalDate.now(), 1000*i, new Client(i, "name", LocalDate.now(), " ", Client.Sex.FEMALE)));
            contractArray.add(new Contract(i,LocalDate.now(),LocalDate.now(), 1000*i, new Client(i, "name", LocalDate.now(), " ", Client.Sex.FEMALE)));
        }
        for(int i=0; i<10; i++){
            assertEquals(i, expected.get(i).getId());
        }

        assertEquals(expected.get(4), contractArray.get(4));

        assertNull(contractArray.get(-1));
    }

    public void testSortBy() {
        ContractArray array = new ContractArray();
        ContractArray expected = new ContractArray();
        for (int i = 0; i < 6; i++) {
            array.add(new Contract(i, LocalDate.of(2012 - i, 5, 12), LocalDate.of(2018 - i, 5, 12), 6 - i, new Client(i, "name" + i, LocalDate.of(1973, 1, 1), "", Client.Sex.MALE)));
            expected.add(new Contract(i, LocalDate.of(2012 - i, 5, 12), LocalDate.of(2018 - i, 5, 12), 6 - i, new Client(i, "name" + i, LocalDate.of(1973, 1, 1), "", Client.Sex.MALE)));
        }
        array.sortBy(new Contract.CompareByStartDate(), new BubbleSort<Contract>());

        for(int i=0; i<6; i++){
            assertEquals (expected.getContractWithIndex(i), array.getContractWithIndex(6-i-1));
        }

        expected.sortBy(new Contract.CompareByEndDate(), new QuickSort<>());

        for(int i=0; i<6; i++){
            assertEquals(expected.getContractWithIndex(i), array.getContractWithIndex(i));
        }
    }

    public void testFindFor() {
        ContractArray expected = new ContractArray();
        for (int i = 0; i < 6; i++) {
            expected.add(new Contract(i, LocalDate.of(2012 - i, 5, 12), LocalDate.of(2018 - i, 5, 12), 6 - i, new Client(i, "name" + i, LocalDate.of(1973, 1, 1), "", Client.Sex.MALE)));
        }
        ContractArray found1 = expected.findFor(Predicates.isClientSex(Client.Sex.MALE));
        for (int i=0; i<6; i++){
            assertEquals(expected.getContractWithIndex(i), found1.getContractWithIndex(i));
        }
        ContractArray found2 = expected.findFor(Predicates.isClientId(5));
        assertEquals(1, found2.size());
        assertEquals(expected.getContractWithIndex(5),found2.getContractWithIndex(0));
    }
}