package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class RandomDataGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(RandomDataGenerator.class);

    public static RandomDataGenerator generate() {
        return new RandomDataGenerator();
    }

    public String randomUserName() {
        String randomString = UUID.randomUUID().toString().substring(5);
        LOGGER.info("Generate random username '" + randomString + "'");
        return randomString;
    }

    public String randomUserPass() {
        String randomString = UUID.randomUUID().toString().substring(5);
        LOGGER.info("Generate random user password '" + randomString + "'");
        return randomString;
    }
}
