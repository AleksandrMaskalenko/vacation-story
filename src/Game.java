import java.io.IOException;
import java.util.List;

public class Game {

    private List<Friend> friendList;

    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public void setList() throws IOException {
        friendList = new FriendsListInit().createServiceList();
    }

    public void create() throws IOException {
        App app = new App();

        app.totalAmount(friendList);
        app.averageAmount();
        app.expenses();
        app.transaction();
    }

}
