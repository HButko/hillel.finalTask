package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
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

    public String randomName() {
        String randomString = UUID.randomUUID().toString().substring(5);
        LOGGER.info("Generate random user name '" + randomString + "'");
        return randomString;
    }

    public String randomLastName() {
        String randomString = UUID.randomUUID().toString().substring(5);
        LOGGER.info("Generate random user last name '" + randomString + "'");
        return randomString;
    }

    public String randomJobTitle() {
        String randomString = UUID.randomUUID().toString().substring(5);
        LOGGER.info("Generate random job title '" + randomString + "'");
        return randomString;
    }

    public String randomJobDescription() {
        String randomString = UUID.randomUUID().toString().substring(5);
        LOGGER.info("Generate random job description '" + randomString + "'");
        return randomString;
    }

    public double randomPrice() {
        int rangeMin = 100;
        int rangeMax = 1000;

        double result = rangeMin + (rangeMax - rangeMin) * new Random().nextDouble();
        BigDecimal bd = new BigDecimal(result);

        double randomDouble = bd.setScale(6, RoundingMode.HALF_UP).doubleValue();
        LOGGER.info("Generate random double '" + randomDouble + "'");
        return randomDouble;
    }

    public String randomCommentMessage() {
        String randomString = UUID.randomUUID().toString().substring(5);
        LOGGER.info("Generate random job description '" + randomString + "'");
        return randomString;
    }

    public String randomCommentDate() {
        String randomString = UUID.randomUUID().toString().substring(5);
        LOGGER.info("Generate random job description '" + randomString + "'");
        return randomString;
    }
}
