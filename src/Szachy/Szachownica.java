

package Szachy;

import Pionki.Skoczek;
import Pionki.Figura;
import Pionki.Pionek;
import Pionki.Krolowa;
import Pionki.Pole;
import Pionki.Goniec;
import Pionki.Wieza;
import Pionki.Krol;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Mack
 */


public class Szachownica extends JPanel implements MouseListener,Runnable {

    private int i,j;
    private int i1;
    private int temp=-1;
    private  int[] wspPol=new int[8];
    private   ArrayList<ArrayList<Pole>> ListaPol= new ArrayList <ArrayList<Pole>>();
    private  ArrayList <Figura> ListaFigur=new ArrayList <Figura>(32);
    private int liczKlik=0;                                        //zlicza klikniecia
    private Border zaznacz = BorderFactory.createLineBorder(Color.BLUE, 3);
    private boolean ruchCzarny = false;


    void wstawFigure(Figura figura,Pole pole){
        figura.getFigura().setLocation(pole.getX(),pole.getY());
    }



    @Override
    public void mouseClicked(MouseEvent e) {

        Object source=e.getSource();


        liczKlik+=1;


        if(liczKlik==1){
            for(i1=0;i1<32;i1++)   {
                if(source.equals(ListaFigur.get(i1).getFigura())){                      //znajdz kliknieta figure przy zalozeniu ze kliknieto tylko raz(1 klik zaznaczenie
                    return;
                }

            }
        }
        if(i1==32){                                            //i1==32    max index listy figur;jesli nie znajdzie figury to znaczy ze kliknieto w pole wiec nic nie rob
            liczKlik=0;
            return;
        }
        //i,j=indeksy LisyPol;i1-indeks ListyFigur okreslajaca pierwsza kliknieta figure
        if( liczKlik == 2 && ruchCzarny ==  ListaFigur.get(i1).getCzyCzarna()){                                        //jesli klikniecie nastapilo 2 klikniecie to sprawdz ma jakim polu..
            //(poprzez sprawdzenie czy punkt na ktory sie kliknelo zawiera sie w jakims polu) a nastepnie.
            for(i=0;i<8;i++)                                                                // nastepnie  wstaw na to pole figure
                for(j=0;j<8;j++) {
                    if(e.getComponent().equals(ListaPol.get(i).get(j))){
                        if(ListaFigur.get(i1).czyRuch(ListaPol.get(i).get(j))){          //wstawia index figury znajdujacej sie w ListaFigur dzieki czemu wiadomo ze na polu znajduje sie dana figura                                   


                            ListaPol.get(ListaFigur.get(i1).getInPola1()).get(ListaFigur.get(i1).getInPola2()).removeFigura();  //jak pionek zejdzie z pola to pole zostaje puste
                            wstawFigure(ListaFigur.get(i1),ListaPol.get(i).get(j));


                            ListaPol.get(i).get(j).setFigura(i1, ListaFigur.get(i1).getCzyCzarna());
                            ListaFigur.get(i1).setJakiePole(i,j);

                            if(ruchCzarny == true)
                                ruchCzarny = false;
                            else ruchCzarny = true;

                        }
                        i=8;
                        break;
                    }
                }

            for(j=0;j<32;j++){                                                                            //jesli klik na figure
                if(e.getComponent().equals(ListaFigur.get(j).getFigura()) && ListaFigur.get(j).getCzyCzarna()!=ListaFigur.get(i1).getCzyCzarna()){   //jesli pionek o 1 kolorze wejdzie na pole gdzie jest pionek o 2 kolorze    i..

                    if(ListaFigur.get(i1).czyRuch(ListaPol.get(ListaFigur.get(j).getInPola1()).get(ListaFigur.get(j).getInPola2()))){          //wstawia index figury znajdujacej sie w ListaFigur dzieki czemu wiadomo ze na polu znajduje sie dana figura                                   
                        add( ListaFigur.get(j).getFigura(),"hidemode 2");
                        wstawFigure(ListaFigur.get(i1),ListaPol.get(ListaFigur.get(j).getInPola1()).get(ListaFigur.get(j).getInPola2()));

                        ListaPol.get(ListaFigur.get(i1).getInPola1()).get(ListaFigur.get(i1).getInPola2()).removeFigura();  //jak pionek zejdzie z pola to pole zostaje puste 
                        ListaFigur.get(i1).setJakiePole(ListaFigur.get(j).getInPola1(), ListaFigur.get(j).getInPola2());  //ustawienie info o lokalizacji pola w pionku
                        ListaPol.get(ListaFigur.get(j).getInPola1()).get(ListaFigur.get(j).getInPola2()).setFigura(ListaFigur.get(i1).getIndex(),ListaFigur.get(j).getCzyCzarna()); //ustawienie danych o figurze na polu
                        if(ruchCzarny == true)
                            ruchCzarny = false;
                        else ruchCzarny = true;

                    }
                    i=8;
                    break;
                }
            }


            liczKlik=0;

        }
        else liczKlik=0;
    }

    @Override
    public void run() {

        wstawFigure(ListaFigur.get(i1),ListaPol.get(ListaFigur.get(j).getInPola1()).get(ListaFigur.get(j).getInPola2()));
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}








    public Szachownica() {
        setLayout(new MigLayout());
       // setSize(300, 300);
        repaint();


    }
    /**
     * Tworzy figury i ustawia je na szachownicy. 
     *
     */
    void StworzIUstawFigury(){    //

        this.setEnabled(true);

        ImageIcon ikonaCKonik= new ImageIcon("figury/CKonik.png");
        ImageIcon ikonaCPionek= new ImageIcon("figury/CPionek.png");
        ImageIcon ikonaCWieza= new ImageIcon("figury/CWieza.png");
        ImageIcon ikonaCGoniec= new ImageIcon("figury/CGoniec.png");
        ImageIcon ikonaCKrol= new ImageIcon("figury/CKrol.png");
        ImageIcon ikonaCKrolowa= new ImageIcon("figury/CKrolowa.png");

        Border border = BorderFactory.createLineBorder(Color.BLUE, 1);



        for(j=0;j<8;j++){                       // implementacja ListyPol
            ArrayList <Pole> Lista=new ArrayList <Pole>(8);
            ListaPol.add(j,Lista);
        }



        int x=0,y=0;




        int k=60;
        int k1=0;
        int indPola1=1;   //indeks-wiersze pola
        int indPola2=0;//indeks-kolumny pola
        i=3;

        for(j=0;j<8;j++){                                           //ustawienie pionkow czarnych
            Pionek pionek=new Pionek(true,j);
            pionek.getFigura().setIcon(ikonaCPionek);
            ListaFigur.add(pionek);

            add(pionek.getFigura(),"pos (headerLabel.x - ("+ k1 +")) (headerLabel.y + "+ k +")");
            ListaFigur.get(j).setJakiePole(indPola1,indPola2);

            k1-=60;
            indPola2+=1;
        }

        Wieza cWieza=new Wieza(true,8);
        cWieza.getFigura().setIcon(ikonaCWieza);
        ListaFigur.add(cWieza);
        add(cWieza.getFigura(),"pos (headerLabel.x - (-420)) (headerLabel.y + 0)");
        ListaFigur.get(8).setJakiePole(0,7);

        Wieza cWieza2=new Wieza(true,9);
        cWieza2.getFigura().setIcon(ikonaCWieza);
        ListaFigur.add(cWieza2);
        add(cWieza2.getFigura(),"pos (headerLabel.x - (0)) (headerLabel.y + 0)");
        ListaFigur.get(9).setJakiePole(0,0);



        Skoczek cSkoczek=new Skoczek(true,10);
        cSkoczek.getFigura().setIcon(ikonaCKonik);
        ListaFigur.add(cSkoczek);
        add(cSkoczek.getFigura(),"pos (headerLabel.x - (-60)) (headerLabel.y + 0)");
        ListaFigur.get(10).setJakiePole(0,1);


        Skoczek cSkoczek2=new Skoczek(true,11);
        cSkoczek2.getFigura().setIcon(ikonaCKonik);
        ListaFigur.add(cSkoczek2);
        add(cSkoczek2.getFigura(),"pos (headerLabel.x - (-360)) (headerLabel.y + 0)");
        ListaFigur.get(11).setJakiePole(0,6);




        Goniec cGoniec=new Goniec(true,12);
        cGoniec.getFigura().setIcon(ikonaCGoniec);
        ListaFigur.add(cGoniec);
        add(cGoniec.getFigura(),"pos (headerLabel.x - (-120)) (headerLabel.y + 0)");
        ListaFigur.get(12).setJakiePole(0,2);


        Goniec cGoniec2=new Goniec(true,13);
        cGoniec2.getFigura().setIcon(ikonaCGoniec);
        ListaFigur.add(cGoniec2);
        add(cGoniec2.getFigura(),"pos (headerLabel.x - (-300)) (headerLabel.y + 0)");
        ListaFigur.get(13).setJakiePole(0,5);

        Krolowa cKrolowa=new Krolowa(true,14);
        cKrolowa.getFigura().setIcon(ikonaCKrolowa);
        ListaFigur.add(cKrolowa);
        add(cKrolowa.getFigura(),"pos (headerLabel.x - (-180)) (headerLabel.y + 0)");
        ListaFigur.get(14).setJakiePole(0,3);

        Krol cKrol=new Krol(true,15);
        cKrol.getFigura().setIcon(ikonaCKrol);
        ListaFigur.add(cKrol);
        add(cKrol.getFigura(),"pos (headerLabel.x - (-240)) (headerLabel.y + 0)");
        ListaFigur.get(15).setJakiePole(0,4);








        k=360;
        k1=0;
        indPola1=6;   //indeks-wiersze pola
        indPola2=0;//indeks-kolumny pola
        i=3;

        for(j=16;j<24;j++){                                           //ustawienie pionkow bialych
            Pionek pionek=new Pionek(false,j);
            ListaFigur.add(pionek);

            add(pionek.getFigura(),"pos (headerLabel.x - ("+ k1 +")) (headerLabel.y + "+ k +")");
            ListaFigur.get(j).setJakiePole(indPola1,indPola2);

            k1-=60;
            indPola2++;
        }

        Wieza bWieza=new Wieza(false,24);
        ListaFigur.add(bWieza);
        add(bWieza.getFigura(),"pos (headerLabel.x - (-420)) (headerLabel.y + 420)");
        ListaFigur.get(24).setJakiePole(7,7);

        Wieza bWieza2=new Wieza(false,25);
        ListaFigur.add(bWieza2);
        add(bWieza2.getFigura(),"pos (headerLabel.x - (0)) (headerLabel.y + 420)");
        ListaFigur.get(25).setJakiePole(7,0);



        Skoczek bSkoczek=new Skoczek(false,26);
        ListaFigur.add(bSkoczek);
        add(bSkoczek.getFigura(),"pos (headerLabel.x - (-60)) (headerLabel.y + 420)");
        ListaFigur.get(26).setJakiePole(7,1);


        Skoczek bSkoczek2=new Skoczek(false,27);
        ListaFigur.add(bSkoczek2);
        add(bSkoczek2.getFigura(),"pos (headerLabel.x - (-360)) (headerLabel.y + 420)");
        ListaFigur.get(27).setJakiePole(7,6);




        Goniec bGoniec=new Goniec(false,28);
        ListaFigur.add(bGoniec);
        add(bGoniec.getFigura(),"pos (headerLabel.x - (-120)) (headerLabel.y + 420)");
        ListaFigur.get(28).setJakiePole(7,2);


        Goniec bGoniec2=new Goniec(false,29);
        ListaFigur.add(bGoniec2);
        add(bGoniec2.getFigura(),"pos (headerLabel.x - (-300)) (headerLabel.y + 420)");
        ListaFigur.get(29).setJakiePole(7,5);


        Krolowa bKrolowa=new Krolowa(false,30);
        ListaFigur.add(bKrolowa);
        add(bKrolowa.getFigura(),"pos (headerLabel.x - (-180)) (headerLabel.y + 420)");
        ListaFigur.get(30).setJakiePole(7,3);

        Krol bKrol=new Krol(false,31);
        ListaFigur.add(bKrol);
        add(bKrol.getFigura(),"pos (headerLabel.x - (-240)) (headerLabel.y + 420)");
        ListaFigur.get(31).setJakiePole(7,4);



        for(i=0;i<8;i++){                                                                      //utworzenie szachownicy i dodanie wszystkich pol do listy
            x=0;
            if(i>0)
                y+=60;

            for(j=0;j<8;j++){
                Pole pole=new Pole();
                //ustawienie x i y ale nie lokacji,dodanie elementu i jej lokacji zostaje podane nizej(add(pole,a))
                pole.addMouseListener(this);
                ImageIcon Ipole;

                String a="pos (headerLabel.x - ("+x+")) (headerLabel.y + "+y+")";

                if((j+i)%2==0)                              //ustawienie koloru  pol
                    Ipole= new ImageIcon("figury/BPole.png");
                else
                    Ipole= new ImageIcon("figury/CPole.png");
                pole.setIcon(Ipole);
                pole.setBorder(border);
                add(pole,"pos (headerLabel.x - ("+ (x) +")) (headerLabel.y + "+ y +")");

                pole.setLocation(x, y);
                ListaPol.get(i).add(j, pole);

                x+=-60;

            }

        }






        int i1=0;
        for(j=0,i=0;j<32;j++){
            ListaFigur.get(j).setListaFigur(ListaFigur);
            ListaFigur.get(j).setListaPol(ListaPol);

            if(j<8){                                         //czarne pionki
                ListaPol.get(1).get(i).setIndexFigury(j);
                ListaPol.get(1).get(i).setFigura(j, true);
                i++;
                if(j==7)
                    i=0;
            }

            if(j>15 && j<24){                                // biale figury
                ListaPol.get(6).get(i).setIndexFigury(j);
                ListaPol.get(6).get(i).setFigura(j, false);
                i++;
            }

            if(j==8){                                     //lewa czarna wiea
                ListaPol.get(0).get(0).setIndexFigury(j);
                ListaPol.get(0).get(0).setFigura(j, true);
            }

            if(j==9){                                     //prawa czarna wieza
                ListaPol.get(0).get(7).setIndexFigury(j);
                ListaPol.get(0).get(7).setFigura(j, true);
            }

            if(j==24){                                  //prawa biala wieza
                ListaPol.get(7).get(0).setIndexFigury(j);
                ListaPol.get(7).get(0).setFigura(j, false);
            }

            if(j==25){                                    //lewa biala wieza
                ListaPol.get(7).get(7).setIndexFigury(j);
                ListaPol.get(7).get(7).setFigura(j, false);
            }


            if(j==10){                                    //lewy czarny skoczek
                ListaPol.get(0).get(1).setIndexFigury(j);
                ListaPol.get(0).get(1).setFigura(j, true);
            }

            if(j==11){                                       //prawy czarny skoczek
                ListaPol.get(0).get(6).setIndexFigury(j);
                ListaPol.get(0).get(6).setFigura(j, true);
            }

            if(j==26){                                     //lewy bialy skoczek
                ListaPol.get(7).get(1).setIndexFigury(j);
                ListaPol.get(7).get(1).setFigura(j, false);
            }

            if(j==27){                                       //prawy bialy skoczek
                ListaPol.get(7).get(6).setIndexFigury(j);
                ListaPol.get(7).get(6).setFigura(j, false);
            }

            if(j==12){                                     //lewy czarny goniec
                ListaPol.get(0).get(2).setIndexFigury(j);
                ListaPol.get(0).get(2).setFigura(j, true);
            }

            if(j==13){                                       //prawy czarny goniec
                ListaPol.get(0).get(5).setIndexFigury(j);
                ListaPol.get(0).get(5).setFigura(j, true);
            }

            if(j==28){                                     //lewy bialy goniec
                ListaPol.get(7).get(2).setIndexFigury(j);
                ListaPol.get(7).get(2).setFigura(j, false);
            }

            if(j==29){                                       //prawy bialy goniec
                ListaPol.get(7).get(5).setIndexFigury(j);
                ListaPol.get(7).get(5).setFigura(j, false);
            }

            if(j==14){                                     //czarna krolowa
                ListaPol.get(0).get(3).setIndexFigury(j);
                ListaPol.get(0).get(3).setFigura(j, true);
            }

            if(j==15){                                       //czarny krol
                ListaPol.get(0).get(4).setIndexFigury(j);
                ListaPol.get(0).get(4).setFigura(j, true);
            }
            if(j==30){                                     // biala krolowa
                ListaPol.get(7).get(3).setIndexFigury(j);
                ListaPol.get(7).get(3).setFigura(j, false);
            }

            if(j==31){                                       // bialy krol
                ListaPol.get(7).get(4).setIndexFigury(j);
                ListaPol.get(7).get(4).setFigura(j, false);
            }


        }

    }


    /**
     * Dodaje MouseListenery wszystkim figurom. 
     *
     */
    void setListenerForAll(){

        int i=0,j;

        for(i=0;i<32 ;i++)
            ListaFigur.get(i).getFigura().addMouseListener(this);
    }
}

