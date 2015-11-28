/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemanagement.gamelogic;

import externalsourcemanagement.MapManager;
import externalsourcemanagement.SoundManager;
import gameentities.FixedObstacle;
import gameentities.GameObject;
import gamemanagement.input.InputManager;
import gamemanagement.settings.SettingsManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;
import userinterface.panels.GamePanel;
import util.QuadTree;

/**
 *
 * @author Burak Ö
 */
public class GameManager implements ActionListener {
    private InputManager im;
    private QuadTree entities;
    public static int currentLevel = 1;
    private MapManager mm;
    private CollisionManager cm;
    private gameentities.Character character;
    private SettingsManager sm;
    private GamePanel gp;
    private final int GAME_SPEED = 1;
    private boolean running = true;
    private Timer timer;
    private final float FPS = 100;
    private int zoom;
    private Point initialPoint;
    private List<GameObject> allObjects;

    public GameManager(GamePanel gp) {
        this.gp = gp;
        this.mm = new MapManager(this);
        this.im = new InputManager();
        gp.setActionListener(im, (KeyListener) im);
        timer = new Timer((int) (1000/FPS),this);
        cm = new CollisionManager();
        this.startANewLevel(currentLevel);
        System.out.println("map manager created");
    }
    
    public GameManager(List<GameObject> allObjects) {
    	this.allObjects = allObjects;
    }
    
    public void setChar(gameentities.Character c){
        this.character = c;
        if(SettingsManager.charIcon != null)
            c.setIcon(SettingsManager.charIcon);
        character.setInitialPoint(new Point(c.getX(), c.getY()));
    }
    
    public void setZoom()
    {
        int size = calculateMapSize();
        int maxSize = 650;
        int zoom = maxSize/size;
        gp.setZoom(zoom);
        this.zoom = zoom;
    }
    
    public void createMap(int level)
    {
        if(allObjects != null)
            allObjects.clear();
        allObjects = mm.getLevel(level);
    }
    
    public int calculateMapSize(){
        return (16*(currentLevel+4));
    }
    
    public void startANewLevel(int level)
    {
        this.currentLevel = level;
        if(allObjects != null)
            allObjects.clear();
        createMap(level);
        setZoom();
        int size = calculateMapSize();
        gp.setMapSize(size, size);
        entities = new QuadTree(0, new Rectangle(0, 0, size, size));
        run();
    }
    
    private void run(){
        timer.start();
    }
    
    public void drawObjects(){
        
        checkKeys();
        
        if (im.isMouseDragged && character.contains(im.getPoint(zoom)))
        {
            /*Point initialPoint = im.getPoint(zoom);
            int xOffset = initialPoint.x - character.getX();
            int yOffset = initialPoint.y - character.getY();
            System.out.println("contains dragged");*/
            character.moveTo((int) im.getPoint(zoom).x - character.getWidth()/2,
            		(int) im.getPoint(zoom).y - character.getHeight()/2);
        }
        
        entities.clear();
        for (int i = 0; i < allObjects.size(); i++) {
            entities.insert(allObjects.get(i));
        }
        
        List<GameObject> collidableObjectsChar = new ArrayList<GameObject>();
        entities.retrieve(collidableObjectsChar, character);
        List<GameObject> illuminated = new ArrayList<GameObject>();
        for(GameObject o : collidableObjectsChar )
        {
            cm.collides(o, character);
        }
        
        for(GameObject o : allObjects)
        {
            if(character.getLight().collides(o))
                illuminated.add(o);
        }
        
        removeDestroyed();
        character.update();
        
        if(character.getY() + character.getHeight() >= calculateMapSize())
        {
            SoundManager.levelFinished();
            startANewLevel(++currentLevel);
        }
        gp.paintObjects(illuminated);
    }
    
    public void draw(){
        //gp.paintObjects(entities.getList());
    }
    
    public void update(){
        
    }
    
    public boolean checkCollision()
    {
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        drawObjects();
    }

    private void checkKeys() {
        if(!im.isKeyPressed)
        {
            return;
        }
        else
        {
            if (im.pressedKey == 'a')
            {
                if(currentLevel > 1)
                    startANewLevel(currentLevel - 1);
            }
            else if (im.pressedKey == 's')
            {
                if(currentLevel < 17)
                    startANewLevel(currentLevel + 1);
            }
        }
    }

    public void removeDestroyed() {
        for(int i = allObjects.size() -1; i >= 0; i--){
            if(allObjects.get(i).isDestroyed())
                allObjects.remove(i);
        }
    }
    
    public List<GameObject> getAllObjects() {
    	return allObjects;
    }
}
