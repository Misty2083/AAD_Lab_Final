#include <iostream>
using namespace std;

struct Node {
    int data;
    Node *left, *right;
    Node(int val) : data(val), left(nullptr), right(nullptr) {}
};

void insertNode(Node*& root, int val) {
    if (!root) {
        root = new Node(val);
        return;
    }
    if (val < root->data) {
        insertNode(root->left, val);
    } else {
        insertNode(root->right, val);
    }
}

void inOrder(Node* root, int arr[], int& index) {
    if (!root) return;
    inOrder(root->left, arr, index);
    arr[index++] = root->data;
    inOrder(root->right, arr, index);
}

void deleteTree(Node* root) {
    if (!root) return;
    deleteTree(root->left);
    deleteTree(root->right);
    delete root;
}

void treeSort(int arr[], int n) {
    Node* root = nullptr;
    for (int i = 0; i < n; i++) {
        insertNode(root, arr[i]);
    }
    int index = 0;
    inOrder(root, arr, index);
    deleteTree(root);
}

int main() {
    int n;
    cout << "\n\nEnter the number of elements: ";
    cin >> n;

    int arr[n];
    cout << "Enter the elements: ";
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    cout << "Original array: ";
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
    treeSort(arr, n);
    cout << "\nSorted array: ";
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl<<endl;


    return 0;
}