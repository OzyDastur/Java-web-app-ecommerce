package com.cocordia.crud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.concordia.crud.model.User;
import com.concordia.crud.repository.UserRepository;

@SpringBootApplication
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class UserRepositoryTests {
    
    @Autowired
    UserRepository userRepository;

 
    @Test
    public void testUserSave() {
        User user = new User("Bob","Bobby","123","12345467","bob@gmail.com","Admin","Today");
        userRepository.save(user);
        User newUser = userRepository.findByEmailAddress("bob@gmail.com");
        assertNotNull(user);
        assertEquals(newUser.getEmailAddress(), user.getEmailAddress());
    }


}