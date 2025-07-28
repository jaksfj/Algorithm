

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Human{
        int weight;
        int height;
        Human(int weight,int height){
            this.weight = weight;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int weight,height;
        int n = Integer.parseInt(br.readLine());
        Human[] array = new Human[n];
        int[] standings = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            array[i] = new Human(weight,height);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(array[j].weight > array[i].weight && array[j].height > array[i].height){
                    standings[i]++;
                }
            }
        }
        for(int num : standings){
            System.out.print((num+1) + " ");
        }
    }
}
