package myPackage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
	public static AddressBook addressBook = new AddressBook(null);
    public static Contact contact=new Contact();

	static Scanner sc = new Scanner(System.in);
	public static ArrayList<AddressBook> book = new ArrayList<>();
	public HashMap<String,String> citydict=new HashMap<>();
	public HashMap<String,String> statedict=new HashMap<>();
	
	public AddressBook(String str) {
			}

	public static void defaultBook() {
        book.add(new AddressBook("default address book"));
        book.add(new AddressBook("Address Book 1"));
        book.add(new AddressBook("Address Book 2"));
    }
	
	public void DefaultContact()
	{
		book.get(0).list.add(new Contact("omkar", "mali", "palaspe", "mumbai", "maharashtra", "4000129", "90290642", "omkar@gmail.com"));
		book.get(0).list.add(new Contact("sumit", "wagh", "tilaknagar", "mumbai", "maharashtra", "400089", "816979161", "sumit@gmail.com"));
		book.get(1).list.add(new Contact("surendra", "chouhan", "wadala", "mumbai", "rajastan", "4000012", "8181818818", "surendra@gmail.com"));
		book.get(1).list.add(new Contact("nikhil", "tiwari", "wadala", "thane", "bihar", "4000012", "1121221", "nikhil@gmail.com"));
		book.get(2).list.add(new Contact("gaurav", "purao", "kohinoor", "thane", "tamilnadu", "4040091", "82828882", "gaurav@gmail.com"));
	}
	

    public static void addAddressBook() {
        System.out.print("Enter name of new Address Book: ");
        String str=sc.next();
        book.add(new AddressBook(str));
    }
    
	public void Searchpersonwithcity()
	{
		System.out.println("Enter city for the contact info: ");
		String city=sc.next();
		list.stream().filter(p->city.equals(p.getCity())).forEach(System.out::println);
	}
	
	public void Searchpersonwithstate()
	{
		System.out.println("Enter state for the contact info: ");
		String state=sc.next();
		list.stream().filter(p->state.equals(p.getState())).forEach(System.out::println);
	}
	
	public void PersonCityDictionary()
	{

		System.out.println("Enter the city name to search for contacts: ");
		String city=sc.next();
		book.forEach(address -> address.list.stream()
                .filter(contact -> contact.getCity().equals(city))
                .forEach(contact -> citydict.put(contact.getFirstName(), contact.getCity())));

		citydict.forEach((key, value) -> System.out.println("Name: "+key));
		System.out.println("Count is: "+citydict.size());
		
	}
	
	public void PersonStateDictionary()
	{
		System.out.println("Enter the state name to search for contacts: ");
		String state=sc.next();
		book.forEach(address -> address.list.stream()
                .filter(contact -> contact.getState().equals(state))
                .forEach(contact -> statedict.put(contact.getFirstName(), contact.getState())));
               
		statedict.forEach((key, value) -> System.out.println("Name: "+key));
		System.out.println("Count is: "+statedict.size());
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
		}	
		Comparator<Contact> list1 = Comparator.comparing(Contact::getFirstName);
		System.out.println("\n After Sorting the contact details are: \n");		
		list.stream()
        .sorted(list1)
        .forEach(System.out::println);
	}
	
	public void sortbyCity()
	{
		Comparator<Contact> list1 = Comparator.comparing(Contact::getState);
		System.out.println("\n After Sorting the contact details by city : \n");		
		list.stream()
        .sorted(list1)
        .forEach(System.out::println);

	}
	
	public void sortbyState()
	{
		Comparator<Contact> list1 = Comparator.comparing(Contact::getCity);
		System.out.println("\n After Sorting the contact details by State : \n");		
		list.stream()
        .sorted(list1)
        .forEach(System.out::println);

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
		
		AddressBook address = new AddressBook(null);
		address.defaultBook();
		address.DefaultContact();
		System.out.print("1.Add AddressBook 2.Add Contact 3.Delete 4.Edit\n"
				+ "5.Search for contacts based on city 6.Search for contacts based on state\n"
				+ "7.To see name of a person based on city 8.To see name of a person based on state\n");
		int check=sc.nextInt();
		
		switch(check)
		{
		case 1:
			addAddressBook();
			break;
		case 2:
			address.AddDetails();
			address.sortbyCity();
			address.sortbyState();
			break;
		case  3:
			Delete();
			for(int i=0; i<list.size(); i++)
			{
					System.out.println(list.get(i));
			}
			break;
		case 4:
			Edit();
			for(int i=0; i<list.size(); i++)
			{
					System.out.println(list.get(i));
			}
			break;
		case 5:
			address.Searchpersonwithcity();
			break;
		case 6:
			address.Searchpersonwithstate();
			break;
		case 7:
			address.PersonCityDictionary();
			break;
		case 8:
			address.PersonStateDictionary();
			break;
		default:
			System.out.println("Wrong input");
		}
		
			
	}
}

