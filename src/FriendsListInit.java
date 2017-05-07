import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class FriendsListInit {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public List<Friend> createServiceList() throws IOException {

        List<Friend> friendList = new ArrayList<>();

        while (true) {
            HashMap<String, Integer> userServiceList = new HashMap<>();

            System.out.println("Friend name: ");
            String name = reader.readLine();
            if (name.equals("")) {
                break;
            }

            while (true) {

                    System.out.println("Service: ");
                    String service = reader.readLine();
                    if (name.equals("")) {
                        break;
                    }

                    System.out.println("Amount: ");
                    int amount = Integer.parseInt(reader.readLine());

                    userServiceList.put(service, amount);

            }
            Friend friend = new Friend(name, userServiceList);
            friendList.add(friend);
        }

        return friendList;

    }

}