package myPackage;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

class ContactAlreadyExistsException extends Exception
{
	public ContactAlreadyExistsException(String message)
	{
		super(message);
	}
}

class Contact{

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	private String email;
	public Contact()
	{
		
	}
	public Contact(String firstName, String lastName, String address, String city , String state,String zip2, String phoneNumber2, String email){

		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip2;
		this.phoneNumber = phoneNumber2;
		this.email = email;
	}
	
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String toString(){

		return "Details of: "+ firstName+ " "+lastName+"\n"
									+"Address: "+address+"\n"
									+"City: "+city+"\n"
									+"State: "+state+"\n"
									+"Zip: "+zip+"\n"
									+"Phone Number: "+phoneNumber+"\n"
									+"Email: "+email;
	}
}
public class AddressBook 
{
	static ArrayList<Contact> list = new ArrayList<Contact>();
	public static AddressBook addressBook = new AddressBook();
    public static HashMap<String, AddressBook> addressBooks = new HashMap<>();
    public static Contact contact=new Contact();

	static Scanner sc = new Scanner(System.in);
	    
	public static void AddAddressBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of new address book");
        String name = sc.nextLine() ;
        addressBook  = new AddressBook();
        addressBooks.put(name, addressBook) ;
        System.out.println("New addressbook added ");       
             
    }
	
	private void AddDetails()
	{
		System.out.println("How many contats do you want to enter? ");
		int num=sc.nextInt();
		list.add(0,new Contact("omkar", "mali", "palaspe", "panvel", "maharastra", "4000129", "90290642", "omkar@gmail.com"));
		
		for(int i=0;i<num;i++)
		{	
			System.out.println("Enter FirstName");
			String firstName=sc.next();
			System.out.println("Enter LastName");
			String lastName=sc.next();
			System.out.println("Enter Address");
			String address=sc.next();
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
			if(!firstName.equals(list.get(0).getFirstName()))
			{
				list.add( new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
				System.out.println(list);
			}
			else 
			{
				System.out.println("You have already entered this contact");
				break;
			}
			addressBook.toString();
		}	
		addressBook.toString();
	}
	
	public static String Edit() 
	{
		String name;
		System.out.println("Enter First Name of Details to be Edited: ");
		name = sc.next();

		if (name.equals(list.get(0).getFirstName())) 
		{
			System.out.println("Enter FirstName");
			list.get(0).setFirstName(sc.next());
			System.out.println("Enter LastName");
			list.get(0).setLastName(sc.next());
			System.out.println("Enter Address");
			list.get(0).setAddress(sc.next());
			System.out.println("Enter CityName");
			list.get(0).setCity(sc.next());
			System.out.println("Enter StateName");
			list.get(0).setState(sc.next());
			System.out.println("Enter ZipCode");
			list.get(0).setZip(sc.next());
			System.out.println("Enter PhoneNumber");
			list.get(0).setPhoneNumber(sc.next());
			System.out.println("Enter Email");
			list.get(0).setEmail(sc.next());

			System.out.println(list.get(0));
			return "Contact Edited";
		}
		else
		{
			return "Name Not Available in List";
		}
	}
	
	public static String Delete() 
	{
		String name;
		System.out.print("Enter FirstName");
		name =sc.next();

		if (name.equals(list.get(0).getFirstName())) 
		{
			list.remove(0);
			return "Deleted";
		}
		else
		{
			return "Name Not Available in List";
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Welcome To Address Book Problem\n");
		
		AddressBook address = new AddressBook();
	//	AddAddressBook();
		address.AddDetails();
		
		System.out.print("1.Add AddressBook 2.Delete 3.Edit");
		int check=sc.nextInt();
		switch(check)
		{
		case 1:
			AddAddressBook();
			break;
		case 2:
			Delete();
			for(int i=0; i<list.size(); i++)
			{
					System.out.println(list.get(i));
			}
			break;
		case  3:
			Edit();
			for(int i=0; i<list.size(); i++)
			{
					System.out.println(list.get(i));
			}
			break;
		}
			
//		}
//		else
//		{
//			System.out.println("Done");
//		}
//		for(int i=0; i<list.size(); i++)
//		{
//			System.out.println(list.get(i));
//		}
//		System.out.print("Do you want to Delete this Contact ? (y/n)");
//		check=sc.next();
//		if(check.equalsIgnoreCase("y")) 
//		{
//			System.out.println(Delete());
//		}
//		else
//		{
//			System.out.println("Done");
//		}
//		for(int i=0; i<list.size(); i++)
//		{
//			System.out.println(list.get(i));
//		}
//		
	}
}

