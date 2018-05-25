/*************************** 
** Jake Howering 
** CS 362 @ Oregon State U 
** Spring 2018 
** Filename: cardtest1.c 
** Description: Card test 1 - 
** test the adventurer card 
*****************************/
#include "dominion.h" 
#include "dominion_helpers.h" #
#include <string.h> #
#include <stdio.h> #
#include <assert.h> #
#include "rngs.h" 
#include <stdlib.h>

int main (int argc, char** argv) {
	int seed = 1000;
	int numPlayers = 2;
	struct gameState G, sampleG;
	int currentPlayer = 0;
	int handCount;
	int sampleDeckSize;
	int k[10] = {adventurer, embargo, village, minion, mine, cutpurse,
			gardens, tribute, smithy, council_room};
	// initialize game state
	initializeGame(numPlayers, k, seed, &G);
	memcpy(&sampleG, &G, sizeof(struct gameState));
	printf("Card Test 1 - Adventurer Card\n");
	int choice1 = 0, choice2 = 0, choice3 = 0;
	//artificially define the deck with 5 cards, all treasure
	//for player 0
	int deckSize = sampleG.deckCount[0];
	int sampleDeck [] = {silver, silver, silver, gold, silver};
        sampleDeckSize = 5;
        for(int i = 0; i < sampleDeckSize; i++){
            sampleG.deck[0][--deckSize] = sampleDeck[i];
        }
	
	printf("Print the initial player hand \n");
	for(int i=0; i<G.handCount[currentPlayer]; i++){
		printf("Card %d\n ", handCard(i,&G));
	}
	
	cardEffect(adventurer, choice1, choice2, choice3, &sampleG, 0, NULL);
	printf("Print the player hand after adventurer card play \n");
	for(int i=0; i<sampleG.handCount[currentPlayer]; i++){
		printf("Card %d\n ", handCard(i,&sampleG));
	}
        handCount = sampleG.handCount[currentPlayer];
	if(sampleG.handCount[currentPlayer] == G.handCount[currentPlayer] + 2) {
		printf("Two treasure cards were added - test passed \n");
		printf("Old handcount %d\n", G.handCount[currentPlayer]);
		printf("New handcount %d\n", sampleG.handCount[currentPlayer]);
	}
	else {
		printf("Two treasure cards were not added - test fails\n");
		printf("Old handcount %d\n", G.handCount[currentPlayer]);
		printf("New handcount %d\n", sampleG.handCount[currentPlayer]);
	}
	return 0;
}
