

package Pionki;

import static java.lang.Math.abs;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Mack
 */
public class Goniec extends Figura {


    public Goniec(ArrayList<ArrayList<Pole>> ListaPol,boolean czyCzarny,int index){
        super(ListaPol,czyCzarny,index);

        id="goniec";
        this.wspPol=wspPol;
    }



    public Goniec(boolean czyCzarny,int index){
        super(czyCzarny,index);
        if(czyCzarny == true)
            ikona = new ImageIcon("figury/CGoniec.png");
        else ikona = new ImageIcon("figury/BGoniec.png");
        figura.setIcon(ikona);
    }

    @Override
    public boolean czyRuch(Pole pole) {

        int i,i1=0,temp=0,j=0,j1;


        int iGoniec=this.getInPola1();      //i,j indeksy pola na ktore figura ma zostac przeniesiona; iGonca,jGonca indeksy pola gdzie znajduje sie figura; i1,j1 indeksy pomocnicze,sprawdzajace warunki
        int jGoniec=this.getInPola2();


        for(i=0;i<8;i++){
            for(j=0;j<8;j++)
                if(ListaPol.get(i).get(j).getLocation().equals(pole.getLocation())){   //sprawdzenie na ktore pole figura ma sie przeniesc
                    temp=i;
                    i=8;
                    break;
                }
        }

        i=temp;


        


        j1=jGoniec;
        i1=iGoniec;

        for(int n=0;n<=abs(i-iGoniec);n++){
            if(i<iGoniec && j<jGoniec)  {                   //jesli figura ma przejsc na pole znajdujace sie na polnocny zachod od niej
                i1-=1;
                j1-=1;
                if(i1>=0 && j1>=0){
                    if(i1!= i && j1!= j && ListaPol.get(i1).get(j1).getIndexFigury()!=-1)
                        return false;
                }


            }

            if(i<iGoniec && j>jGoniec){                                  //jesli figura ma przejsc na pole znajdujace sie na polnocny wschod od niej
                i1-=1;
                j1+=1;
                if(i1>=0 && j1<=7){
                    if(i1!= i && j1!= j && ListaPol.get(i1).get(j1).getIndexFigury()!=-1)
                        return false;
                }

            }


            if(i>iGoniec && j>jGoniec){                                              //jesli figura ma przejsc na pole znajdujace sie na poludniowy wschod od niej         
                i1+=1;
                j1+=1;
                if(i1<=7 && j1<=7){
                    if(i1!= i && j1!= j && ListaPol.get(i1).get(j1).getIndexFigury()!=-1)
                        return false;
                }
            }

            if(i>iGoniec && j<jGoniec){                                              //jesli figura ma przejsc na pole znajdujace sie na poludniowy zachod od niej        
                i1+=1;
                j1-=1;
                if(i1<=7 && j1>=0){
                    if(i1!= i && j1!= j && ListaPol.get(i1).get(j1).getIndexFigury()!=-1)
                        return false;
                }
            }
            if(i1==i && j1==j && ListaPol.get(i1).get(j1).getLocation().equals(pole.getLocation()))        //jesli bicie piona  
                return true;
        }

        return false;
    }
}
