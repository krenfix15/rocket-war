import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tabela de scor pentru Nave ucise.
 * 
 * @author Pascal Marian
 * @version 2017 Februarie
 */
public class Label2 extends Actor
{
    public GreenfootImage label2 = new GreenfootImage(60,50);
    
    public Label2()
    {
        setImage(label2);
        label2.drawString( "Kills : "+Space.shots, 0, 20);
    }
    
    /**
     * Numara cate nave inamice au fost ucise.
     */
    public void act() 
    {
      score2();
    }    
    
    public void score2()
    {
        label2.clear();
        label2.setColor(Color.WHITE);
        label2.drawString( "Kills : "+Space.shots, 10, 30);
    }
}
