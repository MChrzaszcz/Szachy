

package Pionki;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Mack
 */
public class Pionek extends Figura{

    ArrayList <ArrayList<Pole>> ListaPol=new ArrayList();


    public Pionek(ArrayList<ArrayList<Pole>> ListaPol,boolean czyCzarny,int index){
        super(ListaPol,czyCzarny,index);

    }


    public Pionek(boolean czyCzarny,int index){
        super(czyCzarny,index);
        if(czyCzarny == true)
            ikona = new ImageIcon("figury/CPionek.png");
        else ikona = new ImageIcon("figury/BPionek.png");
        figura.setIcon(ikona);
    }


    public void setListaPol( ArrayList <ArrayList<Pole>> ListaPol){
        this.ListaPol=ListaPol;

    }

    public  boolean czyRuch(Pole pole){

        int ruch=60;                          //figura przesuwajac sie o 60px pokonuje 1 pole;
        int xFigury=this.getFigura().getX();
        int yFigury=this.getFigura().getY();
        int i,temp=0,j=0;
        Point punkt=new Point(xFigury,yFigury);




        for(i=0;i<8;i++){
            for(j=0;j<8;j++){
                if(ListaPol.get(i).get(j).getLocation().equals(punkt)){   //sprawdzenie na ktorym polu znajduje sie figura   

                    temp=i;
                    i=8;
                    break;
                }
            }
        }
        i=temp;


        if(this.getCzyCzarna()){

            if(i+1<=7 && ListaPol.get(i+1).get(j).getIndexFigury()==-1  && ListaPol.get(i+1).get(j).getLocation().equals(pole.getLocation())){  //jesli na polu przed pionkiem nie bd innej figury to war.spelniony
                return true;
            }
            if(i+1<=7 && j+1<=7 && ListaPol.get(i+1).get(j+1).getIndexFigury()!=-1 && this.getCzyCzarna()!=ListaPol.get(i+1).get(j+1).getCzyCzarna() && ListaPol.get(i+1).get(j+1).equals(pole))  //jesli na polu na ukos po prawej przed pionkiem  bd inna figury o innym kolorze to war.spelniony
            {
                return true;
            }
            if(j-1>=0 && i+1<=7 && ListaPol.get(i+1).get(j-1).getIndexFigury()!=-1 && this.getCzyCzarna()!=ListaPol.get(i+1).get(j-1).getCzyCzarna() && ListaPol.get(i+1).get(j-1).equals(pole))  //jesli na polu na ukos po prawej przed pionkiem  bd inna figury o innym kolorze to war.spelniony
                return true;

        }

        if(!this.getCzyCzarna()){

            if(i-1>=0 && ListaPol.get(i-1).get(j).getIndexFigury()==-1  && ListaPol.get(i-1).get(j).getLocation().equals(pole.getLocation())){  //jesli na polu przed pionkiem nie bd innej figury to war.spelniony
                return true;
            }
            if(i-1>=0 && j+1<=7 && ListaPol.get(i-1).get(j+1).getIndexFigury()!=-1 && this.getCzyCzarna()!=ListaPol.get(i-1).get(j+1).getCzyCzarna() && ListaPol.get(i-1).get(j+1).equals(pole))  //jesli na polu na ukos po prawej przed pionkiem  bd inna figury o innym kolorze to war.spelniony
                return true;
            if(j-1>=0 && i-1>=0 && ListaPol.get(i-1).get(j-1).getIndexFigury()!=-1 && this.getCzyCzarna()!=ListaPol.get(i-1).get(j-1).getCzyCzarna() && ListaPol.get(i-1).get(j-1).equals(pole))  //jesli na polu na ukos po prawej przed pionkiem  bd inna figury o innym kolorze to war.spelniony
                return true;

        }





        return false;
    }
}