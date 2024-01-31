package ct250.backend.warehouse;

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
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping({ "/", "" })
    public String getAllWarehouse() {
        warehouseService.findAllWarehouses();
        String warehouseList = "";
        for (Warehouse warehouse : warehouseService.getWarehouses()) {
            warehouseList += "\n" + warehouse.toString();
        }
        return "Call find all warehouses function " + warehouseList;
    }

    @GetMapping("/{id}")
    public String getWarehouseById(@PathVariable Long id) {
        if (warehouseService.findWarehouseById(id) == null) {
            return "Call find warehouse by ID " + id + " function\nCan not found warehouse has id " + id;
        }
        return "Call find warehouse by ID " + id + " function\n" + warehouseService.findWarehouseById(id).toString();
    }

    @DeleteMapping("/{id}")
    public String deleteWarehouseById(@PathVariable Long id) {
        if (warehouseService.deleteWarehouse(id)) {
            return "Call delete warehouse by ID " + id + " function\n" + "id " + id + " Warehouse has been deleted!";
        } else if (warehouseService.findWarehouseById(id) == null) {
            return "Call delete warehouse by ID " + id + " function\n" + "Can not found warehouse has id " + id;
        }
        return "Call delete warehouse by ID " + id + " function\n" + "Can not delete warehouse has id " + id;
    }

    @PutMapping("/{id}")
    public String updateWarehouseById(@PathVariable Long id, @RequestBody Warehouse warehouse) {
        if (warehouseService.updateWarehouse(id, warehouse) != null) {
            return "Call update warehouse by ID " + id + " function\n"
                    + warehouseService.updateWarehouse(id, warehouse).toString();
        }
        return "Call update warehouse by ID " + id + " function\n" + "Failed Update!!!";
    }

    @PostMapping("/add")
    public String addWarehouse(@RequestBody Warehouse warehouse) {
        warehouse = warehouseService.addWarehouse(warehouse);
        if (warehouse == null) {
            return "Call add warehouse function \n" + "Add warehouse failed"
                    + "\nBecause this phone number or warehouse name already belongs to a warehouse";
        }
        return "Call add warehouse function \n" + warehouse.toString();
    }

}
