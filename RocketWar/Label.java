import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tabela pentru Puncte.
 * 
 * @author Pascal Marian
 * @version 2017 Februarie
 */
public class Label extends Actor
{
    public GreenfootImage label = new GreenfootImage(60,50);
    
    public Label()
    {
        setImage(label);
        label.drawString( "Puncte : "+Ship.pointsEaten, 0,20);
    }
    
    /**
     * Numara scorul.
     */
    public void act() 
    {
        score();
    }    
    
     /**
     * Arata cate puncte a cules nava.
     */
    public void score()
    {
        label.clear();
        label.setColor(Color.WHITE);
        label.drawString( "Puncte : "+Ship.pointsEaten, 0,20);
    }
}
