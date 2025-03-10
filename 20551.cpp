#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int search(const int* num, int target, int N) {
  int left = 0; int right = N - 1;
  int ans = -1;

  while(left <= right) {
    int mid = (left + right) / 2;
    if (num[mid] >= target) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }
  if (left < N && num[left] == target) ans = left;
  return ans;
}

int main() {
 int N, M;
 scanf("%d %d", &N, &M);
 
 int num[N];
 for (int i = 0; i < N; i++) scanf("%d", &num[i]);

 sort(num, num + N);


 for (int i = 0; i < M; i++) {
  int target;
  scanf("%d", &target);
  int t = search(num, target, N);
  printf("%d\n", t);
 }
}