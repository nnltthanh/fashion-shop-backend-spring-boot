package ct250.backend.privilege;

import ct250.backend.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoleService {

    @Autowired
    private PrivilegeRepository privilegeRepository;

    public ArrayList<Role> findAll() {
        return (ArrayList<Role>) this.privilegeRepository.findAll();
    }

    public Role findById(Long id) {
        return this.privilegeRepository.findById(id).orElse(null);
    }

    public void add(Role role) {
        if (this.findById(role.getId()) == null) {
            this.privilegeRepository.save(role);
        }
    }

    public void deleteById(Long id) {
        this.privilegeRepository.deleteById(id);
    }
}
