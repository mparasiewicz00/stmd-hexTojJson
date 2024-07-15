package pl.mpss.stmdhextojjson.model;

import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

@Setter
@Getter
public class Location {
    private short latitude;
    private short longitude;

    public Location(ByteBuffer buffer) {
        latitude = buffer.getShort();
        longitude = buffer.getShort();
    }

}