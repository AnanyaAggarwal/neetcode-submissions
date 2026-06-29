/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;

        while (temp != null) {
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }

        Node curr = head;
        Node dummy = new Node(0);
        Node newList = map.get(curr);
        dummy.next = newList;

        while (curr != null) {
            Node origNext = curr.next;
            Node origRandom = curr.random;

            newList.next = map.get(origNext);
            newList.random = map.get(origRandom);
            curr = curr.next;
            newList = newList.next;
        }

        return dummy.next;
    }
}
