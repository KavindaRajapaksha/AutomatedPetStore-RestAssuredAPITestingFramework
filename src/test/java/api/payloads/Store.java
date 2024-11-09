package api.payloads;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Store {
    private int id;
    private int petId;
    private int quantity;
    private LocalDateTime shipDate;
    private String status;
    private boolean complete;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDateTime shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    
    public static void main(String[] args) {
        Store store = new Store();
        String shipDateString = "2024-11-09T10:58:21.446+0000";
        
 
        String dateWithoutTimezone = shipDateString.split("\\+")[0];

        // Parse the date part to LocalDateTime (ISO format without time zone)
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime shipDate = LocalDateTime.parse(dateWithoutTimezone, formatter);

        // Set the shipDate in the store object
        store.setShipDate(shipDate);

        // Output the result
        System.out.println("Ship Date: " + store.getShipDate());
    }
}
