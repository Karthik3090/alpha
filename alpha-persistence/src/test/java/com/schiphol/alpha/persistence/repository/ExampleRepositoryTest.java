package com.schiphol.alpha.persistence.repository;

import com.schiphol.alpha.persistence.entity.Driver;
import com.schiphol.alpha.persistence.InMemoryDatabaseConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Configuration
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ExampleRepositoryTest.class})
@Import(InMemoryDatabaseConfiguration.class)
@EnableJpaRepositories(basePackageClasses = {DriverRespository.class})
@Slf4j
public class ExampleRepositoryTest {

    @Autowired
    private DriverRespository driverRepository;

    @Test
    public void shouldPersistExampleInInMemoryDatabase() throws Exception {
        final Driver driver = new Driver();
        driver.setName("Sample");
//        driverRepository.save(driver);
//        assertThat(driverRepository.findAll().size(), is(1));
        //MatcherAssert.assertThat(driverRepository.findAll().get(0)., is("Sample"));
    }
}
