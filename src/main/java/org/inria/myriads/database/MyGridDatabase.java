package org.inria.myriads.database;

import java.util.ArrayList;

import org.inria.myriads.grid.Grid;
import org.inria.myriads.rest.exception.AlreadyDefinedClusterException;
import org.inria.myriads.rest.resource.grid.cluster.Cluster;

/**
 * 
 * In memory database.
 * 
 * 
 * @author msimonin
 *
 */
public class MyGridDatabase 
{

    /** Grid.*/
    private Grid grid_;
    
    /**
     * Constructor.
     * 
     * Prepopulated with 2 clusters.
     */
    public MyGridDatabase() 
    {
        grid_ = new Grid();
        grid_.setName("MyGrid");
        Cluster cluster1 = new Cluster();
        cluster1.setUuid("cluster1");
        Cluster cluster2 = new Cluster();
        cluster2.setUuid("cluster2");
        grid_.addCluster(cluster1);
        grid_.addCluster(cluster2);
    }

    /**
     * @return the grid
     */
    public Grid getGrid() 
    {
        return grid_;
    }

    /**
     * @param grid the grid to set
     */
    public void setGrid(Grid grid) 
    {
        grid_ = grid;
    }

    /**
     * 
     * Gets the clusters.
     * 
     * @return the cluster list.
     */
    public ArrayList<Cluster> getClusters() 
    {
        return grid_.getClusters();
    }

    /**
     * 
     * Creates a new cluster.
     * 
     * @param name           The cluster
     * @return                  The newly created clusters
     * @throws AlreadyDefinedClusterException   Exception.
     */
    public Cluster createCluster(String name) throws AlreadyDefinedClusterException 
    {
        ArrayList<Cluster> clusters = grid_.getClusters();
        for (Cluster registeredCluster : clusters)
        {
            if (name.equals(registeredCluster.getUuid()))
            {
                throw new AlreadyDefinedClusterException();
            }
        }
        Cluster cluster = new Cluster();
        cluster.setUuid(name);
        clusters.add(cluster);
        return cluster;
    }
    
    
}