// qs-16
/*
Create a class NavalVessel with the below attributes:

vesselld – int
vesselName – String
noOfVoyagesPlanned – int
noOfVoyagesCompleted – int
purpose – String


Write getters, setters for the above attributes. Create constructor which takes parameter in the above 
sequence except classification.

Create class Solution with main method. Implement two static methods – findAvgVoyagesByPct and findVesselByGrade 
in Solution class.

findAvgVoyagesByPct method:

This method will take two input parameters -array of NavalVessel objects and int parameter percentage. The method will 
return the average of the noOfVoyagesCompleted attribute from NavalVessel objects which meets the percentage requirement 
as mentioned below.The percentage for each navalVessel is calculated as 
percentage .(noOfVoyagesCompleted * 100)/noOfVoyagesPlanned. If the above calculated percentage is greater than or equal 
to the percentage passed as the parameter, then those objects should participate in the average calculation. If there are 
no objects with the mentioned criteria, then the method should return 0.

findVesselByGrade method:

This method will take a String parameter purpose, along with the array of NavalVessel objects. The method will return the 
NavalVessel object, if the input String parameter matches with the purpose attribute of the NavalVessel object. Before 
returning the object, the classification should be derived as mentioned below. This classification value should be assigned 
to the object before returning. If any of the above conditions are not met, then the method should return null. The 
classification attribute should be calculated based on the percentage calculation mentioned above. 
If the percentage = 100 then classification should be ‘Star’, if percentage is between 99 and 80 then classification should 
be ‘Leader, if percentage is between 79 and 55 then classification should be ‘Inspirer' otherwise the classification should 
be ‘Striver’ If the returned value is null then it should print “No Naval Vessel is available with the specified purpose”.

Before calling these static methods in main, use Scanner object to read the values of four NavalVessel objects referring 
attributes in the above mentioned attribute sequence (except the classification attribute). Next, read the value for 
percentage and purpose.

Input
-------------------
111
Rojer
100
100
Passenger
222
Kalam
200
100
Goods
333
Yashwin
400
300
Army
444
Thanishwini
500
500
Welfare
75
Army

Output
------------------
300
Yashwin%Inspirer
*/

import java.util.*;
class NavalVessel {
    
    private int vesselld ;
    private String vesselName ;
    private int noOfVoyagesPlanned ;
    private int noOfVoyagesCompleted ; 
    private String purpose;
    
    public NavalVessel(int vesselld, String vesselName, int noOfVoyagesPlanned, int noOfVoyagesCompleted, String purpose) {
        this.vesselld = vesselld;
        this.vesselName = vesselName;
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
        this.purpose = purpose;
    }
    public int getVesselld() {
        return vesselld;
    }
    public void setVesselld(int vesselld) {
        this.vesselld = vesselld;
    }
    public String getVesselName() {
        return vesselName;
    }
    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }
    public int getNoOfVoyagesPlanned() {
        return noOfVoyagesPlanned;
    }
    public void setNoOfVoyagesPlanned(int noOfVoyagesPlanned) {
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
    }
    public int getNoOfVoyagesCompleted() {
        return noOfVoyagesCompleted;
    }
    public void setNoOfVoyagesCompleted(int noOfVoyagesCompleted) {
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
    }
    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    
}
public class pra16 {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt(); sc.nextLine();
        NavalVessel [] nv = new NavalVessel [n];

        for(int i=0;i<n;i++){
            int id=sc.nextInt(); 
            sc.nextLine();
            String vesselName=sc.nextLine(); 
            int noOfVoyagesPlanned =sc.nextInt();  
            int noOfVoyagesCompleted =sc.nextInt(); sc.nextLine();
            String purpose =sc.nextLine(); 

            nv[i]= new NavalVessel(id,vesselName, noOfVoyagesPlanned,noOfVoyagesCompleted, purpose);

            System.out.println("id is: "+id+" vsname: "+vesselName+" noofplannedvoyage: "+ noOfVoyagesPlanned+" completedVoyage: "+noOfVoyagesCompleted+ " purpose "+ purpose);
        } 

        int a= sc.nextInt(); sc.nextLine();
        String os=sc.nextLine(); 
        System.out.println("1st fn "+ findAvgVoyagesByPct(nv,a));
        NavalVessel tmp=findVesselByGrade(os,nv);

        if(tmp==null)System.out.println("Null returned!! ");
        else{System.out.println(tmp.getVesselName()+"%"+tmp.getPurpose());}
        sc.close();
}

    public static int findAvgVoyagesByPct  (NavalVessel[]nv, int percentage){ int c=0,sum=0;
        for(NavalVessel n:nv){ 
            double tmp=(n.getNoOfVoyagesCompleted()*100)/(double)n.getNoOfVoyagesPlanned(); 
            n.setNoOfVoyagesPlanned((int)tmp);
            if(tmp>=percentage){c++;
            sum+=n.getNoOfVoyagesCompleted();}
        } if(c==0)return 0;
        return sum/c;
    }
    public static NavalVessel findVesselByGrade  (String purpose, NavalVessel[] nv){ 
        for(NavalVessel n:nv){ 
            if(n.getPurpose().equals(purpose)){
                if(n.getNoOfVoyagesPlanned()>=100){n.setPurpose("Star");}
                else if(n.getNoOfVoyagesPlanned()>=80){n.setPurpose("Leader");}
                else if(n.getNoOfVoyagesPlanned()>=55){n.setPurpose("Inspirer");}
                else {n.setPurpose("Striver");}

                return n;
            }
        }return null;
    }
}
 /* Output-------------------
id is: 111 vsname: Rojer noofplannedvoyage: 100 completedVoyage: 100 purpose Passenger
id is: 222 vsname: Kalam noofplannedvoyage: 200 completedVoyage: 100 purpose Goods
id is: 333 vsname: Yashwin noofplannedvoyage: 400 completedVoyage: 300 purpose Army
id is: 444 vsname: Thanishwini noofplannedvoyage: 500 completedVoyage: 500 purpose Welfare
1st fn 300
Yashwin%Inspirer
  */