package ct250.backend.shipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping({ "/", "" })
    public String getAllShipment() {
        shipmentService.findAllShipments();
        String shipmentList = "";
        for (Shipment shipment : shipmentService.getShipments()) {
            shipmentList += "\n" + shipment.toString();
        }
        return "Call find all shipments function " + shipmentList;
    }

    @GetMapping("/id={id}")
    public String shipPaymentById(@PathVariable Long id) {
        Shipment shipment = shipmentService.findShipmentById(id);
        if (shipment == null) {
            return "Call find shipment by ID " + id + " function\nCan not found shipment with id " + id;
        }
        return "Call find shipment by ID " + id + " function\n" + shipment.toString();
    }

    @DeleteMapping("/delete-id={id}")
    public String deleteShipmentById(@PathVariable Long id) {
        if (shipmentService.deleteShipment(id)) {
            return "Call delete shipment by ID " + id + " function\nShipment with id " + id + " has been deleted!";
        } else if (shipmentService.findShipmentById(id) == null) {
            return "Call delete shipment by ID " + id + " function\nCan not found shipment with id " + id;
        }

        return "Call delete shipment by ID " + id + " function\n" + "Can not delete shipment has id " + id;

    }

    @PutMapping("/update-id={id}")
    public String updateShipmentById(@PathVariable Long id, @RequestBody Shipment shipment) {
        if (shipmentService.updateShipment(id, shipment) != null) {
            return "Call update shipment by ID " + id + " function\n"
                    + shipmentService.updateShipment(id, shipment).toString();
        }
        return "Call update shipment by ID " + id + " function\n" + "Failed Update!!!Not found Shipment";
    }

    @PostMapping("/add")
    public String addShipment(@RequestBody Shipment shipment) {
        shipment = shipmentService.addShipment(shipment);
        if (shipment == null) {
            return "Call add shipment function \n" + "Add shipment failed";
        }
        return "Call add shipment function \n" + shipment.toString();
    }
}
