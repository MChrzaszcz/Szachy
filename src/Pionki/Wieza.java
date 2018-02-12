
package Pionki;

import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author Mack
 */
public class Wieza extends Figura{

    private ImageIcon ikona;

    public Wieza(boolean czyCzarny,int index){
        super(czyCzarny,index);

        if(czyCzarny == true)
            ikona = new ImageIcon("figury/CWieza.png");
        else ikona = new ImageIcon("figury/BWieza.png");
        figura.setIcon(ikona);

    }



    @Override
    public boolean czyRuch(Pole pole) {

        int i,temp=0,j=0,j1;

        for(i=0;i<8;i++){
            for(j=0;j<8;j++)
                if(ListaPol.get(i).get(j).getLocation().equals(pole.getLocation())){   //sprawdzenie na ktore pole figura ma sie przeniesc
                    temp=i;
                    i=8;
                    break;
                }
        }

        i=temp;

        int iWieza=this.getInPola1();                       //index wierszy wListaPol okreslajace miejsce w ktorym znajudje sie Wieza
        int jWieza=this.getInPola2();                      //index kolumn wListaPol okreslajace miejsce w ktorym znajudje sie Wieza


        for(j1=1;j1<9;j1++){

            if(iWieza==i) {                                                                               // jesli prawda to sprawdzanie toru tylko pionowo po x-ach


                if(jWieza-j>0 && (jWieza-j1)> j && ListaPol.get(iWieza).get(jWieza-j1).getIndexFigury()!=-1)                //(jWieza-j)>0 -warunek okresla czy sprawdzac w lewo czy w prawo od wiezy; (jWieza-j1)> j -warunek sprawdza czy figura dotarla do wyznaczonego pola\figury..                  
                    return false;

                if(jWieza-j<0 && (j-j1) > jWieza && ListaPol.get(iWieza).get(j-j1).getIndexFigury()!=-1){              //jesli na drodze figury znajdzie sie inna figura to ruch nie zostanie wykonany

                    return false;
                }

            }


            if(jWieza==j) {                                                        // jesli prawda to sprawdzanie toru tylko pionowo po y-kach           


                if( (iWieza-i)>0  && (iWieza-j1)> i && ListaPol.get(iWieza-j1).get(jWieza).getIndexFigury()!=-1 ){ //jesli na drodze figury znajdzie sie inna figura to ruch nie zostanie wykonany                     
                    return false;

                }
                if( (iWieza-i)<0 && (i-j1)> iWieza && ListaPol.get(i-j1).get(jWieza).getIndexFigury()!=-1) {        //jesli na drodze figury znajdzie sie inna figura to ruch nie zostanie wykonany
                    return false;

                }
            }
        }


        if(jWieza!=j && iWieza!=i){           //jesli ruch zostanie wykonany  na ukos to false   

            return false;
        }



        return true;
    }

}
