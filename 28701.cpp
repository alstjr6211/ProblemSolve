#include <iostream>
using namespace std;

int main() {
  int N;
  cin >> N;
  int sum = 0;
  for (int i = 1; i <= N; i++) {
    sum += i;
  }
  cout << sum << endl;
  cout << sum * sum << endl;
  cout << sum * sum << endl;
  return 0;
}