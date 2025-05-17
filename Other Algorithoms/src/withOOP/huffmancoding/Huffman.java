package withOOP.huffmancoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Huffman {
    public static void printCode(HuffmanNode root, String s, ArrayList<String> codes) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            codes.add(root.c + ":" + s);
            return;
        }
        printCode(root.left, s + "0", codes);
        printCode(root.right, s + "1", codes);
    }

    public static void main(String[] args) {
        int n = 5;
        char[] charArray = { 'p', 'q', 'r', 's', 't' };
        int[] charfreq = { 10, 15, 20, 25, 30 };
        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = charfreq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {
            HuffmanNode x = q.peek();
            q.poll();
            HuffmanNode y = q.peek();
            q.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }

        ArrayList<String> codes = new ArrayList<>();
        printCode(root, "", codes);
        Collections.sort(codes);
        for (String code : codes) {
            System.out.println(code);
        }
    }
}