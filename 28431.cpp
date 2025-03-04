#include <iostream>

using namespace std;

int main() {
  int a;

  int arr[10] = {0};

  for (int i = 0; i < 5; i++) {
    cin >> a;
    arr[a]++;
  }
  for (int i = 0; i < 10; i++) {
    if (arr[i] % 2 == 1) {
      cout << i << endl;
    }
  }
}