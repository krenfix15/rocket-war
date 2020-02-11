import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Navele inamice.
 * 
 * @author Pascal Marian
 * @version 2017 Februarie
 */
public class EnemyShip extends Actor
{
    public int j = 0;
    public int a = 0;
    public int width = 6;
    public int v = 3;
    public int lifePoints = 6;
    
    public EnemyShip(int r)
    {
        setRotation(r);
    }
    
    /**
     * Verifica miscarile aleatorii ale navelor inamice,ataca,explodeaza.
     */
    public void act() 
    {
        if(lifePoints != 0) {
            j++;
            attack();
            flyRandom();
            try {
                explode();
            }
            catch(Exception e){
            }
        }
    }
    
    /**
     * Inamicii se rotesc aleatoriu.
     * Apoi se misca.
     */
    public void flyRandom()
    {
        a++;
        if(a%180 == 0)
            setRotation(getRotation() + Greenfoot.getRandomNumber(450 - 270)+270);
        setRotation(getRotation() + Greenfoot.getRandomNumber(6)-3); 
        move(v);
        remove();
    }
    
    /**
     * Inamicii trag cu lasere.
     */
    public void attack()
    {
        if(j>20)
        {
            shoot(1);
            shoot(-1);
            j = 0;
        }
    }
    /**
     * Sunt adaugate cate 2 lasere.
     */
    public void shoot(int a)
    {
        double angle = Math.toRadians( getRotation() +90* a);
        int x = (int) Math.round(getX() + Math.cos(angle) * width);
        int y = (int) Math.round(getY() + Math.sin(angle) * width);
        
        getWorld().addObject(new RedLaser(getRotation()), x, y);
    }
    
    /**
     * Inamicii explodeaza daca nu mai au puncte de viata.
     */
    public void explode()
    {
        if(Laser()&&lifePoints>0)
            lifePoints --;
        if(lifePoints == 0) {
            getWorld().addObject(new Explosion(), getX(), getY()); 
            Space.shots++;
            getWorld().removeObject(this);
        }
        
    }
    
    /**
     * Inamicii se sterg automat daca au iesit inafara mapei.
     */
    public void remove()
    {
        if(getX()<-200 || getX() > getWorld().getWidth()+200)
            getWorld().removeObject(this);
        else if(getY()<-200 || getY() > getWorld().getHeight()+200)
            getWorld().removeObject(this);  
    }
    
    /**
     * Verifica daca laserul este pe inamic.
     */
    public boolean Laser()
    {
        if(getOneIntersectingObject(Laser.class)!=null)
            return true;
        return false;
    }
}
