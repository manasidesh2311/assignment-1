package hello;
import org.joda.time.DateTime;
import java.lang.Long;
/**
 * Created by manasiDeshpande on 3/1/15.
 */
public class Poll {

    private long id;
    private long moderator;
    private String question;
    private String started_at;
    private String expired_at;
    private String[] choice;
    private Integer[] results;

    public Poll() {}

    public Poll(long id, long moderator, String question, String started_at, String expired_at, String[] choice, Integer[] results) {
        this.id = id;
        this.moderator = moderator;
        this.question = question;
        this.started_at = started_at;
        this.expired_at = expired_at;
        this.choice = choice;
        this.results = results;
    }

    public Poll(long id, long moderator, String question, String started_at, String expired_at, String[] choice) {
        this.id = id;
        this.moderator = moderator;
        this.question = question;
        this.started_at = started_at;
        this.expired_at = expired_at;
        this.choice = choice;
    }

    public Poll(long id, String question, String started_at, String expired_at, String[] choice) {
        this.id = id;
        this.question = question;
        this.started_at = started_at;
        this.expired_at = expired_at;
        this.choice = choice;
    }

    public Poll(Poll poll) {
        this.id = poll.id;
        this.moderator = poll.moderator;
        this.question = poll.question;
        this.started_at = poll.started_at;
        this.expired_at = poll.expired_at;
        this.choice = poll.choice;
        this.results = poll.results;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setModerator(long id) {
        this.moderator = id;
    }

    public long getModerator() {
        return moderator;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setStarted_at(String started) {
        this.started_at = started;
    }

    public String getStarted_at() {
        return started_at;
    }

    public void setExpired_at(String expired) {
        this.expired_at = expired;
    }

    public String getExpired_at() {
        return expired_at;
    }

    public void setChoice(String[] choice) {
        this.choice = choice;
    }

    public String[] getChoice() {
        return choice;
    }

    public void setResults(Integer[] results) {
        this.results = results;
    }

    public Integer[] getResults() {
        return results;
    }
}
