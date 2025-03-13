#include <iostream>
#include <algorithm>

using namespace std;

int main() {
  int N;
  cin >> N;
  string s;
  cin >> s;
  int T;
  cin >> T;
  for (int i = 0; i < T; i++) {
    int a, b;
    cin >> a >> b;
    int max = 0;
    string sub = s.substr(a - 1, b - a + 1);

    for (int j = 0; j < sub.length(); j++) {
      int x = j;
      int y = 0;
      int cnt = 0;
      while(x - y >= 0 && x + y < sub.length()) {
        if (sub[x - y] == sub[x + y + 1]) {
          cnt++;
        }
        y++;
      }
      if (cnt > max) {
        max = cnt;
      }
    }
  
    cout << max << endl;
  }

  return 0;
}

