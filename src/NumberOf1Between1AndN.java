import java.util.Arrays;
import java.util.Scanner;

public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        int base = 1;
        while(base <= n){
            int shang = n / (base * 10) ;
            int yu = n % (base * 10);
            sum += base * shang;
            if(yu >= base * 2)
                sum += base;
            else if(yu >= base)
                sum += (yu - base + 1);
            base *= 10;
        }
        return sum;
    }



    int findMaxGuests(int arrl[], int exit[], int n)
    {
        // Sort arrival and exit arrays
        Arrays.sort(arrl);
        Arrays.sort(exit);
        String[] temp = new String[2];
        Arrays.sort(temp,(o1,o2)-> ((String)o1 + (String)o2).compareTo((String)o2 + (String)o1) );

        // guests_in indicates number of guests at a time
        int guests_in = 1, max_guests = 1, time = arrl[0];
        int i = 1, j = 0;

        // Similar to merge in merge sort to process
        // all events in sorted order
        while (i < n && j < n)
        {
            // If next event in sorted order is arrival,
            // increment count of guests
            if (arrl[i] <= exit[j])
            {
                guests_in++;

                // Update max_guests if needed
                if (guests_in > max_guests)
                {
                    max_guests = guests_in;
                    time = arrl[i];
                }
                i++;  //increment index of arrival array
            }
            else // If event is exit, decrement count
            {    // of guests.
                guests_in--;
                j++;
            }
        }
       return max_guests;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String temp = scan.nextLine();
        String arr[] = temp.split(" ");
        temp = scan.nextLine();
        String exit[] = temp.split(" ");
        int n = arr.length;
        int arrl[] = new int[n];
        int exitl[] = new int[n];
        for(int i = 0; i < n; i++){
            arrl[i] = Integer.valueOf(arr[i]);
            exitl[i] = Integer.valueOf(exit[i]);
        }
        NumberOf1Between1AndN num = new NumberOf1Between1AndN();
        System.out.println(num.findMaxGuests(arrl,exitl,n));
    }
}
