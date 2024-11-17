package scaler.Adv.GraphKuskalAndPrimsAlgo;

import java.util.Arrays;
import java.util.Comparator;

/*Problem Description
        Given a undirected weighted graph with A nodes labelled
        from 1 to A with M edges given in a form of 2D-matrix
        B of size M * 3 where B[i][0] and B[i][1] denotes the two nodes
        connected by an edge of weight B[i][2].

        For each edge check whether it belongs to any of the possible
         minimum spanning tree or not , return 1 if it belongs else return 0.

        Return an one-dimensional binary array of size M denoting answer for each edge.
        NOTE:
        The graph may be disconnected in that case consider mst for each component.
        No self-loops and no multiple edges present.
        Answers in output array must be in order with the input array B output[i] must denote the answer of edge B[i][0] to B[i][1].

        Problem Constraints
        1 <= A, M <= 3*105
        1 <= B[i][0], B[i][1] <= A
        1 <= B[i][1] <= 103

        Input Format
        The first argument given is an integer A representing the number of nodes in the graph.
        The second argument given is an matrix B of size M x 3 which represents the M
        edges such that there is a edge between node B[i][0] and node B[i][1] with weight B[i][2].

        Output Format
        Return an one-dimensional binary array of size M denoting answer for each edge.

        Example Input
        Input 1:
        A = 3
        B = [ [1, 2, 2]
        [1, 3, 2]
        [2, 3, 3]
        ]

        Example Output
        Output 1:
        [1, 1, 0]

        Example Explanation
        Explanation 1:
        Edge (1, 2) with weight 2 is included in the MST           1
        /   \
        2     3
        Edge (1, 3) with weight 2 is included in the same MST mentioned above.
        Edge (2,3) with weight 3 cannot be included in any of the mst possible.
        So we will return [1, 1, 0]*/
public class EdgeinMST {
    public int[] solve(int A, int[][] B) {

        // Create parent array for Disjoint subset tree
        int[] parent = new int[A+1];
        // Initially assign self loop for parent
        for(int i=1;i<=A;i++)
            parent[i]=i;
        // Creates a new array C that will also have the index of the pair after sorting
        int[][] C = new int[B.length][4];
        for(int i=0;i<B.length;i++) {
            C[i][0]=B[i][0];
            C[i][1]=B[i][1];
            C[i][2]=B[i][2];
            C[i][3]=i;
        }
        // Sort the newly Created array with weights
        Arrays.parallelSort(C, Comparator.comparingInt(c-> c[2]));
        int[] res = new int[B.length];
        int i=0, j=0;;
        while(i<B.length) {
            j=i;
            // Checks for the same weighted nodes that can they be part of spanning tree
            while(j<B.length && C[i][2]==C[j][2]) {
                if(root(C[j][0], parent)!=root(C[j][1], parent))
                    res[C[j][3]]=1;
                j++;
            }
            j=i;
            // Merge the same weighted edges in a union if required
            while(j< B.length && C[i][2]==C[j][2]) {
                makeUnion(C[j][0], C[j][1], parent);
                j++;
            }
            i=j;
        }
        return res;
    }

    int root(int x, int parent[]){
        if(x==parent[x])
            return x;
        parent[x]=root(parent[x],parent);
        return parent[x];
    }

    boolean makeUnion(int x, int y, int[] parent) {
        int xx = root(x, parent);
        int yy = root(y, parent);
        if(xx==yy)
            return false;
        parent[yy]=xx;
        return true;
    }
}
