package ct250.backend.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = { "/", "" })
    // public ArrayList<User> getAllUsers() {
    // return this.userService.findAll();
    // }

    public List<UserDTO> getAllUsers() {
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    // public ResponseEntity<?> getUserById(@PathVariable Long id) {
    // User user = this.userService.findById(id);
    // if (user == null) {
    // return new ResponseEntity<>("This user is not exist", HttpStatus.NOT_FOUND);
    // }
    // return new ResponseEntity<>(user, HttpStatus.FOUND);
    // }

    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.findById(id);
        if (userDTO == null) {
            return new ResponseEntity<>("This user is not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDTO, HttpStatus.FOUND);
    }

    @GetMapping("/account/{account}")
    public ResponseEntity<?> getUserById(@PathVariable String account) {
        User user = userService.findByAccount(account);
        if (user == null) {
            return new ResponseEntity<>("This user is not exist", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        User isExistedUser = this.userService.findByAccount(user.getAccount());
        if (isExistedUser == null) {
            this.userService.add(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("The user with account=" + user.getAccount() + " existed. Try again!",
                HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        UserDTO userDTO = this.userService.findById(id);
        if (userDTO == null) {
            return new ResponseEntity<>("This user is not exist", HttpStatus.NOT_FOUND);
        }
        this.userService.deleteById(id);
        return new ResponseEntity<>("A user with id=" + id + " is deleted successfully", HttpStatus.OK);
    }

    @PostMapping("/loginEmployee")
    public ResponseEntity<?> loginCustomer(@RequestBody User user) {
        User existingUser = userService.findByAccount(user.getAccount());
        if (existingUser == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existingUser, HttpStatus.OK);
    }
}
