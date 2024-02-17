package lections.week1basics

object TypesValuesVariables extends App{

	println("Week1 Meets You")

	println("Characters :")

	// val - ключевое слово 
	// name_of_variable - имя переменной 
	// : - двоеточие
	// Type - тип переменной
	// = - равно 
	// Value - значение 

	val my_string : String = "Hello"
	println(my_string)

	// may be simplified 

	val my_string2 = "World!"
	println(my_string2)


	println("Long and Float :")

	val aLong = 11
	println("val aLong = 11")
	println(aLong.getClass) // выводит int

	//val aLong2 : Int = 11L
	//println(aLong2.getClass) // выводит Error

	val aLong3 = 11L
	println("val aLong3 = 11L")
	println(aLong3.getClass) // выводит long

	val aLong4 : Long = 11
	println("val aLong4 : Long = 11")
	println(aLong4.getClass) // выводит long

	val aFloat : Float = 11
	println("val aFloat : Float = 11")
	println(aFloat.getClass) // выводит float

	val aFloat2 = 11F
	println("val aFloat2 = 11F")
	println(aFloat2.getClass) // выводит float

	println()


	println("Var or Val ???")
	println("As I guessed earlier, 'val' creates read-only variables")
	println("On the other side, 'var' variables may be reassigned")

	var aInt : Int = 101
	println("Old Value is:")
	println("var aInt : Int = 101")
	println(aInt)
	aInt = 10
	println("New value is:")
	println("aInt = 10")
	println(aInt)

	var myString = "ABC"
	println("var myString = \"ABC\" ")
	println(myString)

	myString+="DEF"
	println("var myString += \"DEF\" ")
	println(myString)
}