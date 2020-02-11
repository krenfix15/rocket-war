import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Laserele inamicilor.
 * 
 * @author Pascal Marian
 * @version 2017 Februarie
 */
public class RedLaser extends Actor
{
    public int v = 6;
    public String image;
    
    /**
     * Constructor:
     * Laserul se roteste .
     * Laserul isi schimba culoarea.
     */
    public RedLaser(int r)
    {
        setRotation(r);      
    }
    
    /**
     * Laserul se misca in directia in care puncteaza.
     */
    public void act() 
    {
        move(v);
        remove();
    }   
    
    /**
     * Laserul se sterge automat daca este inafara mapei.
     */
    public void remove()
    {
        if(getX()<-5 || getX() > getWorld().getWidth()+5)
            getWorld().removeObject(this);
        else if(getY()<-5 || getY() > getWorld().getHeight()+5)
            getWorld().removeObject(this);
    }
}
