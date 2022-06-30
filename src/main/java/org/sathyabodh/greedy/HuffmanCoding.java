package org.sathyabodh.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class HuffmanCoding {
    static class HuffmanNode{
        char ch;
        int frequency;
        HuffmanNode left = null ;
        HuffmanNode right = null;
        HuffmanNode(char ch, int frequency){
            this.ch = ch;
            this.frequency = frequency;

        }
    }

    private static String encode(String str){
        Collection<HuffmanNode> nodes = constrcutFreqList (str);
        HuffmanNode root = optimalMerging (nodes);
        rootNode = root;
        Map<Character, String> codes = assignCodes(root, nodes);
        StringBuilder builder = new StringBuilder ("");
        for(int i = 0; i < str.length (); ++i){
            builder.append (codes.get (str.charAt (i)));
        }
        return builder.toString ();
    }

    static HuffmanNode rootNode = null;
    private static String decode(String encodedString){
        HuffmanNode node = rootNode;
        StringBuilder builder = new StringBuilder ();
        for(int i = 0; i < encodedString.length (); ++i){
            if(node.ch != '-'){
                builder.append (node.ch);
                node = rootNode;
            }
            node = encodedString.charAt (i) == '0' ? node.left : node.right;
        }
        if(node.ch != '-')
            builder.append (node.ch);
        return builder.toString ();
    }
    private static Map<Character, String> assignCodes(HuffmanNode root, Collection<HuffmanNode> chars){
        Map<Character, String> codes = new HashMap<> ();
        for(HuffmanNode node : chars){
            codes.put (node.ch, getCode (root, node.ch, ""));
        }
        System.out.println ("codes: " + codes);
        return codes;
    }

    private static String getCode(HuffmanNode root, char c, String code){
        if(root == null)
            return null;
        if(root.ch == c && root.left == null && root.right == null){
            return code;
        }
        String code1 = getCode (root.left, c, code+"0");
        String code2 =  getCode (root.right, c, code+"1");
        return code1 == null ? code2 : code1;
    }

    private static HuffmanNode optimalMerging(Collection<HuffmanNode> nodes){
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<> ((first, second)-> first.frequency - second.frequency);
        queue.addAll (nodes);
        while(queue.size () > 1){
            HuffmanNode first = queue.poll ();
            HuffmanNode second = queue.poll ();
            HuffmanNode newNode = new HuffmanNode ('-', first.frequency + second.frequency);
            newNode.left = first;
            newNode.right = second;
            queue.add(newNode);
        }
        return queue.poll ();
    }
    private static Collection<HuffmanNode> constrcutFreqList(String s){
        Map<Character, HuffmanNode> map = new HashMap<> ();
        for(int i = 0; i < s.length (); i++){
            char ch = s.charAt (i);
            if(map.get (ch) == null){
                map.put (ch, new HuffmanNode(ch, 1));
            }
            else{
                HuffmanNode node = map.get (ch);
                node.frequency++;
            }
        }
        return map.values ();
    }

    public static void main(String[] args) {
        int size = 6;
        String str = "geeksforgeeks";
        String encodedString = encode(str);
        System.out.println ("Encoded->" + encodedString);
        String decodedString = decode (encodedString);
        System.out.println ("Decoded->" + decodedString);
    }
}
