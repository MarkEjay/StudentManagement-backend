package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
  /*  @Bean
  CommandLineRunner commandLineRunner(
          StudentRepository repo
    ){
        return args->{
            Student mark = new Student(
            "Mark",
            "Mark@gmail",
             LocalDate.of(1999, Month.MARCH, 16)

            );
            Student alex = new Student(
                    "Alex",
                    "alex@gmail",
                    LocalDate.of(1998, Month.APRIL, 21)

            );
            Student jack = new Student(
                    "Jack",
                    "Jack@gmail",
                    LocalDate.of(2000, Month.JULY, 10)
            );

            repo.saveAll(
                    List.of(mark,alex,jack)
            );
        };
  }*/
}
