
package Pionki;

import static java.lang.Math.abs;
import javax.swing.ImageIcon;


public class Krolowa extends Figura{


    public Krolowa(boolean czyCzarny,int index){
        super(czyCzarny,index);
        if(czyCzarny == true)
            ikona = new ImageIcon("figury/CKrolowa.png");
        else ikona = new ImageIcon("figury/BKrolowa.png");
        figura.setIcon(ikona);
    }



    @Override
    public boolean czyRuch(Pole pole) {


        int i,i1=0,temp=0,j=0,j1;


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

        int iGoniec=this.getInPola1();                       //index wierszy wListaPol okreslajace miejsce w ktorym znajudje sie Wieza
        int jGoniec=this.getInPola2();


        j1=jGoniec;
        i1=iGoniec;

        if(iGoniec!=i && jGoniec!=j){                                                                 //warunek na gonca
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
                if(i1==i && j1==j && ListaPol.get(i1).get(j1).getLocation().equals(pole.getLocation()))        //jesli klik na pionek a nie na figure   ??
                    return true;
            }

            return false;
        }




        else{                                                                                            //warunek na wieze
            for(j1=1;j1<9;j1++){

                if(iWieza==i) {                                                                               // jesli prawda to sprawdzanie toru tylko pionowo po x-ach


                    if(jWieza-j>0 && (jWieza-j1)> j && ListaPol.get(iWieza).get(jWieza-j1).getIndexFigury()!=-1)                //(jWieza-j)>0 -warunek okresla czy sprawdzac w lewo czy w prawo od wiezy; (jWieza-j1)> j -warunek sprawdza czy figura dotarla do wyznaczonego pola\figury..                  
                        return false;

                    if(jWieza-j<0 && (j-j1) > jWieza && ListaPol.get(iWieza).get(j-j1).getIndexFigury()!=-1){              //jesli na drodze figury znajdzie sie inna figura to ruch nie zostanie wykonany
                        return false;
                    }

                }


                if(jWieza==j) {                                                        // jesli prawda to sprawdzanie toru tylko pionowo po y-kach           


                    if( (iWieza-i)>0  && (iWieza-j1)> i && ListaPol.get(iWieza-j1).get(jWieza).getIndexFigury()!=-1 ) //(jWieza-j)>0 -warunek okresla czy sprawdzac w lewo czy w prawo od wiezy; (jWieza-j1)> j -warunek sprawdza czy figura dotarla do wyznaczonego pola\figury..                                                                                                               //jesli na drodze figury znajdzie sie inna figura to ruch nie zostanie wykonany
                        return false;


                    if( (iWieza-i)<0 && (i-j1)> iWieza && ListaPol.get(i-j1).get(jWieza).getIndexFigury()!=-1)          //(jWieza-j)>0 -warunek okresla czy sprawdzac w lewo czy w prawo od wiezy; (jWieza-j1)> j -warunek sprawdza czy figura dotarla do wyznaczonego pola\figury..                                                                                                               //jesli na drodze figury znajdzie sie inna figura to ruch nie zostanie wykonany
                        return false;


                }
            }



            if(jWieza!=j && iWieza!=i)   {        //jesli ruch zostanie wykonany  na ukos to false  
                return false;
            }

            return true;

        }
    }
}
