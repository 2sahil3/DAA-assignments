#include <bits/stdc++.h>

using namespace std;

void Josh(vector<int> person, int k, int index)
{

	if (person.size() == 1) {  //only one person
		cout << person[0] << endl;
		return;

		
	}

	index = ((index + k) % person.size());  //index of 1st person which will die

	person.erase(person.begin() + index);  //remove that person

	Josh(person, k, index);
}

int main()
{
	int n; 
	int k;
	cin>>n;
	cin>>k;
	k--; //k-1 th will die because index starts from 0 
	int index= 0; //person which will die

	vector<int> person;
	for (int i = 1; i <= n; i++) {
		person.push_back(i);    //fill the void of dead person
	}

	Josh(person, k, index);
}
