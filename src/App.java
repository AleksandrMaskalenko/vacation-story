import java.util.*;

public class App {
    private int totalAmount;
    private int averageAmount;
    private List<Friend> friendsList = new ArrayList<>();

    public void totalAmount(List<Friend> friends) {

        for (Friend friend: friends) {
            int totalAmountFriend = 0;
            HashMap<String, Integer> services = friend.getServices();

            for (Map.Entry<String, Integer> pair : services.entrySet()) {

                Integer value = pair.getValue();
                totalAmount += value;
                totalAmountFriend += value;
            }
            friend.setTotalAmount(totalAmountFriend);
            friendsList.add(friend);
        }


        System.out.println("Total amount: " + totalAmount);
    }

    public void averageAmount() {

        averageAmount = totalAmount/friendsList.size();

        System.out.println("Average amount: " + averageAmount + " to be paid by mate");
    }

    public void expenses() {

        for (Friend friend: friendsList) {
            String friendName = friend.getName();
            int friendAmount = friend.getTotalAmount();

            System.out.println(friendName + ": " + friendAmount);
        }


    }

    public void transaction() {

        List<Friend> lastFriend = new ArrayList<>();

        List<Friend> friendsPayToMuch = new ArrayList<>();
        List<Friend> friendsNeedToPayOther = new ArrayList<>();

        for (Friend friend: friendsList) {

            if (friend.getTotalAmount() > averageAmount) {
                friend.setDebt(friend.getTotalAmount() - averageAmount);

                friendsPayToMuch.add(friend);
            } else {
                friend.setDebt(averageAmount - friend.getTotalAmount());
                friendsNeedToPayOther.add(friend);
            }
        }
        Comparator.comparingInt(Friend::getDebt);

        friendsPayToMuch.sort((o1, o2) -> o2.getDebt()-o1.getDebt());

        for (int i = 0; i < friendsNeedToPayOther.size(); i++) {

            int t = friendsNeedToPayOther.get(i).getDebt();

            for (int j = 0; j < friendsPayToMuch.size(); j++) {

                int m = friendsPayToMuch.get(j).getDebt();

                if (t < friendsPayToMuch.get(friendsPayToMuch.size() - 1).getDebt()) {
                    lastFriend.add(friendsNeedToPayOther.get(i));
                }

                if (t > m) {
                    int newDebt = t - m;
                    friendsNeedToPayOther.get(i).setDebt(newDebt);
                    lastFriend.add(friendsNeedToPayOther.get(i));
                    friendsPayToMuch.remove(j);

                    System.out.println(friendsNeedToPayOther.get(i).getName() + " -> " + friendsPayToMuch.get(j).getName() + ": $" + friendsPayToMuch.get(j).getDebt());
                }
            }
        }

        for (Friend friend:lastFriend) {
            System.out.println(friend.getName() + " -> " + friendsPayToMuch.get(0).getName() + ": $" + friend.getDebt());
        }

    }
}
