#include <iostream>
#include <algorithm>

using namespace std;

int main() {
  int arr[5];
  for (int i = 0; i < 5; i++) {
    cin >> arr[i];
  }

  sort(arr, arr + 5);
  int i = arr[2];
  while(true) {
    int count = 0;
    for (int j = 0; j < 5; j++) {
      if (i % arr[j] == 0) {
        count++;
      }
    }
    if (count >= 3) {
      cout << i << endl;
      break;
    }
    i++;
  }

  return 0;
}

