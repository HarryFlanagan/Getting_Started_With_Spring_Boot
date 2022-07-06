package com.example.demo.graduate;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraduateConfig {

  @Bean
  CommandLineRunner commandLineRunner(GraduateRepository repository) {
    return args -> {
      Graduate harry = new Graduate(1L, "Harry", "harry@overstock.com", LocalDate.of(1997, Month.JUNE, 30));
      Graduate tara = new Graduate(2L, "Tara", "tara@overstock.com", LocalDate.of(1999, Month.NOVEMBER, 9));
      Graduate jamie = new Graduate(3L, "Jamie", "jamie@overstock.com", LocalDate.of(1996, Month.MAY, 28));

      repository.saveAll(List.of(harry, tara, jamie));
    };
  }

}
