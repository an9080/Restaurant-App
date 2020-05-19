//NAME    :  Dema Al-faraj   &   Anoud Al-subaie
//ID      :  437200141       &  437201069
//SECTION :  39752
import java.util.*;
public class Order {
static Scanner read =new Scanner (System.in);
private String customerName;
private String date;
private String time;
private int totalDishes;
private String [] dishes ;
private double totalPrice=0;
private String orderCode;
public static int totalOrders=0;//counter

public Order() {
customerName="";
date="";
time="";
totalDishes=0;
totalPrice=0;
orderCode="";
totalOrders++;
}
public Order (String n, String d,String t,int td) {
customerName=n;
date=d;
time=t;
totalDishes=td;
dishes=new String[totalDishes];
totalOrders++;
orderCode=totalOrders+"";
if (orderCode.length()==1){
orderCode="000"+orderCode;}
else if (orderCode.length()==2){
orderCode="00"+orderCode;}
else if (orderCode.length()==3){
orderCode="0"+orderCode;}}

public void addDishes(int totalnumofdishes){
dishes=new String[totalnumofdishes];
int i=0;
do {
System.out.println("1. Dish# 1: Ceasar Salad =32 SR.");        
System.out.println("2. Dish# 2: French Fries=10 SR.");
System.out.println("3. Dish# 3: Pizza=45  SR.");
System.out.println("4. Dish# 4: Pasta=50  SR.");
System.out.println("5. Dish# 5: Rice =25  SR.");
System.out.println("6. Dish# 6: Grilled Chicken= 49  SR.");
System.out.println("7.Dish# 7: Fried Shrimp=95  SR.");
System.out.println("8. Dish# 8: Grilled Fish=89  SR.");

int dishnum=read.nextInt();//dishnum : means dish number
switch (dishnum){
case (1):
dishes[i++]="Dish#"+(i)+": Ceasar Salad =32 SR.";
--totalnumofdishes;//decrement for the dishes so that if it reaches zero it will stop.
break;
case 2:
dishes[i++]="Dish#"+(i)+": French Fries=10 SR.";
--totalnumofdishes;
break;
case 3:
dishes[i++]="Dish#"+(i)+": Pizza=45  SR.";
--totalnumofdishes;
break;
case 4:
dishes[i++]="Dish#"+(i)+": Pasta=50  SR.";
--totalnumofdishes;
break;
case 5:
dishes[i++]="Dish#"+(i)+": Rice =25  SR.";
--totalnumofdishes;
break;
case 6:
dishes[i++]="Dish#"+(i)+": Grilled Chicken=49  SR.";
--totalnumofdishes;
break;
case 7:
dishes[i++]="Dish#"+(i)+": Fried Shrimp=95  SR.";
--totalnumofdishes;
break;
case 8:
dishes[i++]="Dish#"+(i)+": Grilled Fish=89  SR..";
--totalnumofdishes;
break;
default:
System.out.println(" inviled input you must choose dish between 1,8");
} }  
while (totalnumofdishes>0);
calculateTotalPrice();////to call calculateTotalPrice methode

}
public void setCustomerName(String cn){
customerName=cn;
}

public void setDate(String da){
date=da;
}
public void setTime(String ti){
time=ti;
}

public void setTotalDishes(int td){
totalDishes=td;
}
public String getCustomerName() { 
return customerName; } 

public String getDate()  { 
return date; }

public String getTime() { 
return time; }

public String getOrderCode(){
return orderCode;}

public int TotalDishes() { 
return totalDishes; }


public void calculateTotalPrice(){
int index1,index2;
double Price ;
String strPrice;
for (int i=0;i<dishes.length;i++){ 
index1=dishes[i].indexOf("="); 
index2=dishes[i].indexOf(" ",index1);
strPrice=dishes[i].substring(index1+1,index2); //we substring from after the = sign to the space after the number to check the price
Price=Double.parseDouble(strPrice); //to retuer from string to double
totalPrice +=Price; 
}
if (totalDishes>3){
totalPrice=totalPrice-(totalPrice*0.1);
}
System.out.println("Total Price :"+totalPrice);
}
public void printOrderInfo(){
System.out.println("Customer name: "+customerName);
System.out.println("Date: "+date+"\t Time: "+time);
System.out.println("Dishes: ");
for (int i=0;i<dishes.length;i++)System.out.println(dishes[i]);
System.out.println("Total number of dishes:"+totalDishes);
System.out.println("Total Price:"+totalPrice);
System.out.println("order code"+orderCode);

}


}//end class


