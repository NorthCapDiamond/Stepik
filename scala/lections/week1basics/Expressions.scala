package lections.week1basics

object Expressions extends App{
	println("val aVal = 1 + 2 * 3")
	val aVal = 1 + 2 * 3
	println("val aVal = " + aVal.toString)

	println("\n1. Выражения возвращают какое-то значение.\n2. Имеют тип.")

	println("Именно свойство 1 позволяет нам сразу прописывать выражение в print (без его предварительного присваивания какой-либо переменной):")
	print("print(1 + 2 * 3) -- выводит ")
	println(1 + 2 * 3)
	println("И если выражение - это когда мы возвращаем какое-то, как правило, вычисленное значение, то инструкция - это когда мы выполняем какое-то действие, говорим компьютеру сделать что-то, но значение не возвращаем. \nВывод таков, что все в Scala является выражением \n")
	

	println("Типы выражений в Scala")
	println("+ - / *")
	println("& | ^ << >> >>>")
	println("== != > >= <= < ! && ||\n")

	println("if-Выражение")


	val aCondition = true
	val ifExpressionValue = if (aCondition) "True Condition" else "False Condition"
	println("val aCondition = true\nval ifExpressionValue = if (aCondition) \"True Condition\" else \"False Condition\"")
		println("println(ifExpressionValue) -- выведет True Condition")

	println("\nПример показывает, что в Scala, в отличие от других языков программирования, мы не кодим в стиле\nif (условие):\n\tприсвой значение (пишем для этого инструкцию)\nelse:\n\tприсвой переменной другое значение (пишем еще одну инструкцию)\n")


	println("Тип Unit")
	println("Вы же запомнили, что все в Scala является выражением? Ожидается, что выражение возвращает значение. Но бывают случаи, когда никакого значения не возвращается. За примером далеко ходить не надо - тот же print.")

	println("val someVal = print(\"Dimass is here\")\nprintln(someVal.getClass) Returns ???")
	val someVal = print("Dimass is here\n")
	println("someVal.getClass = " + someVal.getClass)
	println("Value = " + someVal.toString)


	println("val someVal: Unit = print(\"Dimass is here\")")
	val someVal2: Unit = print("Dimass is here\n")
	println("someVal.getClass = " + someVal2.getClass)
	println("Value = " ++ someVal2.toString)
}