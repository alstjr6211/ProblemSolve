#include <iostream>

using namespace std;

int main() {
  int N, F;
  cin >> N;
  cin >> F;

  int K = N % F;
  if ((N % 100) - K < 0) {
    int t = (N % 100) + (F - K);
    
    t = (t % 100);
    string s = to_string(t);
    if (s.length() == 1) {
      s = "0" + s;
    }
    cout << s << endl;
  } else {
    int t = (N % 100) - K;
    while (t >= 0) {
      t -= F;
    }
    t += F;

    t = (t % 100);
    string s = to_string(t);
    if (s.length() == 1) {
      s = "0" + s;
    }
    cout << s << endl;
  }

  return 0;
}