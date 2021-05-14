package sample;

public class comintsavwithcon {
    public static double futurevalue(double getintrate1,double gettime1,double getinidep1, double getmoncon1){
        double retfutval1 = (getinidep1*(Math.pow(1 + (getintrate1/12/100),12*gettime1)));
        double retfutval2 = ((getmoncon1*((Math.pow(1+(getintrate1/100/12),12*gettime1))-1)/(getintrate1/100/12)));
        return retfutval1 + retfutval2;
    }

    public static double monthlypayment(double getintrate1,double gettime1,double getinidep1,double getfutval1){

        double retmonpay = ((getfutval1-(getinidep1*(Math.pow(1 + (getintrate1/12/100),12*gettime1))))/(((Math.pow((1+(getintrate1/100/12)),12*gettime1)-1))/(getintrate1/100/12)));
        return retmonpay;
    }
    public static double time(double getintrate1,double getmoncon1,double getinidep1,double getfutval1){
        double rettime = (Math.log(((getfutval1*(getintrate1/100))+(getmoncon1*12))/((getinidep1*(getintrate1/100))+(getmoncon1*12))))/(12*(Math.log(1+(getintrate1/100/12))));
        return rettime;
    }
    public static double initialdeposit(double getintrate1,double gettime1,double getfutval1,double getmoncon1){
        double retinidep = (getfutval1 - (getmoncon1*((Math.pow(1+(getintrate1/100/12),12*gettime1))-1)/(getintrate1/100/12)))/((Math.pow(1 + (getintrate1/12/100),12*gettime1)));
        return retinidep;
    }

}
