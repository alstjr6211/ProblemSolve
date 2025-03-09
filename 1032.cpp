#include <iostream>

using namespace std;

int main() {
  int N;
  cin >> N;

  string s;
  cin >> s;
  int len = s.length();
  char line[len + 1];
  for (int j = 0; j < len; j++) {
    line[j] = s[j];
  }
  line[len] = '\0';

  for (int i = 0; i < N - 1; i++) {
    string str;
    cin >> str;

    for (int j = 0; j < len; j++) {
      if (line[j] != str[j]) {
        line[j] = '?';
      }
    }
  }

  cout << line << endl;
  return 0;
}

// 백준 1032번
//char배열에서 string처럼 다룰 때, len보다 + 1을 한 후 null문자열인 '\0'을 더해야 함을 알려준 문제.

//char배열을 쓸 때 항상 유의하도록 하자!