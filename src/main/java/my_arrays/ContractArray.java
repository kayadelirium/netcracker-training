package my_arrays;

import contract_entities.*;
import sorters.ISorting;
import sorters.QuickSort;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * my_arrays.ContractArray wrapping class for my_arrays.Array;
 * contains methods for working with contracts in array; repository for contract;
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
     * auxiliary function finds index for id if it exists
     * @param id contract id should be found
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
     * @param id specified contract id
     */
    public void remove(int id){
        int index = searchIndexForId(id);
        if (index != -1) contractArray.remove(index);
    }

    /**
     * @param id specified contract id
     * @return element with id if it exists or null otherwise;
     */
    public Contract get(int id){
        int index = searchIndexForId(id);
        if(index ==-1) return null;
        else return contractArray.get(index);
    }

    /**
     * @param index contract index in the array
     * @return array[index]
     */
    public Contract getContractWithIndex(int index){
        return contractArray.get(index);
    }
    /**
     * @return array size
     */
    public int size(){
        return contractArray.size();
    }

    /**
     * sorting method with possibility to choose sorting algorithm and comparator
     * @param comparator sorting rule for specified key
     * @param sorting contract array should be sorted
     */
    public void sortBy(Comparator<Contract> comparator, ISorting<Contract> sorting){
        contractArray = sorting.sort(contractArray, comparator);
    }
    /**
     * method sorting by quickSort the repository due to chosen comparator
     * @param comparator sorting rule for specified key
     */
    public void sortBy(Comparator<Contract> comparator){
        sortBy(comparator, new QuickSort<Contract>());
    }

    /**
     * method searching the contracts which meet the condition
     * @param predicate functional expression describing the search criteria
     * @return new repository container with suitable contracts
     */
    public ContractArray findFor(Predicate<Contract> predicate){
        ContractArray result = new ContractArray();
        for(int i=0; i<contractArray.size(); i++) {
            Contract contract = contractArray.get(i);
            if (predicate.test(contract))
                result.add(contract);
        }
        return result;
    }

    @Override
    public String toString() {
        return contractArray.toString();
    }

}
