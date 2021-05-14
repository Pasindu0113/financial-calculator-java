package sample;

public class comintsav {

    public static double initialvalue(double getintrate,double gettime, double getfutval ){
    double retinival = getfutval/(Math.pow(1 + (getintrate/12/100),12*gettime));
    return retinival;
}
    public static double interestrate(double getinidep,double gettime,double getfutval){
        double retintrate = 12*100*((Math.pow((getfutval/getinidep),1/(12*gettime)))-1);
        return retintrate;
    }
    public static double time(double getinidep,double getrate, double getfutval){
        double rettime = (Math.log(getfutval/getinidep))/(12*(Math.log(1+(getrate/12/100))));
        return rettime;
    }
    public static double futurevalue(double getinidep,double getrate, double gettime){
        double retfutval = getinidep*(Math.pow((1+(getrate/100/12)),12*gettime));
        return retfutval;
    }
}
