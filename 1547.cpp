#include <iostream>

using namespace std;

int main() {
  int N;
  cin >> N;
  int arr[3] = {1, 0, 0};
  arr[0] = 1; 
  for (int i = 0; i < N; i++) {
    int a, b;
    cin >> a >> b;
    int tmp = arr[a - 1];
    arr[a - 1] = arr[b - 1];
    arr[b - 1] = tmp;
  }
  for (int i = 0 ; i < 3; i++) {
    if (arr[i] == 1) {
      cout << i + 1 << endl;
      break;
    }
  }
  return 0;
}

