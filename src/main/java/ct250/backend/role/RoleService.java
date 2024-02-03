package ct250.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ArrayList<User> findAll() {
        return (ArrayList<User>) this.userRepository.findAll();
    }

    public User findById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public User findByAccount(String account) {
        return this.userRepository.findUserByAccount(account).orElse(null);
    }

    public void add(User user) {
        if (this.findById(user.getId()) == null) {
            this.userRepository.save(user);
        }
    }


    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }
}
