package code;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Driver extends JFrame{

	private static BFS_Driver bfs_driver;
	private static DFS_Driver dfs_driver;
	private static DIJKSTRA_Driver dijkstra_driver;

    public Driver() {
        this.setSize(1100, 1100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);        
    }
    
    public static void runDFS() throws InterruptedException {
        Driver frame = new Driver();
        dfs_driver = new DFS_Driver();
        frame.add(dfs_driver); 
        
        while (true) {
        	Driver.dfs_driver.repaint();          
            Thread.sleep(50000);
        }
    }
    
    public static void runBFS() throws InterruptedException {
        Driver frame = new Driver();
        bfs_driver = new BFS_Driver();
        frame.add(bfs_driver); 
        
        while (true) {
        	Driver.bfs_driver.repaint();          
            Thread.sleep(50000);
        }
    }
    
    public static void runDIJKSTRA() throws InterruptedException {
        Driver frame = new Driver();
        dijkstra_driver = new DIJKSTRA_Driver();
        frame.add(dijkstra_driver); 
        
        while (true) {
        	Driver.dijkstra_driver.repaint();          
            Thread.sleep(50000);
        }
    }
}