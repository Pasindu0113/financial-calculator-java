package sample;

public class mortgage {
    public static double term(double getassetpri, double getintrate, double getmonpay){
        double retterm = Math.log(12*getmonpay/(12*getmonpay-(getassetpri*getintrate/100)))/(12*(Math.log(1 + getintrate/12/100)));
        return retterm;
    }
    public static double assetprice(double getintrate,double getmonpay,double getterm){
        double retassetpri = (getmonpay/(getintrate/100/12))*(1-(1/Math.pow((1+(getintrate/100/12)),getterm*12)));
        return retassetpri;
    }
    public static double monthlypayment(double getintrate,double getterm,double getassetpri){
        double retmonpay = (getassetpri*getintrate/100)/(12*(1-(1/Math.pow((1+(getintrate/100/12)),getterm*12))));
        return retmonpay;
    }

}
