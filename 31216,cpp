#include <iostream>
#include <climits>
#include <map>

using namespace std;

int MAX = 1000000;

bool prime[1000000];

map <int, int> prime_number;
map <int, int> super_prime;
void make_false(int N) {
  if (N * 2 >= MAX) return;
  for (int i = (N * 2); i < MAX; i += N) {
    prime[i] = false;
  }
}
int main() {
  std::fill_n(prime, MAX, true);
  int numbering = 0;
  for (int i = 2; i < MAX; i++) {
    if (prime[i]) {
      numbering += 1;
      prime_number.insert({numbering, i});
      make_false(i);
    }
  }
  prime[1] = false;
  int cnt = 0;
  for (auto it = prime_number.begin(); it != prime_number.end(); it++) {
    int K = it->second;
    int numbering_ = it->first;
    if (prime[numbering_]) {
      cnt++;
      super_prime.insert({cnt, K});
    }
  }

  int N;
  cin >> N;

  for (int i = 0; i < N; i++) {
    int P;
    cin >> P;
    cout << super_prime[P] << endl;
  }

  return 0;
}

// N번째 소수에 대해 N이 소수인지를 판별해야하는 문제.

// 에라토스테네스의 체를 사용해서 100만까지의 자연수 중에 소수를 찾고,
// 해당 배열을 다시 이용해 N번째 소수에 대해 N이 소수인지를 판별하면 되는 문제.

// 이후 N번째 소수가 무엇인지 확인하는 과정에서는 O(1)이 걸리도록 map을 사용하였다.

// C++에서는 Map을 사용하기 위해서, map을 사용하고, climits는 INT_MAX를 사용하기 위함이었지만, segmant fault의 위험때문에 사용하진 않았다.

// 이후 std::fill_n()을 사용해 배열을 전부 true로 만들어준다.