// Solution: O(n) time, no additional storage
#include <cstring>
#include <iostream>
#include <string>

int reverse(int start, int end, char* str)
{
	end--;
	int count = (end-start)/2;

	for(int i = 0; i <= count; i++)
	{
		char tmp = str[start+i];
		str[start+i] = str[end-i];
		str[end-i] = tmp;
	}
}

int main(int argc, char** argv)
{
	if(argc != 2)
	{
		std::cout << "Usage: type a quoted string (to be reversed) after the command." << std::endl;
		return EXIT_FAILURE;
	}

	int len = strlen(argv[1]);

	// Reverse the whole string.
	reverse(0, len, argv[1]);

	// Reverse each (now backwards) word in the string
	int start = 0;
	for(int end = 1; end < len; end++)
	{
		if(argv[1][end] == ' ' && start < end)
		{
			reverse(start, end, argv[1]);
			start = end+1;
		}
	}
	// Reverse the last word (or, possibly the whole string again, if it's just one word).
	reverse(start, len, argv[1]);

	// Result: all the words, now in reverse order from the original sentence.
	std::cout << argv[1] << std::endl;

}
