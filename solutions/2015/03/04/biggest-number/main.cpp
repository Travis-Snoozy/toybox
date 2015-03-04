// Solution: O(n*log(n)) (sort) time, O(n) space (based on longest two input numbers)
// Obviously, I have seen this problem before; practically everybody goes down the
// path of trying to figure out the numeric rules that make on number a better enlarger
// than another... which is deviously complicated. T
//
// Builds with
// g++ -std=c++11 main.cpp
// gcc version 4.8.3

#include <algorithm>
#include <iostream>
#include <stdlib.h>
#include <string>
#include <vector>

struct {
	bool operator()(const int& a, const int& b) {
		std::string astr = std::to_string(a);
		std::string bstr = std::to_string(b);

		long long afirst = std::stoll(astr+bstr);
		long long bfirst = std::stoll(bstr+astr);

		if(afirst > bfirst)
		{
			return true;
		}

		return false;
	}
} enlargement_compare;

int main(int argc, char** argv)
{
	std::vector<int> data = { 32, 1, 16, 161, 90, 82, 4454, 4445 };
	std::sort(data.begin(), data.end(), enlargement_compare);
	for(int v : data)
	{
		std::cout << v;
	}
	std::cout << std::endl;
	return EXIT_SUCCESS;
}
