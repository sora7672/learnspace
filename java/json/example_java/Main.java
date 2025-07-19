import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;

class Car{
    public String brand;
    public String originCountry;
    public String owner_name = "Nobody";
    public Integer buildyear;
    public Boolean electric = false;

    @JsonIgnore
    public String jsonPath = "car.json";

    @JsonIgnore
    public String personalPasskey;


    public Car(String brand, Integer buildyear){
        this.brand = brand;
        this.buildyear = buildyear;
    }

    public Integer age(){
        if (this.buildyear == null){
            return 0;
        }
        return 2025 - this.buildyear;
    }

    public void saveAsJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(this.jsonPath), this);
        } catch (IOException err) {
            System.out.println("Error while writing the Car object into a JSON file("+ this.jsonPath +"): " + err.getMessage());
        }
    }

    public static Car loadFromJson(){
        return loadFromJson("car.json");
    }

    public static Car loadFromJson(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(new File(filePath));

            String brand = root.get("brand").asText();
            Integer buildyear = root.get("buildyear").asInt();

            return new Car(brand, buildyear);

        } catch (IOException err) {
            System.out.println("Error while reading in the JSON file (" + filePath + "): " + err.getMessage());
            return null;
        }
    }

}

class TestObject{

    public String name = "John";
    public Integer age = 27;

    @JsonIgnore
    public String password = "start123";

}


class Tester{

    private static String jsonPath = "test.json";

    public static void writeJson(){
        ObjectMapper mapper = new ObjectMapper();
        TestObject myTest = new TestObject();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonPath), myTest);
        } catch (IOException err) {
            System.out.println("Error while writing the Car object into a JSON file("+ jsonPath +"): " + err.getMessage());
        }
    }

    public static void readJson(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(new File(jsonPath));

            System.out.println(root.toPrettyString());

        } catch (IOException err) {
            System.out.println("Error while reading in the JSON file (" + jsonPath + "): " + err.getMessage());
            return;
        }

    }
}


public class Main {
    public static void main(String[] args) {


        /*
        * Comment back in whatever you want to use/test!
        */

        // basic usage

        Tester.writeJson();

        Tester.readJson();




        // Advanced usage to create objects and save them

        /*
        Car audi = new Car("Audi", 2012);

        audi.originCountry = "Germany";
        audi.personalPasskey = "45RJ99"; // This gets ignored by json

        audi.saveAsJson();
        Car banana = Car.loadFromJson();
        System.out.println(banana.personalPasskey);
        System.out.println(banana.buildyear);
        */




    }
}