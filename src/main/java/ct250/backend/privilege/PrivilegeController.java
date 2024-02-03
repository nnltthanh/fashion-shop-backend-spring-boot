package ct250.backend.privilege;

import ct250.backend.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    PrivilegeService privilegeService;

    @GetMapping(value = {"/", ""})
    public ArrayList<Role> getAllRoles() {
        return this.privilegeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable Long id) {
        Role role = this.privilegeService.findById(id);
        if (role == null) {
            return new ResponseEntity<>("This role is not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(role, HttpStatus.FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
//        if (isExistedRole == null) {
            this.privilegeService.add(role);
            return new ResponseEntity<>(role, HttpStatus.CREATED);
//        }
//        return new ResponseEntity<>("The role with id=" + role.getId() + " existed. Try again!", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoleById(@PathVariable Long id) {
        Role role = this.privilegeService.findById(id);
        if (role == null) {
            return new ResponseEntity<>("This role is not exist", HttpStatus.NOT_FOUND);
        }
        this.privilegeService.deleteById(id);
        return new ResponseEntity<>("A role with id=" + id + " is deleted successfully", HttpStatus.OK);
    }
}
