import java.util.ArrayList;

/**
 * Created by Aria on 06/04/2017.
 */
public class Skyline {
    public static void main(String[] args) {
        int points[][] = {{1,11,5},{2,6,7},{3,13,9},{12,7,16},{14,3,25},{19,18,22},{23,13,29},{24,4,28}};
        Building buildingMap[] = mapBuildings(points);
        ArrayList<Corner> finalMap = divide(buildingMap, 0, buildingMap.length-1);
        for (Corner c: finalMap
             ) {
            System.out.print("(" + c.x+","+c.height+")");
        }

    }
    private static Building[] mapBuildings(int[][] points){
        Building buildingMap[] = new Building[points.length];
        for(int i = 0; i < points.length; i++){
            buildingMap[i] = new Building(points[i][0],points[i][1],points[i][2]);
        }
        return buildingMap;
    }

    private static ArrayList<Corner> divide(Building buildingMap[], int low, int high){
        int mid = (low + high)/2;
        if(high == low){
            ArrayList<Corner> equal = new ArrayList<>();
            equal.add(new Corner(buildingMap[low].l, buildingMap[low].h));
            equal.add(new Corner(buildingMap[low].r, 0));
            return equal;
        }
        if(high > low){
            ArrayList<Corner> bm1 = divide(buildingMap, low, mid);
            ArrayList<Corner> bm2 = divide(buildingMap, mid+1, high);
            ArrayList<Corner> conquer = merge(bm1, bm2);
            return conquer;
        }
        return null;
    }

    private static ArrayList<Corner> merge(ArrayList<Corner> bm1, ArrayList<Corner> bm2) {
        ArrayList<Corner> arr = new ArrayList<>();

        //current height
        int h1 = 0, h2 = 0;

        //corner index
        int c1 = 0, c2 = 0;

        while (c1 < bm1.size() && c2 < bm2.size()) {
            Corner r1 = bm1.get(c1);
            Corner r2 = bm2.get(c2);
            if (r1.x < r2.x) {
                h1 = r1.height;
                if (arr.size() > 0 && (arr.get(arr.size() - 1)).height == Math.max(h1, h2)) {
                    c1++;
                    continue;
                }
                arr.add(new Corner(r1.x, Math.max(h1, h2)));
                c1++;
            }
            else {
                h2 = r2.height;
                if (arr.size() > 0 && (arr.get(arr.size() - 1)).height == Math.max(h1, h2)) {
                    c2++;
                    continue;
                }
                arr.add(new Corner(r2.x, Math.max(h1, h2)));
                c2++;
            }
        }
        while (c1 < bm1.size()){
            arr.add(bm1.get(c1));
            c1++;
        }
        while (c2 < bm2.size()){
            arr.add(bm2.get(c2));
            c2++;
        }
        return arr;
    }
}


