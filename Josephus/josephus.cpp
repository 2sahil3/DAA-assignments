#include <iostream>
#include <vector>
using namespace std;

int josephusArray(int n, int k) {
    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        arr[i] = i + 1;
    }
    int idx = 0;
    while (n > 1) {
        idx = (idx + k - 1) % n;
        for (int i = idx; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        n--;
    }
    return arr[0];
}

struct Node {
    int val;
    Node* next;
    Node(int v) : val(v), next(nullptr) {}
};

int josephusLinkedList(int n, int k) {
    Node* head = new Node(1);
    Node* tail = head;
    for (int i = 2; i <= n; i++) {
        tail->next = new Node(i);
        tail = tail->next;
    }
    tail->next = head;
    Node* prev = tail;
    Node* curr = head;
    while (n > 1) {
        for (int i = 0; i < k - 1; i++) {
            prev = curr;
            curr = curr->next;
        }
        prev->next = curr->next;
        Node* tmp = curr;
        curr = curr->next;
        delete tmp;
        n--;
    }
    int result = curr->val;
    delete curr;
    return result;
}

int josephusRecursive(int n, int k) {
    if (n == 1) {
        return 1;
    }
    return (josephusRecursive(n - 1, k) + k - 1) % n + 1;
}

int main() {
    int n, k, choice;
    do {
        cout << "Choose the method to solve the Josephus problem:\n";
        cout << "1. Array\n";
        cout << "2. Linked List\n";
        cout << "3. Recursion\n";
        cout << "4. Quit\n";
        cout << "Enter your choice: ";
        cin >> choice;
        switch (choice) {
            case 1:
                cout << "Enter the number of people: ";
                cin >> n;
                cout << "Enter the interval: ";
                cin >> k;
                cout << "The survivor is at position " << josephusArray(n, k) << endl;
                break;
            case 2:
                cout << "Enter the number of people: ";
                cin >> n;
                cout << "Enter the interval: ";
                cin >> k;
                cout << "The survivor is at position " << josephusLinkedList(n, k) << endl;
                break;
            case 3:
                cout << "Enter the number of people: ";
                cin >> n;
                cout << "Enter the interval: ";
                cin >> k;
                cout << "The survivor is at position " << josephusRecursive(n, k) << endl;
                break;
            case 4:
                cout << "Exiting program..." << endl;
                break;
            default:
                cout << "Invalid choice. Please try again." << endl;
                break;
        }
        cout << endl;
    } while (choice != 4);

    return 0;
}
