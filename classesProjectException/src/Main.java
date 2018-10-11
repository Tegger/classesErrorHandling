import java.util.Scanner;


class Customer {
    /**
     * @param customerName holds customer name
     * @param customerPhone holds customer phone number
     * @param customerAddress holds customer address
     * @param squareFootage holds total footage to be worked for a customer
     */
    String customerName;
    String customerPhone;
    String customerAddress;
    Double squareFootage;

     Customer (String customerName, String customerPhone, String customerAddress, Double squareFootage){
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.squareFootage = squareFootage;
    }

}

class Residential extends Customer{
    /**
     * @param propertyName holds property name
     * @param residentialRate holds total cost of a residential job
     * @param senior holds whether the customer is a senior or not
     * @param seniroDiscount holds the discounted price for seniors
     */
    private String propertyName;
    private Double residentialRate = 6.0 * (squareFootage / 1000);
    private boolean senior;
    private double seniorDiscount = residentialRate - (residentialRate * .15);

    Residential (String name, String phone, String address, Double footage, String propertyName, Boolean senior){
        super(name, phone, address, footage);
        this.propertyName = propertyName;
        this.senior = senior;

    }

    void WeekCharge(){
        System.out.println("Data for " + customerName + ":");
        System.out.println("\nPhone Number: " + customerPhone);
        System.out.println("Address: " + customerAddress);
        System.out.println("Property: " + propertyName);
        if (senior == true){
            System.out.println("Weekly Cost: $" + seniorDiscount + ". (at a 10% discount)");
        }else {
            System.out.println("Weekly Cost: $" + residentialRate);
        }
    }
}

class Commercial extends Customer{
    /**
     * @param propertyName holds property name
     * @param commercialRate holds total cost of a commercial job
     * @param commercialDiscount holds commercial discount
     * @param commercialRate holds the commercial cost for work based on footage
     */
    private String propertyName;
    private Double commercialRate = 5.0 * (squareFootage / 1000);
    private Double commercialDiscount = commercialRate - (commercialRate * .1);
    private String multiProp[];

    Commercial (String name, String phone, String address, Double footage,String propertyName){
        super(name, phone, address, footage);
        this.propertyName = propertyName;
    }

    void WeekCharge(){
        System.out.println("Data for " + customerName + ":");
        System.out.println("\nPhone Number: " + customerPhone);
        System.out.println("Address: " + customerAddress);
        if (multiProp.length > 1){
            for (int i = 0; i <= multiProp.length; i++){
                System.out.println("Property" + i + ": " + multiProp[i]);
            }
            System.out.println("Weekly Cost: $" + commercialDiscount + ". (at a 10% discount)");
        }else {
            System.out.println("Property: " + propertyName);
            System.out.println("Weekly Cost: $" + commercialRate);
        }
    }

}


public class Main {

    public static void main(String[] args) {
        /**
         * @author Thomas Egger
         * @param i boolean to complete loop when all proper data is input
         * @param userInput holds data the user enters
         * @param name holds name of the customer
         * @param phone holds the phone number of the customer
         * @param address holds address of the customer
         * @param property holds the property name
         * @param userNumber holds the total footage worked
         * @param senior holds whether the user is a senior or not
         * @param args Takes input from command line
         * @throws Exception only if a mistake was made
         * 10/11/2018 Modified to allow user input/ Made comments
         */
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        Boolean  i = false;
while( i == false){
    try{
        System.out.println("Please enter 'Residential' or 'Commercial': ");
        String userInput = reader.next();
        System.out.println(userInput);
        if(userInput.equalsIgnoreCase("Residential")){
            System.out.println("Please enter the name of the client: ");
            String name = reader.next();
            System.out.println("Please enter their phone number: ");
            String phone = reader.next();
            System.out.println("Please enter their address: ");
            String address = reader.next();
            System.out.println("Please enter the name of the property: ");
            String property = reader.next();
            System.out.println("Please enter the footage: ");
            Double userNumber = reader.nextDouble();
            System.out.println("Please enter 'true' if they are a senior or 'false if they are not': ");
            Boolean senior = reader.nextBoolean();

            Residential resident = new Residential(name, phone, address, userNumber, property,senior);
            resident.WeekCharge();
            i = true;
        }else if(userInput.equalsIgnoreCase("Commercial")){
            System.out.println("Please enter the name of the client: ");
            String name = reader.next();
            System.out.println("Please enter their phone number: ");
            String phone = reader.next();
            System.out.println("Please enter their address: ");
            String address = reader.next();
            System.out.println("Please enter the name of the property: ");
            String property = reader.next();
            System.out.println("Please enter the footage: ");
            Double userNumber = reader.nextDouble();

            Commercial commercial = new Commercial(name, phone, address,userNumber, property);


            commercial.WeekCharge();
            i = true;
        }else{
            System.out.println("That is not a supported entry, please try again.\n");
        }
    }catch (Exception a){
        System.out.println("Incorrect data type.");
    }

}






    }
}
