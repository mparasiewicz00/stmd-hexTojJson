package pl.mpss.stmdhextojjson.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

@Setter
@Getter
public class BatteryStatus {
    @JsonProperty("voltage_percent")
    private int voltagePercent;
    @JsonProperty("charging")
    private boolean charging;

    public BatteryStatus(ByteBuffer buffer) {
        voltagePercent = buffer.getShort();
        charging = buffer.getShort() != 0;
    }

}