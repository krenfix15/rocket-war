import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Stelele care se genereaza in timpul jocului.
 * 
 * @author Pascal Marian
 * @version 2017 Februarie
 */
public class Stars extends Actor
{
    public int speed = 5;
    public int r = 0;
    
    /**
     * 
     * Stelele isi seteaza viteza si marimea dupa variabile.
     */
    public Stars(int size, int v)
    {
        speed = v;
        getImage().scale(size, size);
    }
    
    /**
     * Miscarea Stelelor.
     */
    public void act() 
    {
        moveBackground();
        goThroughEdge();
    }  
    
    /**
     * Stelele se misca in directia opusa rachetei.
     */
    public void moveBackground()
    {
        if(getWorld().getObjects(Ship.class).size()!=0)
        {
            for(int i=0; i<getWorld().getObjects(Ship.class).size(); i++)
            {
                Ship s = (Ship) getWorld().getObjects(Ship.class).get(i);
                r = s.getRotation();
            }
        }
        setRotation(r +180 );
        move(speed);
    }
    
    /**
     * Daca stelele dispar de pe mapa,apar in partea opusa.
     */
    public void goThroughEdge()
    {
        if(getX()<-5) setLocation(getWorld().getWidth()+5, getY());
        if(getX()> getWorld().getWidth()+5) setLocation(-5, getY());
        if(getY()<-5) setLocation(getX(), getWorld().getHeight()+5);
        if(getY()>getWorld().getHeight()+5) setLocation(getX(), -5);
    }
}
