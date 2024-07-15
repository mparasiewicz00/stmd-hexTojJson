package pl.mpss.stmdhextojjson.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

@Setter
@Getter
public class FrameHeader {
    @JsonProperty("frame_type")
    private int frameType;
    @JsonProperty("frame_content_type")
    private int frameContentType;
    @JsonProperty("frame_size_content")
    private Object frameSizeContent;

    public FrameHeader(ByteBuffer buffer) {
        frameType = buffer.get() & 0xFF;
        frameContentType = buffer.get() & 0xFF;
        switch (frameContentType) {
            case 249: frameSizeContent = new Location(buffer); break;
            case 250: frameSizeContent = new BatteryStatus(buffer); break;
            case 251: frameSizeContent = new NetworkStatus(buffer); break;
            case 252: frameSizeContent = new Uptime(buffer); break;
            case 253: frameSizeContent = new PowerOn(buffer); break;
            case 254: frameSizeContent = new PowerOff(buffer); break;
            default: frameSizeContent = null;
        }
    }

}