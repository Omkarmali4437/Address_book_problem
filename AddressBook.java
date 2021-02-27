package myPackage;
import java.util.Scanner;

class Contact{

	public final String firstName;
	public final String lastName;
	public final String area;
	public final String city;
	public final String state;
	public final String zip;
	public final String phoneNumber;
	public final String email;

	public Contact(String firstName, String lastName, String area, String city , String state, String zip, String phoneNumber, String email){

		this.firstName = firstName;
		this.lastName = lastName;
		this.area = area;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String toString(){

		return "Details of: "+ firstName+ " "+lastName+"\n"
									+"Area: "+area+"\n"
									+"City: "+city+"\n"
									+"State: "+state+"\n"
									+"Zip: "+zip+"\n"
									+"Phone Number: "+phoneNumber+"\n"
									+"Email: "+email;
	}
}
public class AddressBook {
	private int numOfPerson = 0;
	private Contact[] contact;

	public AddressBook(){
		contact = new Contact[3];
	}

	public void details(String firstName, String lastName, String area, String city , String state, String zip, String phoneNumber1, String email){
		contact [ numOfPerson ] = new Contact(firstName, lastName, area, city, state, zip, phoneNumber1, email);
		numOfPerson++;
	}

	private void AddDetails(){
		for (int i=0; i<numOfPerson; i++){
			System.out.println(contact[i]);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome To Address Book Problem\n");
		
		AddressBook address = new AddressBook();
		address.details("Omkar", "Mali", "Palaspe", "Panvel", "Maharashtra", "4406716", "8817171", "omkar@gmail.com");
		address.AddDetails();
		
		Scanner sc=new Scanner(System.in);		
		System.out.println("Number Of Details to Add");
		int numOfPerson=sc.nextInt();
		String name=sc.nextLine();
		for (int i = 1; i <= numOfPerson; i++) 
		{
			System.out.println("Enter no. of details of: "+i);

			System.out.println("Enter FirstName");
			String firstName=sc.next();
			System.out.println("Enter LastName");
			String lastName=sc.next();
			System.out.println("Enter Area");
			String area=sc.next();
			System.out.println("Enter CityName");
			String city=sc.next();
			System.out.println("Enter StateName");
			String state=sc.next();
			System.out.println("Enter ZipCode");
			String zip=sc.next();
			System.out.println("Enter PhoneNumber");
			String phoneNumber=sc.next();
			System.out.println("Enter Email");
			String email=sc.next();

			address.details(firstName, lastName, area, city, state, zip, phoneNumber, email);
			address.AddDetails();

		}
	}
}
