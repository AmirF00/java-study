// ListNode class definition
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// Solution class with the addTwoNumbers method
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize a dummy node to facilitate list construction
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0; // Initialize carry to 0

        // Traverse both lists
        while (l1 != null || l2 != null) {
            // Extract the values from the current nodes, defaulting to 0 if null
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Calculate the sum and the new carry
            int sum = carry + x + y;
            carry = sum / 10; // Update carry for next iteration

            // Create a new node for the current digit and move the pointer
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Move to the next nodes in l1 and l2
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If there's any carry left at the end, add a new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // The result list is in dummyHead.next
        return dummyHead.next;
    }
}

// Main class to test the addTwoNumbers function
public class Main {
    public static void main(String[] args) {
        // Test case 1
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);
        printList(result); // Expected output: 7 -> 0 -> 8

        // Test case 2
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        ListNode result2 = solution.addTwoNumbers(l3, l4);
        printList(result2); // Expected output: 0

        // Test case 3
        ListNode l5 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l6 = new ListNode(1);
        ListNode result3 = solution.addTwoNumbers(l5, l6);
        printList(result3); // Expected output: 0 -> 0 -> 0 -> 1
    }

    // Helper function to print the linked list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
}

