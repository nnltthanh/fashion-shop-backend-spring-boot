package ct250.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({ "/", "" })
    public String getAllUser() {
        userService.findAllUser();
        String userList = "";
        for (User user : userService.getUsers()) {
            userList += "\n" + user.toString();
        }
        return "Call find all users function " + userList;
    }

    @GetMapping("/id={id}")
    public String getUserById(@PathVariable Long id) {
        if (userService.findUserById(id) == null) {
            return "Call find user by ID " + id + " function\nCan not found user has id " + id;
        }
        return "Call find user by ID " + id + " function\n" + userService.findUserById(id).toString();
    }

    @DeleteMapping("/delete-id={id}")
    public String deleteUserById(@PathVariable Long id) {
        if (userService.deleteUser(id)) {
            return "Call delete user by ID " + id + " function\n" + "id " + id + " User has been deleted!";
        } else if (userService.findUserById(id) == null) {
            return "Call delete user by ID " + id + " function\n" + "Can not found user has id " + id;
        }
        return "Call delete user by ID " + id + " function\n" + "Can not delete user has id " + id;
    }

    @PutMapping("/update-id={id}")
    public String updateUserById(@PathVariable Long id, @RequestBody User user) {
        if (userService.updateUser(id, user) != null) {
            return "Call update user by ID " + id + " function\n" + userService.updateUser(id, user).toString();
        }
        return "Call update user by ID " + id + " function\n" + "Wrong username!";
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        user = userService.addUser(user);
        if (user == null) {
            return "Call add user function \n" + "Username has been exist";
        }
        return "Call add user function \n" + user.toString();
    }
}