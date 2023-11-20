// qs-13
import java.util.*;
class AutonomousCar {
    private int carId ;
    private String brand;
    private int noOfTestsConducted  ;
    private int noOfTestsPassed ;
    private String environment; 

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNoOfTestsConducted() {
        return noOfTestsConducted;
    }
    public void setNoOfTestsConducted(int noOfTestsConducted) {
        this.noOfTestsConducted = noOfTestsConducted;
    }
    public int getNoOfTestsPassed() {
        return noOfTestsPassed;
    }
    public void setNoOfTestsPassed(int noOfTestsPassed) {
        this.noOfTestsPassed = noOfTestsPassed;
    }
    public String getEnvironment() {
        return environment;
    }
    public void setEnvironment(String environment) {
        this.environment = environment;
    }
    public int getcarId() {
        return carId;
    }
    public void setcarId(int carId) {
        this.carId = carId;
    }
    AutonomousCar(int carId, String brand, int testConducted, int testPassed,String environment){
        this.carId=carId;
        this.brand=brand;
        this.noOfTestsConducted=testConducted;
        this.noOfTestsPassed=testPassed;
        this.environment=environment;
    }
}
public class pra13 {
    public String str="";
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt(); sc.nextLine();
        AutonomousCar[] au=new AutonomousCar[n];

        for(int i=0;i<n;i++){
            int id=sc.nextInt(); sc.nextLine();
            String brand= sc.nextLine(); //sc.nextLine();
            int tc=sc.nextInt(); //sc.nextLine();
            int tp=sc.nextInt(); sc.nextLine();
            String env=sc.nextLine(); //sc.nextLine(); 
            au[i]= new AutonomousCar(id,brand,tc,tp,env);
            System.out.println("id is: "+id+" brand: "+brand+" testConducted: "+ tc+" testPassed: "+tp+" environment:"+ env);
        } 
        String env=sc.nextLine(); //System.out.println("sk is "+env);
        String bra=sc.nextLine(); //System.out.println("lev is "+bra);
        System.out.println("test passed by env "+ findTestPassedByEnv(au,env));
        AutonomousCar tmp=updateCarGrade(bra,au);
        if(tmp==null){System.out.println("No Car is available with the specified brand");}
        else{System.out.println(tmp.getBrand()+"::"+tmp.getEnvironment());}
        sc.close();
}

    public static int findTestPassedByEnv (AutonomousCar[] au, String env){ 
        int c=0;
        for(AutonomousCar a:au){
            if(a.getEnvironment().equals(env)){c+=a.getNoOfTestsPassed();}
        } return c;
    }

    public static AutonomousCar updateCarGrade  (String brand, AutonomousCar[] au){
        for(AutonomousCar a:au){
            if(a.getBrand().equals(brand)){
                double gr=(a.getNoOfTestsPassed()*100)/(double)a.getNoOfTestsConducted();
                if(gr>=80){a.setEnvironment("A1");}
                else{a.setEnvironment("B2");}
                return a;
            }
        }
        return null;
    }
}

/* Input 
4
100
Tesla
1000
500
Hills
200
Ford
2000
1500
Desert
300
Royce
3000
1700
Hills
400
Mercedez
1000
400
Desert
Desert
Mercedez
 */

 /* Output-------------------
  id is: 100 brand: Tesla testConducted: 1000 testPassed: 500 environment:Hills
id is: 200 brand: Ford testConducted: 2000 testPassed: 1500 environment:Desert
id is: 300 brand: Royce testConducted: 3000 testPassed: 1700 environment:Hills
id is: 400 brand: Mercedez testConducted: 1000 testPassed: 400 environment:Desert
test passed by env 1900
Mercedez::B2
  */