package com.codedictator.repeatingannotations;

import java.lang.annotation.Repeatable;

@Repeatable(Games.class)
@interface Game {
	String name();

	String day();
}
