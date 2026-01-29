import java.util.Random;

public class KMeans {
    private int k;
    private final Random random = new Random();
    int anzahlPunkte;
    Punkt[] zentren;
    Punkt[] daten;
    int[] cluster;

    public KMeans(int kNeu){
        this.k = kNeu;
        this.zentren = new Punkt[k];
    }

    public boolean aktualisiereClusterzuordnung(){
        boolean aenderung = true;
        for(int i = 0; i<daten.length;i++){
            if(this.cluster[i]!=this.daten[i].gibNaechstgelegenerPunkt(this.zentren)){
                this.cluster[i]=this.daten[i].gibNaechstgelegenerPunkt(this.zentren);
                aenderung = false;
            }
        }
        return aenderung;
    }

    public void positioniereZentrenNeu(){
        for(int i = 1; i<this.zentren.length; i++){
            int zahl = 0;
            double summeX = 0;
            double summeY = 0;
            for(int j = 1; i< anzahlPunkte; j++){
                if(this.cluster[j] == i){
                    zahl++;
                    summeX = summeX + this.daten[j].getX();
                    summeY = summeY + this.daten[j].getY();
                }
            }
            if(zahl>0){
                this.zentren[i].setX(summeX/zahl);
                this.zentren[i].setY(summeY/zahl);
            }
        }
    }

    public void kmeansAusfuehren(){
        generiereZufallszentren();
        boolean weiter = true;
        while(weiter == true){
            weiter = this.aktualisiereClusterzuordnung();
            if(weiter == true){
                this.positioniereZentrenNeu();
            }
        }
    }

    public Punkt[] gibDaten(){
        return daten;
    }

    public Punkt[] gibZentren(){
        return zentren;
    }

    public int[] gibCluster(){
        return cluster;
    }

    public int gibK(){
        return k;
    }

    public int gibAnzahl(){
        return anzahlPunkte;
    }

    public void generiereZufallszentren(){
        for(int i = 0; i < k; i++){
            Punkt z = daten[random.nextInt(anzahlPunkte)];
            zentren[i] = new Punkt("Zentrum "+(i+1),z.getX(), z.getY());
        }
    }

    public void gibAlleClusterAus(){
        for(int i = 0; i < k; i++){
            Punkt z = zentren[i];
            System.out.println("Cluster " + (i+1) + " mit Zentrum (" + z.getX() + "/" + z.getY() + "):");
            for(int j = 0; j < anzahlPunkte; j++){
                Punkt d = daten[j];
                if(cluster[j] == i+1)
                    System.out.print("(" + d.getX() + "/" + d.getY() + "); ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------");

    }
}
