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
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("idMemberCreator")
    @Expose
    private Boolean idMemberCreator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getClosed() {
        return idMemberCreator;
    }

    public void setClosed(Boolean closed) {
        this.idMemberCreator = closed;
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
        sb.append("idMemberCreator");
        sb.append('=');
        sb.append(((this.idMemberCreator == null)?"<null>":this.idMemberCreator));
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
        result = ((result* 31)+((this.idMemberCreator == null)? 0 :this.idMemberCreator.hashCode()));
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
            &&((this.idMemberCreator == rhs.idMemberCreator)||((this.idMemberCreator!= null)&&
            this.idMemberCreator.equals(rhs.idMemberCreator))))))));
    }

    public static String generateString(int length) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";
        String sb = IntStream.range(0, length).map(i -> (int) (AlphaNumericString.length()
            * Math.random())).mapToObj(index -> String.valueOf(AlphaNumericString
            .charAt(index))).collect(Collectors.joining());
        return sb;
    }
}
