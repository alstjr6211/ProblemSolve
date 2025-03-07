#include <iostream>
#include <map>

using namespace std;

int main() {
  int N;
  cin >> N;
  map<string, string> classes;
  classes.insert({"Algorithm", "204"});
  classes.insert({"DataAnalysis", "207"});
  classes.insert({"ArtificialIntelligence", "302"});
  classes.insert({"CyberSecurity", "B101"});
  classes.insert({"Network", "303"});
  classes.insert({"Startup", "501"});
  classes.insert({"TestStrategy", "105"});
  for (int i = 0; i < N; i++) {
    string s;
    cin >> s;;

    if (classes.find(s) != classes.end()) {
      cout << classes.find(s)->second << endl;
    }

  }
}