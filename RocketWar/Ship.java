import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mava spatiala.
 * 
 * @author Pascal Marian
 * @version 2017 Februarie
 */
public class Ship extends Actor
{
    public int lifePoints = 80;
    public int width = 46;
    public int j = 0;
    public int d = 300;
    public int a = 0;
    public static int pointsEaten;
    
    
    public Ship()
    {
        pointsEaten = 0;
    }
    
    /**
     * Verifica miscarea mouselui,inamicilor,explozia si tastele apasate iar daca a gasit punctul,il culege.
     */
    public void act() 
    {
        if(foundPoint()) 
        {
            eatPoint();
        }
        newEnemy();
        j++;
        checkKeys();
        followMouse();
        explode();
    }  
    
    /**
     * Verifica daca nava se gaseste pe punct.
     */
    public boolean foundPoint()
    {
        Actor Point = getOneObjectAtOffset(0, 0, Point.class);
        if(Point != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Culege punctul si il numara.
     */
    public void eatPoint()
    {
        Actor Point = getOneObjectAtOffset(0, 0, Point.class);
        if(Point != null) {
            // mananca punctul
            getWorld().removeObject(Point);
            pointsEaten = pointsEaten + 1; 
        }
    }
    
    /**
     * Nava trage lasere cu ambele aripi:
     * Adauga 2 clase Laser in WORLD.
     */
    public void shoot(int a)
    {
        double angle = Math.toRadians( getRotation() +90* a);
        int x = (int) Math.round(getX() + Math.cos(angle) * width);
        int y = (int) Math.round(getY() + Math.sin(angle) * width);
        
        getWorld().addObject(new Laser(getRotation()), x, y);
    }
    
    /**
     * Verifica tastele.
     * Depinzand de tastele apasate se misca sau trage.
     */
    public void checkKeys()
    {
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
            move(2);
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
            move(-2);
        if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
            setRotation(getRotation()+2);
        if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))
            setRotation(getRotation()-2);
        if(Greenfoot.isKeyDown("space") && j>20|| Greenfoot.mouseClicked(null)) {
            shoot(1); 
            shoot(-1);
            j=0;
        }
    }
    
    /**
     * Nava se misca dupa cursor.
     */
    public void followMouse()
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null) 
        {  
             int x = m.getX() - getX();  
             int y = m.getY() - getY();  
             double r = Math.toDegrees(Math.atan2(x, y)) - 90;  
             setRotation(-(int) r);  
        }  
    }
    
    /**
     * Nava explodeaza daca nu mai are puncte de viata.
     */
    public void explode()
    {
        if(Laser()&&lifePoints>0)
            lifePoints --;
        if(lifePoints == 0) {
            getWorld().addObject(new Explosion(), getX(), getY()); 
            World myWorld = getWorld();
            GameOver gameover = new GameOver();
            myWorld.addObject(gameover, myWorld.getWidth()/2, myWorld.getHeight()/2);
            getWorld().removeObject(this);
        }
        
    }
    
     /**
     * Se adauga inamici in lume. (Nu ca nu ar fi destui ! :D)
     */
    public void newEnemy()
    {
        a++;
        if(a%d == 0) {
            int z = Greenfoot.getRandomNumber(9);
            int x = Greenfoot.getRandomNumber(getWorld().getWidth());
            int y = Greenfoot.getRandomNumber(getWorld().getHeight());
            
            if(z == 0)
                addEnemy(800, y);
            if(z == 1)
                addEnemy(x, 700);
            if(z == 2)
                addEnemy(-100, y);
            if(z == 3 || z == 4)
                addEnemy(x, -100);
            if(z == 5 || z == 6)
                addEnemy(x,-150);
            if(z == 7 || z == 8)
                addEnemy(750,y);
            if(z==9)
                addEnemy(x,650);
            if(d > 130)
                d = d - 3;
        }
    }
    
    /**
     * Adauga inamic in lume care tinteste spre nava.
     */
    public void addEnemy(int x, int y)
    {
        int nX = x - getX();  
        int nY = y - getY();  
        double r = Math.toDegrees(Math.atan2(nX, nY)) - 90;   
        getWorld().addObject(new EnemyShip((int)r), x, y);
    }
    
    /**
     * Verifica daca laserul intersecteaza nava.
     */
    public boolean Laser()
    {
        if(getOneIntersectingObject(RedLaser.class)!=null)
            return true;
        return false;
    }
}
