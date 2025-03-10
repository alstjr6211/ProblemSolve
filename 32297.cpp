#include <iostream>
using namespace std;

int main() {
 int len;
 string s;
 cin >> len;
 cin >> s;
 if (s.find("gori") != string::npos) {
  cout << "YES" << endl;
 } else {
  cout << "NO" << endl;
 }


  return 0;
}

// string s가 있을 때, s.find("substring")을 하면 substring의 시작 index를 반환하는데,
// 만약 찾지 못하면 string::npos를 반환한다. 이 값은 매우 큰 수이고, 0이 아니기 때문에 if문 안에 넣으면 false라고 판단하지 못하는 것이다.
// find의 사용법을 명확히 알게 해 준 문제제