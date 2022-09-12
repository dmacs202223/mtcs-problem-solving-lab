​BASIC IDEA:

	As we encounter the ( bracket then increase the open variable.
	As we encounter ) bracket, if some open ( bracket already exists then just assign that to this ) bracket.
	And decrease the open ( brackets value.
	if there are no open ( brackets then increase the cost by one 
	And one more thing we must check is, current position's next character also must be  ) bracket(open, close, close) . 
	So check if it is or not. If it's not or we are standing at end of the string then increase the cost.
	Finally for the open ) brackets that are still not assigned to any of the closed ) brackets then increase the cost by 2 for each of the ( brackets.
