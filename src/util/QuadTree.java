/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import gameentities.GameObject;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Burak Ö
 */
public class QuadTree {
    private int MAX_OBJECTS = 150;
    private int MAX_LEVELS = 5;
    
    private int level;
    private List<GameObject> objects;
    private Rectangle bounds;
    private QuadTree[] nodes;
    
    //
    // Constructor
    //
    public QuadTree(int pLevel, Rectangle pBounds){
        level = pLevel;
        objects = new ArrayList();
        bounds = pBounds;
        nodes = new QuadTree[4];
    }
    
    //
    // Clearing the QuadTree
    //
    public void clear(){
        objects.clear();
        
        for(int i = 0; i < nodes.length; i++){
            if(nodes[i] != null){
                nodes[i].clear();   
                nodes[i] = null;
            }
        }
    }
    
    //
    //         *********
    //         * 1 * 0 *
    //         *********
    //         * 2 * 3 *
    //         *********
    //
    
    //
    // Splits a node into 4 subnodes
    //
    private void split(){
        int subWidth = (int) (bounds.getWidth()/2);
        int subHeight = (int) (bounds.getHeight()/2);
        int x = (int) bounds.getX();
        int y = (int) bounds.getY();
        
        nodes[0] = new QuadTree(level+1, new Rectangle(x + subWidth, y,
                                                    subWidth, subHeight));
        nodes[1] = new QuadTree(level+1, new Rectangle(x, y,
                                                    subWidth, subHeight));
        nodes[2] = new QuadTree(level+1, new Rectangle(x, y + subHeight,
                                                    subWidth, subHeight));
        nodes[3] = new QuadTree(level+1, new Rectangle(x + subWidth, y + subHeight,
                                                    subWidth, subHeight));                                            
    }
    
    //
    // Determines which node a rectangle belongs to. -1 means it belongs to
    // a parent node, because it cannot completely fit into a child node
    //
    private int getIndex(GameObject obj){
        int index = -1;
        
        Rectangle rect = obj.getRect();
        
        double verticalMid = bounds.getX() + (bounds.getWidth() / 2);
        double horizontalMid = bounds.getY() + (bounds.getHeight()/2); 
        
        // Determining which y coordinate rect belongs to
        boolean y0 = ((rect.getY() < horizontalMid) && 
                (rect.getY() + rect.getHeight() < horizontalMid));
        boolean y1 = ((rect.getY() > horizontalMid));
        
        // Determining which x coordinate rect belongs to
        // x = 0
        if((rect.getX() < verticalMid) && 
                rect.getX() + rect.getWidth() < verticalMid){
            if(y0)
                index = 1;
            else if(y1)
                index = 2;
        }
        // x = 1
        if((rect.getX() > verticalMid)){
            if(y0)
                index = 0;
            if(y1)
                index = 3;
        }
        return index;
    }
    
    //
    // Inserts a rect to the tree
    //
    public void insert(GameObject obj){
        if(nodes[0] != null){
            int index = getIndex(obj);
            
            if(index != -1){
                nodes[index].insert(obj);
                return;
            }
        }
        
        objects.add(obj);
        
        if(objects.size() > MAX_OBJECTS && level < MAX_LEVELS){
            if(nodes[0] == null){
                split();
            }
            
            int i = 0;
            while(i < objects.size()){
                int index = getIndex(objects.get(i));
                if(index != -1){
                    GameObject o = objects.remove(i);
                    nodes[index].insert(o);
                }
                else{
                    i++;
                }
            }
        }
    }
    
    public void delete(GameObject obj)
    {
        if (objects.contains(obj))
        {
            objects.remove(obj);
            return;
        }
        else
        {
            if(nodes[0] != null){
                nodes[0].delete(obj);
                nodes[1].delete(obj);
                nodes[2].delete(obj);
                nodes[3].delete(obj);
            }
        }
    }
    
    //
    // Retrieves the objects that a rect possibly collide with
    //
    public List<GameObject> retrieve(List returnObjects, GameObject obj){
        int index = getIndex(obj);
        if(index != -1 && nodes[0] != null){
            nodes[index].retrieve(returnObjects, obj);
        }
        
        for(GameObject o : objects)
        {
           returnObjects.add(o);
        }
        
        return returnObjects;
    }
    
    //
    // Returns game objects
    //
}
