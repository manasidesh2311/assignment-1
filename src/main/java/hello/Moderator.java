package hello;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import java.io.Serializable;


/**
 * Created by manasiDeshpande on 3/1/15.
 */
public class Moderator implements Serializable{
    private long id;
    private String name;
    private String email;
    private String password;
    private String created_at;

    public Moderator() {}

    public Moderator(long id, String name, String email, String password, String dateTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.created_at = dateTime;
    }

    public Moderator(Moderator mod) {
        this.id = mod.id;
        this.name = mod.name;
        this.email = mod.email;
        this.password = mod.password;
        this.created_at = mod.created_at;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {

        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {

        return password;
    }

    public void setCreatedAt(String created) {
        this.created_at = created;
    }

    public String getCreatedAt() {
        return created_at;
    }
}
