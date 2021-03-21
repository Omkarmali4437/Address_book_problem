package com.myPackage;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.net.URI;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.google.gson.*;
import org.json.simple.JSONObject;


public class AddressBook {
    static ArrayList<Contact> list = new ArrayList<Contact>();
    public static AddressBook addressBook = new AddressBook(null);
    public static Contact contact=new Contact();

    static Scanner sc = new Scanner(System.in);
    public static ArrayList<AddressBook> book = new ArrayList<>();
    public HashMap<String,String> citydict=new HashMap<>();
    public HashMap<String,String> statedict=new HashMap<>();

    public Path path=Paths.get("C://Users//DELL//Development//Eclipseworkspace//AddressBook/addressbook.txt");
    public static final String csv_path="C://Users//DELL//Development//Eclipseworkspace//AddressBook/AddressBook.csv";
    public static final String json_file="C://Users//DELL//Development//Eclipseworkspace//AddressBook/AddressBook.json";

    public AddressBook(String str) {
    }

    public static void defaultBook() {
        book.add(new AddressBook("default address book"));
        book.add(new AddressBook("Address Book 1"));
        book.add(new AddressBook("Address Book 2"));
    }

    public void DefaultContact()
    {
        book.get(0).list.add(new Contact("arjun", "bhanushali", "lalbaug", "mumbai", "maharashtra", "400014", "77187642", "arajun@gmail.com"));
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


    private void AddDetails() throws IOException
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

    public void writeData() throws IOException{
        StringBuffer buffer=new StringBuffer();

        for(int i=0;i<list.size();i++) {
            Files.write(path,list.toString().getBytes());
        }
    }

    public void readData() throws IOException {
        Files.lines(path).forEach(System.out::println);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void writeDataintoCSV() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException{
        try
        {
            FileWriter writer = new
                FileWriter(csv_path);
        ColumnPositionMappingStrategy mappingStrategy=
                new ColumnPositionMappingStrategy();
        mappingStrategy.setType(Contact.class);

        String[] columns = new String[]
                { "FirstName", "LastName", "Address", "City", "State", "Zip", "PhoneNumber", "Email" };

        mappingStrategy.setColumnMapping(columns);

        StatefulBeanToCsvBuilder<Contact> builder=
                new StatefulBeanToCsvBuilder(writer);
        StatefulBeanToCsv beanWriter =
                builder.withMappingStrategy(mappingStrategy).build();

        beanWriter.write(list);
        writer.close();

    }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void readDatafromCsv() throws IOException{
        try {
            CSVReader reader = new CSVReader(new FileReader(csv_path));
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void writeintoJsonFile() throws IOException{
        JSONObject obj=new JSONObject();
        try {
            for(Contact c: list) {
                obj.put("First name: ", c.getFirstName());
                obj.put("Last name: ",c.getLastName());
                obj.put("Address: ",c.getAddress());
                obj.put("City: ", c.getCity());
                obj.put("State: ", c.getState());
                obj.put("Zipcode: ", c.getZip());
                obj.put("Phone-number: ", c.getPhoneNumber());
                obj.put("Email: ", c.getEmail());
                FileWriter writer=new FileWriter(json_file);
                writer.write(obj.toJSONString());
                writer.flush();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
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

    public void choiceWriteRead() {
        AddressBook address = new AddressBook(null);
        address.defaultBook();
        System.out.println("1.To write to .txt file, \n"
                + "2.To write to .csv file, \n"
                + "3.To write to .json.file");
        int num=sc.nextInt();
        try {
            switch(num)
            {
                case 1:
                    address.writeData();
                    address.readData();
                    break;
                case 2:
                    address.writeDataintoCSV();
                    address.readDatafromCsv();
                    break;
                case 3:
                    address.writeintoJsonFile();
                    break;
                default:
                    System.out.println("Wrong input please enter again");
                    address.choiceWriteRead();
                    break;
            }
        }catch(Exception e) {
            e.printStackTrace();
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
                + "7.To see name of a person based on city 8.To see name of a person based on state\n"
                + "9.Sort by City 10.Sort by State\n");
        int check=sc.nextInt();

        switch(check)
        {
            case 1:
                addAddressBook();
                break;
            case 2:
                try {
                    address.AddDetails();
                    address.choiceWriteRead();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
            case 9:
                address.sortbyCity();
                break;
            case 10:
                address.sortbyState();
                break;
            default:
                System.out.println("Wrong input");
        }


    }
}
