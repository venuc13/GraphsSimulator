package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Graph Class
 * @author Venugopal Chillal (edited by Aryan Singh)
 */
public class Graph {

    // adjacency list; source vertex is identified by ArrayList index, destinations and weights by HashMap
    List<HashMap<Integer, Integer>> graph; 
    private int size;
    
    public Graph() {
        graph = new ArrayList<>();
        size = graph.size();
    }
    
    // returns false if edge is already present
    public boolean addEdge(int u, int v, int weight) {
        if (!graph.get(u).containsKey(v)) {
            graph.get(u).put(v, weight);
            return true;
        }
        
        return false;
    }
    
    // returns false if edge not present
    public boolean removeEdge(int u, int v) {
        if (graph.get(u).containsKey(v)) {
            graph.get(u).remove(v);
            return true;
        }
        return false;
    }
    
    // returns false if edge not present
    public boolean changeEdgeWeight(int u, int v, int weight) {
        if (graph.get(u).containsKey(v)) {
            graph.get(u).put(v, weight);
            return true;
        }
        return false;
    }
    
    public void addVertex() {
        graph.add(new HashMap<Integer, Integer>());
        size++;
    }
    
    // returns false if vertex not present; indices of remaining vertices do not change
    public boolean removeVertex(int v) {
        if (!hasVertex(v)) {
            return false;
        }
        
        graph.set(v, null);
        size--;
        for (int u = 0; u < graph.size(); u++) {
            if (graph.get(u) != null) {
                graph.get(u).remove(v);
            }
        }
        return true;
    }
    
    public boolean hasEdge(int u, int v) {
        return (hasVertex(u) && graph.get(u).containsKey(v));
    }
    
    // returns -1 if edge not present
    public int getWeight(int u, int v) {
        if(!hasEdge(u, v)) {
            return -1;
        }
        return graph.get(u).get(v);
    }
    
    public int getSize() {
        return size;
    }
    
    // returns null if u not present
    public ArrayList<Integer> getNeighbors(int u) {
        if (!hasVertex(u)) {
            return null;
        }
        
        ArrayList<Integer> output = new ArrayList<>();
        for (Integer v : graph.get(u).keySet()) {
            output.add(v);
        }
        
        return output;
    }
    
    public boolean hasVertex(int u) {
        return u >= 0 && u < graph.size() && graph.get(u) != null;
    }
    
    /**
     * Graph Generation Constructor
     * @author Aryan Singh
     * @param size The size of the graph to be madee
     */
    public Graph(int size) {
    	graph = new ArrayList<>();
        for (int i = 0; i < size; i++) {
        	addVertex();
        }
        this.size = graph.size();
    	
    	double edge;
    	int weight;
    	
    	for (int i = 0; i < size; i++) {
    		for (int j = i + 1; j < size; j++) {
    			edge = Math.random();
    			weight = (int) (Math.random() * 100);
    			
    			if (edge > 0.67) {
    				addEdge(i, j, weight);
    			}
    		}
    	}
    }
    
    
}

