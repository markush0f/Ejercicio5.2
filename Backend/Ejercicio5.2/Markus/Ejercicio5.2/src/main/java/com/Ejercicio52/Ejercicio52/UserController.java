package com.Ejercicio52.Ejercicio52;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("")
    public User createUser(@RequestBody UserCreateDto userCreateDto) {
        try {
            // Log para ver el valor de "agree"
            logger.debug("DTO : {}", userCreateDto);

            logger.info("Iniciando metodo createUser");

            // Verificación si el usuario acepta los términos
            // if (!userCreateDto.getAgree()) {
            // logger.trace("You must agree to the terms and conditions");
            // throw new RuntimeException("You must agree to the terms and conditions");
            // }

            // Crear el objeto User con los datos recibidos
            logger.debug("Creating user with provided details...");
            User user = new User(
                    null,
                    userCreateDto.getName(),
                    userCreateDto.getEmail(),
                    userCreateDto.getUrl(),
                    userCreateDto.getComment(),
                    userCreateDto.getAgree(),
                    userCreateDto.getNewsletter());

            logger.debug("User object created: {}", user);

            logger.debug("Attempting to save user...");
            User savedUser = userRepository.save(user);

            logger.debug("User saved successfully: {}", savedUser);

            return savedUser;

        } catch (Exception e) {
            // Log de error en caso de excepciones
            logger.error("Error creating user with email: {}", userCreateDto.getEmail(), e);
            throw new RuntimeException("Error creating user with email: " + userCreateDto.getEmail(), e);
        }
    }

    @PostMapping("/contact")
    public Contact createContact(@RequestBody ContactCreateDto userCreateDto) {
        logger.debug("User {}");
        Contact contact = new Contact(
                null,
                userCreateDto.getEmail(),
                userCreateDto.getName(),
                userCreateDto.getSurname(),
                userCreateDto.getJob(),
                userCreateDto.getLocation());
        return contactRepository.save(contact);
    }
}