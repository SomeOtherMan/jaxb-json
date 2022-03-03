package by.kustarev.json;

import by.kustarev.json.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {

    private static final String FILE_NAME = "./users.json";

    private static void toJSON(User user) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(FILE_NAME), user);
        System.out.println("JSON created!");
    }

    private static User toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(FILE_NAME), User.class);
    }

    public static void main(String[] args) throws IOException {
        User first = new User(1L, "Ivan", "375336268978", "1");

        toJSON(first);
        System.out.println("Записали");

        User user = toJavaObject();
        System.out.println(user);
    }

}
