import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aria on 18/04/2017.
 */
public class GuestList {
    private static Map<Integer, int[]> companyList = new HashMap<>();
    static int[] rank = {1, 2, -2, 5, -5, 3, 11, 6}; //ranks of employees

    public static void main(String[] args) {
        companyList.put(1, new int[]{2,3,4}); //CEO has children 2, 3, 4
        companyList.put(2, new int[]{5,6});
        companyList.put(3, new int[]{7});
        companyList.put(4, null);
        companyList.put(5, new int[]{8});
        companyList.put(6, null);
        companyList.put(7, null);
        companyList.put(8, null);
        OptimalGuestList();
    }

    private static void OptimalGuestList(){
        int[] includedList = new int[companyList.size()+1];
        int[] excludedList = new int[companyList.size()+1];

        for (int i = companyList.size(); i>0; i--){
            int includedSum = 0;
            int excludedSum = 0;
            int[] temp = companyList.get(i);
            if(temp!= null){ //foreach, if the employee has a subordinate
                for (int j = 0; j < temp.length; j++){
                    includedSum += includedList[temp[j]];
                    excludedSum += excludedList[temp[j]];
                }
            }
            excludedList[i] = includedSum;
            includedList[i] = Math.max(excludedSum + rank[i-1], includedSum);
        }
        for (int i = 0; i<= companyList.size(); i++){
            if(includedList[i] > excludedList[i]){
                System.out.println(i);
            }
        }
    }

}
