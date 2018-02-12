
package Pionki;

import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author Mack
 */
public class Skoczek extends Figura{


    public Skoczek(boolean czyCzarny,int index){
        super(czyCzarny,index);
        if(czyCzarny == true)
            ikona = new ImageIcon("figury/CKonik.png");
        else ikona = new ImageIcon("figury/BKonik.png");
        figura.setIcon(ikona);
    }




    @Override
    public boolean czyRuch(Pole pole) {


        int xFigury=this.getFigura().getX();
        int yFigury=this.getFigura().getY();
        int i,temp=0,j=0,j1;
        Point punkt=new Point(xFigury,yFigury);




        for(i=0;i<8;i++){
            for(j=0;j<8;j++)
                if(ListaPol.get(i).get(j).getLocation().equals(punkt)){   //sprawdzenie na ktorym polu znajduje sie figura    
                    temp=i;
                    i=8;
                    break;
                }
        }

        i=temp;

        int y=3;
        int x;
        for(j1=0;j1<6;j1++){
            x=1;
            y--;

            if(y==2 || y==-2  ){                                                                             //dla ruchow: 2 w przod/tyl 1 w prawo/lewo
                x=1;
                if( (i+y)<8 && (i+y)>=0 && (j+x)<8 && ListaPol.get(i+y).get(j+x).getLocation().equals(pole.getLocation()))
                    return true;

                x=-1;

                if(  (j+x)>=0  && (i+y)>=0 && (i+y)<8 && ListaPol.get(i+y).get(j+x).getLocation().equals(pole.getLocation()))
                    return true;
            }


            if(y==1 || y==-1 ){                                                                               //dla ruchow: 1 w przod/tyl 2 w prawo/lewo
                x=2;
                if( (i+y)<8 && (i+y)>=0 && (j+x)<8 &&  ListaPol.get(i+y).get(j+x).getLocation().equals(pole.getLocation()))
                    return true;
                x=-2;
                if((i+y)<8  && (i+y)>=0 && (j+x)>=0 && ListaPol.get(i+y).get(j+x).getLocation().equals(pole.getLocation()))
                    return true;

            }

        }


        return false;
    }

}
