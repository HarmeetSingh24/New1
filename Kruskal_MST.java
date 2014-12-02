import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Kruskal_MST {
   // static BufferedReader in;
    static PrintWriter out;
  //  static StringTokenizer stk;
    static int n,m;
    static int p[];
 
    public static void main(String[] args) throws Exception {
       // in = new BufferedReader(new InputStreamReader(System.in));
        //in = new BufferedReader(new FileReader("in.txt"));
        Scanner a1 = new Scanner(System.in);
        out = new PrintWriter(System.out);
       // stk = new StringTokenizer(in.readLine());
        int i,a,b,c;
        n=a1.nextInt();//number of nodes
        m=a1.nextInt();//number of edges
        p=new int[n+1];
        for(i=1;i<=n;i++)
            p[i]=i;
         
        edges e[]=new edges[m];
        for(i=0;i<m;i++){
            a=a1.nextInt();
            b=a1.nextInt();
            c=a1.nextInt();
            e[i]=new edges(a, b, c);
        }
        Sorter com=new Sorter();
        Arrays.sort(e,com);
        boolean check;
        ArrayList<edges> final_tree=new ArrayList<edges>();
        for(i=0;i<m;i++){
            check=false;
            check=union(e[i].start_node,e[i].end_node);
            if(!check){
                final_tree.add(e[i]);
            }
        }
        long min_cost=0;
        System.out.println("The Edges are :");
        for(i=0;i<final_tree.size();i++){
            System.out.println(final_tree.get(i).start_node+" "+final_tree.get(i).end_node+" "+final_tree.get(i).cost);
            min_cost+=final_tree.get(i).cost;
        }
        System.out.println("Minimum Cost = "+min_cost);
}
     
    static boolean union(int a,int b){
         int a1,b1;
         a1=parent(a);
         b1=parent(b);
         if(a1!=b1){
             p[a1]=b1;
             return false;
         }
         return true;
     }
     static int parent(int a){
         if(p[a]==a)
             return a;
         else
             return parent(p[a]);
     }
 
  /* static int ni() throws Exception {
        while (!stk.hasMoreTokens()) {
            stk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(stk.nextToken());
    }
 
    static long nl() throws Exception {
        while (!stk.hasMoreTokens()) {
            stk = new StringTokenizer(in.readLine());
        }
        return Long.parseLong(stk.nextToken());
//    }*/
}
 
class edges{
    int start_node,end_node;
    Integer cost;
     
    edges(int st, int en,int cst){
        start_node=st;
        end_node=en;
        cost=cst;
                
    }
}
class Sorter implements Comparator<edges>{
 
    @Override
    public int compare(edges o1, edges o2) {
        return o1.cost.compareTo(o2.cost);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}