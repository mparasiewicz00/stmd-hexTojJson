package pl.mpss.stmdhextojjson.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

@Setter
@Getter
public class PowerOff {
    @JsonProperty("power_off")
    private boolean powerOff;

    public PowerOff(ByteBuffer buffer) {
        powerOff = buffer.getInt() != 0;
    }

}