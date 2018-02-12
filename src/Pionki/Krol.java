
package Pionki;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Krol extends Figura {


    public Krol(boolean czyCzarny,int index){
        super(czyCzarny,index);
        if(czyCzarny == true)
            ikona = new ImageIcon("figury/CKrol.png");
        else ikona = new ImageIcon("figury/BKrol.png");
        figura.setIcon(ikona);
    }


    public Krol (){


        id="krol";
        this.wspPol=wspPol;

    }

    public Krol(ArrayList<ArrayList<Pole>> ListaPol,boolean czyCzarny,int index){
        super(ListaPol,czyCzarny,index);
    }

    public  boolean czyRuch(Pole pole){

        int ruch=60;                          //figura przesuwajac sie o 60px pokonuje 1 pole;
        int xFigury=this.getFigura().getX();
        int yFigury=this.getFigura().getY();
        int i,j;
        Point punkt=new Point();


        for( i=0;i<3;i++)
            for(j=0;j<3;j++){
                punkt.setLocation((xFigury-ruch)+j*ruch,(yFigury-ruch)+i*ruch);    //petla sprawdza kolejno 9 pol,gdzie w centrum(na 5 polu) znajduje sie figura-krol                   
                if(pole.getLocation().equals(punkt) ){                           //od aktualnych wspolrzednych odejmujemy po 1 polu/ruch zeby zaczac sprawdzanie od 1 do 3 pola wokol figury
                    if(pole.getIndexFigury()!=-1 ){
                        return true;

                    }
                    if(pole.getIndexFigury()==-1 ){
                        return true;
                    }

                }


            }
        return false;

    }
}
