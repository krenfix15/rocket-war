import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  Laserele rachetei.
 * 
 *  @author Pascal Marian
 * @version 2017 Februarie
 */
public class Laser extends Actor
{
    public int v = 5;
    public String image;
    
    /**
     * Constructor:
     * Laserele se rotesc dupa pozitia data.
     */
    public Laser(int r)
    {
        setRotation(r);      
    }
    
    /**
     * Laserul se duce in directia spre care nava arata.
     */
    public void act() 
    {
        move(v);
        remove();
    }   
    
    /**
     * Laserul dispare daca iese inafara lumii.
     */
    public void remove()
    {
        if(getX()<-5 || getX() > getWorld().getWidth()+5)
            getWorld().removeObject(this);
        else if(getY()<-5 || getY() > getWorld().getHeight()+5)
            getWorld().removeObject(this);
    }
}
