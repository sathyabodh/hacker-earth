package org.sathyabodh.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubSequence {

    public static int findLIS(int[] a){
        int [] lis = new int[a.length];
        int [] prev = new int[a.length];
        Arrays.fill (lis, 1);
        for(int i = 0; i < prev.length; ++i){
            prev[i] = -1;
        }
        int maxLength = lis[0];
        int maxLengthIndex = -1;
        for(int i = 1; i < a.length; ++i){
            for(int j=0; j < i; ++j){
                if(a[j] < a[i]){
                    if(lis[i] < 1+lis[j]){
                        lis[i] =  1+ lis[j];
                        prev[i] = j;
                    }
                }
            }
            if(maxLength < lis[i]){
                maxLength = lis[i];
                maxLengthIndex = i;
            }
        }
        int i = maxLengthIndex;
        while(i!= -1){
            System.out.print(" " + a[i]);
            i = prev[i];
        }
        System.out.println(" ");
        return maxLength;
    }

    static class Pair{
        int value;
        int index;
        Pair(int index, int value){
            this.value = value;
            this.index = index;
        }
    }
    private static int LISUsingPatienceSort(int[] a){
        int maxLength = -1;
        /*
        Consider index in list as piles and place the new element only
        in any of the piles starting from left to right, if any one of them is having element greater
        than the current element. If not such piles exists, then create new pile which is same as
        inserting new element in the list.
         */
        List<Pair> piles = new ArrayList<> ();
        int[] prevIndex = new int[a.length];
        Arrays.fill (prevIndex, -1);

        for(int i = 0; i < a.length; ++i){
            int index = findPile(piles, 0, piles.size ()-1, a[i]);
            if(index < 0){
                if(!piles.isEmpty ())
                    prevIndex[i] = piles.get(piles.size ()-1).index;
                piles.add (new Pair (i, a[i]));
            }
            else{
                piles.set (index, new Pair(i,a[i]));
                if(index > 0){
                    prevIndex[i] = piles.get(index-1).index;
                }
            }
        }
//        piles.stream ().forEach (p-> System.out.print(p.value + " "));
        int index = piles.get (piles.size ()-1).index;
        while(index != -1){
            System.out.println (a[index]);
            index = prevIndex[index];
        }
        System.out.println ();
        return piles.size ();
    }

    private static int findPile(List<Pair> piles, int low, int high, int value){
        if( low > high)
            return -1;

        int mid = (low + high) / 2;
        int prevElement = mid-1 >=0 ? piles.get(mid-1).value:value;
        if(piles.get (mid).value == value){
            return mid;
        }
        else if(prevElement <= value && piles.get(mid).value > value) {
            return mid ;
        }
        else if(piles.get(mid).value < value){
            return findPile (piles, mid+1, high, value);
        }
        else {
            return findPile (piles, low, mid-1, value);
        }
    }

    public static void main(String[] args) {
        int [] a = {10, 22, 79, 33, 21, 50, 41, 60};
        int [] arr = {2, 5, 3, 7, 11, 8, 10, 13, 6};
//        int maxLength = findLIS(a);
//        System.out.println ("Max length:" + maxLength);

        int maxLength1 = LISUsingPatienceSort(arr);
        System.out.println ("Max length:" + maxLength1);
    }
}
