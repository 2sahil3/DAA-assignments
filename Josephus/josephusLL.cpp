#include <iostream>
using namespace std;
/*The createList function takes an integer n and creates a circular linked list with n nodes,
 where each node contains a unique integer value from 1 to n. It returns the head of the linked list. 
 The josephus function takes two arguments n and k, where n is the number of people in the circle and k is the number of people to be skipped before removing the next person.
  It creates a circular linked list using the createList function, and then repeatedly removes the kth person from the circle until only one person is left. 
  Finally, it returns the value of the remaining person. The main function tests the josephus function with n = 7 and k = 3 and prints the result.



*/
struct Node {
    int data;
    Node* next;
};

Node* createList(int n) {
    Node* head = new Node();
    head->data = 1;
    head->next = head;
    Node* prev = head;
    for (int i = 2; i <= n; i++) {
        Node* curr = new Node();
        curr->data = i;
        curr->next = head;
        prev->next = curr;
        prev = curr;
    }
    return head;
}

int josephus(int n, int k) {
    Node* head = createList(n);
    Node* curr = head;
    Node* prev = NULL;
    while (curr->next != curr) {
        for (int i = 0; i < k - 1; i++) {
            prev = curr;
            curr = curr->next;
        }
        prev->next = curr->next;
        Node* temp = curr;
        curr = curr->next;
        delete temp;
    }
    int survivor = curr->data;
    delete curr;
    return survivor;
}

int main() {
    int n, k;
    cout << "Enter value of n:" << endl;
    cin >> n;
    cout << "Enter value of k:" << endl;
    cin >> k;
    cout << "Survivor: " << josephus(n, k) << endl; // expected output: 4
    return 0;
}
