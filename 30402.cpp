#include <iostream>

using namespace std;

int main() {
  
  loop:
  for (int i = 0; i < 15; i++) {
    for (int j = 0; j < 15; j++) {
      char a;
      cin >> a;

      if (a == 'w') {
        cout << "chunbae";
        goto fin;
      } else if (a == 'b') {
        cout << "nabi";
        goto fin;
      } else if (a == 'g') {
        cout << "yeongcheol";
        goto fin;
      }

    }
  }

  fin:
  return 0;
}