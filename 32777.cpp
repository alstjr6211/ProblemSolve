#include <iostream>

using namespace std;

int main() {
  int T;
  cin >> T;

  for (int i = 0; i < T; i++) {
    int a, b;
    cin >> a >> b;

    

    if (((a - b < 22) && (a - b > 0)) || (a - b < -21)) {
      cout << "Outer circle line" << endl;
    } else {
      cout << "Inner circle line" << endl;
    }
  }
}