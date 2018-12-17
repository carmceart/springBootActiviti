package org.cgenh.springBoot.activiti;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.cgenh.springBoot.activiti.dao.CompRepository;
import org.cgenh.springBoot.activiti.dao.PersonRepository;
import org.cgenh.springBoot.activiti.entity.Comp;
import org.cgenh.springBoot.activiti.entity.Person;
import org.cgenh.springBoot.activiti.service.ActivitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan("org.cgenh.springBoot.activiti.controller")
@EnableJpaRepositories("org.cgenh.springBoot.activiti.dao")
@EntityScan("org.cgenh.springBoot.activiti.entity")
public class ActivitiApplication {
    @Autowired
    private CompRepository compRepository;
    @Autowired
    private PersonRepository personRepository;


    public static void main(String[] args) {
        SpringApplication.run(ActivitiApplication.class, args);
    }

    //初始化模拟数据
    @Bean
    public CommandLineRunner init(final ActivitiService myService) {
        return new CommandLineRunner() {
            public void run(String... strings) throws Exception {
                if (personRepository.findAll().size() == 0) {
                    personRepository.save(new Person("wtr"));
                    personRepository.save(new Person("wyf"));
                    personRepository.save(new Person("admin"));
                }
                if (compRepository.findAll().size() == 0) {
                    Comp group = new Comp("great company");
                    compRepository.save(group);
                    Person admin = personRepository.findByPersonName("admin");
                    Person wtr = personRepository.findByPersonName("wtr");
                    admin.setComp(group); wtr.setComp(group);
                    personRepository.save(admin); personRepository.save(wtr);
                }
            }
        };
    }
}
