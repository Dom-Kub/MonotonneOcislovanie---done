/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monotonneocislovanie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dominik - PC
 */
public class MonotonneOcislovanie {

    private int vrcholy; //pocet vrcholov

    private double[][] hrany;   //matica vzdialenosti
    private ArrayList<Integer> zoznam;

    public MonotonneOcislovanie()  {


        try (Scanner citac = new Scanner(new File("graf.txt"))) {
            vrcholy = citac.nextInt();
            citac.close();
        }
        catch (FileNotFoundException fne){
            System.out.println("Nastala chyba: "+fne);

        }

        // this.vrchol = new Vrchol[pocetVrcholov];
        this.hrany = new double[vrcholy][vrcholy];
        this.zoznam=new ArrayList<>();
    }

    public void nacitajSubor() {

        try (Scanner citac = new Scanner(new File("graf.txt"))) {
            citac.nextLine();
            citac.nextLine();

            do{

                int pozx = citac.nextInt() - 1;
                int pozy = citac.nextInt() - 1;
                //ulozi jednotlive ceny hran na poziciu x,y 
                this.hrany[pozx][pozy] = Double.POSITIVE_INFINITY;

            }while (citac.hasNext());

        }
        catch (IOException ioe){
            System.out.println("Nastala chyba : "+ioe);

        }

    }

    public void Algoritmus() {
        int i = 0;
        boolean ukoncenie = false;
        int pomocna = 0;
        int vrcholy = this.vrcholy - 1;
        boolean koniec = false;


        do{


            do{


                if (this.hrany[i][vrcholy] == Double.POSITIVE_INFINITY) {
                    System.out.println("Nastala chyba");

                }else
                    {
                    pomocna++;
                    if (pomocna != this.vrcholy - 1) {
                        System.out.println("Nastala chyba ");

                    }
                    else{
                        System.out.println(i + " - " + (vrcholy + 1) + ", pocitadlo " + pomocna);
                        koniec = true;
                    }

                }


                if (i == this.vrcholy - 1 ) {
                    if(koniec == false){
                    vrcholy--;
                    pomocna = 0;
                    i = 0;}
                    else {
                        System.out.println("Nastala chyba");
                    }
                }
                else {
                    System.out.println("Nastala chyba");
                }


                i++;

            } while (!koniec);

            this.zoznam.add(vrcholy + 1);
            for (int j = 0; j < this.hrany.length; j++) {
                System.out.println(vrcholy + " pocetV");
                this.hrany[vrcholy][j] = 0;


            }
            if (vrcholy == -1) {
                ukoncenie = true;

            } else {

                vrcholy--;

            }

            if (this.zoznam.size() != this.vrcholy) {
                ukoncenie = false;
            }else {
                ukoncenie = true;
            }

        } while (!ukoncenie);
    }

    
    
    public void vypis(){

        for (int i = 0; i < this.zoznam.size(); i++) {
            System.out.println(this.zoznam.get(i)+" ");
        }
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        MonotonneOcislovanie o = new MonotonneOcislovanie();
        o.nacitajSubor();
        o.Algoritmus();
        o.vypis();
    }
}
