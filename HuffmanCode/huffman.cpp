#include <bits/stdc++.h>
using namespace std;
int len;
struct MinHeapNode {

	char data;

	unsigned freq;

	MinHeapNode *left, *right;

	MinHeapNode(char data, unsigned freq)

	{

		left = right = NULL;
		this->data = data;
		this->freq = freq;
	}
};


struct compare {

	bool operator()(MinHeapNode* l, MinHeapNode* r)

	{
		return (l->freq > r->freq);
	}
};


void printCodes(struct MinHeapNode* root, string str)
{
    
	if (!root)
		return;

	if (root->data != '$'){
		cout << root->data << ": " << str << "\n";
        len += str.length()*root->freq;
    }

	printCodes(root->left, str + "0");
	printCodes(root->right, str + "1");
}

void HuffmanCodes(char data[], int freq[], int size)
{
	struct MinHeapNode *left, *right, *top;

	priority_queue<MinHeapNode*, vector<MinHeapNode*>,
				compare>
		minHeap;

	for (int i = 0; i < size; ++i)
		minHeap.push(new MinHeapNode(data[i], freq[i]));

	while (minHeap.size() != 1) {

		
		left = minHeap.top();
		minHeap.pop();

		right = minHeap.top();
		minHeap.pop();

		top = new MinHeapNode('$',
							left->freq + right->freq);

		top->left = left;
		top->right = right;

		minHeap.push(top);
	}

	printCodes(minHeap.top(), "");
}

int main()
{
    cout<<"\nOriginal Message: BCAADDDCCACACAC";
	char arr[] = { 'a', 'b', 'c', 'd'};
	int freq[] = { 5, 1, 6, 3};
    

	int size = sizeof(arr) / sizeof(arr[0]);
    cout<<"\nlength of message*char_size="<<15*8<<"\n";

	HuffmanCodes(arr, freq, size);
    cout<<"\nlength of compressed message*char_size="<<len;


	return 0;
}
