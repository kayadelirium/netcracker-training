package my_arrays;

import contract_entities.*;

/**
 * my_arrays.ContractArray - wrapping class for my_arrays.Array;
 * contains methods for working with contracts in array;
 */
public class ContractArray {
    Array<Contract> contractArray;

    ContractArray(){
        contractArray = new Array<Contract>();
    }

    /**
     * add contract to array;
     * @param contract
     */
    public void add(Contract contract){
        contractArray.add(contract);
    }

    /**
     * auxiliary function - finds index for id if it exists
     * @param id - contract id should be found
     * @return index of the element with id or -1 if id was not found
     */
    private int searchIndexForId(int id){
        for (int i=0; i<contractArray.size(); i++)
        {
            if (contractArray.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    /**
     * removes element with specified id if it exists
     * @param id - specified contract id
     */
    public void remove(int id){
        int index = searchIndexForId(id);
        if (index != -1) contractArray.remove(index);
    }

    /**
     * @param id - specified contract id
     * @return element with id if it exists or null otherwise;
     */
    public Contract get(int id){
        int index = searchIndexForId(id);
        if(index ==-1) return null;
        else return contractArray.get(index);
    }

    /**
     * @return array size
     */
    public int size(){
        return contractArray.size();
    }
}
