package friend_app.friend;

import friend_app.linked_list.LinkedList;
import friend_app.sorter.SorterInterface;

public class FriendList extends LinkedList<Friend> implements SorterInterface {
    private static int MIN_LIST_SIZE = 5;

    @Override
    public FriendList sort() {

        if (this.isEmpty() || this.getLength() == 1){
            return null;
        }

        FriendList sortedList = new FriendList();   //Setting up a list to return
        Object[] toArrayRetrieval = this.toArray(); //Getting the Object array from LinkedList
        Friend[] sortingArray = new Friend[toArrayRetrieval.length]; //Setting up a Friend array


        for (int i = 0; i < toArrayRetrieval.length; i++){
            sortingArray[i] = (Friend) toArrayRetrieval[i]; //Casting each object in Object array to Friend
        }

        int length = sortingArray.length;

        quickSort(sortingArray, 0, length-1); //Implementing the quicksort algorithm for the list

        System.out.println("Sorted Array:");
        for (int i = 0; i < sortingArray.length; i++){
            System.out.println(sortingArray[i].getLastName());
            sortedList.add(sortingArray[i]);
        }

        return sortedList;
    }

    /**
     * Sort an array using the insertion sort algorithm.
     * @param sortable
     * @param first
     * @param last
     *
     */
    private void insertionSort(Friend[] sortable, int first, int last){

        if(first < last){
            insertionSort(sortable, first, last-1);
            insertInOrder(sortable[last], sortable, first, last-1);
        }

    }
    /**
     * Sort an array using the quicksort algorithm.
     * Uses insertion sort algorithm if the list contains less than MIN_LIST_SIZE items.
     *
     * @param sortable
     * @param first
     * @param last
     */
    private void quickSort(Friend[] sortable, int first, int last){

        if (last-first+1 < MIN_LIST_SIZE) {
            insertionSort(sortable, first, last);
        } else {
            int pivotIndex = partition(sortable, first, last);
            quickSort(sortable, first, pivotIndex-1);
            quickSort(sortable, pivotIndex+1, last);
        }
    }
    /**
     * Helper method for quicksort.
     * Finds the median pivot point between three potential candidates.
     *
     * Sorts a list of three String values.
     * The first is the first location of the array.
     * The mid is the pivot to be sorted.
     * The last is the last location of the array.
     *
     * @param friends
     * @param first
     * @param mid
     * @param last
     */
    private void pivotSorter (Friend[] friends, int first, int mid, int last){

        Friend firstCandidate = friends[first];
        Friend midCandidate = friends[mid];
        Friend lastCandidate = friends[last];
        int firstToMid = firstCandidate.getLastName().compareToIgnoreCase(midCandidate.getLastName());
        int firstToLast = firstCandidate.getLastName().compareToIgnoreCase(lastCandidate.getLastName());
        int midToLast = midCandidate.getLastName().compareToIgnoreCase(lastCandidate.getLastName());

        if (firstToMid > 0 && firstToLast < 0){
            friends[first] = midCandidate;
            friends[mid] = firstCandidate;
            friends[last] = lastCandidate;

        } else if (firstToMid < 0 && firstToLast > 0) {
            friends[first] = lastCandidate;
            friends[mid] = firstCandidate;
            friends[last] = midCandidate;

        } else if ((firstToMid > 0 && midToLast > 0)){
            friends[first] = lastCandidate;
            friends[mid] = midCandidate;
            friends[last] = firstCandidate;

        } else if (firstToMid < 0 && midToLast < 0) {
            friends[first] = firstCandidate;
            friends[mid] = midCandidate;
            friends[last] = lastCandidate;

        } else if (midToLast > 0 && firstToLast < 0){
            friends[first] = firstCandidate;
            friends[mid] = lastCandidate;
            friends[last] = midCandidate;

        } else if (midToLast < 0 && firstToLast > 0) {
            friends[first] = midCandidate;
            friends[mid] = lastCandidate;
            friends[last] = firstCandidate;
        }
    }
    /**
     * Helper method for the quicksort algorithm.
     *
     * 1. Selects a pivot
     * 2. Swaps pivot with second to last spot.
     * 3. Divides array into two subarrays.
     * 4. Locates unsorted entries in the partition.
     * 5. Swaps the two entries.
     * 6. When all entries are swapped, swaps left index with pivot value.
     *
     * @param friendArray
     * @param first
     * @param last
     *
     * @return pivotIndex
     */
    private int partition (Friend[] friendArray, int first, int last){
        int mid = first+((last-first)/2); //Setting the middle of the array (Pivot location)
        pivotSorter(friendArray, first, mid, last); //Choosing the pivot

        int pivotIndex = last-1;
        Friend midValue = friendArray[pivotIndex];
        Friend pivotValue = friendArray[mid];
        friendArray[pivotIndex] = pivotValue;
        friendArray[mid] = midValue;

        //Setting up subarrays
        int indexFromLeft = first+1;
        int indexFromRight = last-2;
        boolean done = false;

        while(!done){
            //Begin at the start of the array, find first entry greater than or equal to pivot
            while (friendArray[indexFromLeft].getLastName().compareToIgnoreCase(pivotValue.getLastName()) < 0){
                indexFromLeft++;
            }
            //Begin at the end of the array, find the first entry smaller than or equal to pivot
            while (friendArray[indexFromRight].getLastName().compareToIgnoreCase(pivotValue.getLastName()) > 0){
                indexFromRight--;
            }
            //If the indices do not share value, swap the two objects and increase indices
            if (indexFromLeft < indexFromRight){
                Friend leftie = friendArray[indexFromLeft];
                Friend rightie = friendArray[indexFromRight];
                friendArray[indexFromRight] = leftie;
                friendArray[indexFromLeft] = rightie;
                indexFromLeft++;
                indexFromRight--;
            } else {
                done = true; //If no further swapping is required, exit loop.
            }
        }

        Friend leftExchange = friendArray[indexFromLeft];
        friendArray[indexFromLeft] = pivotValue;
        friendArray[pivotIndex] = leftExchange;
        pivotIndex = indexFromLeft;

        return pivotIndex;
    }
    /**
     * Helper method for the insertionSort algorithm
     * Looks for entries that belong after the selected entry.
     * If such a location is found, the entry is placed after it.
     *
     * @param entry
     * @param unsortedArray
     * @param begin
     * @param end
     */
    private void insertInOrder (Friend entry, Friend[] unsortedArray, int begin, int end){
        if(entry.getLastName().compareToIgnoreCase(unsortedArray[end].getLastName()) >= 0){
            unsortedArray[end+1] = entry;
        } else if (begin < end){
            unsortedArray[end+1] = unsortedArray[end];
            insertInOrder(entry, unsortedArray, begin, end-1);
        } else {
            unsortedArray[end+1] = unsortedArray[end];
            unsortedArray[end] = entry;
        }
    }


}
