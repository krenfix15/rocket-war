import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo) //PMV

/**
 * 
 * @author Pascal Marian
 * @version 2017 Februarie
 *
 * https://www.youtube.com/channel/UCHLduiuV8Sz5KlLtnjmaBCA
 */
public class Space extends World
{

    public int stars = 80;
    public static int shots;
    public int howMany =1000;
    

    /**
     * Construieste obiectele clasei Space.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 600, 1, false); 
        
        shots=0;
        
        Greenfoot.playSound("kirov.mp3");
        setPaintOrder(Ship.class, EnemyShip.class, Laser.class, Stars.class, Point.class);
    
        prepare();
    }
    
    /**
     * Pregateste lumea :
     * - adauga racheta
     * - adauga stele
     * - adauga tabela scor
     */
    public void prepare()
    {
        addObject(new Label(),1020 , 40);
        addObject(new Label2(),1011 , 60);
        addObject(new Label3(),1020 , 100);
        addObject(new Ship(),350 , 300);
        
        for(int i=0; i<stars; i++)
            Stars();
    }
    
    /**
     * Adauga steaua in lumea intr-o anumita pozitie cu o anumita viteza.
     */
    public void Stars()
    {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        int s = Greenfoot.getRandomNumber(3)+3;
        int v = Greenfoot.getRandomNumber(3)+2;

        
        if(!StarAtLocation(x,y))
            addObject(new Stars(s,v),x,y);
        else
            Stars();
    }   
    
     /**
     * Se verifica daca exista o stea intr-o anumita locatie.
     */
    public boolean StarAtLocation(int x, int y)
    {
        if(getObjectsAt(x,y, Stars.class).size()!=0)
            return true;
        return false;
    }

    private int spawnCounter = 0;
 
    
    /**
     * Creeaza un punct pe mapa la un interval de timp.
     */
    public void act()
    {
        if (spawnCounter > 1500)
        {
            spawnCounter = 0;
            addObject(new Point(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
    spawnCounter++;
    }
}