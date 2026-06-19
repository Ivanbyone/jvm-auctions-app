package io.ivanbyone.backend.core.service;

import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandomDataService {

    private final Faker faker;

    @Autowired
    public RandomDataService(Faker faker) {
        this.faker = faker;
    }

    public String title() {
        return faker.book().title();
    }

    public String description() {
        return "Designed by " + faker.book().author();
    }

    public int supply() {
        return faker.number().numberBetween(2, 50);
    }
}
