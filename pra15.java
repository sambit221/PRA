// qs-15
/*
Create a class Phone with below attributes: 

phoneId - int 
os - String 
brand - String 
price - int

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create class Solution with main method.

Implement two static methods - findPriceForGivenBrand and getPhoneIdBasedOnOs in Solution class.

findPriceForGivenBrand method: 
----------------------------------
This method will take two input parameters - array of Phone objects and string 
parameter brand. The method will return the sum of the price attribute from phone objects for the brand passed 
as parameter. If no phones with the given brand is present in the array of phone objects, then the method should 
return 0.

getPhoneIdBasedOnOs method: 
----------------------------------
This method will take a String parameter os, along with the array of Phone objects. 
The method will return the phone object, if the input String parameter matches with the os attribute of the phone 
object and its price attribute is greater than or equal to 50000. If any of the conditions are not met, then the 
method should return null.

Note : No phone object would have the same value for os attribute. All phone object would have the price greater than 0. 
All the searches should be case insensitive.

These above mentioned static methods should be called from the main method.

For findPriceForGivenBrand method - The main method should print the price as it is if the returned price is greater 
than 0, or it should print "The given Brand is not available".

For getPhoneIdBasedOnOs method - The main method should print the phoneId of the returned phone object. If the returned 
value is null then it should print "No phones are available with specified os and price range".

Before calling these static methods in main, use Scanner object to read the values of four Phone objects referring 
attributes in the above mentioned attribute sequence. Next, read the value for brand and os.

Input
--------------
111
iOS
Apple
30000
222
android
Samsung
50000
333
Symbian
HTC
12000
444
Paranoid
HTC
89000
Blackberry
aNdRoid

Output
------------------
The given Brand is not available
222
*/
import java.util.*;
class Phone {
    
    private int id;
    private String os;
    private String brand;
    private int price; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    Phone(int id, String os, String brand, int price){
        this.id=id;
        this.os=os;
        this.brand=brand;
        this.price=price;
    }
}
public class pra15 {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt(); sc.nextLine();
        Phone[] ph=new Phone[n];

        for(int i=0;i<n;i++){
            int id=sc.nextInt(); 
            sc.nextLine();
            String os= sc.nextLine();
            String brand= sc.nextLine(); 
            int price=sc.nextInt();  sc.nextLine();

            ph[i]= new Phone(id,os,brand,price);

            System.out.println("id is: "+id+" os: "+os+" brand: "+ brand+" price: "+price);
        } 

        String br=sc.nextLine(); 
        String os=sc.nextLine(); 
        int a =findPriceForGivenBrand(ph,br);
        if(a==0)System.out.println("The given Brand is not available");
        else{System.out.println(a);}
        Phone tmp=getPhoneIdBasedOnOs(os,ph);
        if(tmp==null)System.out.println("No phones are available with specified os and price range");
        else{System.out.println(tmp.getId());}
        sc.close();
}

    public static int findPriceForGivenBrand  (Phone[] ph, String brand){ int c=0;
        for(Phone p:ph){ if(p.getBrand().equals(brand)){
            c+=p.getPrice();}
        } return c;
    }
    public static Phone getPhoneIdBasedOnOs (String os, Phone[] ph){ 
        for(Phone p:ph){ if(p.getOs().toLowerCase().equals(os.toLowerCase()) && p.getPrice()>=50000){
            return p;}
        } return null;
    }
}
 /* Output-------------------
id is: 111 os: iOS brand: Apple price: 30000
id is: 222 os: android brand: Samsung price: 50000
id is: 333 os: Symbian brand: HTC price: 12000
id is: 444 os: Paranoid brand: HTC price: 89000
The given Brand is not available
222
  */