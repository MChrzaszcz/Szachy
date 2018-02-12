
package Pionki;

import javax.swing.JLabel;

/**
 *
 * @author Mack
 */
public class Pole extends JLabel {



   private int indexFigury=-1;          //wartosc -1 oznacza ze na polu nie znajduje sie zadna figura
   private boolean czyCzarna;    //opisuje czy na danym polu znajduje sie jakas figura
   private boolean czyFigura;
   private int i,j;

    public Pole(int x,int y,boolean czyFigura){

        this.czyFigura=czyFigura;

    }

    public boolean getCzyFigura(){
        return czyFigura;
    }

    public void setCzyCzarna(Boolean czyCzarna){
        this.czyCzarna=czyCzarna;
    }
    public void setIndexFigury(int index){
        this.indexFigury=index;

    }

    public int getIndexFigury(){
        return indexFigury;
    }

    public Boolean getCzyCzarna(){
        return czyCzarna;
    }

    public Pole(){}

    public void setFigura(int indexFigury,boolean czyCzarna){
        this.indexFigury=indexFigury;
        this.czyCzarna=czyCzarna;


    }

    public void removeFigura(){
        indexFigury=-1;


    }




}
