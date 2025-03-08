#include <iostream>

using namespace std;

string solve(int hour, int min, int sec, int time) {
  string str;
  int res_sec = (time + sec) % 60;
  int min_ = (time + sec) / 60;
  int res_min = (min_ + min) % 60;
  int hour_ = (min_ + min) / 60;
  int res_hour = (hour_ + hour) % 24;
  return to_string(res_hour) + " " + to_string(res_min) + " " + to_string(res_sec);
}
int main() {
  int hour, min, sec;
  cin >> hour >> min >> sec;
  int time;
  cin >> time;
  cout << solve(hour, min, sec, time);
  return 0;
}