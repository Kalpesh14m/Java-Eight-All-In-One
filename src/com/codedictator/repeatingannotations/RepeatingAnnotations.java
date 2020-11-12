package com.codedictator.repeatingannotations;
//Declaring repeatable annotation type  

//Repeating annotation  
@Game(name = "Cricket", day = "Sunday")
@Game(name = "Hockey", day = "Friday")
@Game(name = "Football", day = "Saturday")
public class RepeatingAnnotations {
	public static void main(String[] args) {
		// Getting annotation by type into an array
		Game[] game = RepeatingAnnotations.class.getAnnotationsByType(Game.class);
		for (Game game2 : game) { // Iterating values
			System.out.println(game2.name() + " on " + game2.day());
		}
	}
}

/*
 * As the name suggests, Repeating Annotations imply that a particular
 * annotation is applied multiple times to a declaration.
 * 
 * 
 * For example: Lets say there is an annotation @Game with an attribute name of
 * type String and day of type String.
 * 
 * Let us apply @Game annotation multiple times to another class
 * RepeatingAnnotations
 * 
 * Till Java 7, Repeating Annotations defined in the above way would have given
 * a compiler error – Duplicate annotation @Game...
 * 
 * 
 * 
 * Annotate Repeating Annotation with @Repeatable: Mark the annotation which can
 * be repeated with @Repeatable annotation. This is a meta-annotation as it
 * annotates an annotation.
 * 
 * Create a container annotation: Create an annotation which has an attribute
 * which is an array of the Repeating Annotation type.
 *
 * Let us now apply the above two rules to make the @Game annotation repeatable.
 *
 * Where, Games is the Container Annotation.
 * 
 * 
 * Class.java, from Java 8 onwards, supports a new method
 * getAnnotationsByType(<Annotation-class>) method which returns an array of
 * Annotation-Class type. Lets see an example usage of this new method
 * using @Game, @Games & RepeatingAnnotations class defined earlier
 * 
 * Note – To get the annotation information at runtime do annotate @Games
 * annotation with @Retention(RetentionPolicy.RUNTIME) annotation.
 * 
 * 
 * How Java 8 handles Repeating Annotations internally Java 8 internally treats
 * this Repeating Annotation as an instance of @Games holding an array of @Game.
 * The fact that we do not use @Games when we annotate definition of
 * RepeatingAnnotations class is just easing the syntax for the developer.
 * Internally, the compiler treats it as a @Games container annotation with an
 * array of @Game.
 */