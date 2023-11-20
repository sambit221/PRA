// qs-10
import java.util.*;
class Employee{
    private int employeeId ;
    private String name; 
    private String branch; 
    private double rating;
    private Boolean transport ;

    Employee(int id, String name, String branch, double rating, Boolean transport){
        this.employeeId=id;
        this.name=name;
        this.branch=branch;
        this.rating=rating;
        this.transport=transport;
    }
    
    public int getEmplyeeId(){ return employeeId;}
    public String getName(){ return name;}
    public String getBranch(){ return branch;}
    public double getRating(){ return rating;}
    public Boolean getTransport(){ return transport;}

    public void setEmplyeeId(int id ){ this.employeeId=id;}
    public void setName(String name){ this.name=name;}
    public void setBranch(String branch){ this.branch=branch;}
    public void setRating(double r ){ this.rating=r;}
    public void setTransport(Boolean transport){ this.transport=transport;}
}
public class pra10 {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        Employee[] emp=new Employee[n];

        for(int i=0;i<n;i++){
            int id=sc.nextInt(); sc.nextLine();
            String name= sc.nextLine();
            String branch=sc.nextLine();
            double rating=sc.nextDouble();sc.nextLine();
            Boolean transport=sc.nextBoolean(); sc.nextLine();
            emp[i]= new Employee(id,name,branch,rating,transport);
        } 
        String b=sc.nextLine();
        System.out.println("No of pipul via transport"+ countOfEmployeesUsingCompTransport(emp,b));
        System.out.println("2nd highest rating is : "+secondHighestRating(emp));
        sc.close();
}

    public static int countOfEmployeesUsingCompTransport(Employee[] emp, String br){ 
        int c=0;
        for(Employee e:emp){
            if(e.getTransport()==true && e.getBranch().equals(br)){c++;}
        } return c;
    }

    public static double secondHighestRating (Employee[] emp){
        Arrays.sort(emp,Comparator.comparingDouble(Employee::getRating).reversed());
        System.out.println("name is: "+emp[1].getName());
        return emp[1].getRating();
    }
}