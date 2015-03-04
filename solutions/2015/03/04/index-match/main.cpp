#include <iostream>
#include <stdlib.h>
#include <vector>

int main(int argc, char** argv)
{
	// Match (index 10 == value 10)
	std::vector<int> data = {-50, -25, -12, -6, -3, -1, 0, 1, 2, 4, 10, 16, 32, 64};

	// No match
	//std::vector<int> data = {-50, -25, -12, -6, -3, -1, 0, 1, 2, 4, 8, 16, 32, 64};
	
	int start = 0;
	int end = data.size() - 1;
	int test = 0;
	bool found = false;

	while(start < end)
	{
		test = (start + end) / 2;
		if(data[test] > test)
		{
			end = test - 1;
		}
		else if(data[test] < test)
		{
			start = test + 1;
		}
		else
		{
			found = true;
			break;
		}
	}

	if(found)
	{
		std::cout << "Index " << test << " has a value identical to the index." << std::endl;
	}
	else
	{
		std::cout << "There was no index that had a value identical to the index." << std::endl;
	}
	return EXIT_SUCCESS;
}
