package com.automation.index;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CalCulations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int Req_Qty=100;
int lead_qty_var=85;
double Qty_brd_var =99;
double Attr_Rate_var=59.85;
double calculation =   (Req_Qty*Qty_brd_var*((Attr_Rate_var/100)+1)) +lead_qty_var;
System.out.println("Total Quantity:"+calculation);

double cal=1234.123456489;
DecimalFormat df = new DecimalFormat("#.######");
df.setRoundingMode(RoundingMode.DOWN);
System.out.println(df.format(cal));

cal=123456789.000006789;
System.out.println(df.format(cal));

cal=12456.9999906789;
System.out.println(df.format(cal));

cal=12.000006389;
System.out.println(df.format(cal));

cal=2.0000001;
System.out.println(df.format(cal));
Double d  = 0.382409;
System.out.println(d);
Double t = 0.0000001;
//System.out.println(df.format(t));
d = d + t;
d = d + 0.000001;
//d = d - 0.0000001;
System.out.println(d);

	}

}
