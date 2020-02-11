import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
   /**
 * Tabela de scor pentru Total.
 * 
 * @author Pascal Marian
 * @version 2017 Februarie
 */
 
public class Label3 extends Actor
{
    public GreenfootImage label3 = new GreenfootImage(60,50);
    
    public Label3()
    {
        setImage(label3);
        label3.drawString("Total : "+(Space.shots+2*Ship.pointsEaten),0,20);
    }
    
    /**
     * 10 * Puncte+Nr. Nave Ucise.
     */
    public void act() 
    {
      score3();
    }    
    
    public void score3()
    {
        label3.clear();
        label3.setColor(Color.WHITE);
        label3.drawString("Total : "+(Space.shots+10*Ship.pointsEaten),0,20);
    }
}
