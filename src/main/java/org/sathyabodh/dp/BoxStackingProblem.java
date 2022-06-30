package org.sathyabodh.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoxStackingProblem {

    static class Box{
        int width;
        int depth;
        int height;
        Box(int height, int width, int depth){
            this.height =height;
            this.width = width;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "width=" + width +
                    ", depth=" + depth +
                    ", height=" + height +
                    '}';
        }
    }
    private static List<Box> rotate(List<Box> boxes){
        List<Box> rotated = new ArrayList<> ();
        for(Box box : boxes){
            rotated.add (new Box (box.height, Math.min(box.depth, box.width), Math.max (box.depth, box.width)));
            rotated.add(new Box(box.width, Math.min(box.height, box.depth), Math.max(box.height, box.depth)));
            rotated.add(new Box(box.depth, Math.min (box.height, box.width), Math.max (box.height, box.width)));
        }
        return rotated;
    }

    private static int maxHeight(List<Box> boxeList){
        int maxHeight = -1;
        int maxHeightIndex = -1;

        List<Box> rotated = rotate (boxeList);
        int[] prev = new int[rotated.size ()];
        Arrays.fill (prev, -1);

        int size = rotated.size ();

        Collections.sort (rotated, (first, second)-> first.width - second.width);
        int[] maxHeights = new int[size];
        for(int i = 0; i < maxHeights.length; ++i){
            maxHeights[i] = rotated.get (i).height;
        }

        for(int i = 0; i < rotated.size ();++i){
            for(int j = 0; j < i ; ++j){
                if(canPlace (rotated.get(i), rotated.get(j))){
                    if(maxHeights[i] < maxHeights[j] + rotated.get (i).height){
                        maxHeights[i] = maxHeights[j] + rotated.get (i).height;
                        prev[i] = j;
                    }
                }
            }
            if(maxHeights[i] > maxHeight){
                maxHeight = maxHeights[i];
                maxHeightIndex = i;
            }
        }
        System.out.println ("Box stacking order starting from top to bottom");
        while(prev[maxHeightIndex] != -1){
            System.out.println (rotated.get (maxHeightIndex));
            maxHeightIndex = prev[maxHeightIndex];
        }
        System.out.println (rotated.get (maxHeightIndex));
        return maxHeight;
    }

    private static boolean canPlace(Box lower, Box higher){
        return lower.width > higher.width && lower.depth > higher.depth;
    }

    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<> ();
        boxes.add(new Box (4,6,7));
        boxes.add(new Box (1,2,3));
        boxes.add(new Box (4,5,6));
        boxes.add(new Box (10,12,32));
        int maxHeight = maxHeight(boxes);
        System.out.println ("Max height: "+ maxHeight);
    }
}
