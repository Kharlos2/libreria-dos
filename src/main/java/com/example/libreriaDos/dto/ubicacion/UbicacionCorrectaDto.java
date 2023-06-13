package com.example.libreriaDos.dto.ubicacion;

public class UbicacionCorrectaDto extends UbicacionDto{

    private String id;
    private String floor;
    private String lounge;
    private String shelf;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getLounge() {
        return lounge;
    }

    public void setLounge(String lounge) {
        this.lounge = lounge;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }
}
