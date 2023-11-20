// qs-12
import java.util.*;
class Medicine {
    private String name ;
    private String batch;
    private String disease;
    private int price; 

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    Medicine( String name, String batch, String disease, int price){
        this.name=name;
        this.batch=batch;
        this.disease=disease;
        this.price=price;
    }
}
public class pra12 {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt(); sc.nextLine();
        Medicine[] md=new Medicine[n];

        for(int i=0;i<n;i++){
            String name=sc.nextLine(); 
            String batch= sc.nextLine();
            String disease=sc.nextLine(); 
            int price=sc.nextInt(); sc.nextLine();
            md[i]= new Medicine(name,batch,disease,price);
            System.out.println("name is: "+name+" batch: "+batch+" disease: "+ disease+" price: "+price);
        } 
        String ds=sc.nextLine(); 
        System.out.println("price for given disease's medicine list:");
         for(int a: getPriceByDisease(md,ds)){
             System.out.println(a);
         }
        sc.close();
}

    public static int[] getPriceByDisease (Medicine[] md, String ds){ 
        ArrayList<Integer>ar=new ArrayList<>();
        for(Medicine p:md){
            if(p.getDisease().toLowerCase().equals(ds.toLowerCase())){
                ar.add(p.getPrice());}
        } 
        int [] arr=new int [ar.size()];
        // int i=0;
        for(int i=0;i<ar.size();i++){
            arr[i]=ar.get(i);
        }return arr;
    }
}

/* Input 
4
dolo650
FAC124W
fever
100
paracetamol
PAC545B
bodypain
150
almox
ALM747S
fever
200
aspirin
ASP849Q
flu
250
fever
 */

 /* Output-------------------
  name is: dolo650 batch: FAC124W disease: fever price: 100
name is: paracetamol batch: PAC545B disease: bodypain price: 150
name is: almox batch: ALM747S disease: fever price: 200
name is: aspirin batch: ASP849Q disease: flu price: 250
price for given disease's medicine list:
100
200
  */