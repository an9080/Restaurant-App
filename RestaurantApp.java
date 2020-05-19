//NAME    :  Dema Al-faraj   &   Anoud Al-subaie
//ID      :  437200141       &  437201069
//SECTION :  39752
import java.util.*;
public class RestaurantApp{
static Scanner read =new Scanner (System.in);
private static Order[] order = new Order [200];
public static void main (String args[]){
String name;
String date;
String time;
int numOfDish;
int number;//(number)means service choice
   
do{
System.out.println("what you whant to do ?");
System.out.println("1.Add a new customer order.");
System.out.println("2.Find the information about an order given its code.");       
System.out.println("3.Display all orders.");         
System.out.println("4.Display the total number of orders.");       
System.out.println("5.Exit.");
number = read.nextInt();
         
      
switch(number){
case 1: 
System.out.println ("Enter full name in the format firstNameLastName");
read.nextLine();
name= read.nextLine();
System.out.println ("Enter the date in the format (DD/MM/YYYY)");
date=read.next();
System.out.println ("Enter the time in the format(HH:MM)");
time=read.next();
System.out.println ("Enter the number of dishes");
numOfDish = read.nextInt();
           
           
if( addOrder(name, date,time, numOfDish)){//Send data that added by user to addOrder method 
             
             
Order Norder=new Order(name,date ,time,numOfDish);
Norder.addDishes(numOfDish); 
order[Order.totalOrders-1]=Norder;
System.out.println("The order is added successfully");}
else 
System.out.println("Order wasn't added");
          
break; 
       
case 2:      
System.out.println("Enter the order code to search for it ");
String ordercode=read.next();
int i = findOrder(ordercode);
if(i== -1)
System.out.println(" the order is not part of the order list");
break; 
        
case 3:
printAll();
break;
        
case 4:
System.out.println(" Total orders= "+allOrders()+" orders");
break;
 
}
}
while (number!=5); 
}

public static boolean addOrder (String name,String date,String time,int numOfDish){
   
boolean ff=true;            
if (date.length()!=10)
ff=false;
    
if ((date.indexOf('/')!=2) || (date.indexOf('/',3)!=5))
ff=false;

if (time.length()!=5)
ff=false;
  
if (time.indexOf(':')!=2)
ff=false;
    
return ff; 
        
}         
         

public static int findOrder(String orderCode){
boolean flag=false;
int i;
for(i=0;i<Order.totalOrders;i++)
if(order[i].getOrderCode().equals(orderCode)){
order[i].printOrderInfo();

return i;
}
return -1;
}

public static void printAll() {
if(order.length>0){
for(int i=0;i<Order.totalOrders;i++){
order[i].printOrderInfo();
}}
else
System.out.println("No Orders");
}

public static int allOrders(){
return Order.totalOrders;
}

}//end of class