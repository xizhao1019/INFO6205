package edu.neu.coe.info6205.union_find;

import java.util.Random;

/**
 * Takes an integer value n from the command line to determine the number of "sites."
 * Then generates random pairs of integers between 0 and n-1, calling connected() to determine if they are connected and union() if not.
 * Loop until all sites are connected then print the number of connections generated.
 *
 */
public class UF_RandomConnections {

    public static int count(int n){
        int result = 0;
        UF_HWQUPC uf = new UF_HWQUPC(n);
        Random random = new Random();
        while (uf.components()>1){
            result++;
            int i = random.nextInt(n);
            int j = random.nextInt(n);
            if (uf.connected(i,j)) continue;
            uf.union(i,j);
        }
        return result;
    }

    public static void main(String[] args) {
        for (int n = 10; n <= 100; n++){
            int m = 0;
            for(int i = 0; i< 10; i++)
                m += new UF_RandomConnections().count(n);
            System.out.println( n + "," + m/10);
        }
    }
}
