package com.codedictator.repeatingannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//Declaring container for repeatable annotation type  
@Retention(RetentionPolicy.RUNTIME)
@interface Games {
	Game[] value();
}