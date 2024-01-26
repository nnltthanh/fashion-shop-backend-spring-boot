package ct250.backend.warehouse;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    private ArrayList<Warehouse> warehouses;

    public WarehouseService(ArrayList<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public WarehouseService() {
        this.warehouses = new ArrayList<>();
    }

    public ArrayList<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(ArrayList<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public ArrayList<Warehouse> findAllWarehouses() {
        System.out.println("Call find all warehouses function");
        this.warehouses = (ArrayList<Warehouse>) warehouseRepository.findAll();
        for (Warehouse warehouse : warehouses) {
            System.out.println(warehouse.toString());
        }
        return warehouses;
    }

    public Warehouse findWarehouseById(Long id) {
        return warehouseRepository.findById(id).orElse(null);
    }

    @Transactional
    public Warehouse addWarehouse(Warehouse warehouse) {
        if (!(warehouseRepository.findOneByPhone(warehouse.getPhone()).equals(Optional.empty())
                && warehouseRepository.findOneByName(warehouse.getName()).equals(Optional.empty()))) {
            System.out.println("This phone number or warehouse name already belongs to a warehouse");
            return null;
        } else {
            return warehouseRepository.save(warehouse);
        }
    }

    @Transactional
    public Warehouse updateWarehouse(Long id, Warehouse warehouse) {
        Warehouse existingWarehouse = findWarehouseById(id);
        if (existingWarehouse != null) {
            // Update fields based on your requirements
            existingWarehouse.setName(warehouse.getName());
            existingWarehouse.setAddress(warehouse.getAddress());
            existingWarehouse.setPhone(warehouse.getPhone());

            warehouseRepository.save(existingWarehouse);
            return existingWarehouse;
        }
        return null;
    }

    @Transactional
    public boolean deleteWarehouse(Long id) {
        Warehouse resultFindWarehouse = findWarehouseById(id);
        if (resultFindWarehouse != null) {
            warehouseRepository.delete(resultFindWarehouse);
            return true;
        } else {
            return false;
        }
    }
}
