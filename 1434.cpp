#include <iostream>
#include <vector>

using namespace std;

int main() {
 int N, M;
 cin >> N >> M;
 vector<int> box(N);
 for (int i = 0; i < N; i++) {
  cin >> box[i];
 }
 vector<int> book(M);
 for (int i = 0; i < M; i++) {
  cin >> book[i];
 }
 int cnt = 0;
 int sum = 0;
 for (int i = 0; i < N; i++) {
  while(cnt < M) {
    if (box[i] >= book[cnt]) {
      box[i] -= book[cnt];
      cnt++;
    } else {
      sum += box[i];
      break;
    }
  }
  if (cnt >= M) {
    sum += box[i];
  } 
 }
 cout << sum << endl;
 return 0;
}