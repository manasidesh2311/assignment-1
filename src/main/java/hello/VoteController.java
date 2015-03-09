package hello;


import org.joda.time.LocalDateTime;
import org.springframework.web.bind.annotation.*;

import org.joda.time.LocalTime;
import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by manasiDeshpande on 3/2/15.
 */

@RestController
public class VoteController {

    //Moderator mod = new Moderator();

    private final AtomicLong modId = new AtomicLong(000);
    private final AtomicLong poId = new AtomicLong(000);
    LocalDateTime localTime = new LocalDateTime();
    HashMap<Long, Moderator> map = new HashMap<Long, Moderator>();
    HashMap<Long, Poll> pMap = new HashMap<Long, Poll>();

    @RequestMapping("/")
    public String welcome() {
        return "Welcome to MyVote";
    }

    @RequestMapping(value = "/moderators", method = RequestMethod.POST)
    public @ResponseBody Moderator createModerator(@RequestBody Moderator mod) {

        long atomicId = modId.incrementAndGet();

        mod.setId(atomicId);
        mod.setCreatedAt(localTime.toString());

        Moderator createMod = new Moderator(mod);

        map.put(atomicId, createMod);

        return mod;
    }

    @RequestMapping(value = "/moderators/{id}", method = RequestMethod.GET)
    public @ResponseBody Moderator getModerator(@PathVariable("id") long id) {

        Moderator getMod;
        getMod = map.get(id);

        return new Moderator(getMod);
    }

    @RequestMapping(value = "/moderators/{id}", method = RequestMethod.PUT)
    public @ResponseBody Moderator updateModerator(@RequestBody Moderator mod, @PathVariable("id") long id) {

        Moderator putMod = map.get(id);

        mod.setId(putMod.getId());
        mod.setName(putMod.getName());
        mod.setCreatedAt(putMod.getCreatedAt());

        map.put(id, mod);

        return mod;
    }

    @RequestMapping(value = "/moderators/{id}/polls", method = RequestMethod.POST)
    public @ResponseBody Poll createPoll(@RequestBody Poll po, @PathVariable("id") long id) {
        long atomicId = poId.incrementAndGet();
        Integer[] postRes = {200, 600};

        po.setId(atomicId);
        po.setResults(postRes);
        po.setModerator(id);

        Poll putPoll = new Poll(po);
        pMap.put(atomicId, putPoll);

        return po;
    }

    @RequestMapping(value = "/polls/{id}", method = RequestMethod.GET)
    public @ResponseBody Poll getPoll(@PathVariable("id") long id) {
        Poll tempPoll;
        tempPoll = pMap.get(id);

        Poll getPoll = new Poll(tempPoll.getId(), tempPoll.getQuestion(), tempPoll.getStarted_at(),
                tempPoll.getExpired_at(), tempPoll.getChoice());

        return getPoll;
    }

    @RequestMapping(value = "/moderators/{modId}/polls/{id}", method = RequestMethod.GET)
    public @ResponseBody Poll getModPoll(@PathVariable("modId") long modId, @PathVariable("id") long id) {
        Poll tempPoll;
        tempPoll = pMap.get(id);

        Poll getPoll;

        if (tempPoll.getModerator() == modId)
            getPoll = new Poll(tempPoll);
        else
            getPoll = new Poll();

        return getPoll;
    }

    @RequestMapping(value = "moderators/{modId}/polls", method = RequestMethod.GET)
    public @ResponseBody Poll[] allPolls(@PathVariable("modId") long modId) {
        Poll[] tempPoll = new Poll[pMap.size()];
        Poll[] getPoll = new Poll[pMap.size()];

        for(long i = 0; i < pMap.size(); i++) {
            tempPoll[(int)i] = pMap.get(i+1);
            if (tempPoll[(int)i].getModerator() == modId) {
                getPoll[(int)i] = new Poll(tempPoll[(int)i]);
            }
            else
                getPoll[(int)i] = new Poll();


        }

        return getPoll;
    }

    @RequestMapping(value = "/moderators/{modId}/polls/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deletePoll(@PathVariable("id") long id) {
        pMap.remove(id);
    }

    @RequestMapping(value = "/polls/{id}?choice={choiceId}", method = RequestMethod.PUT)
    public void votePoll(@PathVariable("id") long id, @RequestParam("choiceId") int choiceId) {

        Poll po = pMap.get(id);
        //int i = (int)choiceId;
        String[] voteChoice = po.getChoice();

        // String[] vote = new String[10];
        voteChoice[0] = voteChoice[choiceId];

        po.setChoice(voteChoice);

        pMap.put(id, po);

    }

}
