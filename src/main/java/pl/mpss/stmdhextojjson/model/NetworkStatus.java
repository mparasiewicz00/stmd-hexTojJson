package pl.mpss.stmdhextojjson.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.nio.ByteBuffer;

public class NetworkStatus {
    @Setter
    @JsonProperty("signal_strength")
    private int signalStrength;
    @Setter
    @JsonProperty("network_type")
    private int networkType;
    private int unUsed;

    public NetworkStatus(ByteBuffer buffer) {
        signalStrength = buffer.get() & 0xFF;
        networkType = buffer.get() & 0xFF;
        unUsed = buffer.getShort();
    }

}