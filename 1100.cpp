#include <iostream>

using namespace std;

int main() {
  bool white = true;
  int cnt = 0;
  for (int i = 0; i < 8; i++) {
    string chess;
    getline(cin, chess);
    for (int j = 0; j < 8; j++) {
      if (white && chess[j] == 'F') {
        cnt++;
      }
      white = !white;
    }
    white = !white;
  }
  cout << cnt << endl;
  return 0;
}