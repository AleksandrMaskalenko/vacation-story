import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppTest {
    private List<Friend> friends = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        HashMap<String, Integer> lisaList = new HashMap<>();
        lisaList.put("Cake", 5);
        lisaList.put("Hotel", 120);
        lisaList.put("Museum ticket", 20);
        Friend friend1 = new Friend("Lisa", lisaList);

        HashMap<String, Integer> hansList = new HashMap<>();
        hansList.put("Museum ticket1", 20);
        hansList.put("Museum ticket", 20);
        hansList.put("Dinner", 34);
        Friend friend2 = new Friend("Hans", hansList);

        HashMap<String, Integer> ivanList = new HashMap<>();
        ivanList.put("Railway tickets", 48);
        ivanList.put("Supper", 33);
        Friend friend3 = new Friend("Ivan", ivanList);

        friends.add(friend1);
        friends.add(friend2);
        friends.add(friend3);


    }


    @Test
    public void create() throws Exception {
        Game game = new Game();

        game.setFriendList(friends);
        game.create();

    }

}