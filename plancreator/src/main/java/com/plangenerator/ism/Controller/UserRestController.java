package com.plangenerator.ism.Controller;


import com.plangenerator.ism.Model.User;
import com.plangenerator.ism.Repository.UserRepository;
import com.plangenerator.ism.exceptions.RecordNotFoundException;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Irakli Kardava
 *
 */
@RestController
@RequestMapping("/api/v1/User")
public class UserRestController {


    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserRestController.class);


    @GetMapping
    @ResponseBody
    public User findByUsername(@RequestParam(value = "userName") String userName) {
        logger.debug("**User get by UserName*", userRepository.findByUsername(userName));
        return userRepository.findByUsername(userName);
    }

    @PostMapping
    public void deleteUser(@RequestParam(value = "id") int id) {
        userRepository.deleteById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<User> updateDepartment(
            @RequestParam(value = "id") int id, @RequestBody User userDetails)
            throws RecordNotFoundException {
        User user =
                userRepository
                        .findById(id)
                        .orElseThrow(() -> new RecordNotFoundException(id));
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        final User updateUser = userRepository.save(user);
        logger.debug("**Update User**", userRepository.save(user));
        return ResponseEntity.ok(updateUser);
    }

}
