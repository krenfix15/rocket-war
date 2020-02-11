import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.util.*;

/**
 * Explozie. 
 * Va omori si obiectele din apropiere.
 * 
 * @author Pascal Marian
 * @version 2017 Februarie
 */
public class Explosion extends Actor
{
    /** Numarul imaginilor din animatia exploziei */
    private final static int IMAGE_COUNT= 14;
    
    /** 
     * Imaginile din explozie. 
     */
    private static GreenfootImage[] images;
    
    /** Marimea actuala a exploziei */
    private int size=0;
    
    private int increment=1;    
    
    public Explosion()
    {
        initialiseImages();
        setImage(images[0]);        
        Greenfoot.playSound("Explosion.wav");
    }    
    
    /** 
     * Creaza imaginile exploziei.
     */
    public synchronized static void initialiseImages()
    {
        if(images == null) {
            GreenfootImage baseImage = new GreenfootImage("explosion.png");
            int maxSize = baseImage.getWidth()*4;
            int delta = maxSize / (IMAGE_COUNT+1);
            int size = 0;
            images = new GreenfootImage[IMAGE_COUNT];
            for(int i=0; i < IMAGE_COUNT; i++) {
                size = size + delta;
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
        }
    }
    
    /**
     * Explodeaza !!
     */
    public void act()
    { 
        setImage(images[size]);

        size += increment;
        if(size>=IMAGE_COUNT) {
            increment = -increment;
            size += increment;
        }
        
        lostGame();
        
        if(size <= 0) {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Termina jocul daca racheta dispare.
     */
    public void lostGame()
    {
        if(getWorld().getObjects(Ship.class).size()==0 && size <= 0)
            Greenfoot.stop();
    }
    
}