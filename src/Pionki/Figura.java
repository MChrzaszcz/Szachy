
package Pionki;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public abstract class Figura {
    protected int x,y;
    protected  int ruch=60;                  // 1 ruch figury w pixelach
    protected  int ruchprzod;
    protected  ImageIcon ikona;
    protected  int[] wspPol=new int[8];
    protected  boolean czyCzarna;
    protected  JLabel figura=new JLabel();
    protected  String id="cos";
    protected  ArrayList<ArrayList<Pole>> ListaPol= new ArrayList <ArrayList<Pole>>();
    protected  int i,j;
    protected  int index=-1;
    protected  ArrayList <Figura> ListaFigur=new ArrayList <Figura>(32);


    public Figura(int x,int y,int wspPol[],String url,boolean czyCzarna){
        this.x=x;
        this.y=y;
        this.wspPol=wspPol;
        this.czyCzarna=czyCzarna;
      
    }


    public Figura( ArrayList<ArrayList<Pole>> ListaPol,boolean czyCzarny,int index ){

        this.ListaPol=ListaPol;
        this.czyCzarna=czyCzarny;
        this.index=index;
    }


    public Figura( boolean czyCzarny,int index ){


        this.czyCzarna=czyCzarny;
        this.index=index;
    }


    public Figura(boolean czyCzarny){
        this.czyCzarna=czyCzarny;
    }
     public Figura(){};

    public int getIndex(){
        return index;
    }

    public void setJakiePole(int i,int j){
        this.i=i;
        this.j=j;
    }


    public void setListaFigur( ArrayList <Figura> ListaFigur){
        this.ListaFigur=ListaFigur;

    }

    public void setListaPol( ArrayList <ArrayList<Pole>> ListaPol){
        this.ListaPol=ListaPol;

    }



    public int getInPola1(){
        return i;
    }
    public int getInPola2(){
        return j;
    }
   
    public JLabel getFigura(){
        return figura;
    }
 

  

  /**
 * Metoda weryfikuje czy gracz wykonal dozwolony ruch. 
 * 
 */
    abstract public boolean czyRuch(Pole pole);


    public void setWspolrzedne(int x,int y){


        figura.setLocation(this.x+x, this.y+y);

    }


    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
  /**
 * Ustalenie koloru figury. 
 * 
 */

   public boolean getCzyCzarna(){
        return czyCzarna;
    }
}
     
    

