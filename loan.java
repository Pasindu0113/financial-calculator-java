package sample;

public class loan {
    public static double loanamount(double gettime,double getintrate, double getmonpay){
        double retloanamt = (getmonpay/(getintrate/100/12))*(1-(1/Math.pow((1+(getintrate/100/12)),gettime*12)));
        return retloanamt;
    }
    public static double time(double getloanamt,double getintrate, double getmonpay){
        double rettime = Math.log(12*getmonpay/(12*getmonpay-(getloanamt*getintrate/100)))/(12*(Math.log(1 + getintrate/12/100)));
        return rettime;

    }
    public static double monthlypayment(double getloanamt,double getintrate, double gettime){
        double retmonpay =  (getloanamt*getintrate/100)/(12*(1-(1/Math.pow((1+(getintrate/100/12)),gettime*12))));
        return retmonpay;
    }

}
