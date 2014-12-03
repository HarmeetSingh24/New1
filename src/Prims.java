import java.util.*;

public class Prims {
	
	
	int no_of_nodes = 5;
	int queue_size = no_of_nodes;
	int INFINITY = 100;
	int graph[][] = new int[no_of_nodes][no_of_nodes]; 
    int queue[] = new int[queue_size];
    int key[] = new int[no_of_nodes];
    int pi[] = new int[no_of_nodes];
	//Queue<Integer> queue = new LinkedList<Integer>();
	public static void main(String [] args)
	{
		
		Prims prim_algo = new Prims();
		prim_algo.intializeGraph();
		
		long starttime = System.currentTimeMillis();
		prim_algo.prims();
		long endtime = System.currentTimeMillis();
		
		System.out.println("Required time = "+ (endtime - starttime)+ " milliseconds");
		prim_algo.display();
	}
	
	public void prims()
	{
		
		for(int i=0;i<no_of_nodes;i++)
		{
			key[i] = INFINITY;
			pi[i] = -1;
		}
		
		key[0] = 0;
		intializeQueue();
		
		while(!isEmpty())
		{
			int u = Extract_Min();
			System.out.println("exatacted element from queue "+u);
			for(int i=0 ;i< no_of_nodes; i++)
			{
				if(graph[u][i]!=0)
				{
					int v = i;
		            if(contains(v) && graph[u][v] < key[v])
		            {
		            	pi[v] = u;
		            	
		            	key[v] = graph[u][v];
		            	
		            	
		            }
				}
			}
			
		}
		
	}
	
	public boolean contains(int v)
	{
		for(int i=0;i<queue_size;i++)
		{
			if(queue[i] == v)
				return true;
		}
		
		return false;
	}
	
	
	public boolean isEmpty()
	{
		if(queue_size == 0)
			return true;
		
		return false;
	}
	public int Extract_Min()
	{
		if(queue_size != 1)
			   Min_Heapify(0);
		
		int min = queue[0];
		
		
		queue[0] = queue[queue_size-1];
		
		queue_size = queue_size - 1;
		
		
		return min;
	}
	
	public void Min_Heapify(int start)
	{
		int left = (2 * start) + 1;
		int right = (2 * start) + 2;
		int smallest = -1;
		
		if(left<=queue_size-1 && key[queue[left]]<key[queue[start]])
			smallest = left;
		else
			smallest = start;
		
		if(right<=queue_size-1 && key[queue[right]]<key[queue[smallest]])
			smallest = right;
	    
		if(smallest != start)
		{
			int temp = queue[start];
			queue[start] = queue[smallest];
			queue[smallest] = temp;
			
			Min_Heapify(smallest);
			
		}
		

	}
	
	public void intializeQueue()
	{
	  for(int i=0;i<queue_size;i++)
	  {
		  queue[i] = i;
	  }
	}
	
	public void intializeGraph()
	{
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		//Random rand = new Random();
		for(int i=0; i<no_of_nodes;i++)
		{
			//System.out.println("enter adjecents of node" + i);
			for(int j=0;j<no_of_nodes;j++)
			{
				if(i!=j)
				{
				graph[i][j]=s.nextInt(10);
				}
			}
				//graph[i][j]=rand.nextInt(10);
		}
	}
	
	public void display()
	{
		for(int i=0; i<no_of_nodes;i++)
		{
			for(int j=0;j<no_of_nodes;j++)
				System.out.print(graph[i][j] + " ");
			System.out.println("\n");
		}
		
		for(int i=0; i<no_of_nodes; i++)
			if(pi[i]!=-1)
				System.out.println(i + " -> " + pi[i] +"  weight: " + graph[i][pi[i]]);
	}
}