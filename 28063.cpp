#include <iostream>
#include <vector>

using namespace std;

int main() {
 int N;
 cin >> N;
 int x, y;
 cin >> x >> y;
 int sum = 0;
 if (x == 1 || x == N) sum = 1;
 else sum = 2;
 if (y == 1 || y == N) sum += 1;
 else sum += 2;

 if (N == 1) sum = 0;
 
 cout << sum << endl;
}