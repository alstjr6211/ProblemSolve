#include <iostream>

using namespace std;

int main() {
  int N, M;
  cin >> N >> M;
  char arr[N][M];

  for (int i = 0; i < N; i++) {
    for (int j = 0; j < M; j++) {
      cin >> arr[i][j];
    }
  }
  int i_c = 0;
  int j_c = 0;

  for (int i = 0; i < N; i++) {
    bool flag = false;
    for (int j = 0; j < M; j++) {
      if (arr[i][j] == 'X') {
        flag = true;
      }
    }
    if (!flag) {
      i_c++;
    }
  }

  for (int j = 0; j < M; j++) {
    bool flag = false;
    for (int i = 0; i < N; i++) {
      if (arr[i][j] == 'X') {
        flag = true;
      }
    }
    if (!flag) {
      j_c++;
    }
  }

  if (i_c > j_c) {
    cout << i_c << endl;
  } else {
    cout << j_c << endl;
  }
    
  return 0;
}