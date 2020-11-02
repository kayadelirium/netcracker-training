import contract_entities.*;

public class ContractArray {
    Array<Contract> contractArray = new Array<Contract>();

    public void add(Contract contract){
        contractArray.add(contract);
    }

    private int searchIndexForId(int id){
        for (int i=0; i<contractArray.size(); i++)
        {
            if (contractArray.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    public void remove(int id){
        int index = searchIndexForId(id);
        if (index != -1) contractArray.remove(index);
    }

    public Contract get(int id){
        int index = searchIndexForId(id);
        if(index ==-1) return null;
        else return contractArray.get(index);
    }

}
