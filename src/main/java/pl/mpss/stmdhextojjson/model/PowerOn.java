package pl.mpss.stmdhextojjson.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

@Setter
@Getter
public class PowerOn {
    @JsonProperty("power_on")
    private boolean powerOn;

    public PowerOn(ByteBuffer buffer) {
        powerOn = buffer.getInt() != 0;
    }

}