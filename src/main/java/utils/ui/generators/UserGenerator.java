package utils.ui.generators;

import utils.ui.data.User;

import java.util.ArrayList;
import java.util.List;

import static utils.RandomDataGenerator.generate;

public class UserGenerator {
    private static UserGenerator instance;

    List<User> users;

    private UserGenerator() {
        users = new ArrayList<>();
    }

    public static UserGenerator getInstance() {
        if (instance == null) {
            instance = new UserGenerator();
        }
        return instance;
    }

    public static User getUser() {
        if (getInstance().users.size() == 0) {
            createUser();
        }
        return getInstance().users.get(getInstance().users.size()-1);
    }

    public static User createUser() {
        User user = new User();
        String userName = generate().randomUserName();
        String userPassword = generate().randomUserPass();
        String name = generate().randomName();
        String lastName = generate().randomLastName();

        user.setUsername(userName);
        user.setName(name);
        user.setLastname(lastName);
        user.setPassword(userPassword);
        user.setConfirmPassword(userPassword);

        getInstance().users.add(user);

        return user;
    }
}
