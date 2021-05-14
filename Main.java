package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class Main extends Application {

    public void start(Stage primaryStage) {
        home(primaryStage);
    }

    public static void home(Stage primaryStage){

        primaryStage.setTitle("JavaFX financial Calculator");
        Button btn = new Button("Continue with the Program");

        btn.setLayoutX(140); //setting the buttons on the first window with two buttons
        btn.setLayoutY(190);
        Button btn1 = new Button("Close");

        btn1.setLayoutX(360);
        btn1.setLayoutY(190);
        btn.setId("btnhome");
        btn1.setId("btnhome");

        GridPane gridPane1 = new GridPane();//the grid pane which will be holding the results of the user's input data
        gridPane1.setVgap(40);
        Label res1 = new Label("RESULTS");
        res1.setStyle("-fx-font-style: oblique;-fx-font-size: 30px");
        Text txt = new Text("");
        txt.setId("txt");
        Text txt1 = new Text("");
        txt1.setId("txt1");
        Text txt2 = new Text("");
        txt2.setId("txt2");
        Text txt3 = new Text("");
        txt3.setId("txt3");
        Text txt4 = new Text("");
        txt4.setId("txt4");

        gridPane1.add(res1,0,0);
        gridPane1.add(txt,0,1);
        gridPane1.add(txt1,0,2);
        gridPane1.add(txt2,0,3);
        gridPane1.add(txt3,0,4);
        gridPane1.add(txt4,0,5);

        gridPane1.setId("res");

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { //close window when the close button is clicked
                Stage stage = (Stage) btn1.getScene().getWindow();
                stage.close();

            }
        });
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { //close the first window and open the window with the financial calculator
                Stage stage = (Stage) btn.getScene().getWindow();
                stage.close();

                SplitPane splitPane = new SplitPane();
                TabPane tabPane = new TabPane();

                Tab tab5 = new Tab("History");
                tab5.setId("tab5");
                ListView<String> listView = new ListView<>();
                listView.setCellFactory(TextFieldListCell.forListView());

                tab5.setContent(listView);

                Tab tab1 = new Tab("Compound Interest savings(Without Contributions)");
                tab1.setId("tab1");

                VBox tab1_vBox = new VBox(20);
                tab1_vBox.getChildren().addAll(
                        new Label("Initial Deposit"),  //initializing the labels on the Compound Interest savings (Without Contributions) tab
                        new Label("Interest Rate(% value)"),
                        new Label("Time(In Years)"),
                        new Label("Future Value"));

                HBox hbox = new HBox(20);
                VBox vbox = new VBox(10);
                TextField inidep1 = new TextField(); //adding the necessary text fields to the tab
                TextField intrate1 = new TextField();
                TextField time1 = new TextField();
                TextField futval1= new TextField();
                Button Calculate1 = new Button("Calculate");
                Button History1 = new Button("Save to History");
                Calculate1.setStyle("-fx-text-fill: #0010ff;-fx-font-weight: bold");
                Button help1 = new Button("Help");

                vbox.getChildren().addAll(
                        inidep1,
                        intrate1,
                        time1,
                        futval1,
                        Calculate1,
                        History1,
                        help1
                );

                    Calculate1.setOnAction( event1 ->  { //initialising a button to the compound savings (without contributions) to calculate the necessary value
                        try {
                                if (inidep1.getText().isEmpty()) {//checking if the paticular textfield is empty
                                    double getintrate = Double.parseDouble(intrate1.getText());
                                    double gettime = Double.parseDouble(time1.getText());
                                    double getfutval = Double.parseDouble(futval1.getText());

                                    double output1 = comintsav.initialvalue(getintrate, gettime, getfutval); //calling the function to calculate the initial deposit
                                    DecimalFormat df = new DecimalFormat("#.##");
                                    inidep1.setText(df.format(output1));

                                    txt.setText("The Initial Deposit is Rs." + df.format(output1));
                                    txt1.setText("The Interest rate is " + getintrate + "%");
                                    txt2.setText("The Number of Years " + gettime);
                                    txt3.setText("The Future Value is Rs." + getfutval);

                                } else if (intrate1.getText().isEmpty()) { //checking if that specific text field is empty
                                    double getinidep = Double.parseDouble(inidep1.getText());
                                    double gettime = Double.parseDouble(time1.getText());
                                    double getfutval = Double.parseDouble(futval1.getText());

                                    double output2 = comintsav.interestrate(getinidep, gettime, getfutval); //calling the function to calculate the interest rate
                                    DecimalFormat df = new DecimalFormat("#.##");
                                    intrate1.setText(df.format(output2));

                                    txt.setText("The Initial Deposit is Rs." + getinidep);
                                    txt1.setText("The Interest rate is " + df.format(output2) + "%");
                                    txt2.setText("The Number of Years " + gettime);
                                    txt3.setText("The Future Value is Rs." + getfutval);

                                } else if (time1.getText().isEmpty()) {
                                    double getinidep = Double.parseDouble(inidep1.getText());
                                    double getrate = Double.parseDouble(intrate1.getText());
                                    double getfutval = Double.parseDouble(futval1.getText());

                                    double output3 = comintsav.time(getinidep, getrate, getfutval);
                                    DecimalFormat df = new DecimalFormat("#.##");
                                    time1.setText(df.format(output3));

                                    txt.setText("The Initial Deposit is Rs." + getinidep);
                                    txt1.setText("The Interest rate is " + getrate + "%");
                                    txt2.setText("The Number of Years. " + df.format(output3));
                                    txt3.setText("The Future Value is Rs." + getfutval);

                                } else if (futval1.getText().isEmpty()) {
                                    double getinidep = Double.parseDouble(inidep1.getText());
                                    double getrate = Double.parseDouble(intrate1.getText());
                                    double gettime = Double.parseDouble(time1.getText());

                                    double output4 = comintsav.futurevalue(getinidep, getrate, gettime); //calling the function to calculate the future value
                                    DecimalFormat df = new DecimalFormat("#.##");
                                    futval1.setText(df.format(output4));

                                    txt.setText("The Initial Deposit is Rs." + getinidep);
                                    txt1.setText("The Interest rate is " + getrate + "%");
                                    txt2.setText("The Number of Years " + gettime);
                                    txt3.setText("The Future Value is Rs." + df.format(output4));

                                }
                            } catch (NumberFormatException exception) { //if the user inputs a value other than a number the applicaion will show an alert with an error messsage on it
                                Stage al = new Stage();
                                al.setTitle("Caution!!!");
                                Pane pn = new Pane();

                                Label lb = new Label("Please Enter Integers!!");
                                lb.setStyle(" -fx-text-fill: #ff0000;-fx-font-weight: bolder ");
                                Label lb1 = new Label("Please keep only one text field empty");
                                lb1.setStyle(" -fx-text-fill: #ff0000;-fx-font-weight: bolder ");
                                lb.setLayoutX(20);
                                lb.setLayoutY(20);
                                lb1.setLayoutX(20);
                                lb1.setLayoutY(40);
                                pn.getChildren().addAll(lb,lb1);

                                Scene scene2 = new Scene(pn, 400, 100);
                                al.setScene(scene2);
                                al.show();

                            }
                        });
                        History1.setOnAction(new EventHandler<ActionEvent>() { //save the user's data as history
                            @Override
                            public void handle(ActionEvent event) {
                                String tf1 = txt.getText();
                                String tf2 = txt1.getText();
                                String tf3 = txt2.getText();
                                String tf4 = txt3.getText();
                                String Name = "Compound Interest savings(Without Contributions)";
                                String hisres1 = tf1+"";
                                String hisres2 = tf2+"";
                                String hisres3 = tf3+"";
                                String hisres4 = tf4+"";

                                listView.getItems().addAll(Name,hisres1,hisres2,hisres3,hisres4,"\n");
                                listView.scrollTo(listView.getItems().size() - 1);
                            }
                        });

                            help1.setOnAction(new EventHandler<ActionEvent>() { //the help window will pop up when clicked
                    @Override                                                   //with all the required instructions on how to use the application
                    public void handle(ActionEvent event) {
                        Label help = new Label("1) Please Enter the Required data");
                        help.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");
                        Label help1 = new Label("2) Keep the field that you want the answer for as empty");
                        help1.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");
                        Label help2 = new Label("4) Press calculate to get the answer you want ");
                        help2.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");
                        Label help3 = new Label("3) Press the "+"C "+"button on the number pad to clear the text fields");
                        help3.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");

                        help.setLayoutX(10);
                        help.setLayoutY(20);
                        help1.setLayoutX(10);
                        help1.setLayoutY(50);
                        help3.setLayoutX(10);
                        help3.setLayoutY(80);
                        help2.setLayoutX(10);
                        help2.setLayoutY(110);

                        AnchorPane anchorPane1 = new AnchorPane();
                        anchorPane1.setStyle("-fx-background-color: beige");
                        anchorPane1.getChildren().addAll(help,help1,help3,help2);


                        Scene scene1 = new Scene(anchorPane1,650,500);
                        Stage helpwin = new Stage();
                        helpwin.setScene(scene1);
                        helpwin.setTitle("HELP");

                        helpwin.show();
                    }
                });
                hbox.getChildren().addAll(tab1_vBox, vbox);

                tab1.setContent(tab1_vBox);
                tab1.setContent(hbox);

                Tab tab2 = new Tab("Compound Interest savings (With Contributions)");
                tab2.setId("tab2");

                VBox tab2_vBox = new VBox(20);
                tab2_vBox.getChildren().addAll(
                        new Label("Initial Deposit"),
                        new Label("Interest Rate(% value)"),
                        new Label("Time(In Years)"),
                        new Label("Monthly Contribution"),
                        new Label("Future Value"));

                HBox hbox1 = new HBox(20);
                VBox vbox1 = new VBox(10);
                TextField inidep2 = new TextField();
                TextField intrate2 = new TextField();
                TextField time2 = new TextField();
                TextField moncon = new TextField();
                TextField futval2= new TextField();

                Button Calculate2 = new Button("Calculate");
                Button History2 = new Button("Save to History");
                Calculate2.setStyle("-fx-text-fill: #0010ff;-fx-font-weight: bold");
                Button help2 = new Button("Help");

                vbox1.getChildren().addAll(
                        inidep2,
                        intrate2,
                        time2,
                        moncon,
                        futval2,
                        Calculate2,
                        History2,
                        help2
                );
                Calculate2.setOnAction(event12 -> {
                    try {
                        if (futval2.getText().isEmpty()) {
                            double getintrate1 = Double.parseDouble(intrate2.getText());
                            double gettime1 = Double.parseDouble(time2.getText());
                            double getinidep1 = Double.parseDouble(inidep2.getText());
                            double getmoncon1 = Double.parseDouble((moncon.getText()));

                            double output = comintsavwithcon.futurevalue(getintrate1, gettime1, getinidep1, getmoncon1);
                            DecimalFormat df1 = new DecimalFormat("#.##");
                            futval2.setText(df1.format(output));

                            txt.setText("The Initial Deposit is Rs." + getinidep1);
                            txt1.setText("The Interest rate is " + getintrate1 + "%");
                            txt2.setText("The Number of Years " + gettime1);
                            txt3.setText("The Monthly Contribution : Rs." + getmoncon1);
                            txt4.setText("The Future Value is Rs." + df1.format(output));

                        } else if (moncon.getText().isEmpty()) {
                            double getintrate1 = Double.parseDouble(intrate2.getText());
                            double gettime1 = Double.parseDouble(time2.getText());
                            double getinidep1 = Double.parseDouble(inidep2.getText());
                            double getfutval1 = Double.parseDouble((futval2.getText()));

                            double output = comintsavwithcon.monthlypayment(getintrate1, gettime1, getinidep1, getfutval1);
                            DecimalFormat df1 = new DecimalFormat("#.##");
                            moncon.setText((df1.format(output)));

                            txt.setText("The Initial Deposit is Rs." + getinidep1);
                            txt1.setText("The Interest rate is " + getintrate1 + "%");
                            txt2.setText("The Number of Years " + gettime1);
                            txt3.setText("The Monthly Contribution : Rs." + df1.format(output));
                            txt4.setText("The Future Value is Rs." + getfutval1);

                        } else if (time2.getText().isEmpty()) {
                            double getintrate1 = Double.parseDouble(intrate2.getText());
                            double getinidep1 = Double.parseDouble(inidep2.getText());
                            double getfutval1 = Double.parseDouble((futval2.getText()));
                            double getmoncon1 = Double.parseDouble((moncon.getText()));

                            double output = comintsavwithcon.time(getintrate1, getmoncon1, getinidep1, getfutval1);
                            DecimalFormat df1 = new DecimalFormat("#.##");
                            time2.setText((df1.format(output)));

                            txt.setText("The Initial Deposit is Rs." + getinidep1);
                            txt1.setText("The Interest rate is " + getintrate1 + "%");
                            txt2.setText("The Number of Years " + df1.format(output));
                            txt3.setText("The Monthly Contribution : Rs." + getmoncon1);
                            txt4.setText("The Future Value is Rs." + getfutval1);

                        } else if (inidep2.getText().isEmpty()) {
                            double getintrate1 = Double.parseDouble(intrate2.getText());
                            double gettime1 = Double.parseDouble(time2.getText());
                            double getfutval1 = Double.parseDouble((futval2.getText()));
                            double getmoncon1 = Double.parseDouble((moncon.getText()));

                            double output = comintsavwithcon.initialdeposit(getintrate1, gettime1, getfutval1, getmoncon1);
                            DecimalFormat df1 = new DecimalFormat("#.##");
                            inidep2.setText((df1.format(output)));

                            txt.setText("The Initial Deposit is Rs." + df1.format(output));
                            txt1.setText("The Interest rate is " + getintrate1 +"%");
                            txt2.setText("The Number of Years " + gettime1);
                            txt3.setText("The Monthly Contribution : Rs." + getmoncon1);
                            txt4.setText("The Future Value is Rs." + getfutval1);

                        }
                    }catch (NumberFormatException exception){
                        Stage al = new Stage();
                        al.setTitle("Caution!!!");
                        Pane pn = new Pane();

                        Label lb = new Label("Please Enter Integers!!");
                        lb.setStyle(" -fx-text-fill: #ff0000;-fx-font-weight: bolder ");
                        Label lb1 = new Label("Please keep only one text field empty");
                        lb1.setStyle(" -fx-text-fill: #ff0000;-fx-font-weight: bolder ");
                        lb.setLayoutX(20);
                        lb.setLayoutY(20);
                        lb1.setLayoutX(20);
                        lb1.setLayoutY(40);
                        pn.getChildren().addAll(lb,lb1);

                        Scene scene2 = new Scene(pn, 400, 100);
                        al.setScene(scene2);
                        al.show();

                    }

                });
                History2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String tf1 = txt.getText();
                        String tf2 = txt1.getText();
                        String tf3 = txt2.getText();
                        String tf4 = txt3.getText();
                        String Name = "Compound Interest savings(With Contributions)";
                        String hisres1 = tf1+"";
                        String hisres2 = tf2+"";
                        String hisres3 = tf3+"";
                        String hisres4 = tf4+"";

                        listView.getItems().addAll(Name,hisres1,hisres2,hisres3,hisres4,"\n");
                        listView.scrollTo(listView.getItems().size() - 1);
                    }
                });
                help2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Label help = new Label("1) Please Enter the Required data");
                        help.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");
                        Label help1 = new Label("2) Keep the field that you want the answer for as empty");
                        help1.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");
                        Label help2 = new Label("4) Press calculate to get the answer you want ");
                        help2.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");
                        Label help3 = new Label("3) Press the "+"C "+"button on the number pad to clear the text fields");
                        help3.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");

                        help.setLayoutX(10);
                        help.setLayoutY(20);
                        help1.setLayoutX(10);
                        help1.setLayoutY(50);
                        help3.setLayoutX(10);
                        help3.setLayoutY(80);
                        help2.setLayoutX(10);
                        help2.setLayoutY(110);

                        AnchorPane anchorPane2 = new AnchorPane();
                        anchorPane2.setStyle("-fx-background-color: antiquewhite");
                        anchorPane2.getChildren().addAll(help,help2,help1,help3);

                        Scene scene1 = new Scene(anchorPane2,650,500);
                        Stage helpwin1 = new Stage();
                        helpwin1.setScene(scene1);
                        helpwin1.setTitle("HELP");

                        helpwin1.show();
                    }
                });
                hbox1.getChildren().addAll(tab2_vBox, vbox1);

                tab2.setContent(tab2_vBox);
                tab2.setContent(hbox1);
                Tab tab3 = new Tab("Loans" );
                tab3.setId("tab3");

                VBox tab3_vBox = new VBox(20);
                tab3_vBox.getChildren().addAll(
                        new Label("Loan Amount"),
                        new Label("Interest Rate(% value)"),
                        new Label("Time(In Years)"),
                        new Label("Monthly Payment"),
                        new Label("No. of Payments"));

                HBox hbox2 = new HBox(20);
                VBox vbox2 = new VBox(10);
                TextField loanamt = new TextField();
                TextField intrate3 = new TextField();
                TextField time3 = new TextField();
                TextField monpay = new TextField();
                TextField noofpay = new TextField();
                Button Calculate3 = new Button("Calculate");
                Button History3 = new Button("Save to History");
                Calculate3.setStyle("-fx-text-fill: #0010ff;-fx-font-weight: bold");
                Button help3 = new Button("Help");

                vbox2.getChildren().addAll(
                        loanamt,
                        intrate3,
                        time3,
                        monpay,
                        noofpay,
                        Calculate3,
                        History3,
                        help3
                );
                Calculate3.setOnAction(event13 -> {
                    try {
                        if (loanamt.getText().isEmpty()) {
                            double gettime = Double.parseDouble(time3.getText());
                            double getintrate = Double.parseDouble(intrate3.getText());
                            double getmonpay = Double.parseDouble(monpay.getText());

                            double output = loan.loanamount(gettime, getintrate, getmonpay);
                            DecimalFormat df1 = new DecimalFormat("#.##");
                            loanamt.setText(df1.format(output));
                            noofpay.setText(df1.format(gettime * 12));

                            txt.setText("The Loan Amount is Rs." + df1.format(output));
                            txt1.setText("The Interest rate is " + getintrate + "%");
                            txt2.setText("The Number of Years " + gettime);
                            txt3.setText("The Monthly Payment is Rs." + getmonpay);
                            txt4.setText("The Number of Payments : " + (gettime * 12));

                        } else if (time3.getText().isEmpty()) {
                            double getloanamt = Double.parseDouble(loanamt.getText());
                            double getintrate = Double.parseDouble(intrate3.getText());
                            double getmonpay = Double.parseDouble(monpay.getText());

                            double output = loan.time(getloanamt, getintrate, getmonpay);
                            DecimalFormat df1 = new DecimalFormat("#.##");
                            time3.setText(df1.format(output));

                            noofpay.setText(df1.format(output * 12));
                            txt.setText("The Loan Amount is Rs." + getloanamt);
                            txt1.setText("The Interest rate is " + getintrate + "%");
                            txt2.setText("The Number of Years " + df1.format(output));
                            txt3.setText("The Monthly Payment Rs." + getmonpay);
                            txt4.setText("The Number of Payments : " + (output * 12));

                        } else if (monpay.getText().isEmpty()) {
                            double getloanamt = Double.parseDouble(loanamt.getText());
                            double getintrate = Double.parseDouble(intrate3.getText());
                            double gettime = Double.parseDouble(time3.getText());

                            double output = loan.monthlypayment(getloanamt, getintrate, gettime);
                            DecimalFormat df1 = new DecimalFormat("#.##");
                            monpay.setText(df1.format(output));

                            noofpay.setText(df1.format(gettime * 12));

                            txt.setText("The Loan Amount is Rs." + getloanamt);
                            txt1.setText("The Interest rate is " + getintrate + "%");
                            txt2.setText("The Number of Years " + gettime);
                            txt3.setText("The Monthly Payment is Rs." + df1.format(output));
                            txt4.setText("The Number of Payments : " + (gettime * 12));
                        }else if(noofpay.getText().isEmpty()){ //if the user sets only the number of payments field empty an error message should be displayed
                            Stage al = new Stage();
                            al.setTitle("Warning!!");
                            Pane pn = new Pane();

                            Label lb1 = new Label("Please dont keep only the Number of payments field empty");
                            lb1.setStyle(" -fx-text-fill: #ff0000;-fx-font-weight: bolder ");
                            lb1.setLayoutX(20);
                            lb1.setLayoutY(40);
                            pn.getChildren().add(lb1);

                            Scene scene2 = new Scene(pn, 550, 100);
                            al.setScene(scene2);
                            al.show();

                        }
                    }catch(NumberFormatException exception){
                        Stage al = new Stage();
                        al.setTitle("Caution!!!");
                        Pane pn = new Pane();

                        Label lb = new Label("Please Enter Integers!!");
                        lb.setStyle(" -fx-text-fill: #ff0000;-fx-font-weight: bolder ");
                        Label lb1 = new Label("Please keep only one text field empty");
                        lb1.setStyle(" -fx-text-fill: #ff0000;-fx-font-weight: bolder ");
                        lb.setLayoutX(20);
                        lb.setLayoutY(20);
                        lb1.setLayoutX(20);
                        lb1.setLayoutY(40);
                        pn.getChildren().addAll(lb,lb1);

                        Scene scene2 = new Scene(pn, 400, 100);
                        al.setScene(scene2);
                        al.show();
                    }

                });
                History3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String tf1 = txt.getText();
                        String tf2 = txt1.getText();
                        String tf3 = txt2.getText();
                        String tf4 = txt3.getText();
                        String tf5 = txt4.getText();
                        String Name = "Loan";
                        String hisres1 = tf1+"";
                        String hisres2 = tf2+"";
                        String hisres3 = tf3+"";
                        String hisres4 = tf4+"";
                        String hisres5 = tf5+"";

                        listView.getItems().addAll(Name,hisres1,hisres2,hisres3,hisres4,hisres5,"\n");
                        listView.scrollTo(listView.getItems().size() - 1);
                    }
                });

                help3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Label help = new Label("1) Please Enter the Required data");
                        help.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");
                        Label help1 = new Label("2) Keep the field that you want the answer for as empty");
                        help1.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");
                        Label help2 = new Label("4) Press calculate to get the answer you want ");
                        help2.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");
                        Label help4 = new Label("3) No of payments will be calculated for you please don't try to insert a value");
                        help4.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");
                        Label help3 = new Label("3) Press the "+"C "+"button on the number pad to clear the text fields");
                        help3.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");

                        help.setLayoutX(10);
                        help.setLayoutY(20);
                        help1.setLayoutX(10);
                        help1.setLayoutY(50);
                        help3.setLayoutX(10);
                        help3.setLayoutY(80);
                        help2.setLayoutX(10);
                        help2.setLayoutY(110);
                        help4.setLayoutX(10);
                        help4.setLayoutY(140);

                        AnchorPane anchorPane3 = new AnchorPane();
                        anchorPane3.setStyle("-fx-background-color: bisque");
                        anchorPane3.getChildren().addAll(help,help2,help1,help3,help4);

                        Scene scene1 = new Scene(anchorPane3,800,500);
                        Stage helpwin2 = new Stage();
                        helpwin2.setScene(scene1);
                        helpwin2.setTitle("HELP");

                        helpwin2.show();
                    }
                });
                hbox2.getChildren().addAll(tab3_vBox, vbox2);

                tab3.setContent(tab3_vBox);
                tab3.setContent(hbox2);
                Tab tab4 = new Tab("Mortgage" );
                tab4.setId("tab4");

                VBox tab4_vBox = new VBox(20);
                tab4_vBox.getChildren().addAll(
                        new Label("Asset Price"),
                        new Label("Loan Term (In Years)"),
                        new Label("Interest Rate(% value)"),
                        new Label("Monthly Payment")

                );

                HBox hbox3 = new HBox(20);
                VBox vbox3 = new VBox(10);
                TextField assetprice = new TextField();
                TextField loanterm = new TextField();
                TextField intrate4 = new TextField();
                TextField monpay2 = new TextField();
                Button Calculate4 = new Button("Calculate");
                Button History4 = new Button("Save to History");
                Calculate4.setStyle("-fx-text-fill: #0010ff;-fx-font-weight: bold");
                Button help4 = new Button("Help");

                vbox3.getChildren().addAll(
                        assetprice,
                        loanterm,
                        intrate4,
                        monpay2,
                        Calculate4,
                        History4,
                        help4

                );

                Calculate4.setOnAction(event14 -> {
                    try {
                        if (loanterm.getText().isEmpty()) {
                            double getassetpri = Double.parseDouble(assetprice.getText());
                            double getintrate = Double.parseDouble(intrate4.getText());
                            double getmonpay = Double.parseDouble(monpay2.getText());

                            double output = mortgage.term(getassetpri, getintrate, getmonpay);
                            DecimalFormat df1 = new DecimalFormat("#.##");
                            loanterm.setText(df1.format(output));

                            txt.setText("The Asset Price is Rs." + getassetpri);
                            txt1.setText("The Interest rate is " + getintrate +"%");
                            txt2.setText("The Loan Term is " + df1.format(output) + " Years");
                            txt3.setText("The Monthly Payment is Rs." + getmonpay);


                        } else if (assetprice.getText().isEmpty()) {
                            double getintrate = Double.parseDouble(intrate4.getText());
                            double getmonpay = Double.parseDouble(monpay2.getText());
                            double getterm = Double.parseDouble(loanterm.getText());

                            double output = mortgage.assetprice(getintrate, getmonpay, getterm);
                            DecimalFormat df1 = new DecimalFormat("#.##");
                            assetprice.setText(df1.format(output));

                            txt.setText("The Asset Price is Rs." + df1.format(output));
                            txt1.setText("The Interest rate is " + getintrate +"%");
                            txt2.setText("The Loan Term is " + getterm + "years");
                            txt3.setText("The Monthly Payment is Rs." + getmonpay);

                        } else if (monpay2.getText().isEmpty()) {
                            double getintrate = Double.parseDouble(intrate4.getText());
                            double getterm = Double.parseDouble(loanterm.getText());
                            double getassetpri = Double.parseDouble(assetprice.getText());

                            double output = mortgage.monthlypayment(getintrate, getterm, getassetpri);
                            DecimalFormat df1 = new DecimalFormat("#.##");
                            monpay2.setText(df1.format(output));

                            txt.setText("The Asset Price is Rs." + getassetpri);
                            txt1.setText("The Interest rate is " + getintrate +"%");
                            txt2.setText("The Loan Term is " + getterm + " years");
                            txt3.setText("The Monthly Payment is Rs." + df1.format(output));

                        }
                    }catch (NumberFormatException exception){
                        Stage al = new Stage();
                        al.setTitle("Caution!!!");
                        Pane pn = new Pane();

                        Label lb = new Label("Please Enter Integers!!");
                        lb.setStyle(" -fx-text-fill: #ff0000;-fx-font-weight: bolder ");
                        Label lb1 = new Label("Please keep only one text field empty");
                        lb1.setStyle(" -fx-text-fill: #ff0000;-fx-font-weight: bolder ");
                        lb.setLayoutX(20);
                        lb.setLayoutY(20);
                        lb1.setLayoutX(20);
                        lb1.setLayoutY(40);
                        pn.getChildren().addAll(lb,lb1);


                        Scene scene2 = new Scene(pn, 400, 100);
                        al.setScene(scene2);
                        al.show();
                    }

                });
                History4.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String tf1 = txt.getText();
                        String tf2 = txt1.getText();
                        String tf3 = txt2.getText();
                        String tf4 = txt3.getText();
                        String Name = "Mortgage";
                        String hisres1 = tf1+"";
                        String hisres2 = tf2+"";
                        String hisres3 = tf3+"";
                        String hisres4 = tf4+"";

                        listView.getItems().addAll(Name,hisres1,hisres2,hisres3,hisres4,"\n");
                        listView.scrollTo(listView.getItems().size() - 1);
                    }
                });
                help4.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Label help = new Label("1) Please Enter the Required data");
                        help.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");
                        Label help1 = new Label("2) Keep the field that you want the answer for as empty");
                        help1.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");
                        Label help2 = new Label("4) Press calculate to get the answer you want ");
                        help2.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");
                        Label help3 = new Label("3) Press the "+"C "+"button on the number pad to clear the text fields");
                        help3.setStyle("-fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight: bold;");

                        help.setLayoutX(10);
                        help.setLayoutY(20);
                        help1.setLayoutX(10);
                        help1.setLayoutY(50);
                        help3.setLayoutX(10);
                        help3.setLayoutY(80);
                        help2.setLayoutX(10);
                        help2.setLayoutY(110);


                        AnchorPane anchorPane4 = new AnchorPane();
                        anchorPane4.setStyle("-fx-background-color: burlywood");
                        anchorPane4.getChildren().addAll(help,help2,help1,help3);

                        Scene scene1 = new Scene(anchorPane4,650,500);
                        Stage helpwin3 = new Stage();
                        helpwin3.setScene(scene1);
                        helpwin3.setTitle("HELP");

                        helpwin3.show();
                    }
                });
                hbox3.getChildren().addAll(tab4_vBox, vbox3);

                tab4.setContent(tab4_vBox);
                tab4.setContent(hbox3);

                tabPane.getTabs().add(tab1);
                tabPane.getTabs().add(tab2);
                tabPane.getTabs().add(tab3);
                tabPane.getTabs().add(tab4);
                tabPane.getTabs().add(tab5);


                VBox leftControl = new VBox();
                leftControl.getChildren().add(tabPane);
                leftControl.setId("savings1");

                VBox rightControl = new VBox();



                splitPane.getItems().addAll(gridPane1,rightControl);

                SplitPane splitPane1 = new SplitPane();
                splitPane1.setOrientation(Orientation.VERTICAL);
                splitPane1.getItems().addAll(leftControl,splitPane);

                Button button1 = new Button("7"); //setting up the buttons for the number pad
                button1.setFocusTraversable(false);
                button1.setStyle("-fx-font-size: 40px;-fx-font-weight: bold ");
                button1.setMinSize(165, 105);
                Button button2 = new Button("8");
                button2.setFocusTraversable(false);
                button2.setStyle("-fx-font-size: 40px;-fx-font-weight: bold ");
                button2.setMinSize(165, 105);
                Button button3 = new Button("9");
                button3.setFocusTraversable(false);
                button3.setStyle("-fx-font-size: 40px;-fx-font-weight: bold ");
                button3.setMinSize(165, 105);
                Button button4 = new Button("4");
                button4.setFocusTraversable(false);
                button4.setStyle("-fx-font-size: 40px;-fx-font-weight: bold ");
                button4.setMinSize(165, 105);
                Button button5 = new Button("5");
                button5.setFocusTraversable(false);
                button5.setStyle("-fx-font-size: 40px;-fx-font-weight: bold ");
                button5.setMinSize(165, 105);
                Button button6 = new Button("6");
                button6.setFocusTraversable(false);
                button6.setStyle("-fx-font-size: 40px;-fx-font-weight: bold ");
                button6.setMinSize(165, 105);
                Button button7 = new Button("1");
                button7.setFocusTraversable(false);
                button7.setStyle("-fx-font-size: 40px;-fx-font-weight: bold ");
                button7.setMinSize(165, 105);
                Button button8 = new Button("2");
                button8.setFocusTraversable(false);
                button8.setStyle("-fx-font-size: 40px;-fx-font-weight: bold ");
                button8.setMinSize(165, 105);
                Button button9 = new Button("3");
                button9.setFocusTraversable(false);
                button9.setStyle("-fx-font-size: 40px;-fx-font-weight: bold ");
                button9.setMinSize(165, 105);
                Button button10 = new Button(".");
                button10.setFocusTraversable(false);
                button10.setStyle("-fx-font-size: 40px;-fx-font-weight: bold ");
                button10.setMinSize(165, 105);
                Button button11 = new Button("0");
                button11.setFocusTraversable(false);
                button11.setStyle("-fx-font-size: 40px;-fx-font-weight: bold ");
                button11.setMinSize(165, 105);
                Button button12 = new Button("C");
                button12.setStyle("-fx-font-size: 40px;-fx-font-weight: bold;-fx-text-fill: #008609 ");
                button12.setMinSize(165, 105);

                button1.setOnAction(new EventHandler<ActionEvent>() { //initializing the number pad
                    @Override                                         //the numbers should only be set when the text field is focused
                    public void handle(ActionEvent event) {
                        String extractfrombutton = "7";
                        if (inidep1.isFocused()) {
                            inidep1.setText(inidep1.getText()+ extractfrombutton);
                        }
                        else if (intrate1.isFocused()) {
                            intrate1.setText(intrate1.getText() + extractfrombutton);
                        }
                        else if (time1.isFocused()) {
                            time1.setText(time1.getText() + extractfrombutton);
                        }
                        else if (futval1.isFocused()) {
                            futval1.setText(futval1.getText() + extractfrombutton);
                        }
                        else if (inidep2.isFocused()) {
                            inidep2.setText(inidep2.getText() + extractfrombutton);
                        }
                        else if (intrate2.isFocused()) {
                            intrate2.setText(intrate2.getText() + extractfrombutton);
                        }
                        else if (time2.isFocused()) {
                            time2.setText(time2.getText() + extractfrombutton);
                        }
                        else if (moncon.isFocused()) {
                            moncon.setText(moncon.getText() + extractfrombutton);
                        }
                        else if (futval2.isFocused()) {
                            futval2.setText(futval2.getText() + extractfrombutton);
                        }
                        else if (loanamt.isFocused()) {
                            loanamt.setText(loanamt.getText() + extractfrombutton);
                        }
                        else if (intrate3.isFocused()) {
                            intrate3.setText(intrate3.getText() + extractfrombutton);
                        }
                        else if (time3.isFocused()) {
                            time3.setText(time3.getText() + extractfrombutton);
                        }
                        else if (monpay.isFocused()) {
                            monpay.setText(monpay.getText() + extractfrombutton);
                        }
                        else if (noofpay.isFocused()) {
                            noofpay.setText(noofpay.getText() + extractfrombutton);
                        }
                        else if (assetprice.isFocused()) {
                            assetprice.setText(assetprice.getText() + extractfrombutton);
                        }
                        else if (loanterm.isFocused()) {
                            loanterm.setText(loanterm.getText() + extractfrombutton);
                        }
                        else if (intrate4.isFocused()) {
                            intrate4.setText(intrate4.getText() + extractfrombutton);
                        }
                        else if (monpay2.isFocused()) {
                            monpay2.setText(monpay2.getText() + extractfrombutton);
                        }
                    }
                });

                button2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String extractfrombutton = "8";
                        if (inidep1.isFocused()) {
                            inidep1.setText(inidep1.getText()+ extractfrombutton);
                        }
                        else if (intrate1.isFocused()) {
                            intrate1.setText(intrate1.getText() + extractfrombutton);
                        }
                        else if (time1.isFocused()) {
                            time1.setText(time1.getText() + extractfrombutton);
                        }
                        else if (futval1.isFocused()) {
                            futval1.setText(futval1.getText() + extractfrombutton);
                        }
                        else if (inidep2.isFocused()) {
                            inidep2.setText(inidep2.getText() + extractfrombutton);
                        }
                        else if (intrate2.isFocused()) {
                            intrate2.setText(intrate2.getText() + extractfrombutton);
                        }
                        else if (time2.isFocused()) {
                            time2.setText(time2.getText() + extractfrombutton);
                        }
                        else if (moncon.isFocused()) {
                            moncon.setText(moncon.getText() + extractfrombutton);
                        }
                        else if (futval2.isFocused()) {
                            futval2.setText(futval2.getText() + extractfrombutton);
                        }
                        else if (loanamt.isFocused()) {
                            loanamt.setText(loanamt.getText() + extractfrombutton);
                        }
                        else if (intrate3.isFocused()) {
                            intrate3.setText(intrate3.getText() + extractfrombutton);
                        }
                        else if (time3.isFocused()) {
                            time3.setText(time3.getText() + extractfrombutton);
                        }
                        else if (monpay.isFocused()) {
                            monpay.setText(monpay.getText() + extractfrombutton);
                        }
                        else if (noofpay.isFocused()) {
                            noofpay.setText(noofpay.getText() + extractfrombutton);
                        }
                        else if (assetprice.isFocused()) {
                            assetprice.setText(assetprice.getText() + extractfrombutton);
                        }
                        else if (loanterm.isFocused()) {
                            loanterm.setText(loanterm.getText() + extractfrombutton);
                        }
                        else if (intrate4.isFocused()) {
                            intrate4.setText(intrate4.getText() + extractfrombutton);
                        }
                        else if (monpay2.isFocused()) {
                            monpay2.setText(monpay2.getText() + extractfrombutton);
                        }
                    }
                });
                button3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String extractfrombutton = "9";
                        if (inidep1.isFocused()) {
                            inidep1.setText(inidep1.getText()+ extractfrombutton);
                        }
                        else if (intrate1.isFocused()) {
                            intrate1.setText(intrate1.getText() + extractfrombutton);
                        }
                        else if (time1.isFocused()) {
                            time1.setText(time1.getText() + extractfrombutton);
                        }
                        else if (futval1.isFocused()) {
                            futval1.setText(futval1.getText() + extractfrombutton);
                        }
                        else if (inidep2.isFocused()) {
                            inidep2.setText(inidep2.getText() + extractfrombutton);
                        }
                        else if (intrate2.isFocused()) {
                            intrate2.setText(intrate2.getText() + extractfrombutton);
                        }
                        else if (time2.isFocused()) {
                            time2.setText(time2.getText() + extractfrombutton);
                        }
                        else if (moncon.isFocused()) {
                            moncon.setText(moncon.getText() + extractfrombutton);
                        }
                        else if (futval2.isFocused()) {
                            futval2.setText(futval2.getText() + extractfrombutton);
                        }
                        else if (loanamt.isFocused()) {
                            loanamt.setText(loanamt.getText() + extractfrombutton);
                        }
                        else if (intrate3.isFocused()) {
                            intrate3.setText(intrate3.getText() + extractfrombutton);
                        }
                        else if (time3.isFocused()) {
                            time3.setText(time3.getText() + extractfrombutton);
                        }
                        else if (monpay.isFocused()) {
                            monpay.setText(monpay.getText() + extractfrombutton);
                        }
                        else if (noofpay.isFocused()) {
                            noofpay.setText(noofpay.getText() + extractfrombutton);
                        }
                        else if (assetprice.isFocused()) {
                            assetprice.setText(assetprice.getText() + extractfrombutton);
                        }
                        else if (loanterm.isFocused()) {
                            loanterm.setText(loanterm.getText() + extractfrombutton);
                        }
                        else if (intrate4.isFocused()) {
                            intrate4.setText(intrate4.getText() + extractfrombutton);
                        }
                        else if (monpay2.isFocused()) {
                            monpay2.setText(monpay2.getText() + extractfrombutton);
                        }
                    }
                });
                button4.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String extractfrombutton = "4";
                        if (inidep1.isFocused()) {
                            inidep1.setText(inidep1.getText()+ extractfrombutton);
                        }
                        else if (intrate1.isFocused()) {
                            intrate1.setText(intrate1.getText() + extractfrombutton);
                        }
                        else if (time1.isFocused()) {
                            time1.setText(time1.getText() + extractfrombutton);
                        }
                        else if (futval1.isFocused()) {
                            futval1.setText(futval1.getText() + extractfrombutton);
                        }
                        else if (inidep2.isFocused()) {
                            inidep2.setText(inidep2.getText() + extractfrombutton);
                        }
                        else if (intrate2.isFocused()) {
                            intrate2.setText(intrate2.getText() + extractfrombutton);
                        }
                        else if (time2.isFocused()) {
                            time2.setText(time2.getText() + extractfrombutton);
                        }
                        else if (moncon.isFocused()) {
                            moncon.setText(moncon.getText() + extractfrombutton);
                        }
                        else if (futval2.isFocused()) {
                            futval2.setText(futval2.getText() + extractfrombutton);
                        }
                        else if (loanamt.isFocused()) {
                            loanamt.setText(loanamt.getText() + extractfrombutton);
                        }
                        else if (intrate3.isFocused()) {
                            intrate3.setText(intrate3.getText() + extractfrombutton);
                        }
                        else if (time3.isFocused()) {
                            time3.setText(time3.getText() + extractfrombutton);
                        }
                        else if (monpay.isFocused()) {
                            monpay.setText(monpay.getText() + extractfrombutton);
                        }
                        else if (noofpay.isFocused()) {
                            noofpay.setText(noofpay.getText() + extractfrombutton);
                        }
                        else if (assetprice.isFocused()) {
                            assetprice.setText(assetprice.getText() + extractfrombutton);
                        }
                        else if (loanterm.isFocused()) {
                            loanterm.setText(loanterm.getText() + extractfrombutton);
                        }
                        else if (intrate4.isFocused()) {
                            intrate4.setText(intrate4.getText() + extractfrombutton);
                        }
                        else if (monpay2.isFocused()) {
                            monpay2.setText(monpay2.getText() + extractfrombutton);
                        }
                    }
                });
                button5.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String extractfrombutton = "5";
                        if (inidep1.isFocused()) {
                            inidep1.setText(inidep1.getText()+ extractfrombutton);
                        }
                        else if (intrate1.isFocused()) {
                            intrate1.setText(intrate1.getText() + extractfrombutton);
                        }
                        else if (time1.isFocused()) {
                            time1.setText(time1.getText() + extractfrombutton);
                        }
                        else if (futval1.isFocused()) {
                            futval1.setText(futval1.getText() + extractfrombutton);
                        }
                        else if (inidep2.isFocused()) {
                            inidep2.setText(inidep2.getText() + extractfrombutton);
                        }
                        else if (intrate2.isFocused()) {
                            intrate2.setText(intrate2.getText() + extractfrombutton);
                        }
                        else if (time2.isFocused()) {
                            time2.setText(time2.getText() + extractfrombutton);
                        }
                        else if (moncon.isFocused()) {
                            moncon.setText(moncon.getText() + extractfrombutton);
                        }
                        else if (futval2.isFocused()) {
                            futval2.setText(futval2.getText() + extractfrombutton);
                        }
                        else if (loanamt.isFocused()) {
                            loanamt.setText(loanamt.getText() + extractfrombutton);
                        }
                        else if (intrate3.isFocused()) {
                            intrate3.setText(intrate3.getText() + extractfrombutton);
                        }
                        else if (time3.isFocused()) {
                            time3.setText(time3.getText() + extractfrombutton);
                        }
                        else if (monpay.isFocused()) {
                            monpay.setText(monpay.getText() + extractfrombutton);
                        }
                        else if (noofpay.isFocused()) {
                            noofpay.setText(noofpay.getText() + extractfrombutton);
                        }
                        else if (assetprice.isFocused()) {
                            assetprice.setText(assetprice.getText() + extractfrombutton);
                        }
                        else if (loanterm.isFocused()) {
                            loanterm.setText(loanterm.getText() + extractfrombutton);
                        }
                        else if (intrate4.isFocused()) {
                            intrate4.setText(intrate4.getText() + extractfrombutton);
                        }
                        else if (monpay2.isFocused()) {
                            monpay2.setText(monpay2.getText() + extractfrombutton);
                        }
                    }
                });
                button6.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String extractfrombutton = "6";
                        if (inidep1.isFocused()) {
                            inidep1.setText(inidep1.getText()+ extractfrombutton);
                        }
                        else if (intrate1.isFocused()) {
                            intrate1.setText(intrate1.getText() + extractfrombutton);
                        }
                        else if (time1.isFocused()) {
                            time1.setText(time1.getText() + extractfrombutton);
                        }
                        else if (futval1.isFocused()) {
                            futval1.setText(futval1.getText() + extractfrombutton);
                        }
                        else if (inidep2.isFocused()) {
                            inidep2.setText(inidep2.getText() + extractfrombutton);
                        }
                        else if (intrate2.isFocused()) {
                            intrate2.setText(intrate2.getText() + extractfrombutton);
                        }
                        else if (time2.isFocused()) {
                            time2.setText(time2.getText() + extractfrombutton);
                        }
                        else if (moncon.isFocused()) {
                            moncon.setText(moncon.getText() + extractfrombutton);
                        }
                        else if (futval2.isFocused()) {
                            futval2.setText(futval2.getText() + extractfrombutton);
                        }
                        else if (loanamt.isFocused()) {
                            loanamt.setText(loanamt.getText() + extractfrombutton);
                        }
                        else if (intrate3.isFocused()) {
                            intrate3.setText(intrate3.getText() + extractfrombutton);
                        }
                        else if (time3.isFocused()) {
                            time3.setText(time3.getText() + extractfrombutton);
                        }
                        else if (monpay.isFocused()) {
                            monpay.setText(monpay.getText() + extractfrombutton);
                        }
                        else if (noofpay.isFocused()) {
                            noofpay.setText(noofpay.getText() + extractfrombutton);
                        }
                        else if (assetprice.isFocused()) {
                            assetprice.setText(assetprice.getText() + extractfrombutton);
                        }
                        else if (loanterm.isFocused()) {
                            loanterm.setText(loanterm.getText() + extractfrombutton);
                        }
                        else if (intrate4.isFocused()) {
                            intrate4.setText(intrate4.getText() + extractfrombutton);
                        }
                        else if (monpay2.isFocused()) {
                            monpay2.setText(monpay2.getText() + extractfrombutton);
                        }
                    }
                });
                button7.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String extractfrombutton = "1";
                        if (inidep1.isFocused()) {
                            inidep1.setText(inidep1.getText()+ extractfrombutton);
                        }
                        else if (intrate1.isFocused()) {
                            intrate1.setText(intrate1.getText() + extractfrombutton);
                        }
                        else if (time1.isFocused()) {
                            time1.setText(time1.getText() + extractfrombutton);
                        }
                        else if (futval1.isFocused()) {
                            futval1.setText(futval1.getText() + extractfrombutton);
                        }
                        else if (inidep2.isFocused()) {
                            inidep2.setText(inidep2.getText() + extractfrombutton);
                        }
                        else if (intrate2.isFocused()) {
                            intrate2.setText(intrate2.getText() + extractfrombutton);
                        }
                        else if (time2.isFocused()) {
                            time2.setText(time2.getText() + extractfrombutton);
                        }
                        else if (moncon.isFocused()) {
                            moncon.setText(moncon.getText() + extractfrombutton);
                        }
                        else if (futval2.isFocused()) {
                            futval2.setText(futval2.getText() + extractfrombutton);
                        }
                        else if (loanamt.isFocused()) {
                            loanamt.setText(loanamt.getText() + extractfrombutton);
                        }
                        else if (intrate3.isFocused()) {
                            intrate3.setText(intrate3.getText() + extractfrombutton);
                        }
                        else if (time3.isFocused()) {
                            time3.setText(time3.getText() + extractfrombutton);
                        }
                        else if (monpay.isFocused()) {
                            monpay.setText(monpay.getText() + extractfrombutton);
                        }
                        else if (noofpay.isFocused()) {
                            noofpay.setText(noofpay.getText() + extractfrombutton);
                        }
                        else if (assetprice.isFocused()) {
                            assetprice.setText(assetprice.getText() + extractfrombutton);
                        }
                        else if (loanterm.isFocused()) {
                            loanterm.setText(loanterm.getText() + extractfrombutton);
                        }
                        else if (intrate4.isFocused()) {
                            intrate4.setText(intrate4.getText() + extractfrombutton);
                        }
                        else if (monpay2.isFocused()) {
                            monpay2.setText(monpay2.getText() + extractfrombutton);
                        }
                    }
                });
                button8.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String extractfrombutton = "2";
                        if (inidep1.isFocused()) {
                            inidep1.setText(inidep1.getText()+ extractfrombutton);
                        }
                        else if (intrate1.isFocused()) {
                            intrate1.setText(intrate1.getText() + extractfrombutton);
                        }
                        else if (time1.isFocused()) {
                            time1.setText(time1.getText() + extractfrombutton);
                        }
                        else if (futval1.isFocused()) {
                            futval1.setText(futval1.getText() + extractfrombutton);
                        }
                        else if (inidep2.isFocused()) {
                            inidep2.setText(inidep2.getText() + extractfrombutton);
                        }
                        else if (intrate2.isFocused()) {
                            intrate2.setText(intrate2.getText() + extractfrombutton);
                        }
                        else if (time2.isFocused()) {
                            time2.setText(time2.getText() + extractfrombutton);
                        }
                        else if (moncon.isFocused()) {
                            moncon.setText(moncon.getText() + extractfrombutton);
                        }
                        else if (futval2.isFocused()) {
                            futval2.setText(futval2.getText() + extractfrombutton);
                        }
                        else if (loanamt.isFocused()) {
                            loanamt.setText(loanamt.getText() + extractfrombutton);
                        }
                        else if (intrate3.isFocused()) {
                            intrate3.setText(intrate3.getText() + extractfrombutton);
                        }
                        else if (time3.isFocused()) {
                            time3.setText(time3.getText() + extractfrombutton);
                        }
                        else if (monpay.isFocused()) {
                            monpay.setText(monpay.getText() + extractfrombutton);
                        }
                        else if (noofpay.isFocused()) {
                            noofpay.setText(noofpay.getText() + extractfrombutton);
                        }
                        else if (assetprice.isFocused()) {
                            assetprice.setText(assetprice.getText() + extractfrombutton);
                        }
                        else if (loanterm.isFocused()) {
                            loanterm.setText(loanterm.getText() + extractfrombutton);
                        }
                        else if (intrate4.isFocused()) {
                            intrate4.setText(intrate4.getText() + extractfrombutton);
                        }
                        else if (monpay2.isFocused()) {
                            monpay2.setText(monpay2.getText() + extractfrombutton);
                        }
                    }
                });
                button9.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String extractfrombutton = "3";
                        if (inidep1.isFocused()) {
                            inidep1.setText(inidep1.getText()+ extractfrombutton);
                        }
                        else if (intrate1.isFocused()) {
                            intrate1.setText(intrate1.getText() + extractfrombutton);
                        }
                        else if (time1.isFocused()) {
                            time1.setText(time1.getText() + extractfrombutton);
                        }
                        else if (futval1.isFocused()) {
                            futval1.setText(futval1.getText() + extractfrombutton);
                        }
                        else if (inidep2.isFocused()) {
                            inidep2.setText(inidep2.getText() + extractfrombutton);
                        }
                        else if (intrate2.isFocused()) {
                            intrate2.setText(intrate2.getText() + extractfrombutton);
                        }
                        else if (time2.isFocused()) {
                            time2.setText(time2.getText() + extractfrombutton);
                        }
                        else if (moncon.isFocused()) {
                            moncon.setText(moncon.getText() + extractfrombutton);
                        }
                        else if (futval2.isFocused()) {
                            futval2.setText(futval2.getText() + extractfrombutton);
                        }
                        else if (loanamt.isFocused()) {
                            loanamt.setText(loanamt.getText() + extractfrombutton);
                        }
                        else if (intrate3.isFocused()) {
                            intrate3.setText(intrate3.getText() + extractfrombutton);
                        }
                        else if (time3.isFocused()) {
                            time3.setText(time3.getText() + extractfrombutton);
                        }
                        else if (monpay.isFocused()) {
                            monpay.setText(monpay.getText() + extractfrombutton);
                        }
                        else if (noofpay.isFocused()) {
                            noofpay.setText(noofpay.getText() + extractfrombutton);
                        }
                        else if (assetprice.isFocused()) {
                            assetprice.setText(assetprice.getText() + extractfrombutton);
                        }
                        else if (loanterm.isFocused()) {
                            loanterm.setText(loanterm.getText() + extractfrombutton);
                        }
                        else if (intrate4.isFocused()) {
                            intrate4.setText(intrate4.getText() + extractfrombutton);
                        }
                        else if (monpay2.isFocused()) {
                            monpay2.setText(monpay2.getText() + extractfrombutton);
                        }
                    }
                });
                button10.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String extractfrombutton = ".";
                        if (inidep1.isFocused()) {
                            inidep1.setText(inidep1.getText()+ extractfrombutton);
                        }
                        else if (intrate1.isFocused()) {
                            intrate1.setText(intrate1.getText() + extractfrombutton);
                        }
                        else if (time1.isFocused()) {
                            time1.setText(time1.getText() + extractfrombutton);
                        }
                        else if (futval1.isFocused()) {
                            futval1.setText(futval1.getText() + extractfrombutton);
                        }
                        else if (inidep2.isFocused()) {
                            inidep2.setText(inidep2.getText() + extractfrombutton);
                        }
                        else if (intrate2.isFocused()) {
                            intrate2.setText(intrate2.getText() + extractfrombutton);
                        }
                        else if (time2.isFocused()) {
                            time2.setText(time2.getText() + extractfrombutton);
                        }
                        else if (moncon.isFocused()) {
                            moncon.setText(moncon.getText() + extractfrombutton);
                        }
                        else if (futval2.isFocused()) {
                            futval2.setText(futval2.getText() + extractfrombutton);
                        }
                        else if (loanamt.isFocused()) {
                            loanamt.setText(loanamt.getText() + extractfrombutton);
                        }
                        else if (intrate3.isFocused()) {
                            intrate3.setText(intrate3.getText() + extractfrombutton);
                        }
                        else if (time3.isFocused()) {
                            time3.setText(time3.getText() + extractfrombutton);
                        }
                        else if (monpay.isFocused()) {
                            monpay.setText(monpay.getText() + extractfrombutton);
                        }
                        else if (noofpay.isFocused()) {
                            noofpay.setText(noofpay.getText() + extractfrombutton);
                        }
                        else if (assetprice.isFocused()) {
                            assetprice.setText(assetprice.getText() + extractfrombutton);
                        }
                        else if (loanterm.isFocused()) {
                            loanterm.setText(loanterm.getText() + extractfrombutton);
                        }
                        else if (intrate4.isFocused()) {
                            intrate4.setText(intrate4.getText() + extractfrombutton);
                        }
                        else if (monpay2.isFocused()) {
                            monpay2.setText(monpay2.getText() + extractfrombutton);
                        }
                    }
                });
                button11.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String extractfrombutton = "0";
                        if (inidep1.isFocused()) {
                            inidep1.setText(inidep1.getText()+ extractfrombutton);
                        }
                        else if (intrate1.isFocused()) {
                            intrate1.setText(intrate1.getText() + extractfrombutton);
                        }
                        else if (time1.isFocused()) {
                            time1.setText(time1.getText() + extractfrombutton);
                        }
                        else if (futval1.isFocused()) {
                            futval1.setText(futval1.getText() + extractfrombutton);
                        }
                        else if (inidep2.isFocused()) {
                            inidep2.setText(inidep2.getText() + extractfrombutton);
                        }
                        else if (intrate2.isFocused()) {
                            intrate2.setText(intrate2.getText() + extractfrombutton);
                        }
                        else if (time2.isFocused()) {
                            time2.setText(time2.getText() + extractfrombutton);
                        }
                        else if (moncon.isFocused()) {
                            moncon.setText(moncon.getText() + extractfrombutton);
                        }
                        else if (futval2.isFocused()) {
                            futval2.setText(futval2.getText() + extractfrombutton);
                        }
                        else if (loanamt.isFocused()) {
                            loanamt.setText(loanamt.getText() + extractfrombutton);
                        }
                        else if (intrate3.isFocused()) {
                            intrate3.setText(intrate3.getText() + extractfrombutton);
                        }
                        else if (time3.isFocused()) {
                            time3.setText(time3.getText() + extractfrombutton);
                        }
                        else if (monpay.isFocused()) {
                            monpay.setText(monpay.getText() + extractfrombutton);
                        }
                        else if (noofpay.isFocused()) {
                            noofpay.setText(noofpay.getText() + extractfrombutton);
                        }
                        else if (assetprice.isFocused()) {
                            assetprice.setText(assetprice.getText() + extractfrombutton);
                        }
                        else if (loanterm.isFocused()) {
                            loanterm.setText(loanterm.getText() + extractfrombutton);
                        }
                        else if (intrate4.isFocused()) {
                            intrate4.setText(intrate4.getText() + extractfrombutton);
                        }
                        else if (monpay2.isFocused()) {
                            monpay2.setText(monpay2.getText() + extractfrombutton);
                        }
                    }
                });
                button12.setOnAction(new EventHandler<ActionEvent>() { //the clear button
                    @Override
                    public void handle(ActionEvent event) {
                        inidep1.setText("");
                        inidep2.setText("");
                        intrate1.setText("");
                        intrate2.setText("");
                        time1.setText("");
                        time2.setText("");
                        futval1.setText("");
                        futval2.setText("");
                        loanamt.setText("");
                        intrate3.setText("");
                        time3.setText("");
                        monpay.setText("");
                        moncon.setText("");
                        noofpay.setText("");
                        assetprice.setText("");
                        loanterm.setText("");
                        intrate4.setText("");
                        monpay2.setText("");
                        txt.setText("");
                        txt1.setText("");
                        txt2.setText("");
                        txt3.setText("");
                        txt4.setText("");

                    }
                });

                GridPane gridPane = new GridPane(); //adding the buttons to the gridpane

                gridPane.add(button1, 0, 0, 1, 1);
                gridPane.add(button2, 1, 0, 1, 1);
                gridPane.add(button3, 2, 0, 1, 1);
                gridPane.add(button4, 0, 1, 1, 1);
                gridPane.add(button5, 1, 1, 1, 1);
                gridPane.add(button6, 2, 1, 1, 1);
                gridPane.add(button7, 0, 2, 1, 1);
                gridPane.add(button8, 1, 2, 1, 1);
                gridPane.add(button9, 2, 2, 1, 1);
                gridPane.add(button10, 0, 3, 1, 1);
                gridPane.add(button11, 1, 3, 1, 1);
                gridPane.add(button12, 2, 3, 1, 1);

                rightControl.getChildren().add(gridPane);

                Scene scene = new Scene(splitPane1,1000,800);
                scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());//connecting the external style sheet to the main file
                primaryStage.setScene(scene);
                primaryStage.setTitle("Financial calculator");
                primaryStage.show();
                primaryStage.setResizable(false); //disable resizing the window

            }
        });

        Pane root = new Pane();
        root.setId("Home");
        root.getChildren().add(btn);
        root.getChildren().add(btn1);

        Scene scene1 = new Scene(root, 600, 500);
        scene1.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());

        primaryStage.setScene(scene1);
        primaryStage.show();
        primaryStage.setResizable(false);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
