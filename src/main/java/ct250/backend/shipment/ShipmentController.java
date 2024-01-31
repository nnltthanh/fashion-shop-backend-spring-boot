package ct250.backend.shipment;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping({ "/", "" })
    public ArrayList<Shipment> getAllShipment() {
        return this.shipmentService.findAllShipments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> shipPaymentById(@PathVariable Long id) {
        Shipment shipment = this.shipmentService.findShipmentById(id);
        if (shipment == null) {
            return new ResponseEntity<>("This shipment is not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shipment, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShipmentById(@PathVariable Long id) {
        Shipment shipment = this.shipmentService.findShipmentById(id);
        if (shipment == null) {
            return new ResponseEntity<>("This shipment is not exist", HttpStatus.NOT_FOUND);
        }

        this.shipmentService.deleteShipment(id);
        return new ResponseEntity<>("A shipment with id=" + id + " is deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateShipmentById(@PathVariable Long id, @RequestBody Shipment shipment) {
        if (this.shipmentService.updateShipment(id, shipment) != null) {
            return new ResponseEntity<>("A shipment with id=" + id + " is updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("The notification with id=" + shipment.getId() + " fail updated. Try again!",
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/")
    public ResponseEntity<?> addShipment(@RequestBody Shipment shipment) {
        Shipment isExistedShipment = this.shipmentService.findShipmentById(shipment.getId());
        if (isExistedShipment == null) {
            this.shipmentService.addShipment(shipment);
            return new ResponseEntity<>(shipment, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("The shipment with id=" + shipment.getId() + " existed. Try again!",
                HttpStatus.BAD_REQUEST);
    }
}
