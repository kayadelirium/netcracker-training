package my_arrays;

import contract_entities.Client;
import contract_entities.Contract;
import junit.framework.TestCase;

import java.util.Date;

public class ContractArrayTest extends TestCase {

    public void testRemove() {
        ContractArray contractArray = new ContractArray();
        Array<Contract> expected = new Array<Contract>();

        for(int i=0; i<10; i++){
            expected.add(new Contract(i,new Date(), new Date(), 1000*i, new Client(i, "name", new Date(), " ", Client.Sex.FEMALE)));
            contractArray.add(new Contract(i,new Date(), new Date(), 1000*i, new Client(i, "name", new Date(), " ", Client.Sex.FEMALE)));
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
            expected.add(new Contract(i,new Date(), new Date(), 1000*i, new Client(i, "name", new Date(), " ", Client.Sex.FEMALE)));
            contractArray.add(new Contract(i,new Date(), new Date(), 1000*i, new Client(i, "name", new Date(), " ", Client.Sex.FEMALE)));
        }
        for(int i=0; i<10; i++){
            assertEquals(i, expected.get(i).getId());
        }

        assertEquals(expected.get(4), contractArray.get(4));

        assertNull(contractArray.get(-1));
    }
}