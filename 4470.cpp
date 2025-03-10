#include <iostream>

using namespace std;

int main() {
  int N;
  cin >> N;
  cin.ignore();
  for (int i = 0; i < N; i++) {
    string input;
    getline(cin , input);
    cout << (i + 1)<< ". " << input << "\n";
  }
}

