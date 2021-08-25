package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Board {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("descData")
    @Expose
    private String descData;
    @SerializedName("closed")
    @Expose
    private Boolean closed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescData() {
        return descData;
    }

    public void setDescData(String descData) {
        this.descData = descData;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Board.class.getName()).append('@')
          .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("desc");
        sb.append('=');
        sb.append(((this.desc == null)?"<null>":this.desc));
        sb.append(',');
        sb.append("descData");
        sb.append('=');
        sb.append(((this.descData == null)?"<null>":this.descData));
        sb.append(',');
        sb.append("closed");
        sb.append('=');
        sb.append(((this.closed == null)?"<null>":this.closed));
        sb.append(',');

        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.desc == null)? 0 :this.desc.hashCode()));
        result = ((result* 31)+((this.descData == null)? 0 :this.descData.hashCode()));
        result = ((result* 31)+((this.closed == null)? 0 :this.closed.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Board) == false) {
            return false;
        }
        Board rhs = ((Board) other);
        return ((((((((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id)))
            &&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))
            &&((this.desc == rhs.desc)||((this.desc!= null)&&this.desc.equals(rhs.desc))))
            &&((this.descData == rhs.descData)||((this.descData!= null)&&this.descData.equals(rhs.descData))))
            &&((this.closed == rhs.closed)||((this.closed!= null)&&this.closed.equals(rhs.closed))))));
    }

    public String generateDescription(int length) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";
        String sb = IntStream.range(0, length).map(i -> (int) (AlphaNumericString.length()
            * Math.random())).mapToObj(index -> String.valueOf(AlphaNumericString
            .charAt(index))).collect(Collectors.joining());
        return sb;
    }
}
