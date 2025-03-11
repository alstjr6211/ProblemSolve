#include <iostream>

using namespace std;

int main() {
  int N;
  cin >> N;
  int name[26] = {0};
  for (int i = 0; i < N; i++) {
    string s;
    cin >> s;
    name[s[0] - 'a']++;
  }
  bool flag = false;
  for (int i = 0; i < 26; i++) {
    
    if (name[i] > 4) {
      cout << char('a' + i) << "";
      flag = true;
    }
    
  }
  if (!flag) {
    cout << "PREDAJA";
  }

  return 0;
}

