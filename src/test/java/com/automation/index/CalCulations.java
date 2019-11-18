package com.automation.index;

public class CalCulations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int Req_Qty=100;
int lead_qty_var=10;
double Qty_brd_var =10;
double Attr_Rate_var=50.85;
double calculation =   (Req_Qty*Qty_brd_var*((Attr_Rate_var/100)+1)) +lead_qty_var;
//Attr_Rate_var/100;
//calculation=calculation+1;
//calculation=Req_Qty*Qty_var*calculation;
//calculation=calculation+lead_qty_var;
String cal= Double.toString(calculation);
int dot= cal.indexOf(".");
String final_calculation=cal.substring(0, dot)+cal.substring(dot, dot+7);
//String cal2=cal.substring(dot, dot+7);
//String sub_cal= cal.substring(".",6);
//System.out.println("index of dot:"+dot);
System.out.println("Total Quantity:"+calculation);
//System.out.println("Total Quantity:"+cal1);
//System.out.println("Total Quantity:"+cal2);
System.out.println("Total Quantity:"+final_calculation);
	}

}
