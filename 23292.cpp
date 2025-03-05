#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int solve(int birth, int day) {
  std::string str1 = std::to_string(birth);
  std::string str2 = std::to_string(day);
  int birth_1 = str1[0] - '0';
  int birth_2 = str1[1] - '0';
  int birth_3 = str1[2] - '0';
  int birth_4 = str1[3] - '0';
  int birth_5 = str1[4] - '0';
  int birth_6 = str1[5] - '0';
  int birth_7 = str1[6] - '0';
  int birth_8 = str1[7] - '0';

  int day_1 = str2[0] - '0';
  int day_2 = str2[1] - '0';
  int day_3 = str2[2] - '0';
  int day_4 = str2[3] - '0';
  int day_5 = str2[4] - '0';
  int day_6 = str2[5] - '0';
  int day_7 = str2[6] - '0';
  int day_8 = str2[7] - '0';

  int year = ((birth_1 - day_1) * (birth_1 - day_1)) + ((birth_2 - day_2) * (birth_2 - day_2)) + ((birth_3 - day_3) * (birth_3 - day_3)) + ((birth_4 - day_4) * (birth_4 - day_4));

  int month = ((birth_5 - day_5) * (birth_5 - day_5)) + ((birth_6 - day_6) * (birth_6 - day_6));
  
  int days = ((birth_7 - day_7) * (birth_7 - day_7)) + ((birth_8 - day_8) * (birth_8 - day_8));

  return year * month * days;
}

int main() {
  int birthday;
  cin >> birthday;

  int N;
  cin >> N;

  int arr[N];

  int max = 0;
  int ans = 0;
  for (int i = 0; i < N; i++) {
    cin >> arr[i];
  }
  sort(arr, arr + N);

  for (int i = 0; i < N; i++) {
    int res = solve(birthday, arr[i]);
    if (res > max) {
      max = res;
      ans = arr[i];
    }
  }


  cout << ans << endl;

  return 0;
}

