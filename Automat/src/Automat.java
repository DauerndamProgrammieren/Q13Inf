public class Automat {
    private int aktuellerZustand = 0;
    private String toCheck;
    private char[] chCheck;


    public Automat(String input){
        this.toCheck = input;
        this.chCheck = this.toCheck.toCharArray();
        this.eingabePruefen();
    }

    private boolean eingabePruefen(){
        for (int i = 0; i < this.toCheck.length(); i++) {
            this.zeichenVerarbeiten(this.chCheck[i]);
        }
        return true;
    }

    private void zeichenVerarbeiten(char z){
        switch (this.aktuellerZustand){
            case 0:
                if (z=='a'){aktuellerZustand = 0;}
                if (z=='b'){aktuellerZustand = 1;}
                break;
            case 1:
                if (z=='a'){aktuellerZustand = 0;}
                if (z=='b'){aktuellerZustand = 2;}
                break;
            case 2:
                if (z=='a'){aktuellerZustand = 0;}
                if (z=='b'){aktuellerZustand = 2;}
                break;
        }
    }
}
