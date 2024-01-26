package ct250.backend.user;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private ArrayList<User> users;

    public UserService(ArrayList<User> users) {
        this.users = users;
    }

    public UserService() {
        this.users = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public User findUserById(Long id) {
        System.out.println("Call find user by ID function");
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            System.out.println("Can not found user has id " + id);
            return null;
        } else
            System.out.println(user.get());

        return user.get();
    }

    public User findUserByUsername(String username) {
        Optional<User> user = userRepository.findOneByUsername(username);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public ArrayList<User> findAllUser() {
        System.out.println("Call find all users function");
        this.users = (ArrayList<User>) userRepository.findAll();
        for (User a : users) {
            System.out.println(a.toString());
        }
        return users;
    }

    @Transactional
    public User addUser(User user) {
        if (!userRepository.findOneByUsername(user.getUsername()).equals(Optional.empty())) {
            System.out.println(userRepository.findOneByUsername(user.getUsername()));
            System.out.println("Username has been exist");
            return null;
        } else {
            return userRepository.save(user);
        }
    }

    @Transactional
    public User updateUser(Long id, User user) {
        System.out.println("Call update user function");
        User temp = findUserById(id);
        if (temp != null) {
            if (findUserById(id).getUsername().equals(user.getUsername())) {
                temp.setPassword(user.getPassword());
                System.out.println("Reset new password successfully");
                System.out.println(temp);
                userRepository.save(temp);
                return temp;
            } else {
                System.out.println("Wrong username!!");
            }
        } else {
            System.out.println("Can not found user has id " + id);
        }
        return null;
    }

    @Transactional
    public boolean deleteUser(Long id) {
        userRepository.delete(findUserById(id));
        return findUserById(id) == null;
    }

}
