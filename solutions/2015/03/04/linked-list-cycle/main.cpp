#include <iostream>
#include <stdlib.h>
#include <vector>

struct node
{
	node* next;
};

int main(int argc, char** argv)
{
	node nodes[] = { node(), node(), node(), node(), node(), node(), node(), node(), node() };
	nodes[0].next = &nodes[1];
	nodes[1].next = &nodes[2];
	nodes[2].next = &nodes[3];
	nodes[3].next = &nodes[4];
	nodes[4].next = &nodes[5];
	nodes[5].next = &nodes[6];
	nodes[6].next = &nodes[7];
	nodes[7].next = &nodes[8];
	nodes[8].next = &nodes[3];

	node* a,* b;
	a = &nodes[0];
	b = a->next;

	while(true)
	{
		if(a == nullptr || b == nullptr || b->next == nullptr)
		{
			std::cout << "End of list located. No cycles." << std::endl;
			break;
		}
		if(a == b)
		{
			std::cout << "Cycle detected." << std::endl;
			break;
		}
		a = a->next;
		b = b->next->next;
	}
	return EXIT_SUCCESS;
}
