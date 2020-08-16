package com.thehecklers.webfluxthymeleaf;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

import java.util.List;

@SpringBootApplication
public class WebfluxThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxThymeleafApplication.class, args);
    }

}

@Controller
class SimpleController {
    @GetMapping("/")
    String loadPage(final Model model) {
        Flux<Person> people = Flux.just(new Person("Alpha", "Bravo"), new Person("Charlie", "Delta"));

        model.addAttribute("people", people);

        return "testpage";
    }
}

@Data
@AllArgsConstructor
class Person {
    private String firstName, lastName;
}