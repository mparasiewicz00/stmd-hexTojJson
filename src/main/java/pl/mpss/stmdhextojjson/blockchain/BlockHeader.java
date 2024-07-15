package pl.mpss.stmdhextojjson.blockchain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class BlockHeader {
    @JsonProperty("exm_id")
    private long exmId;
    @JsonProperty("index")
    private int index;
    @JsonProperty("timestamp")
    private long timestamp;
    @JsonProperty("data_len")
    private long dataLen;
    @JsonSerialize(using = ByteArraySerializer.class)
    @JsonProperty("prev_hash")
    private byte[] prevHash = new byte[32];
    @JsonSerialize(using = ByteArraySerializer.class)
    @JsonProperty("hash")
    private byte[] hash = new byte[32];

    // Gettery i Settery
    public long getExmId() { return exmId; }
    public void setExmId(long exmId) { this.exmId = exmId; }
    public int getIndex() { return index; }
    public void setIndex(int index) { this.index = index; }
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
    public long getDataLen() { return dataLen; }
    public void setDataLen(long dataLen) { this.dataLen = dataLen; }
    public byte[] getPrevHash() { return prevHash; }
    public void setPrevHash(byte[] prevHash) { this.prevHash = prevHash; }
    public byte[] getHash() { return hash; }
    public void setHash(byte[] hash) { this.hash = hash; }
}