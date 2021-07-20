package code;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

@SuppressWarnings("serial")
public class DIJKSTRA_Driver extends JPanel {

	Graph graph = new Graph(12);
    int[][] coordinates = new int[graph.getSize()][2];
    
    ArrayList<Integer> discovered = new ArrayList<>();
    ArrayList<int[]> discoveredEdges = new ArrayList<>();
    HashMap<Integer, Integer> distances = new HashMap<Integer, Integer>();
    int size = graph.getSize();
    int n = graph.getSize();
    
    public DIJKSTRA_Driver() {
    	
    	for (int i = 0; i < graph.getSize(); i++) {
        	distances.put(i, 101);
        }
    	
        distances.put(0, 0);
    	
    	coordinates[0][0] = 0+15;
        coordinates[0][1] = 500+15;
        
        coordinates[1][0] = 67+15;
        coordinates[1][1] = 250+15;
        
        coordinates[2][0] = 250+15;
        coordinates[2][1] = 67+15;
        
        coordinates[3][0] = 500+15;
        coordinates[3][1] = 0+15;
        
        coordinates[4][0] = 750+15;
        coordinates[4][1] = 67+15;
        
        coordinates[5][0] = 933+15;
        coordinates[5][1] = 250+15;
        
        coordinates[6][0] = 1000+15;
        coordinates[6][1] = 500+15;
        
        coordinates[7][0] = 933+15;
        coordinates[7][1] = 750+15;
        
        coordinates[8][0] = 750+15;
        coordinates[8][1] = 933+15;
        
        coordinates[9][0] = 500+15;
        coordinates[9][1] = 1000+15;
        
        coordinates[10][0] = 250+15;
        coordinates[10][1] = 933+15;
        
        coordinates[11][0] = 67+15;
        coordinates[11][1] = 750+15;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
            
        displayDIJKSTRA(g2d);
        
        g2d.dispose();
    }
    
    protected void drawGraph(Graphics2D g2d) {    
    	g2d.setColor(Color.BLACK);
    	
    	for (int i = 0; i < graph.getSize(); i++) {
        	for (int j = i + 1; j < graph.getSize(); j++) {
        		if (graph.hasEdge(i, j)) {
        			g2d.drawLine(coordinates[i][0], coordinates[i][1],
        					coordinates[j][0], coordinates[j][1]);
        		}
            }
        }
        
        for (int i = 0; i < graph.getSize(); i++) {
        	g2d.fillOval(coordinates[i][0] - 5, coordinates[i][1] - 5, 10, 10);
        }
    }
    
    protected void displayDIJKSTRA(Graphics2D g2d) {
    	
        drawGraph(g2d);
        g2d.setColor(Color.RED);
        for (Integer i : discovered) {
        	g2d.fillOval(coordinates[i][0] - 5, coordinates[i][1] - 5, 10, 10);
        }
        for (int[] edge : discoveredEdges) {
        	g2d.drawLine(coordinates[edge[0]][0], coordinates[edge[0]][1],
					coordinates[edge[1]][0], coordinates[edge[1]][1]);
        }
        
    	if (n > 0) {
    		int u = findMin();
    		n--;
    		discovered.add(u);
    		for (Integer v : graph.getNeighbors(u)) {
    			if (distances.get(v) > distances.get(u) + graph.getWeight(u, v)) {
    				distances.put(v, distances.get(u) + graph.getWeight(u, v));    						
    				discoveredEdges.add(new int[] {u, v});
    			}
    		}
    		distances.put(u, 102);
        }             
    }
    
    private int findMin() {
    	int min = 0;
    	for (int i = 0; i < size; i++) {
    		if (distances.get(min) > distances.get(i)) {
    			min = i;
    		}
    	}
    	return min;
    }
}
