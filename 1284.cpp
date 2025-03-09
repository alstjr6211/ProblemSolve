#include <iostream>

using namespace std;

int main () {
  while (true) {
    int N;
    cin >> N;
    if (N == 0) break;

    string str = to_string(N);
    int sum = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str[i] == '1') {
        sum += 2;
      } else if (str[i] == '0') {
        sum += 4;
      } else {
        sum += 3;
      }
    }

    sum += (str.length() + 1);

    cout << sum << endl;
  }

  return 0;
}