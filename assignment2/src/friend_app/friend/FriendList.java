package friend_app.friend;

import friend_app.linked_list.LinkedList;
import friend_app.sorter.SorterInterface;

public class FriendList extends LinkedList<Friend> implements SorterInterface {
    @Override
    public FriendList sort() {
        Friend pivot = null;
        int length = this.getLength();
        System.out.println(length);

        if (length > 0){
            //Pivot Selection
            Friend firstCandidate = this.get(1);
            Friend midCandidate = this.get(length/2);
            Friend lastCandidate = this.get(length);
            int firstToMid = firstCandidate.getLastName().compareToIgnoreCase(midCandidate.getLastName());
            int firstToLast = firstCandidate.getLastName().compareToIgnoreCase(lastCandidate.getLastName());
            int midToLast = midCandidate.getLastName().compareToIgnoreCase(lastCandidate.getLastName());

            System.out.println(firstCandidate.getLastName());
            System.out.println(midCandidate.getLastName());
            System.out.println(lastCandidate.getLastName());
            System.out.println(firstToMid);
            System.out.println(firstToLast);
            System.out.println(midToLast);

            if ((firstToMid > 0 && firstToLast < 0) || (firstToMid < 0 && firstToLast > 0)){
                pivot = firstCandidate;
            } else if ((firstToMid > 0 && midToLast > 0) || (firstToMid < 0 && midToLast < 0)){
                pivot = midCandidate;
            } else if ((midToLast > 0 && firstToLast < 0) || (midToLast > 0 && firstToLast < 0)){
                pivot = lastCandidate;
            }
            System.out.println(pivot);
        }

        return this;
    }


}
