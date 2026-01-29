public class Punkt {
    String beschreibung;
    double x;
    double y;

    public Punkt(String bNeu, double xNeu, double yNeu){
        this.beschreibung = bNeu;
        this.x = xNeu;
        this.y = yNeu;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setX(double nX) {
        this.x = nX;
    }

    public void setY(double nY) {
        this.y = nY;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int gibNaechstgelegenerPunkt(Punkt[] punkt){
        int save = 0;
        double dis = (this.x-punkt[0].getX())*(this.x-punkt[0].getX())+(this.y-punkt[0].getY())*(this.y-punkt[0].getY());
        for (int i = 1; i < punkt.length; i++) {
            if (dis > (this.x-punkt[i].getX())*(this.x-punkt[i].getX())+(this.y-punkt[i].getY())*(this.y-punkt[i].getY())){
                save = i;
                dis = (this.x-punkt[i].getX())*(this.x-punkt[i].getX())+(this.y-punkt[i].getY())*(this.y-punkt[i].getY());
            }
        }
        return save;
    }




}
