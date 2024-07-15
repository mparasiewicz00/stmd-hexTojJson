package pl.mpss.stmdhextojjson.model;

import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

@Setter
@Getter
public class Frame {
    private FrameHeader header;

    public Frame(ByteBuffer buffer) {
        header = new FrameHeader(buffer);
    }

}