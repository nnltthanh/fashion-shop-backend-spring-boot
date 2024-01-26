package ct250.backend.shipment;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    private ArrayList<Shipment> shipments;

    public ShipmentService(ArrayList<Shipment> shipments) {
        this.shipments = shipments;
    }

    public ShipmentService() {
        this.shipments = new ArrayList<>();
    }

    public ArrayList<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(ArrayList<Shipment> shipments) {
        this.shipments = shipments;
    }

    public ArrayList<Shipment> findAllShipments() {
        System.out.println("Call find all shipments function");
        this.shipments = (ArrayList<Shipment>) shipmentRepository.findAll();
        for (Shipment a : shipments) {
            System.out.println(a.toString());
        }
        return shipments;
    }

    public Shipment findShipmentById(Long id) {
        return shipmentRepository.findById(id).orElse(null);
    }

    @Transactional
    public Shipment addShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    @Transactional
    public Shipment updateShipment(Long id, Shipment shipment) {
        Shipment existingShipment = findShipmentById(id);
        if (existingShipment != null) {
            // Update fields based on your requirements
            // existingShipment.setShipDate(shipment.getShipDate());
            existingShipment.setStatus(shipment.getStatus());
            existingShipment.setMethod(shipment.getMethod());

            shipmentRepository.save(existingShipment);
            return existingShipment;
        }
        return null;
    }

    @Transactional
    public boolean deleteShipment(Long id) {
        Shipment resultFindShipment = findShipmentById(id);
        if (resultFindShipment != null) {
            shipmentRepository.delete(resultFindShipment);
            return true;
        } else {
            return false;
        }
    }
}
