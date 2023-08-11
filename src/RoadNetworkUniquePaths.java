import java.util.ArrayList;
import java.util.List;

public class RoadNetworkUniquePaths {

    /*
    * As a startup built to solve the problem of efficient commuting for city dwellers, we need to find the number of
    * unique paths between two intersections in a given road network. We have the number of intersections and the
    * number of roads connecting these intersections. As a commuter, you can only travel in the forward direction along
    * the roads. Given this information, write a function that returns the number of unique paths from the starting
    * intersection to the destination intersection.
    *
    * Example 1:
    * int n = 4;
    * int[][] roads = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
    * int start = 0;
    * int end = 3;
    * int expectedOutput = 2;
    *
    * Example 2:
    * int n = 5;
    * int[][] roads = {{0, 1}, {0, 2}, {1, 2}, {2, 3}, {3, 4}};
    * int start = 0;
    * int end = 4;
    * int expectedOutput = 1;
    *
    * Example 3:
    * int n = 4;
    * int[][] roads = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
    * int start = 1;
    * int end = 3;
    * int expectedOutput = 1;
    *
    * */

    public static void main(String[] args){
        int n = 4;
        int[][] roads = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        int start = 0;
        int end = 3;
        System.out.println(findUniquePaths(n,roads,start,end));


        n = 5;
        roads = new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}, {3, 4}};
        start = 0;
        end = 4;
        System.out.println(findUniquePaths(n,roads,start,end));


        n = 3;
        roads = new int[][]{{0, 1}, {1, 2}};
        start = 0;
        end = 2;
        System.out.println(findUniquePaths(n,roads,start,end));

        n = 3;
        roads = new int[][]{{0, 1}, {1, 2}};
        start = 1;
        end = 2;
        System.out.println(findUniquePaths(n,roads,start,end));

        n = 3;
        roads = new int[][]{{0, 1}, {1, 2}};
        start = 0;
        end = 1;
        System.out.println(findUniquePaths(n,roads,start,end));

        n = 4;
        roads = new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        start = 1;
        end = 3;
        System.out.println(findUniquePaths(n,roads,start,end));


    }

    public static int findUniquePaths(int n, int[][] roads, int start, int end){

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            adjacencyList.get(u).add(v);
        }
        boolean[] visited = new boolean[n];

        return dfs(adjacencyList, visited, start, end);
    }

    private static int dfs(List<List<Integer>> adjacencyList, boolean[] visited,
                           int current, int end){
        if(current == end){
            return 1;
        }

        visited[current] = true;

        int uniquePaths = 0;
        for(int next : adjacencyList.get(current)){
            if(!visited[next]){
                // Recursively explore the next intersection
                uniquePaths += dfs(adjacencyList,visited,next, end);
            }
        }

        visited[current] = false;

        return uniquePaths;
    }
}
