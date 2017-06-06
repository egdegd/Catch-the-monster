/**
 * Created by User on 05.06.2017.
 */
import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class Bfs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int monster_index = scan.nextInt();
        int character_index = scan.nextInt();
        monster_index --;
        character_index --;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i ++){
            int from = scan.nextInt();
            int to =  scan.nextInt();
            from --;
            to --;
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        Queue <Integer> q = new LinkedList<Integer>();
        int[] parent = new int[n];
        int[] distance = new int[n];
        for (int i = 0; i < n; i ++){
            distance[i] = 1000000000;
        }
        q.add(monster_index);
        distance[monster_index] = 0;
        int v;
        while (! q.isEmpty()){
            v = q.remove();
            for (int i = 0; i < graph.get(v).size(); i ++){
                if (distance[v] + 1 < distance[graph.get(v).get(i)]) {
                    distance[graph.get(v).get(i)] = distance[v] + 1;
                    parent[graph.get(v).get(i)] = v;
                    q.add(graph.get(v).get(i));
                }
            }
        }
        System.out.println(distance[character_index]);
        int prev = character_index;
        ArrayList <Integer> way = new ArrayList<>();
        way.add(prev);
        while (prev != 0){
            prev = parent[prev];
            way.add(prev);
        }

        for (int i = way.size() - 1; i >= 0; i --){
            System.out.print(way.get(i) + 1 + " ");
        }
    }
}