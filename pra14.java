// qs-14
import java.util.*;
class Movie {
    
    private String name;
    private String company;
    private String genre;
    private int budget ; 

    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getCompany() {
        return company;
    }


    public void setCompany(String company) {
        this.company = company;
    }


    public String getGenre() {
        return genre;
    }


    public void setGenre(String genre) {
        this.genre = genre;
    }


    public int getBudget() {
        return budget;
    }


    public void setBudget(int budget) {
        this.budget = budget;
    }


    Movie(String name, String company, String genre, int budget){
        this.name=name;
        this.company=company;
        this.budget=budget;
        this.genre=genre;
    }
}
public class pra14 {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt(); sc.nextLine();
        Movie[] m=new Movie[n];

        for(int i=0;i<n;i++){
            String name= sc.nextLine(); //sc.nextLine();
            
            String company=sc.nextLine();
            String gen=sc.nextLine();
            int bud=sc.nextInt(); sc.nextLine();

            m[i]= new Movie(name,company,gen,bud);
            System.out.println("nm is: "+name+" company: "+company+" genere: "+ gen+" budget: "+bud);
        } 

        String gen=sc.nextLine(); 
        ArrayList <Movie> ar=getMovieByGenre(m,gen);
        for(Movie mo: ar){
            if(mo.getBudget()>80000000){
                System.out.println("High Budget Movie");
            }else{System.out.println("Low Budget Movie");}
        }
        sc.close();
}

    public static ArrayList <Movie> getMovieByGenre (Movie[] m, String gen){ 
        ArrayList <Movie> ar=new ArrayList<>();
        for(Movie a:m){
            if(a.getGenre().toLowerCase().equals(gen.toLowerCase())){ar.add(a);}
        } return ar;
    }
}

/* Input 
4
aaa
Marvel
Action
250000000
bbb
Marvel
Comedy
25000000
ccc
Marvel
Comedy
2000000
ddd
Marvel
Action
300000000
Action
 */

 /* Output-------------------
nm is: aaa company: Marvel genere: Action budget: 250000000
nm is: bbb company: Marvel genere: Comedy budget: 25000000
nm is: ccc company: Marvel genere: Comedy budget: 2000000
nm is: ddd company: Marvel genere: Action budget: 300000000
High Budget Movie
High Budget Movie
  */