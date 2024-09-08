package sessionPart3.session20to29;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

class EAddress {

    private String street;
    private String city;
    private String state;
    private int pincode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
}

class EData {

    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private double salary;
    private EAddress address;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EAddress getAddress() {
        return address;
    }

    public void setAddress(EAddress address) {
        this.address = address;
    }
}

class CompanyAddress {

    private String companyName;
    private String street;
    private String city;
    private String state;
    private int pincode;
    private List<String> bankAccount;
    private List<EData> employeeData;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public List<String> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(List<String> bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<EData> getEmployeeData() {
        return employeeData;
    }

    public void setEmployeeData(List<EData> employeeData) {
        this.employeeData = employeeData;
    }
}

public class Session23_ComplexDemoNestedPayload {

    @Test
    public void createUser() throws JsonProcessingException {

        CompanyAddress companyAdd = new CompanyAddress();
        companyAdd.setCompanyName("XYZ Limited");
        companyAdd.setCity("Mumbai");
        companyAdd.setStreet("Andheri");
        companyAdd.setPincode(11111);
        companyAdd.setState("Maharashtra");

        List<String> banks = new ArrayList<>();
        banks.add("SBI");
        banks.add("HDFC");
        banks.add("AXIS");

        companyAdd.setBankAccount(banks);

        EData emp1 = new EData();
        emp1.setFirstName("Rinku");
        emp1.setLastName("Kalam");
        emp1.setGender("Male");
        emp1.setAge(31);
        emp1.setSalary(10000);

        EAddress address1 = new EAddress();
        address1.setStreet("Badlapur Road");
        address1.setCity("Indore");
        address1.setState("Madhya Pradesh");
        address1.setPincode(331023);

        emp1.setAddress(address1);

        EData emp2 = new EData();
        emp2.setFirstName("Akshay");
        emp2.setLastName("Kalam");
        emp2.setGender("Male");
        emp2.setAge(31);
        emp2.setSalary(10000);

        EAddress address2 = new EAddress();
        address2.setStreet("NDA Road");
        address2.setCity("Pune");
        address2.setState("MH");
        address2.setPincode(431023);

        emp2.setAddress(address2);

        EData emp3 = new EData();
        emp3.setFirstName("Jitendra");
        emp3.setLastName("Singh");
        emp3.setGender("Male");
        emp3.setAge(41);
        emp3.setSalary(210000);

        EAddress address3 = new EAddress();
        address3.setStreet("Ranchi Chowk");
        address3.setCity("Mirzapur");
        address3.setState("Manipur");
        address3.setPincode(231023);

        emp3.setAddress(address3);

        List<EData> list = new ArrayList<>();

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        companyAdd.setEmployeeData(list);

        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(companyAdd);
        System.out.println(body);
         // Uncomment to send request
         RestAssured.baseURI = "https://httpbin.org/post";
         RequestSpecification reqSpec = RestAssured.given();
         reqSpec.body(body);
         reqSpec.contentType(ContentType.JSON);
         Response res = reqSpec.post();
         ValidatableResponse valRes = res.then().log().all().statusCode(200);
    }
}
